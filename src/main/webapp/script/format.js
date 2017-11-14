
var Format = {}

Format.fixLength = function(s,length,c){
	if (!c) c = " ";
	var len = s.length
	var str = ""
	for (var i=0;i<length - len ; i++){
		str += c
	}
	return str + s
}

/* 将数字转换为金额格式，例: 220 -> 220.00 */
Format.formatMoney = function(balanceValue){
	balanceValue = balanceValue +"";	
	var dotIndex = balanceValue.indexOf(".");
	var len = balanceValue.length;
	if(dotIndex == -1){
		balanceValue = balanceValue + ".00";
	}
	else{
		var A = balanceValue.substring(0,dotIndex);
		var B =  balanceValue.substring(dotIndex,len);
		B = (B + "00").substring(0,3);
		balanceValue = A + B ;
	}
	if(balanceValue.indexOf(".") == 0){
		balanceValue = "0" + balanceValue;
	}
	return balanceValue;
}

/* 将数字转换为金额格式 4位小数，例: 220 -> 220.0000 */
Format.formatRate = function(balanceValue){
	balanceValue = balanceValue +"";	
	var dotIndex = balanceValue.indexOf(".");
	var len = balanceValue.length;
	if(dotIndex == -1){
		balanceValue = balanceValue + ".0000";
	}
	else{
		var A = balanceValue.substring(0,dotIndex);
		var B =  balanceValue.substring(dotIndex,len);
		B = (B + "0000").substring(0,5);
		balanceValue = A + B ;
	}
	if(balanceValue.indexOf(".") == 0){
		balanceValue = "0" + balanceValue;
	}
	return balanceValue;
}


/* 金额(分)转换为金额(元)格式 */
Format.fenToYuan = function(i){
	if(!i && i!= 0)
		return "";
	i = new Number(i);
	i = Math.round(i);
	i = i/100;
	i = Format.formatMoney(i);
	return i + "";
}

/* 积分后台到前台 */
Format.pointOut = function(i){
	if(!i && i!= 0)
		return "";
	i = new Number(i);
	i = i/100;
	i = Math.round(i);
	return i + "";
}
/* 金额(元)转换为金额(分)格式 */
Format.yuanToFen = function(i){
	if(!i && i!= 0)
		return "";
	i = new Number(i);
	i = i*100;
	i = Math.round(i);
	return i;
}


/* 格式化时间：yyyy-MM-dd hh:mm */
Format.formatToMM = function(timeObj) {
	if (!timeObj) return ''
	return timeObj.format("yyyy-MM-dd hh:mm");
}
/* 取得当前日期或时间：yyyy-MM-dd | yyyy-MM-dd hh:mm:ss */
Format.today = function(withTime){
	var d = new Date();
	if(withTime)
		return d.format("yyyy-MM-dd hh:mm:ss");
	else
		return d.format("yyyy-MM-dd");
}

/**
 * 得到某天的开始时间
 * @param str - 格式为2008-08-08
 * @return str - 格式为2008-08-08 00:00:00
*/
Format.getBeginTimeOfDay = function(str){
	if(str != "" && str != null){
		var d = str.split("-");
		return (new Date(d[0],(new Number(d[1]) -1),d[2])).format("yyyy-MM-dd hh:mm:ss");
	}
	return "";	
}

/**
 * 得到某天的结束时间
 * @param str - 格式为2008-08-08
 * @return str - 格式为2008-08-08 23:59:59
*/
Format.getEndTimeOfDay = function(str){
	if(str != "" && str != null){
		var d = str.split("-");
		d = new Date(d[0],(new Number(d[1]) -1),new Number(d[2]) + 1);
		d = new Date(d -1);
		return d.format("yyyy-MM-dd hh:mm:ss");
	}
	return "";	
}
/**
 * 得到某月第一天的开始时间
 * @param str - 格式为2008-08-08
 * @return str - 格式为2008-08-01 00:00:00
*/
Format.getBeginTimeOfMonth = function(str){
	if(str != "" && str != null){
		sDate = str.split("-");
		sDate = new Date(new Number(sDate[0]),new Number(sDate[1]) -1,1);
		return sDate.format("yyyy-MM-dd hh:mm:ss");
	}
	return "";	
}


/**
 * 得到某月最后一天的结束时间
 * @param str - 格式为2008-08-08
 * @return str - 格式为2008-08-31 23:59:59
*/
Format.getEndTimeOfMonth = function(str){
	if(str != "" && str != null){
		sDate = str.split("-");
		sDate = new Date(new Number(sDate[0]),new Number(sDate[1]),1);
		sDate = new Date(sDate -1);
		return sDate.format("yyyy-MM-dd hh:mm:ss");
	}
	return "";	
}
/**
 * 得到某年月第一天的开始时间
 * @param str - 格式为2008-08-08
 * @return str - 格式为2008-01-01 00:00:00
*/
Format.getBeginTimeOfYear = function(str){
	if(str != "" && str != null){
		sDate = str.split("-");
		sDate = new Date(new Number(sDate[0]),0,1);
		return sDate.format("yyyy-MM-dd hh:mm:ss");
	}
	return "";	
}

