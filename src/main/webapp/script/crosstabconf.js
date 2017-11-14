function CrosstabView(divId, sqlName, dimensions, measures, defaultHorizon, defaultVertical, defaultMeasure, paramFunc) {
    var html = "";
    html += "<div id='chartView' style='display:none;'></div>";
    html += "<div id='pivotView'></div>";
    $(divId).innerHTML = html;

    $("pivotView").innerHTML = PivotPage.initPivotView();
    $("chartView").innerHTML = PivotPage.initChartView();
    var switchArea = function (pageId) {
        var areaList = ["pivotView", "chartView"]
        for (var i = 0; i < areaList.length; i++) {
            var c = $(areaList[i]);
            if (!c) continue;
            if (c.id == pageId) {
                c.style.display = "";
            } else {
                c.style.display = "none";
            }
        }
    }
    var conf = new CrossConf();
    conf.initCrosstab(dimensions, measures, defaultHorizon, defaultVertical, defaultMeasure);
    var showTable = function () {
        var params = paramFunc ? paramFunc() : {};
        var rows = conf.getDimensions();
        var cols = conf.getMeasures();
        DWR.call("crosstabService.statData", sqlName, rows, cols, params, function (obj) {
            crosstab.setData(obj);
            crosstab.show('pivottable')
        });
    }
    var showChart = function () {
        var params = paramFunc ? paramFunc() : {};
        var rows = conf.getChartDimensions();
        var cols = conf.getChartMeasures();
        DWR.call("crosstabService.statData", sqlName, rows, cols, params, function (obj) {
            PivotPage.Handler.FusionCharts(obj);
        });
    }
    //列表定制
    $("pivotpage_crosstab_conf").onclick = function () {
        conf.openCrossConfDlg(showTable)
    }
    //显示图表
    $("pivotpage_crosstab_chart").onclick = function () {
        switchArea("chartView");
        Page.chartType = 1
        showChart()
    }
    //图表定制
    $("pivotpage_chart_conf").onclick = function () {
        conf.openCrossConfDlg(showChart)
    }
    //显示列表
    $("pivotpage_chart_crosstab").onclick = function () {
        switchArea("pivotView");
        showTable()
    }
    //显示柱状图
    $("pivotpage_chart_1").onclick = function () {
        Page.chartType = 1
        showChart()
    }
    //显示饼状图
    $("pivotpage_chart_2").onclick = function () {
        Page.chartType = 2
        showChart()
    }
    this.showTable = function () {
        switchArea("pivotView");
        showTable()
    }
}

PivotPage.initPivotView = function () {
    return ""
        + "<p><button type='button' id='pivotpage_crosstab_conf' onclick=\"PivotPage.CrosstabConf.edit()\">定制</button>"
        + "<button type='button' id='pivotpage_crosstab_chart' onclick=\"PivotPage.showChart(1)\">图表</button>"
        + "<button type='button' onclick=\"WebPrint.preview('printArea')\">打印预览</button>"
        + "<button type='button' onclick=\"WebPrint.print('printArea')\">打印</button>"
        + "<button type='button' onclick=\"switchPage('queryView')\">返 回</button></p>"
        + "<div id='printArea'><div id='pivotable_head'></div><div align='center' id='pivotTable'></div></div>";
}
/**
 * 显示图表
 */
