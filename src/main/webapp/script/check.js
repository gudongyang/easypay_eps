/**
 * 校验库
 **/
Validator = {
    Time: /^(([0-1][0-9])|2[0-3]):[0-5][0-9]:[0-5][0-9]$/,
    Email: /^[\u0391-\uFFE5\w]+[-+.\u0391-\uFFE5\w]*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
    Tel: /^((\+)?\d{2,3}(-)?)?((0)?\d{2,3}(-)?)?[1-9]\d{6,8}((-)\d{1,4})?$/,
    Mobile: /^((\+)?\d{2,3}(-)?)?(0)?1[35]\d{9}$/,
    Url: /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
    IdCard: /^(\d{17}|\d{14})[\da-zA-Z]$/,
    BankCard: /^(\d{16}|\d{19})$/,
    CheckNo: /^[A-Za-z0-9]+$/,
    OrgId: /^(\d{15}|\d{13})$/,
    OrgCode: /^[A-Z0-9]{8}(-)?[A-Z0-9]{1}]?$/,
    OfficerId: /^\d{7}$/,
    Passport: /^[A-Z\d]{7,9}$/,
    Currency: /^\d+(\.\d+)?$/,
    DateFormat: /^([1-2]{1}[0-9]{3}(-){1}(([0]{1}[1-9]{1})|([1]{1}[0-2]{1}))(-){1}(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1})))?$/,
    Date: /^((\d{2}(([02468][048])|([13579][26]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|([1-2][0-9])))))|(\d{2}(([02468][1235679])|([13579][01345789]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\s(((0?[0-9])|([1][0-9])|([2][0-3]))\:([0-5]?[0-9])((\s)|(\:([0-5]?[0-9])))))?$/,
    DateTime: /^([1-2]{1}[0-9]{3}(-){1}(([0]{1}[1-9]{1})|([1]{1}[0-2]{1}))(-){1}(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))[ ]{1}(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1}))(:){1}[0-5]{1}[0-9]{1}(:){1}[0-5]{1}[0-9]{1})?$/,
    Number: /^\d+$/,
    PositiveInt: /^[0-9]*[1-9][0-9]*$/,
    Zip: /^[1-9]\d{5}$/,
    Integer: /^[-\+]?\d{1,9}$/,
    NonnegativeInt: /^[0-9]{1,8}$/,
    Long: /^\d{1,18}$/,
    Half: /^[A-Za-z0-9]+$/,
    Hex: /^[A-Fa-f0-9]+$/,
    Double: /^[-\+]?\d+(\.\d+)?$/,
    English: /^[A-Za-z]+$/,
    Chinese: /^[\u0391-\uFFE5]+$/,
    Username: /^[a-z]\w{3,}$/i,
    Amount: /^[-\+]?(([0-9]{1,7})?(\.\d{0,2})?)$/,
    UnSafe: /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
    CardBill: /^\d{12}$/,
    Ip: /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/,
    Asn: /^\d{16}$/,
    ServerIp: /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?):\d{1,4}$/

}


/**
 * 校验输入日期与当前日期的比较结果
 * @param date --yyyy-mm-dd格式的字符串
 * @param type:[ "pastDate"   --小于当前日期|
 *            "_pastDate"   --小于等于当前日期|
 *            "futureDate"  --大于当前日期|
 *            "_futureDate" --大于等于当前日期 ]
 */
Validator.validateDay = function (v, ctype) {
    //判断格式
    if (!Validator.DateFormat.test(v))
        return "正确的日期格式为：2008-08-08"
    else if (!Validator.Date.test(v))
        return "输入的日期不存在"
    var b = v.split("-");
    var c = new Date();
    var inputDay = Date.parse(new Date(b[0], (new Number(b[1]) - 1), b[2]));
    var sysDay = Date.parse(new Date(c.getFullYear(), c.getMonth(), c.getDate()));
    //判断大小的逻辑
    if (ctype == "_pastDate" && inputDay > sysDay)
        return "此日期必须小于等于当前日期"
    if (ctype == "_futureDate" && inputDay < sysDay)
        return "此日期必须大于等于当前日期"
    if (ctype == "pastDate" && inputDay >= sysDay)
        return "此日期必须小于当前日期"
    if (ctype == "futureDate" && inputDay <= sysDay)
        return "此日期必须大于当前日期"
    return true
}


