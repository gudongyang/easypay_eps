function a1(o){TX.Test.alertAll(o)}

/** 国际化,文件在app目录下  */
function I18N(){}
I18N.tokenMaps = {}
		
I18N.getText = function(token,defvalue){
	var locale = Cookie.read('locale')
	if (!locale) return defvalue
	var map = this.tokenMaps[locale]
	if (!map) return defvalue
	var v = map[token]
	if (!v) return defvalue
	else return v
	
}

/* 去掉字符串首尾的空格 */
function trim(str){	
	return str?str.trim():"";
}

/* Array的remove方法 */
Array.prototype.remove=function(dx){
	this.splice(dx,1);
}
/* Array的add方法 */
Array.prototype.add=function(dx,element){
	this.splice(dx,0,element);
}

/* 判断当前浏览器是否是ie */
function isIE(){
	return Browser.Engine.trident
}
function isIE7(){
	return Browser.Engine.trident5
}

function esc(str){
	if(!str){
		return "";
	}
	else{
		return encodeURIComponent(str);
	} 
}
function unesc(str){
	if(!str){
		return "";
	}
	else{
		return decodeURIComponent(str);
	} 
}

/* 获取url中的参数 */
function getPara(para,s){
	if (!para) return
	var str = s? s : document.location.href
	var m = new RegExp("[\\?&]"+para+"=([^&]*)","i");
	var r = str.match(m)
	return r?unesc(r[1]):""
}


/* 从dialog返回值 */
function backValue(value) {
	parent.parent.window.returnValue = value ;
	parent.parent.window.close();
}

function supportModalDialog(){
	if (window.Project && Project.doNotUseModalDialog)
		return false;
	return window.showModalDialog
}

/* 在dialog窗口中打开页面 */
function openDialogFrame(fileName,title,height,width,callback,resize){
	height = height + 22;
	if (fileName.charAt(0) == "/"){
		fileName = fileName.substring(1);
		fileName = appRoot + fileName;
	}
	var path = appRoot + "common/dialog.html?title="+title+"&src="+esc(fileName);
	return openDialog(path+(resize?"&scroll=no":""),window,height,width,callback,"auto",resize);
	
}

/* 显示一个dialog窗口 */
function openDialog(path,strMessage,height,width,callback,scroll,resize){
	var h,w,s,r;
	!height?h="200":h=height;
	!width?w="350":w=width;
	!scroll?s="no":s=scroll;
	!resize?r="no":r=resize;
	if(isIE7()||!isIE()) h = parseInt(h) - 50;
	
	var f = "";
	var left = (screen.width - w)/2;
	var top = ((screen.height - h)/2 - 100);
	var result
	if(supportModalDialog()){
		f = "dialogHeight:"+h+"px;dialogWidth:"+w+"px;"
		if (!isIE()){
			f += "dialogleft=" + left+"px;dialogTop=" + top+"px;"
		}
		f += "edge:Raised;center: Yes;help: no;resizable:"+r+";status:yes;scroll:"+s+";";
		result = window.showModalDialog(path,strMessage,f);
		if (result!=null && callback){
			callback(result);
		}
	}
	else{
		window._dialogCallback = callback	// support firefox
		f = "width="+w+",height="+h+",modal=yes,dialog=yes," + "left=" +left + ",top=" + top;
		var dot = "?";
		if(path.indexOf("?") != -1)dot = "&";
		result = window.open(path + dot + "msg=" + esc(strMessage),"",f);
	}
	return result
	
}


//dialog back value function
function dialogBackValue(v){
	var pw = Common.rootWin()
	if(supportModalDialog()){
		pw.returnValue = v ;
		pw.close();
	}
	else{
        if(pw.opener._dialogCallback){
            pw.opener._dialogCallback(v);
        }
        parent.close();
	}
}
/* 调用日期控件 */
function showDatePicker(id){
	var obj = typeof id == "object"?id:$(id);
	var paras = appRoot + "script/date/date.html?tId=" + obj.id + "&tValue=" + obj.value;
	var defaultHeight = 266;
	if(obj.id.indexOf("AndTime") != -1){
		defaultHeight = 296;
	}
	var defaultWidth = 250;
	openDialog(paras,0,defaultHeight,defaultWidth,function(dates){
					obj.value = dates;
					obj.focus();
				},"no",false);
}


/* 日期格式化:format="yyyy-MM-dd hh:mm:ss"; */
Date.prototype.format = function(format){
	if (!format)
		format = "yyyy-MM-dd"
	var o = {
		"M+" :  this.getMonth()+1,  //month
		"d+" :  this.getDate(),     //day
		"h+" :  this.getHours(),    //hour
		"m+" :  this.getMinutes(),  //minute
		"s+" :  this.getSeconds(), //second
		"q+" :  Math.floor((this.getMonth()+3)/3),  //quarter
		"S"  :  this.getMilliseconds() //millisecond
	}
	if(/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	}
	for(var k in o) {
		if(new RegExp("("+ k +")").test(format)){
			format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
		}
	}
	return format;
}
String.prototype.replaceAll = function(s1,s2){
	return this.replace(new RegExp(s1,"gm"),s2);
} 
function clone(object){
	var obj 
	if (object instanceof Array){
		obj = [];
		return obj.extend(object)
	} else if(object instanceof Date){
		obj = object
	} else {
		obj = {}
		$extend(obj,object)
	}
	return obj;
}