PivotPage.initChartView = function () {
    var s = "<div align='center'>"
        + "<p><button type='button' id='pivotpage_chart_conf' onclick=\"PivotPage.CrosstabConf.edit()\">定制</button>"
        + "<button type='button' id='pivotpage_chart_crosstab' onclick=\"PivotPage.showTable()\">报表</button>"
        + "<button type='button' id='pivotpage_chart_1' onclick=\"PivotPage.showChart(1)\">柱状图</button>"
        + "<button type='button' id='pivotpage_chart_2' onclick=\"PivotPage.showChart(2)\">饼状图</button>"
        + "<button type='button' onclick=\"switchPage('queryView')\">返 回</button></p>"
        + "<div id='flashContent'></div>"
        + "</div>";
    return s;
}
function CrossConf() {
    var idx = "IDX_" + (CrosstabConfig.IDX++);
    var data = {}
    this.initCrosstab = function (dimensions, measures, defaultHorizon, defaultVertical, defaultMeasure) {
        if (!window._crosstabData) window._crosstabData = {}
        data.dimensions = dimensions;
        data.measures = measures;

        data.defaultHorizon = defaultHorizon;
        data.defaultVertical = defaultVertical;
        data.defaultMeasure = defaultMeasure;

        data.currentHorizon = defaultHorizon;
        data.currentVertical = defaultVertical;
        data.currentMeasure = defaultMeasure;

        var pushItem = function (items, columns, isMeasure) {
            for (var p in items) {
                var d = items[p];
                if (typeof d == "function") continue;
                columns.push({name: p, title: d, isMeasure: isMeasure});
            }
        }
        //设置初始值
        var initColumns = [];
        pushItem(dimensions, initColumns, false);
        pushItem(measures, initColumns, true);

        data.initColumns = initColumns;
        window._crosstabData[idx] = data;
    }
    //报表设置
    this.openCrossConfDlg = function (handle) {
        if (!data) return;
        var url = spellUrl("../common/report/crosstab_conf.html", {idx: idx});
        openDialogFrame(url, '报表设置', 465, 500, function (res) {
            data.currentVertical = res.vertical;
            data.currentHorizon = res.horizon;
            data.currentMeasure = res.measure;
            data.rows = res.rows;
            data.cols = res.cols;
            if (typeof handle == "function")
                handle(res);
        });
    }
    this.getDimensions = function () {
        return CrosstabConf.formatResult(data.currentHorizon);
    }
    this.getMeasures = function () {
        var str = "";
        str += CrosstabConf.formatResult(data.currentVertical);
        str += "|";
        str += CrosstabConf.formatResult(data.currentMeasure);
        return str;
    }
    this.getCurrentHorizon = function () {
        return data.currentHorizon;
    }
    this.getCurrentVertical = function () {
        return data.currentVertical;
    }
    this.getCurrentMeasure = function () {
        return data.currentMeasure;
    }
    this.getChartDimensions = function () {
        var map = clone(data.currentHorizon);
        map = CrosstabConf.merge(map, data.currentVertical)
        return CrosstabConf.formatResult(map)
    }
    this.getChartMeasures = function () {
        var res = {}
        for (prop in data.currentMeasure) {
            var c = data.currentMeasure[prop]
            if (!c || typeof c == "function") continue;
            res[prop] = c
            break;
        }
        return "|" + CrosstabConf.formatResult(res)
    }
}
CrosstabConfig.IDX = 1000;

var CrosstabConf = {}
CrosstabConf.initCrosstab = function (dimensions, measures, defaultHorizon, defaultVertical, defaultMeasure) {
    window._crosstabData = {};
    window._crosstabData.dimensions = dimensions;
    window._crosstabData.measures = measures;

    window._crosstabData.defaultHorizon = defaultHorizon;
    window._crosstabData.defaultVertical = defaultVertical;
    window._crosstabData.defaultMeasure = defaultMeasure;

    window._crosstabData.currentHorizon = defaultHorizon;
    window._crosstabData.currentVertical = defaultVertical;
    window._crosstabData.currentMeasure = defaultMeasure;

    var pushItem = function (items, columns, isMeasure) {
        for (var p in items) {
            var d = items[p];
            if (typeof d == "function") continue;
            columns.push({name: p, title: d, isMeasure: isMeasure});
        }
    }
    //设置初始值
    var initColumns = [];
    pushItem(dimensions, initColumns, false);
    pushItem(measures, initColumns, true);

    window._crosstabData.initColumns = initColumns;
}
//报表设置
CrosstabConf.openCrossConfDlg = function (handle) {
    if (!window._crosstabData) return;
    var url = spellUrl("../common/report/crosstab_conf.html");
    openDialogFrame(url, '报表设置', 465, 500, function (data) {
        window._crosstabData.currentVertical = data.vertical;
        window._crosstabData.currentHorizon = data.horizon;
        window._crosstabData.currentMeasure = data.measure;
        window._crosstabData.rows = data.rows;
        window._crosstabData.cols = data.cols;
        if (typeof handle == "function")
            handle(data);
    });
}