Validator.checkMap = {
    'int': [Validator.Integer, "请输入一个整数(不超过9位)"],
    'nonnegativeInt': [Validator.NonnegativeInt, "请输入一个大于等于0的整数(不超过9位)"],
    'positiveInt': [Validator.PositiveInt, "请输入一个大于0的整数(不超过9位)"],
    'time': [Validator.Time, "正确的时间格式为：23:59:59"],
    'long': [Validator.Long, "请输入一个整数(不超过18位)"],
    'english': [Validator.English, "请输入英文字符"],
    'half': [Validator.Half, "请输入英文或数字"],
    'double': [Validator.Double, "请输入一个数字"],
    'email': [Validator.Email, "请输入合法的Email地址"],
    'Asn10': [Validator.Asn10, "请输入合法的10位数字"],
    'asn': [Validator.Asn, "请输入合法卡号"],
    'number': [Validator.Number, "只能输入数字"],
    'zip': [Validator.Zip, "邮政编码格式不正确"],
    'amount': [Validator.Amount, "金额格式不正确或超过长度"],
    'tel': [Validator.Tel, "请输入合法的固定电话号码"],
    'mobile': [Validator.Mobile, "请输入合法的移动电话号码"],
    'phone': [[Validator.Tel, Validator.Mobile], "请输入合法的电话号码"],
    'ip': [Validator.Ip, "请输入合法的ip地址"],
    'serverIp': [Validator.ServerIp, "请输入合法的服务器地址"],
    'positiveAmount': [function (v) {
        if (v <= 0) return false
        return Validator.Amount.test(v)
    }, "请输入大于0的金额"],
    'nonNegativeAmount': [function (v) {
        if (v < 0) return false
        return Validator.Amount.test(v)
    }, "请输入大于等于0的金额"],
    'date': [null, function (v) {
        if (!Validator.DateFormat.test(v)) {
            return "正确的日期格式为：2008-08-08"
        }
        else if (!Validator.Date.test(v)) {
            return "输入的日期不存在"
        }
        return true
    }],
    'dateTime': [null, function (v) {
        if (!Validator.DateTime.test(v)) {
            return "正确的时间格式为：2008-08-08 13:01:20"
        }
        else if (!Validator.Date.test(v)) {
            return "输入的日期不存在"
        }
        return true
    }],
    'pastDate': [null, Validator.validateDay],
    '_pastDate': [null, Validator.validateDay],
    'futureDate': [null, Validator.validateDay],
    '_futureDate': [null, Validator.validateDay],
    'bankCard': [Validator.BankCard, "请输入合法的银行卡号(16或19位数字)"],
    'checkNo': [Validator.CheckNo, "支票号只能为英文或数字"],

    'idCard': [Validator.IdCard, "身份证号格式不正确"],
    '1': [Validator.IdCard, "身份证号格式不正确"],
    'officerId': [Validator.OfficerId, "军官证证件号格式不正确"],
    '2': [Validator.OfficerId, "军官证证件号格式不正确"],
    'passport': [Validator.Passport, "护照证件号格式不正确"],
    '3': [Validator.Passport, "护照证件号格式不正确"],
    'orgId': [Validator.OrgId, "营业执照证件号格式不正确，请输入13或15位数字"],
    '4': [Validator.OrgId, "营业执照证件号格式不正确，请输入13或15位数字"],
    'driverLicense': [Validator.IdCard, "驾驶证证件号格式不正确"],
    '5': [Validator.IdCard, "驾驶证证件号格式不正确"],
    'orgCode': [Validator.OrgCode, "组织机构代码证代码格式不正确，注意字母只能大写"],
    '6': [Validator.OrgCode, "组织机构代码证代码格式不正确，注意字母只能大写"],
    'certificateNo': [[Validator.OrgId, Validator.Passport, Validator.OfficerId, Validator.IdCard], "系统支持证件类型包括：身份证号、军官证、护照、营业执照、驾驶证、组织机构代码证；请输入上述类型中的任意一种证件号"],
    '99': [[Validator.OrgId, Validator.Passport, Validator.OfficerId, Validator.IdCard], "系统支持证件类型包括：身份证号、军官证、护照、营业执照、驾驶证、组织机构代码证；请输入上述类型中的任意一种证件号"]

}