//弹出窗口，选择数据
function spellUrl(url,opts){
	if (!opts) return url
	return url + '?' +$H(opts).toQueryString();
}

function Common(){}

Common.rootWin = function(p){
	if (!p)
		p = window;
	while(p.parent != p){
		p = p.parent
	}
	return p
}

Common.addOption = function(obj,value,text){
	var opts = obj.options;
	
	for(var i=0;i<opts.length;i++){
		if(opts[i].value == value)
			return;
	}
	var o = new Option(text,value);
	obj[obj.options.length] = o;
	return o
}

Common.removeOption = function(obj){
	var list = [];
	var selectNo = 0;
	for(var i=0;i<obj.childNodes.length;i++){
		var ct = obj.childNodes[i];
		if (ct.selected){
			list.push(ct);
			selectNo++;
		}		
	}
	if(selectNo == 0)showWarning("请先选中需要删除的数据项");
	for(var i=0;i<list.length;i++){
		var c = list[i];
		obj.removeChild(c);
	}
}

Common._importOption = function(obj,dialogUrl,label,height,maxLength,formName){
	var ov = String($A(obj.options).map(function(o){return o.value}))
	openDialogFrame(obj.addUrl + "&ids=" + ov,label,height,700,function(a){
		if(a){
			var op = "";
			if (maxLength && (a.length + obj.options.length) > maxLength){
				showError("选择数据超过允许数量("+maxLength + ")");
				return;
			}
			for(var i=0;i<a.length;i++){
				op = a[i];
				var o = {}
				if (obj.parseBackValue)
					o = obj.parseBackValue(op)
				else{
					o.value = op[1]
					o.text = op[2]
				}
				var opt = Common.addOption(obj,o.value,o.text);
				opt.obj = o
			}
		}
	});
}

Common.initMultiSelect = function(targetId,label,formName,selectName,dialogUrl,height,maxLen,options,parseBackValue){
	var obj = $(targetId);
	if (!obj) return;
	if (!options){
		options = {}
		options.orgId = (Common.cOrg()).id
	}
	obj.innerHTML = Common.getMultiSelectHtml(label,formName,selectName,dialogUrl,height,maxLen);
	var select = $(formName)[selectName]
	select.addUrl = spellUrl(dialogUrl,options)
	select.parseBackValue = parseBackValue
}

Common.getMultiSelectHtml = function(label,formName,selectName,dialogUrl,height,maxLen){
	
	var str = "<table cellspacing=0 cellpadding=0 border=0>";
		str += "<tr><td valign=top style='padding-top:5px;width:100px;'><label>"+label+"</label></td>";
		str += "<td valign=top><select multiple name='"+selectName+"' style='height:100px;margin:0px;width:130px'>";
		str += "</select></td><td valign=top>";
		str += "<button name='addBtn' type='button' onclick=\"Common._importOption($('"+formName+"')['"+selectName+"'],'"+dialogUrl+"','"+label+"',"+height+","+maxLen+",'"+formName+"')\"><img src='../images/basic/button_add.gif' border=0></button>";
		str += "<br><button name='delBtn' type='button' onclick=\"Common.removeOption($('"+formName+"')['"+selectName+"'])\"><img src='../images/basic/button_remove.gif' border=0></button>";
		str += "</td></tr></table>";
	return str;
}

Common.getValues = function(form) {
	if(typeof form=="string")
		form = $(form);
	var eles = form.elements;
	var key,value,formMap={};
	for(var i=0; i<eles.length;i++){
		key = eles[i].name?eles[i].name:eles[i].id;
		value = Common.getValue(eles[i]);
		if (key != null && key != "" ){
			if(!formMap[key]){
				formMap[key] = value;
			}
			else{
				if(value != "")
					formMap[key] += ","+ value;
			}
		}
	}
	return formMap;
}

