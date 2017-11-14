function DWR() {
}

//override this method in eui or other place
DWR._errorHandler = function (message) {
    var msg = message;
    if (typeof message == "object" && message.name == "Error" && message.description) {
        msg = message.description;
    }
    if (msg == DWR.SESSION_TIME_OUT) {
        alert(msg);//手机提示有问题，暂时去掉 2014-12-24
    }
};
DWR._verb = "post";
DWR._async = true;

//call action
DWR.syncCall = function (actionName) {
    try {
        if (!actionName)
            throw new Error("must provide actionName")
        var args = arguments;
        var c = {}

        var lastArgIndex = args.length - 1;

        var ss = actionName.split('.')
        var path = contextRoot + "d/dwr/" + ss[0]
        if (ss[1]) path += "/" + ss[1]
        c.path = path;
        c.verb = DWR._verb;
        c.async = false;
        c.directreturn = true;
        c.map = {};

        /*for (var i = 1; i <= lastArgIndex; i++) {
         if (args[i]){
         c.map['p'+(i-1)] = DWR.toJSON(args[i]);
         }
         }*/
        if (lastArgIndex >= 1) {
            var params = []

            for (var i = 1; i <= lastArgIndex; i++) {
                params[i - 1] = args[i]
            }
            c.map.ps = DWR.toJSON(params)
        }

        return DWR._sendData(c);
    } catch (e) {
//		throw new Error(e.message);
        DWR._errorHandler(e.message)

    }
};

DWR.call = function (actionName) {

    if (!actionName)
        throw new Error("must provide actionName")
    var args = arguments;
    var c;

    var lastArg = args[args.length - 1];
    var lastArgIndex = args.length - 1;
    if (args.length == 1) {
        c = {}
    }
    else if (typeof lastArg == "function") {
        c = {callback: lastArg};
        lastArgIndex = args.length - 2;
    }
    else if (typeof lastArg == "object") {

        var last2Arg
        if (args.length >= 2)
            last2Arg = args[args.length - 2];
        if (typeof last2Arg == "function") {
            c = lastArg;
            c.callback = last2Arg;
            lastArgIndex = args.length - 3;
        }
        else {
            c = {}
        }
    }
    else c = {}
    var ss = actionName.split('.')
    var path = contextRoot + "d/dwr/" + ss[0]
    if (ss[1]) path += "/" + ss[1]
    c.path = path;
    if (c.verb == null) {
        c.verb = DWR._verb;
    }
    if (c.async == null) {
        c.async = DWR._async;
    }

    c.map = {};

    /*for (var i = 1; i <= lastArgIndex; i++) {
     if (args[i]){
     c.map['p'+(i-1)] = DWR.toJSON(args[i]);
     }
     }*/

    if (lastArgIndex >= 1) {
        var params = []

        for (var i = 1; i <= lastArgIndex; i++) {
            params[i - 1] = args[i];
        }
        c.map.ps = DWR.toJSON(params)
    }

    if (c.blockScreen) {
        Loading.blockScreen();
    }
    else {
        var cObj = c.disCtrl;
        if (cObj) {
            if (cObj.length) {
                if (cObj.length > 0) {
                    for (var j = 0; j < cObj.length; j++) {
                        cObj[j].disabled = true;
                    }
                }
            }
            else {
                cObj.disabled = true;
            }
        }
        if (c.loading) Loading.addLoading(c.loading);
    }

    DWR._sendData(c);
}
DWR.SESSION_TIME_OUT = "session time out"
DWR._sendData = function (c) {

    var result
    var req = new Request({
        url: c.path, method: c.verb, async: c.async,
        data: c.map,
        onSuccess: function (text) {
            if (!text) {
                alert('网络连接超时，请检查网络状况后重试');
                return;
            }
            var obj;
            try {
                eval('obj=' + text)
                if (obj && obj._error) {
                    if (c.async)
                        DWR._errorHandler(obj._error);
                    else {
                        c._err = obj._error
                        if (obj._error == DWR.SESSION_TIME_OUT)
                            DWR._errorHandler(obj._error);

                    }
                }
                else {
                    if (c.directreturn) {
                        result = obj
                    }
                    else if (c.callback) c.callback(obj);
                }
            } finally {
                if (window.DWR)		//maybe page unavailabe
                    DWR._onComplete(c)
            }
        },
        onFailure: function () {

            try {
                if (c.async)
                    alert("网络超时请核对交易流水,请勿重复提交!");
                else
                    c._err = "Network connection error"
            } finally {
                if (window.DWR)		//maybe page unavailabe
                    DWR._onComplete(c)
            }
        }
    })


    req.success = Rpc._success
    req.send();
    if (c._err)
        throw new Error(c._err)
    return result
};

DWR._onComplete = function (c) {

    if (c.finalFunc) {
        try {
            c.finalFunc();
        }
        catch (ex) {
            DWR._errorHandler(ex);
        }
    }

    if (c.blockScreen) {
        Loading.cancelBlockScreen();
    }
    var cObj = c.disCtrl;
    if (cObj) {
        if (cObj.length) {
            if (cObj.length > 0) {
                for (var j = 0; j < cObj.length; j++) {
                    cObj[j].disabled = false;
                }
            }
        }
        else {
            cObj.disabled = false;
        }
    }
    if (c.loading) Loading.removeLoading(c.loading);
}


DWR.SLASHREG = new RegExp("\\\\", "gm");
DWR.QUOTEREG = new RegExp("'", "gm");


DWR._escJSONStr = function (str) {
    return "'" + str + "'"

}

DWR.toJSON = function (obj) {

    switch ($type(obj)) {
        case 'string':
            return obj.replace(DWR.SLASHREG, "\\\\").replace(DWR.QUOTEREG, "\\'");
        case 'array':
            return '[' + String(obj.map(function (value) {
                    var json = DWR.toJSON(value);
                    if (json) {
                        if ($type(value) == 'string')
                            json = DWR._escJSONStr(json)
                    }
                    return json
                }).filter($defined)) + ']';
        case 'object':
        case 'hash':
            var string = [];
            Hash.each(obj, function (value, key) {
                var json = DWR.toJSON(value);
                if (json != null) {
                    if ($type(value) == 'string')
                        json = DWR._escJSONStr(json)
                    string.push(key + ':' + json);
                }
            });
            return '{' + string + '}';
        case 'number':
        case 'boolean':
            return String(obj);
        case 'date':
            return obj.getTime()
        case false:
            return 'null';
    }
    return null;
}

function Rpc() {
}
/*
 **获取某个文件的内容(同步方法)
 **@param url - 文件路径，如："person_detail.html"
 **@param id - 获取内容后显示区域的id，如某个<div>的id
 */
Rpc.loadPage = function (id, url) {
    if (url.charAt(0) == "/") {
        url = url.substring(1);
        url = appRoot + url;
    }

    var req = new Request({
        url: url, method: 'get', async: false,
        onSuccess: function (text) {
            $(id).set('html', text);
            //Eui.showCurrency();
        },
        onFailure: function () {
            alert('读取数据失败，请刷新页面');
        }
    })

    req.success = Rpc._success
    req.send();
}

//用来代替mootools的Request.success (原方法中会试图处理text中的script)
Rpc._success = function (text, xml) {
    this.onSuccess(text, xml);
}