/**
 * 表单的单个元素校验方法
 **/
Validator.getError = function (v, ctype, cannotEmpty, description) {

    /** 自动Trim */
    /** 非必填项为空时不校验 */
    if (cannotEmpty != true && v == "")return true;

    if (cannotEmpty == true && v == "") return description ? description : "此项数据不能为空"
    /** 最多输入字符长度校验 */

    var res = Validator._getError(Validator.checkMap, v, ctype);
    if (res == -1 && Validator.checkMap2) {
        //可以用checkMap2扩展
        res = Validator._getError(Validator.checkMap2, v, ctype);
    }
    if (res == -1) res = true
    return res
}

Validator._getError = function (checkMap, v, ctype) {

    /** 各类型数据校验 */
    var errData = checkMap[ctype]
    if (errData) {
        if (errData[0] == null) {
            return errData[1](v, ctype)
        }
        else if ($type(errData[0]) == 'function')
            return errData[0](v) ? true : errData[1]
        else if ($type(errData[0]) != 'array') {
            return errData[0].test(v) ? true : errData[1]
        }
        else {
            //array
            var checks = errorData[0]
            for (var i = 0; i < checks.length; i++) {
                if (!checks[i].test(v)) return errData[1]
            }
            return true
        }
    }
    else return -1
}


/* 以下是check的相关方法 */
Validator.inputFocus = function (e) {
    var target = e.target
    if (target.get('_showErrorOnFocus')) {
        target.set('_showErrorOnFocus', null)	//only show error once ,when check form
        return
    }
    var infoSpan = target.getParent('td').getNext().getChildren()[0]
    infoSpan.set({
        'class': 'inputNotice',
        'html': target.get('info')
    })
}

Validator.inputValidate = function (e) {
    var target = e.target
    var r = Validator.getError(target.value, target.get('checkType'), target.get('cannotEmpty') == 'true', target.get('emptyDesc'))
    var infoSpan = target.getParent('td').getNext().getChildren()[0]
    if (r == true) {
        target.set('checkPassed', true)
        infoSpan.set({
            'class': 'inputSuccess',
            'html': target.get('info')
        })
    }
    else
        infoSpan.set({
            'class': 'inputError',
            'html': r
        })

}

/* 为input增加check代码,样式为右侧提示信息 */
Validator.addInputCheck = function (ele, msg, checkType, cannotEmpty, emptyDesc) {
    ele = $(ele)	//must do that ,because form.inputName will have no ele.uid, so cannot use same handle
    //wrap input td
    var td = ele.getParent('td')
    td.addClass('inputBox')

    ele.set({
        info: msg,
        checkType: checkType,
        cannotEmpty: cannotEmpty,
        emptyDesc: emptyDesc,
        events: {
            focus: Validator.inputFocus,
            blur: Validator.inputValidate
        }
    })
    ele.addClass('checkedInput')
    //inject info td
    var infoTd = new Element('td', {
        'class': 'inputInfoBox'
    }).inject(td, 'after')
    var infoSpan = new Element('div', {
        html: msg,
        'class': 'inputInfo'
    }).inject(infoTd)
    infoSpan.set({
        styles: {
            height: infoSpan.getSize().y + 'px'
        }
    })

    //modify title td
    var titleTd = ele.getParent('td').getPrevious()
    titleTd.addClass('inputTitle')
    if (cannotEmpty) {
        var req = new Element('span', {
            html: '[必填]',
            'class': 'inputRequired'
        })
        req.inject(titleTd)
    }
}

/**
 * 表单的单个元素校验方法
 **/
Validator.checkV = function (obj, checkType, cannotEmpty, errorMsg) {
    var obj = $(obj)
    Validator._normalStyle(obj);
    var v = trim(obj.value);
    if (!obj.get('_formChecking')) {
        if (cannotEmpty == true && v == "")
            return true;
        /** 提交表单时校验必填项，否则不校验 */
    }
    var error = Validator.getError(v, checkType, cannotEmpty, errorMsg)
    if (error != true) {
        Validator._errorStyle(obj, error);
        return false
    } else {
        obj.set('checkPassed', true)
        return true
    }
}
/* Validator.checkV 的便捷方法 */
var checkV = Validator.checkV;