Common.getValue = function(ele){
	if(ele.tagName=="SELECT"){
		if(ele.multiple == true){
			return String($A(ele.options).map(function(obj){return obj.value}))
		}
		else{
			return ele.value;
		}
	}
	if(ele.tagName=="INPUT"){
		if(ele.type == "radio" || ele.type == "checkbox"){
			if(ele.checked)return ele.value;
		}
		else{
			return ele.value;
		}
	}
	if (ele.tagName=="TEXTAREA"){
		return ele.value;
	}
	return "";
}
Common.showDetail = function(node,obj,tagName){
	if (typeof node=="string")
		node = $(node);
	if (!node){alert("Common.showDetail:null error");return;}
	if (!tagName) tagName = "SPAN";
	var nodes = node.getElements(tagName);
	for (var i = 0;nodes&&i<nodes.length;i++){
		var n = nodes[i];
		var prop = null;
		if (n.name) prop = n.name;
		else if (n.id) prop = n.id;
		else continue;
		var text = obj[prop];
		if (text instanceof Date){
			text = text.format();
		}
		n.innerHTML = text||text==0?text:"";

	}
}
Common.setValues = function(form,values) {
	if (typeof form == "string")
		form = $(form);
	if (!form){alert("Common.setValues:null error");return;}
	var dealed={};	
	for (var i = 0; i < form.elements.length; i++) {
		if (form[i].tagName=="FIELDSET"||form[i].type=="button") continue;		
		if (form[i].name != null) prop = form[i].name;
		else if (form[i].id) prop = form[i].id;
		if (dealed[prop])
			continue;
		if (prop)
		{	
			Common.setValue(form[prop],values[prop]);
			dealed[prop] = true;
		}
	}	
}
Common.setValue = function(ele, val) {
	if (val == null) val = "";
	if (val instanceof Date)
	{
		val = val.format();
	}
	if (ele.tagName == "SELECT") {
		if (ele.type == "select-multiple" && $type(val)=='array') {
			this._selectListItems(ele, val);
		}
		else {
			this._selectListItem(ele, val);
		}
		return;
	}
	var obj = ele[0]?ele[0]:ele;
	val = val.toString();
	
	if (obj.tagName == "INPUT") {
		if (obj.type == "radio") {
	
			if (ele.length > 1) {
				var node;
				for (i = 0; i < ele.length; i++) {
					node = ele[i];
					if (node.type == "radio") {
						node.checked = (node.value == val);
					}
				}
			}
			else {
				ele.checked = (val == true);
			}
		}
		else if (obj.type == "checkbox") {
			ele.checked = val;
		}
		else {
			ele.value = val;
		}
		return;
	}

	if (ele.tagName =="TEXTAREA") {
		ele.value = val;
		return;
	}
}
Common._selectListItems = function(ele, val) {
	var found  = false;
	var i;
	var j;
	for (i = 0; i < ele.options.length; i++) {
		ele.options[i].selected = false;
		for (j = 0; j < val.length; j++) {
			if (ele.options[i].value == val[j]) {
				ele.options[i].selected = true;
			}
		}
	}
	if (found) return;
	for (i = 0; i < ele.options.length; i++) {
		for (j = 0; j < val.length; j++) {
			if (ele.options[i].text == val[j]) {
				ele.options[i].selected = true;
			}
		}
	}
}

Common._selectListItem = function(ele, val) {

	var found  = false;
	var i;
	for (i = 0; i < ele.options.length; i++) {
		if (ele.options[i].value == val) {
			ele.options[i].selected = true;
			found = true;
		}
		else {
			ele.options[i].selected = false;
		}
	}
	
	if (found) return;
	
	for (i = 0; i < ele.options.length; i++) {
		if (ele.options[i].text == val) {
			ele.options[i].selected = true;
		}
		else {
			ele.options[i].selected = false;
		}
	}
}

Common.getRadio = function(radioName){
	if (!radioName) radioName = "radios";
	var radios = document.getElementsByName(radioName);
	for (var i=0;i<radios.length;i++){
		var radio = radios[i];
		if (radio.checked){
			return radio;
		}
	}
	return null;
}
Common.getRadioValue = function(radioName){
	var radio = Common.getRadio(radioName);
	return radio?radio.value:null;
}
Common.getCheckBoxValue = function(checkName){
	if (!checkName) checkName = "checkboxs";
	var cs = document.getElementsByName(checkName);
	var ids = "";
	for (var i=0;i<cs.length;i++){
		var cb = cs[i];
		if (cb.checked){
			if (ids) ids += ",";
			ids += cb.value;
		}
	}
	return ids;	
}


Common.initBoxOrRadio = function(area,options){	
	if (typeof area == "string") area = $(area);
	if (!area){alert("Common.initCheckboxs:null error");return;}
	var list = options.list;
	var boxName = options.boxName?options.boxName:area.id;
	var name = options.name?options.name:"name"
	var value = options.value?options.value:"value"
	var type = options.isRadio?"radio":"checkbox"
	var ckmap = {}
	if (options.defChecked){
		if (options.defChecked instanceof Array){
			for (var i=0;i<options.defChecked.length;i++){
				ckmap[options.defChecked[i]] = true
			}
		}else{
			ckmap[options.defChecked] = true
		}		
	}
	var html = ""
	for (var i=0;i<list.length;i++){
		var b = list[i];
		html += "<input type="+type+" name='"+boxName+"' value='"+b[value]+"'"+(ckmap[b[value]]?" checked":"")+">" + b[name] +" "
	}
	area.innerHTML = html;
}
Common.switchPage = function(pages,divId){
	for(var i=0;i<pages.length;i++){
		if (pages[i]==divId)
			Common.show($(divId))
		else
			Common.hide($(pages[i]))
	}
}
Common.hide = function(div){
	div.style.display = "none"
}
Common.show = function(div){
	div.style.display = ""
}