CrosstabConf.getDimensions = function () {
    return CrosstabConf.formatResult(window._crosstabData.currentHorizon);
}
CrosstabConf.getMeasures = function () {
    var str = "";
    str += CrosstabConf.formatResult(window._crosstabData.currentVertical);
    str += "|";
    str += CrosstabConf.formatResult(window._crosstabData.currentMeasure);
    return str;
}
CrosstabConf.getCurrentHorizon = function () {
    return window._crosstabData.currentHorizon;
}
CrosstabConf.getCurrentVertical = function () {
    return window._crosstabData.currentVertical;
}
CrosstabConf.getCurrentMeasure = function () {
    return window._crosstabData.currentMeasure;
}
CrosstabConf.getChartDimensions = function () {
    var map = clone(window._crosstabData.currentHorizon);
    map = CrosstabConf.merge(map, window._crosstabData.currentVertical)
    return CrosstabConf.formatResult(map)
}
CrosstabConf.getChartMeasures = function () {
    var res = {}
    for (prop in window._crosstabData.currentMeasure) {
        var c = window._crosstabData.currentMeasure[prop]
        if (!c || typeof c == "function") continue;
        res[prop] = c
        break;
    }
    return "|" + CrosstabConf.formatResult(res)
}


CrosstabConf.formatResult = function (columns) {
    var str = "";
    if (columns)
        for (var prop in columns) {
            var dims = columns[prop];
            if (typeof dims == "function" || dims === false) continue;
            if (typeof dims == "object") {
                str += prop;
                for (var p in dims) {
                    var op = dims[p];
                    if (typeof op == "function" || op === false) continue;
                    str += "," + p
                }
            } else
                str += prop;
            str += ";";
        }
    return str;
}
CrosstabConf.merge = function (orig, map) {
    if (orig && map)
        for (p in map) {
            var d = map[p];
            if (typeof d == "function") continue;
            orig[p] = d
        }
    return orig
}
CrosstabConf.formatChartResult = function (columns) {
    var result = []
    var map = clone(window._crosstabData.dimensions);
    map = CrosstabConf.merge(map, window._crosstabData.measures);
    if (columns)
        for (var prop in columns) {
            var dims = columns[prop];
            if (typeof dims == "function" || dims === false) continue;
            var res = {}
            var str = "";
            if (typeof dims == "object") {
                str += prop;
                for (var p in dims) {
                    var op = dims[p];
                    if (typeof op == "function" || op === false) continue;
                    str += "," + p
                }
            } else
                str += prop;
            str += ";";
            var obj = map[prop];
            if (typeof obj == "object")
                res.text = obj.name;
            else
                res.text = obj;
            res.value = str;
            result.push(res);
        }
    return result
}