Validator.inlineValidate = function (e) {
    var target = e.target
    Validator.checkV(target, target.get('checkType'), target.get('cannotEmpty') == 'true', target.get('emptyDesc'))
}

/** 取半角字符长度 */
Validator._getStrHalfLength = function (str) {
    return str.replace(/[^\x00-\xff]/g, "**").length;
}
/**
 * 清除一个校验项的校验结果显示
 */
Validator._normalStyle = function (obj) {
    if (obj.type == "text" || obj.type == "password") {
        if (obj.hasClass('inlineTextError')) {
            obj.removeClass("inlineTextError");

        }
    } else {

        obj.removeClass("inlineError");
    }

    var span = obj.getNext()
    if (span && span.get('class') == 'errorSpan') {
        span.destroy()
    }
}
/**
 *显示一个校验项的校验结果
 */
Validator._errorStyle = function (obj, msg) {

    if (obj.type == "text" || obj.type == "password") {
        if (!obj.hasClass('inlineTextError')) {
            obj.addClass("inlineTextError");

        }
    } else {
        obj.addClass("inlineError");
    }
    var span = obj.getNext()
    if (!span || span.get('class') != 'errorSpan') {
        var cor = obj.getCoordinates()
        cor.top += cor.height + 1
        if (msg && msg.length) {
            var halfLen = Validator._getStrHalfLength(msg)
            if (halfLen < 28) {
                cor.width = 20 + halfLen * 6;
                cor.height = 19
            }
            else {
                cor.width = 188
                cor.height = 19 * (Math.floor(halfLen / 30) + 1);
            }
        }
        var span = new Element("span", {
            'class': 'errorSpan',
            html: msg
        }).setStyles(cor)
            .inject(obj, 'after');

        var html = "<img src='" + appRoot + "images/icon/exclamation.gif" + "' align=absmiddle>" + msg + "<iframe src='" + appRoot + "common/bg.html?bgheight=" + cor.height + "&bgwidth=" + (cor.width + 2) + "' frameborder=0 style='position:absolute;visibility:inherit;top:0px;left:0px;z-index:-1;overflow:hidden;width:" + (cor.width + 4) + "px;height:" + (cor.height + 2) + "px;' scrolling=no height='" + (cor.height + 2) + "'>";
        html += "</iframe>"
        span.set('html', html)
    }
}

/**
 * 清除一个表单的校验结果显示
 */
Validator.clearErrorView = function (formId) {
    var form = $(formId);
    var elems = form.getElements('.checkedInput')
    for (var i = 0; i < elems.length; i++) {
        Validator._normalStyle(elems[i]);
    }
}

/* 为input增加check代码,样式为下方浮动提示信息 */
Validator.addInlineCheck = function (ele, checkType, cannotEmpty, emptyDesc) {
    ele = $(ele)	//must do that ,because form.inputName will have no ele.uid, so cannot use same handle

    ele.set({
        checkType: checkType,
        cannotEmpty: cannotEmpty,
        emptyDesc: emptyDesc,
        events: {
            blur: Validator.inlineValidate
        }
    })
    ele.addClass('checkedInput')
}

Validator.checkForm = function (form) {
    if (typeof form == "string")
        form = $(form);

    var elems = form.getElements('.checkedInput')
    var j = 0;
    var ele
    for (var i = 0; i < elems.length; i++) {
        ele = elems[i]
        if (!ele.disabled) {
            ele.set('_formChecking', true)	//对某些input validate样式有效
            try {
                ele.fireEvent('blur', {target: ele});
                if (!ele.get("checkPassed")) {
                    try {
                        ele.set('_showErrorOnFocus', true)
                        ele.focus();
                    } catch (e) {
                    }
                    return false;
                }
            } finally {
                ele.set('_formChecking', null)
            }
        }
    }

    return true;
}
//便捷方法
var checkForm = Validator.checkForm