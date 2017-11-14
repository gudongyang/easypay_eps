document.write("<link href='" + appRoot + "css/importdata.css' type=text/css rel=stylesheet>");
function ImportData(file) {
    var serverFile;
    var titles;
    var titleMap = {};
    var titleLayer = null;						//title拖动层
    var headFile = file;
    var finish = false;							//数据导入是否成功！
    var columnsDivId = "allColumns";			//可选数据列div id
    var dataDivId = "dataPreview";
    var dataTitleList = [];						//可选数据列数组
    var insideTd = null;						//拖动层进入数据区域的title对象
    this.getImportColumns = function () {
        DWR.call("generalImporter.getImportColumns", headFile,
            function (result) {
                var div = $(columnsDivId);
                div.innerHTML = ""
                if (!result) return;

                var tbody = ct(div);
                var tr = document.createElement("TR");
                tbody.appendChild(tr);

                var column
                var td
                for (var i = 0; i < result.length; i++) {
                    column = result[i]
                    td = document.createElement("TD");
                    td.className = ImportData.evtout;
                    td.innerHTML = column.title;
                    td.style.width = Math.floor(100 / result.length) + "%"
                    td.id = column.name + "_allcolumns";
                    td.colName = column.name;
                    titleMap[column.title] = column.name;
                    tr.appendChild(td);
                    bind(td, "mouseover", evtMouseOver)
                    bind(td, "mouseout", evtMouseOut)
                    bind(td, "mousedown", evtMouseDown)
                    bind(td, "mouseup", evtMouseUp)
                    bind(td, "mousemove", evtMouseMove)
                }
            }
        )
    }
    var ct = function (div) {
        var table = document.createElement("TABLE");
        table.width = "100%";
        table.border = "0";
        table.cellPadding = 0;
        table.cellSpacing = 0;
        div.appendChild(table);
        var tbody = document.createElement("TBODY");
        table.appendChild(tbody);
        return tbody;
    }
    var getTitleLayer = function () {
        if (!titleLayer) {
            titleLayer = $("titleLayer");
            titleLayer.className = ImportData.titleLayer;
        }
        return titleLayer
    }
    var evtMouseMove = function () {
        if (!finish) return;
        var l = getTitleLayer();
        if (event.button != 1) return;
        if (this.moveStart) {
            var w = event.clientX - l.startX;
            var h = event.clientY - l.startY;
            l.style.left = l.startLeft + w;
            l.style.top = l.startTop + h;

            var pos = {left: event.clientX, top: event.clientY}
            for (var i = 0; i < dataTitleList.length; i++) {
                var td = dataTitleList[i];
                if (insideElement(pos, td)) {
                    td.className = ImportData.insideClass;
                    insideTd = td;
                } else {
                    td.className = ImportData.datatitle;
                }
            }
        }
    }
    var evtMouseOver = function () {
        if (!finish) return;
        this.className = ImportData.evtover;
    }
    var evtMouseOut = function () {
        if (!finish) return;
        this.className = ImportData.evtout;
    }

    var evtMouseDown = function () {
        if (!finish) return;
        if (event.button != 1) return;
        if (this.move) return;
        this.setCapture();
        this.moveStart = true;
        insideTd = null;

        var l = getTitleLayer();
        l.colName = this.colName;
        l.innerHTML = "<span style='color:blue'>" + this.innerHTML + "</span>";

        l.style.display = "";
        l.startLeft = event.clientX - 10;
        l.startTop = event.clientY - 5;
        l.style.left = l.startLeft + "px";
        l.style.top = l.startTop + "px";

        l.startX = event.clientX;
        l.startY = event.clientY;

        this.move = true;
    }

    var evtMouseUp = function () {
        if (!finish) return;
        this.releaseCapture();
        var l = getTitleLayer();
        l.style.display = "none";
        this.moveStart = false;
        this.move = false;
        this.className = ImportData.evtout;
        if (insideTd) {
            insideTd.className = ImportData.datatitle;
            insideTd.innerHTML = l.innerHTML;
            insideTd.colName = l.colName;
        }
    }
    var insideElement = function (pos, ele) {
        if (typeof ele != "object") ele = $(ele);
        if (!ele) return false;
        if (!ele.pos)
            ele.pos = absp(ele);
        var p = ele.pos;
        if (pos.left > p.left && pos.left < p.left + ele.offsetWidth && pos.top > p.top && pos.top < p.top + ele.offsetHeight)
            return true;
        else
            return false;
    }
    this.importData = function () {
        if (!dataForm.dataFile.value) {
            showError("请先选择数据文件");
            return;
        }
        dataForm.action = contextRoot + "d/importdata"
        serverFile = null;
        Site.upload(dataForm, function (r) {
            var obj;
            if (r) {
                eval("obj=" + r)
            }
            else
                obj = {}
            if (obj.error) {
                showError(obj.error)
            }
            else if (obj.serverFileName) {
                var samples = obj.samples
                if (!samples || samples.length == 0) {

                    showError("文件中没有数据")
                    return;
                }
                serverFile = obj.serverFileName
                showInformation("文件上传成功！");

                titles = obj.titles;

                var div = $(dataDivId);
                div.innerHTML = "";
                var tbody = ct(div);

                var dataTitleTr = document.createElement("TR");
                tbody.appendChild(dataTitleTr);
                //title
                var td
                var titleName
                for (var j = 0; j < titles.length; j++) {
                    titleName = titleMap[titles[j]]
                    td = document.createElement("TD");
                    td.className = ImportData.datatitle;
                    td.style.width = Math.floor(100 / titles.length) + "%"
                    td.innerHTML = titleName ? "<span style='color:blue'>" + titles[j] + "</span>" : "<span style='color:red'>" + (titles[j] ? titles[j] : "???") + "</span>"
                    td.colName = titleName ? titleName : false
                    dataTitleTr.appendChild(td);

                    titles[j] = titleName
                }

                //data
                var tr
                var sample
                for (var i = 0; i < samples.length; i++) {
                    tr = document.createElement("TR");
                    tbody.appendChild(tr);
                    sample = samples[i]
                    for (j = 0; j < titles.length; j++) {
                        td = document.createElement("TD");
                        td.innerHTML = sample[j] ? sample[j] : ""
                        tr.appendChild(td);
                    }
                }
                finish = true;
                dataTitleList = dataTitleTr.childNodes;
                for (var j = 0; j < dataTitleList.length; j++) {
                    td = dataTitleList[j];
                    td.pos = absp(td);
                }

            } else {
                finish = false;
                showError("文件上传失败！");
            }
        });
    }

    this.onSave = function () {
        if (!serverFile) {
            showError("请先上传数据文件");
            return;
        }
        if (!titles) {
            showError("数据列没有完全匹配可用字段");
            return;
        }
        var columnNames = [];
        for (var i = 0; i < dataTitleList.length; i++) {
            var td = dataTitleList[i];
            if (!td.colName) {
                showError("数据列没有完全匹配可用字段");
                return;
            }
            columnNames.push(td.colName)
        }
        if (showQuestion("是否导入这些数据?")) {
            DWR.call("generalImporter.importDataOnly", headFile, serverFile, columnNames, null,
                function (result) {
                    if (result) {
                        if (result.success == result.total) {
                            showInformation("成功导入" + result.success + "条数据");
                            dialogBackValue();
                        }
                        else {
                            var errorStr = "导入" + result.success + "条数据"
                            errorStr += ",处理数据["
                            var line = result.line
                            for (var i = 0; i < line.length; i++) {
                                if (i > 0)
                                    errorStr += ","
                                errorStr += line[i] ? line[i] : ""
                            }
                            errorStr += "]时发生错误:<br>" + result.errorMsg
                            showError(errorStr);
                        }
                    }
                }
            )
        }
    }
}
ImportData.datatitle = "datatitle";						//数据区，title样式
ImportData.insideClass = "insideclass";					//拖动层进入数据区title样式
ImportData.titleLayer = "titleLayer";					//拖动层样式
ImportData.evtover = "evtover";							//列选择区域over样式
ImportData.evtout = "evtout";							//列选择区域out样式