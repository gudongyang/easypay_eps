/**
 *
 * Helper classes for AnyChart
 *
 * @copyright(c) Copyright G&D Corporation 2007.
 * @author lushu
 * @version v0.2
 */

/**
 * Contails several 'static' methods for operating xml objects<br>
 * Some of these methods are from <JavaScript: The Definitive Guide, 5th Edition>
 */
function XML() {
}
//Create and Return a new XML Document
XML.newDocument = function () {
    if (!isIE()) {
        // This is the W3C standard way to do it
        return document.implementation.createDocument("", "", null);
    } else {
        return new ActiveXObject("MSXML2.DOMDocument");
    }
};

XML.parse = function (text) {
    if (!isIE()) {
        // Mozilla, Firefox, and related browsers
        return new DOMParser().parseFromString(text, "application/xml");
    }
    else {
        // Internet Explorer.
        var doc = XML.newDocument();  // Create an empty document
        doc.async = false;  // synchronously
        doc.loadXML(text);			// Parse text into it
        return doc;				   // Return it
    }
};
//Create a new XML and Synchronized load file to it
XML.load = function (url) {
    var xmlStr
    var req = new Request({
        url: url, method: 'get', async: false,
        onSuccess: function (text) {
            xmlStr = text
        },
        onFailure: function () {
            showInfo("读取数据失败，请刷新页面");
        }
    })

    req.success = Rpc._success
    req.send();
    if (!xmlStr) return
    return XML.parse(xmlStr)
};

//function toString
XML.serialize = function (node) {
    if (typeof XMLSerializer != "undefined")
        return (new XMLSerializer()).serializeToString(node);
    else if (node.xml)
        return node.xml;
    else
        throw "XML.serialize is not supported or can't serialize " + node;
};
XML.xml = XML.newDocument();//default empty XML Object
/**
 * A newly created Element node with the specified tag name.
 * This method is different from the method from Object Document by do not up case the elements
 */
XML.createElement = function (name) {
    return XML.xml.createElement(name);
}
/**
 * A newly created Text node that represents the specified data string.
 */
XML.createTextNode = function (value) {
    return XML.xml.createTextNode(value);
}

/**
 * Proxy Class for AnyChart.
 * The basic point is to block setting the data until the swf object is loaded.
 * @prarm swfFile - the flash file will be loaded.
 * @param xml - the xml content.
 * @param div - the id of the HTMLElement DIV that will contains the Flash object. Default: "flashContent"
 * @param id - the id of the Flash Object. Default: "chart0"
 */
function AnyChartProxy(swfFile, xml, div, id) {
    this.swfFile = swfFile;
    this.xml = xml;
    this.div = div ? div : "flashContent";
    this.id = id ? id : "chart0";
    this.anyChart = new AnyChart(
        this.swfFile,			//flash type
        '',						//url of the xml will be loaded. No use here.
        this.id,				//chart id
        700,					//height
        400);					//width
    this.anyChart.write(this.div);
}
AnyChartProxy.LOAD_INTERVAL = 100; //Interval Time between loads. Unit: millisecond
//Show the chart
AnyChartProxy.prototype.show = function () {
    Loading.showFrameLoading()
    $(this.div).style.display = "";
    var chart = this;
    var interval = window.setInterval(function () {
        if ($(chart.id).SetXMLText) {
            window.clearInterval(interval);
            $(chart.id).SetXMLText(chart.xml);
            Loading.hideFrameLoading();
        }
    }, AnyChartProxy.LOAD_INTERVAL);
}

/**
 * Superclass of all kinds of Charts classes.
 */
function ChartBase() {
}
ChartBase.SWF_FOLDER = "../swf/";
ChartBase.NO_DATA = XML.parse("<text text='没有统计数据' auto_size='yes' x='300' y='190' >"
    + "<font color='White' size='14' align='center' type='Verdana'/>"
    + "<background enabled='no' color='#999999'/>"
    + "<border enabled='yes' color='White'/></text>").getElementsByTagName("text")[0];