function CrosstabConfig(divId, columns) {
    var confDivId = divId;
    var confLayer, tabLayer, flagLayer, listdiv, rowsdiv, colsdiv, datadiv;
    var insideDiv;										//当前框
    var idx = 1000;										//序号
    var divArray = [];
    var nodeMap = {};									//可选择统计维度、数据map，key=name,value=div
    this.columns = columns;
    this.currentVertical;
    this.currentHorizon;
    this.currentMeasure;
    var initColumnMap = {}
    var currentData = {currentVertical: {}, currentHorizon: {}, currentMeasure: {}};
    var cheboxValueMap = {}								//机构、时间等checkbox是否被选择的map
    this.showTable = function () {
        initDefColumnsMap(this.currentVertical);
        initDefColumnsMap(this.currentHorizon);
        drawTable();
        drawColumns(this.columns);
        insertDiv(colsdiv, this.currentVertical);
        insertDiv(rowsdiv, this.currentHorizon);
        insertDiv(datadiv, this.currentMeasure);
    }
    var setResult = function (d, map) {
        var value = nodeMap[d.get('field')].value;
        var node = initColumnMap[d.get('field')];
        var t = node.title;
        if (typeof t == "object") {
            var optArray = value.split(",")
            var option = {}
            var b = false
            for (var i = 1; i < optArray.length; i++) {
                var o = optArray[i];
                option[o] = true
                b = true
            }
            if (!b) throw new Error(node.title.name + "不能为空")
            map[node.name] = option;
        } else {
            map[node.name] = node.title;
        }
        return value + ";"
    }
    this.getHorizon = function () {
        var me = this
        me.currentHorizon = {}
        var str = "";
        rowsdiv.getChildren('div').each(function (item) {
            str += setResult(item, me.currentHorizon);
        })
        return str;
    }
    this.getVertical = function () {
        var me = this
        me.currentVertical = {}
        var str = "";
        colsdiv.getChildren('div').each(function (item) {
            str += setResult(item, me.currentVertical);
        })
        return str;
    }
    this.getMeasure = function () {
        var me = this
        me.currentMeasure = {}
        var str = "";
        datadiv.getChildren('div').each(function (item) {
            str += setResult(item, me.currentMeasure);
        })
        return str;
    }
    this.getParams = function () {
        var data = {}
        var m = this.getMeasure();
        if (!m) throw new Error("请选择数据项！");
        var h = this.getHorizon();
        var v = this.getVertical();
        if (!v && !h) throw new Error("请选择统计维度！");
        data.rows = h;
        data.cols = v + "|" + m;
        data.horizon = this.currentHorizon;
        data.vertical = this.currentVertical;
        data.measure = this.currentMeasure;
        return data;
    }
    var drawTable = function () {
        var div = $(confDivId);
        var html = "<div id='" + confDivId + "_conf_layer' class='confLayer' style='display:none;'><div id='" + confDivId + "_vf'></div></div>";
        html += "<table cellSpacing='0' cellPadding='4' border='0' class='label6'>";
        html += "<tr><td width='150px' valign=top class='titleClass'>";
        html += "可选统计维度和数据项";
        html += "</td>";
        html += "<td valign=top class='titleClass'>";
        html += "统计维度设置预览";
        html += "</td></tr>";

        html += "<tr><td width='150px' valign=top>";
        html += "<div id='" + confDivId + "_list'></div>";
        html += "</td>";
        html += "<td>";

        html += "<table cellSpacing='0' cellPadding='4' width='300px;' border='1' class='label6'>";
        html += "<tr><td width='150px;' height='160px;'>";
        html += "</td>";
        html += "<td width='150px;' height='160px;' class='verticalTd' id='" + confDivId + "_cols' valign='top'><div id='" + confDivId + "_null_cols' class='nulltext'>列维度</div>";
        html += "</td></tr>";
        html += "<tr><td width='150px;' height='160px;' class='horizonTd' id='" + confDivId + "_rows' valign='top'><div id='" + confDivId + "_null_rows' class='nulltext'>行维度</div>";
        html += "</td>";
        html += "<td width='150px;' height='160px;' id='" + confDivId + "_data' class='measureTd' valign='top'><div id='" + confDivId + "_null_data' class='nulltext'>数据项</div>";
        html += "</td></tr>";
        html += "</table>";

        html += "</td></tr>";
        html += "</table>";
        div.innerHTML = html;
        listdiv = $(confDivId + "_list");

        colsdiv = $(confDivId + "_cols");
        rowsdiv = $(confDivId + "_rows");
        datadiv = $(confDivId + "_data");

        colsdiv.nullTextDiv = $(confDivId + "_null_cols");
        rowsdiv.nullTextDiv = $(confDivId + "_null_rows");
        datadiv.nullTextDiv = $(confDivId + "_null_data");

        colsdiv.set('isMeasure', false);
        rowsdiv.set('isMeasure', false);
        datadiv.set('isMeasure', true);

        divArray.push(rowsdiv);
        divArray.push(colsdiv);
        divArray.push(datadiv);
    }
    var initDefColumnsMap = function (cols) {
        if (!cols) return;
        for (var p in cols) {
            var value = cols[p];
            if (typeof value == "object") {
                for (var prop in value) {
                    var v = value[prop];
                    if (typeof v == "function" || v === false) continue;
                    cheboxValueMap[p + "" + prop] = true
                }
            }
        }
    }
    var drawColumns = function (columns) {
        for (var i = 0; i < columns.length; i++) {
            var c = columns[i];
            createNode(c);
            initColumnMap[c.name] = c;
        }
    }

    var insertDiv = function (pDiv, currentColumns) {
        if (!currentColumns) return;
        pDiv.removeChild(pDiv.nullTextDiv);
        for (var p in currentColumns) {
            var value = currentColumns[p];
            if (typeof value == "function" || value === false) continue;
            var c = currentColumns[p];
            if (typeof c == "object") {
                var b = false
                for (var prop in c) {
                    var v = c[prop];
                    if (typeof v == "function") continue;
                    if (v) {
                        b = true
                        break;
                    }
                }
                if (!b) continue;
            }
            var div = nodeMap[p];
            if (div) {
                div.selected = true;
                div.className = "listNode selFont";
                pDiv.appendChild(createTabDiv(div));
            }
        }
    }
    var getConfLayer = function () {
        if (!confLayer) confLayer = $(confDivId + "_conf_layer");
        return confLayer;
    }


    //统计列层

    var evtMouseDown = function (e) {
        e = new Event(e).stop();

        var layer = getConfLayer();
        var div = layer.getChildren()[0]
        div.set('class', "up_no viewframe")
        div.set('html', this.get('html'))

        layer.style.display = "";
        var coord = this.getCoordinates()
        coord.x -= 5
        coord.y -= 5
        layer.setStyles(coord)

        var orig = this
        var drag = layer.makeDraggable({
            droppables: divArray,
            onCancel: function (element) { // due to MooTool's inheritance, all [Drag][]'s Events are also available.
                layer.style.display = "none"
            },
            onDrop: function (element, droppable) {
                if (droppable && orig.get('isMeasure') == droppable.get('isMeasure')) {
                    var div = orig.id.indexOf('_') == 0 ? orig : $("_" + orig.id);
                    if (!div) {
                        div = createTabDiv(orig);
                    }
                    droppable.grab(div)
                }
                layer.style.display = "none"
            },
            onEnter: function (element, droppable) {
                element.childNodes[0].className = orig.get('isMeasure') == droppable.get('isMeasure') ? "up_yes viewframe" : "up_no viewframe"

                droppable.set('class', "layerin")
            },

            onLeave: function (element, droppable) {

                element.getChildren()[0].set('class', "up_no viewframe")

                droppable.set('class', "layerout")
            }

        }); // this returns the dragged element

        drag.start(e); // start the event manual

    }

    var selOption = function () {
        var pos = this.getPosition();
        var l = $(this.idx + "_layer");
        l.className = "optionLayer";
        l.style.display = "";
        l.style.left = (pos.x - 2) + "px";
        l.style.top = pos.y + "px";
    }
    var showOption = function () {
        this.style.display = "";
    }
    var hideOption = function () {
        this.style.display = "none";
    }
    var createNode = function (c) {
        var pdiv = new Element("DIV");
        var div = new Element("DIV", {
            id: "divid" + idx,
            'class': "colOut listNode",
            isMeasure: c.isMeasure,
            field: c.name,
            value: c.name,
            events: {
                mousedown: evtMouseDown
            }
        })
        pdiv.appendChild(div);
        listdiv.appendChild(pdiv);
        idx++;
        var title = "";
        if (typeof c.title == "object") {
            title = c.title.name;
            var d = new Element("DIV");
            d.innerHTML = "<a href=# id='" + div.id + "_a'><div style='padding-top:5px;'><img src='../../images/icon/down.jpg' title='设置详细维度'></div></a><div id='" + div.id + "_layer' style='display:none;'></div>"
            pdiv.appendChild(d);
            var l = $(div.id + "_layer");
            var a = $(div.id + "_a");
            a.idx = div.id;
            a.addEvent("click", selOption);
            l.addEvent("mouseout", hideOption);
            l.addEvent("mouseover", showOption)
            var optionValue = c.name;
            for (var p in c.title.option) {
                var op = c.title.option[p];
                if (typeof op == "function") continue;
                var cbdiv = new Element("DIV");
                var span = new Element("SPAN");
                span.innerHTML = op;
                var checked = cheboxValueMap[c.name + "" + p];
                var cb;
                if (isIE() && checked) {
                    cb = new Element("<INPUT CHECKED>")
                } else {
                    cb = new Element("INPUT")
                    cb.checked = checked;
                }
                cb.type = "checkbox";
                cb.value = p;
                if (checked) optionValue += "," + p;
                cbdiv.appendChild(cb);
                cbdiv.appendChild(span);
                l.appendChild(cbdiv);
                cb.addEvent("click", function () {
                    var ckd = this.checked;
                    var s = false;
                    var cbs = $(div.id + "_layer").getElementsByTagName("INPUT")
                    var dv = c.name;
                    for (var i = 0; i < cbs.length; i++) {
                        var cbx = cbs[i];
                        if (cbx.value == this.value)
                            s = true

                        if ((ckd && !s) || (!ckd && s))
                            cbx.checked = ckd

                        if (cbx.checked) dv += "," + cbx.value;
                    }
                    div.value = dv;
                })
                cb.addEvent("mouseover", function () {
                    $(div.id + "_layer").style.display = "";
                })
            }
            div.value = optionValue;
        } else
            title = c.title;
        div.set('html', (c.isMeasure ? "数据" : "维度") + ":" + title)

        nodeMap[c.name] = div;
    }

    var createTabDiv = function (obj) {
        var div = new Element("DIV", {
            id: "_" + obj.id,
            html: obj.get('html'),
            value: obj.get('value'),
            field: obj.get('field'),
            isMeasure: obj.get('isMeasure'),
            'class': "listNode",
            events: {
                mousedown: evtMouseDown
            }
        })

        return div;
    }

}
