function Rpc(id, url, handle, options) {
    this.targetId = "";
    this.id = id;
    this.url = url;
    this.handle = handle;
    this.options = options;
    var xmlhttp;
    if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
    } else {
        xmlhttp = new XMLHttpRequest;
    }
    var me = this;
    xmlhttp.onreadystatechange = function () {
        Rpc.outputPage(me, xmlhttp);
    }
    this.req = function () {
        xmlhttp.open("GET", this.url, false);
        xmlhttp.setRequestHeader("Content-Type", "text/xml");
        xmlhttp.send(null);
        //同步情况下，firefox回调方式不同
        if (!window.ActiveXObject) {
            Rpc.outputPage(me, xmlhttp);
        }
    }
}
Rpc.outputPage = function (me, xmlhttp) {
    if (xmlhttp.readyState == 4) {
        if (xmlhttp.status == 200) {
            if (me.id) {
                if (me.id.innerHTML) me.id.innerHTML = xmlhttp.responseText;
                else
                    $(me.id).innerHTML = xmlhttp.responseText;
            }
            if (typeof me.handle == "function")
                me.handle(me.options)
        }
        else {
            showInfo("读取数据失败，请刷新页面");
        }
    }
}
/*
 **获取某个文件的内容
 **@param url - 文件路径，如："person_detail.html"
 **@param id - 获取内容后显示区域的id，如某个<div>的id
 **@param func - 回调方法，回调方法会收到两个参数(str,id)，str是文件内容，id是显示区域id。
 */
Rpc.loadPage = function (id, url, func, options) {
    if (url.charAt(0) == "/") {
        url = url.substring(1);
        url = appRoot + url;
    }
    var obj = new Rpc(id, url, func, options);
    obj.req();
}