ChartBase.prototype = {
    //Contruct method
    _init_: function () {
        this.swf = ChartBase.SWF_FOLDER + this.type + ".swf";
        this.template = ChartBase.SWF_FOLDER + this.type + ".xml";
        this.xmlDoc = XML.load(this.template);
        this.flag = true;
        var oldData = this.xmlDoc.getElementsByTagName("data");
        var objects = this.xmlDoc.getElementsByTagName("objects");
        if (oldData.length == 0 || objects.length == 0) {
            showError("载入数据模板失败");
            this.flag = false;
            return;
        }
        this.oldData = oldData[0];
        this.objects = objects[0];
    },
    //Serialize
    getXML: function () {
        return XML.serialize(this.xmlDoc);
    },
    //Show the flash
    show: function () {
        var chart = new AnyChartProxy(this.swf, this.getXML());
        chart.show();
    },
    //Set the data and show the flash
    setAndShow: function (data) {
        this.setData(data);
        this.show();
    },
    //Set data to XML object
    setData: function (v) {
        var dataE = this.getDataE();
        var block, blockE;
        var node;
        var setIndex;
        for (var index in v) {
            if (typeof v[index] == "function")
                continue;
            node = v[index];
            if (block != node[0]) {
                if (blockE)
                    dataE.appendChild(blockE);
                blockE = this.getBlockE();
                blockE.setAttribute("name", node[0]);
                block = node[0];
                setIndex = 0;
            }
            var color = this.getColor(setIndex);
            var setE = this.getSetE([node[1], node[2]], color);
            blockE.appendChild(setE);
            setIndex++;
        }
        if (blockE)
            dataE.appendChild(blockE);
        else {//if the block element never initiated, an empty one is needed.
            dataE.appendChild(this.getBlockE());
            this.objects.appendChild(ChartBase.NO_DATA);
        }
        this.replace(dataE);
    },
    //set the "text" attribute of the given element
    setText: function (element, value) {
        var node = this.xmlDoc.getElementsByTagName(element);
        if (node.length > 0)
            node[0].setAttribute("text", value);
    },
    //get the corresponding color
    getColor: function (index) {
        return this.COLORS[index % this.COLORS.length];
    },
    //get a new Element of "data"
    getDataE: function () {
        return XML.createElement("data");
    },
    //get a new Element of "block"
    getBlockE: function () {
        return XML.createElement("block");
    },
    //get a new Element of "set"
    getSetE: function (obj, color) {
        var set = XML.createElement("set");
        set.setAttribute("name", obj[0]);
        set.setAttribute("value", obj[1]);
        set.setAttribute("color", color);
        if (this.getSetChildE) //mainly for background
            set.appendChild(this.getSetChildE(color));
        return set;
    },
    //replace the "data" node with given data
    replace: function (data) {
        this.oldData.parentNode.replaceChild(data, this.oldData);
        //this.oldData = data;//refresh mode
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
    },
    //set the attribute "name"
    setName: function (name) {
        this.setAttribute("root.type.workspace.name@text", name);
        //for unique tag, can use like this: this.setAttribute("name",name)
    },
    //set the attribute "subname"
    setSubName: function (subname) {
        this.setAttribute("root.type.workspace.subname@text", subname);
    }
}

/**
 * Chart 2D Pie
 */
function Chart2DPie() {
    this._init_();
}
Chart2DPie.prototype = new ChartBase();
Chart2DPie.prototype.type = "2DPie";
Chart2DPie.prototype.COLORS = ['0x418CF0', '0x7397C1', '0xCB9236'];
Chart2DPie.prototype.getSetChildE = function (color) {
    return this.getBackgroundE(color);
}
Chart2DPie.prototype.getBackgroundE = function (color) {
    var background = XML.createElement("background");
    background.setAttribute("type", "gradient");
    background.appendChild(this.getColorsE(color));
    return background;
}
Chart2DPie.prototype.getColorsE = function (color) {
    var colors = XML.createElement("colors");
    colors.appendChild(this.getColorE(color));
    colors.appendChild(this.getColorE(color));
    return colors;
}
Chart2DPie.prototype.getColorE = function (color) {
    var colorEle = XML.createElement("color");
    colorEle.appendChild(XML.createTextNode(color));
    return colorEle;
}

/**
 * Chart Stack 3D Column
 */
function ChartStacked3DColumn() {
    this._init_();
}
ChartStacked3DColumn.prototype = new ChartBase();
ChartStacked3DColumn.prototype.type = "Stacked3DColumn";
ChartStacked3DColumn.prototype.COLORS = ["0xFDF6E6", "0xFFC080", "0xB0FF80"];

/**
 * Chart 2D Column
 */
function Chart2DColumn() {
    this._init_();
}
Chart2DColumn.prototype = new ChartBase();
Chart2DColumn.prototype.type = "2DColumn";
Chart2DColumn.prototype.COLORS = ["0x419AFF", "0x104CC7", "0x080070"];