/**
 * 得到某年月最后一天的结束时间
 * @param str - 格式为2008-08-08
 * @return str - 格式为2008-12-31 23:59:59
*/
Format.getEndTimeOfYear = function(str){
	if(str != "" && str != null){
		sDate = str.split("-");
		sDate = new Date(new Number(sDate[0]) + 1,0,1);
		sDate = new Date(sDate -1);
		return sDate.format("yyyy-MM-dd hh:mm:ss");
	}
	return "";	
}

/**
 * 格式化时间：yyyy-MM-dd hh:mm:ss 
 * @param {Object} v
 * @author lushu
 */ 
Format.timeRender = function(v){
	try{
		return v.format("yyyy-MM-dd hh:mm:ss");
	}catch(e){
		return v;
	} 
}
/**
 * 格式化日期：yyyy-MM-dd
 * @param {Object} v
 * @author lushu
 */ 
Format.dateRender = function (v){
	try{
		return v.format("yyyy-MM-dd");
	}catch(e){
		return v;
	} 
}
/**
 * 如果为空/空字符串,则返回0
 * @param {Object} v
 * @author lushu
 */ 
Format.emptyToZero = function(v){
	return v ? v:0;
}
/**
 * 如果为0,则返回空字符串
 * @param {Object} v
 * @author lushu
 */ 
Format.zeroToEmpty = function(v){
	return v==0?'':v;
}

/**
 * 将字符串时间转化为Date对象
 * @param sDate 字符串时间(2008-08-08)
 * @param forart 格式化格式，默认为yyyy-MM-dd
 * @return date
 */
Format.parseDate = function(sDate,format){
	if (!format)
		format = "yyyy-MM-dd"
	var o = {
			"y+":function(date,year){date.setYear(year)},
			"M+":function(date,month){date.setMonth(month-1)},
			"d+":function(date,day){date.setDate(day)},
			"h+":function(date,hours){date.setHours(hours)},
			"m+":function(date,minutes){date.setMinutes(minutes)},
			"s+":function(date,seconds){date.setSeconds(seconds)},
			"S":function(date,milli){date.setMilliseconds(milli)}
		}
	var date = new Date(0)
	for (var k in o ){
		if (new RegExp("("+ k +")").test(format)){
			var s = format.indexOf(RegExp.$1)
			var l = RegExp.$1.length
			o[k](date,sDate.substring(s,s+l))
		}
	}
	return date;
}

/**
 * 取得字符串的长度
 */
Format.strLength = function (str) {
    ///<summary>获得字符串实际长度，中文2，英文1</summary>
    ///<param name="str">要获得长度的字符串</param>
    var realLength = 0, len = str.length, charCode = -1;
    for (var i = 0; i < len; i++) {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128) realLength += 1;
        else realLength += 2;
    }
    return realLength;
}

//js截取字符串，中英文都能用  
//如果给定的字符串大于指定长度，截取指定长度返回，否者返回源字符串。  
//字符串，长度  

/** 
 * js截取字符串，中英文都能用 
 * @param str：需要截取的字符串 
 * @param len: 需要截取的长度 
 */
Format.cutstr = function(str, len) {
    var str_length = 0;
    var str_len = 0;
    str_cut = new String();
    str_len = str.length;
    for (var i = 0; i < str_len; i++) {
        a = str.charAt(i);
        str_length++;
        if (escape(a).length > 4) {
            //中文字符的长度经编码之后大于4  
            str_length++;
        }
        str_cut = str_cut.concat(a);
        if (str_length >= len) {
            str_cut = str_cut.concat("...");
            return str_cut;
        }
    }
    //如果给定字符串小于指定长度，则返回源字符串；  
    if (str_length < len) {
        return str;
    }
}

/**
 * 0.5500888转化为百分数55.00888
 */
Format.formatPercent = function (value){
	if (!value) value="0"
	var idx = value.indexOf(".");
	if (idx == -1) {
		idx = value.length
	}else
		value = value.replace(".","")
	
	value = value + "0000"
	value = value.substring(0,idx+2)+"."+value.substring(idx+2)
	return new Number(value)
}

Format.getYesterday = function (n){
	var d = new Date();
	d.setTime(d.getTime()-n*24*3600*1000);
	return d.format("yyyy-MM-dd"); 
}

Format.getYesterdayTime = function (n){
	var d = new Date();
	d.setTime(d.getTime()-n*24*3600*1000);
	return d.format("yyyy-MM-dd hh:mm:ss");
}

Format.checkBeginEndTimeIsValid = function(beginTime, endTime){
	if(!Validator.DateTime.test(beginTime) || !Validator.DateTime.test(endTime)){
		Portal.error("格式有误，应为yyyy-MM-dd hh:mm:ss");
		return false;
	}

	var a = Date.parse(beginTime);
	var b = Date.parse(endTime);

	if(a>b){
		//$("txlist").innerHTML=""
		Portal.error("开始日期必须小于等于结束日期");
		return false;
	}
	return true;
}