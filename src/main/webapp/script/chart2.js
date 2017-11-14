/**
 *
 * Helper classes for FusionCharts
 *
 * @copyright(c) Copyright G&D Corporation 2007.
 * @author lushu
 * @version v0.4
 */

/**
 * Proxy Class for FusionCharts.
 * The basic point is to block setting the data until the swf object is loaded.
 * @prarm swfFile - the flash file will be loaded.
 * @param xml - the xml content.
 * @param div - the id of the HTMLElement DIV that will contains the Flash object. Default: "flashContent"
 * @param id - the id of the Flash Object. Default: "chart0"
 */
function FusionChartsProxy(swfFile, xml, div, id) {
    this.swfFile = swfFile;
    this.xml = xml;
    this.div = div ? div : "flashContent";
    this.id = id ? id : "chart0";
    this.chart = new FusionCharts(
        this.swfFile,			//flash type
        this.id,				//chart id
        800,					//height
        400);					//width
}
FusionChartsProxy.prototype.show = function () {
    this.chart.setDataXML(this.xml.replace(/"/g, "'"));
    this.chart.render(this.div);
}
/**
 * Superclass of all kinds of Charts classes.
 */
function FusionChartsBase() {
}
FusionChartsBase.SWF_FOLDER = "../swf/";
FusionChartsBase.prototype = {
    //Contruct method
    _init_: function () {
        this.swf = FusionChartsBase.SWF_FOLDER + this.type + ".swf";
        this.template = FusionChartsBase.SWF_FOLDER + this.type + ".xml";

        this.xmlDoc = XML.load(this.template);
        var graph = this.xmlDoc.getElementsByTagName("graph");
        if (graph.length == 0) {
            showError("载入数据模板失败");
            this.flag = false;
            return;
        }
        this.graph = graph[0];
    },
    //Serialize
    getXML: function () {
        return XML.serialize(this.xmlDoc);
    },
    //Set the data and show the flash
    setAndShow: function (data) {
        this.setData(data);
        this.show();
    },
    //Show the flash
    show: function () {
        var chart = new FusionChartsProxy(this.swf, this.getXML(), this.div, this.id);
        chart.show();
    },
    setData: function (v) {
        if (this.isMultiple)
            this.setMultiData(v);
        else
            this.setSingleData(v);
    },
    //Set data to XML object
    setSingleData: function (v) {
        var setIndex = 0;
        for (var index in v) {
            if (typeof v[index] == "function")
                continue;
            var node = v[index];
            var color = this.getColor(setIndex);
            var setE = this.getSetE([node[0], node[2]], color);
            this.graph.appendChild(setE);

            setIndex++;
        }
    },
    //Set data to XML object
    setMultiData: function (v) {
        var category, categoryE;
        var categoriesE = this.getCategoriesE();
        var current, series = {};
        var node;
        var setIndex = 0;
        for (var index in v) {
            if (typeof v[index] == "function")
                continue;
            node = v[index];
            if (category != node[0]) {
                categoryE = this.getCategoryE();
                categoryE.setAttribute("name", node[0]);
                categoriesE.appendChild(categoryE);
                category = node[0];
            }
            current = node[1];
            var dataset = series[current];
            if (!dataset) {
                dataset = this.getDataSetE();
                var color = this.getColor(setIndex);
                dataset.setAttribute("seriesname", current);
                dataset.setAttribute("color", color);
                series[current] = dataset;
                setIndex++;
            }
            dataset.appendChild(this.getSetE([node[1], node[2]]));
        }
        this.graph.appendChild(categoriesE);
        //这部分代码暂时没有用上(多维统计图,所以暂时不删除)
//						for (var x in series){
//							if (typeof(series[x])!='function')
//								this.graph.appendChild(series[x]);
//						}
        series.each(function (v) {
            alert(1);
            this.graph.appendChild(v);
        });
    },
    //get the corresponding color
    getColor: function (index) {
        return this.COLORS[index % this.COLORS.length];
    },

    //get a new Element of "set"
    getSetE: function (obj, color) {
        var set = XML.createElement("set");
        set.setAttribute("name", obj[0]);
        set.setAttribute("value", obj[1]);
        if (color)
            set.setAttribute("color", color);
        return set;
    },
    getCategoryE: function () {
        return XML.createElement("category");
    },
    getCategoriesE: function () {
        return XML.createElement("categories");
    },
    getDataSetE: function () {
        return XML.createElement("dataset");
    },
    //set the attribute
    setAttribute: function (fullAttr, value) {
        var x = fullAttr.split("@");
        if (x.length > 2) {//too many attributes;
            showError("错误的属性:" + fullAttr);
            return;
        }
        var y = x[0];
        var attr = (x.length == 2) ? x[1] : "text";
        var tags = y.split(".");
        var node = this.xmlDoc;
        for (var i = 0; i < tags.length; i++) {
            node = node.getElementsByTagName(tags[i]);
            if (node.length == 0) {//there is no such node
                showError("不存在的节点:" + y + "[" + i + "]");
                return;
            }
            node = node[0];
        }
        node.setAttribute(attr, value);
    },
    //set the attributes in the map
    setAttributes: function (map) {
        for (var key in map) {
            if (typeof map[key] == "function")
                continue;
            this.setAttribute(key, map[key]);
        }
    }
}

/**
 * Chart 2D Pie
 */
function FusionChart2DPie() {
    this._init_();
}
FusionChart2DPie.prototype = new FusionChartsBase();
FusionChart2DPie.prototype.type = "FCF_Pie2D";
FusionChart2DPie.prototype.COLORS = ["AFD8F8", "F6BD0F", "8BBA00", "FF8E46", "008E8E", "D64646", "8E468E", "588526", "B3AA00", "008ED6", "9D080D", "A186BE"];
/**
 * Chart 2D Column
 */
function FusionCharts2DColumn() {
    this._init_();
}
FusionCharts2DColumn.prototype = new FusionChartsBase();
FusionCharts2DColumn.prototype.isMultiple = false;
FusionCharts2DColumn.prototype.type = "FCF_Column2D";
FusionCharts2DColumn.prototype.COLORS = ["AFD8F8", "F6BD0F", "8BBA00", "FF8E46", "008E8E", "D64646", "8E468E", "588526", "B3AA00", "008ED6", "9D080D", "A186BE"];
/**
 * MS Chart 2D Column
 */
function FusionChartsMS2DColumn() {
    this._init_();
}
FusionChartsMS2DColumn.prototype = new FusionChartsBase();
FusionChartsMS2DColumn.prototype.isMultiple = true;
FusionChartsMS2DColumn.prototype.type = "FCF_MSColumn2D";
FusionChartsMS2DColumn.prototype.COLORS = ["0x419AFF", "0x104CC7", "0x080070"];