//mootools domready
window.addEvent('domready', function() {
	//把form名建立全局变量，用ie的方式直接访问form
    $$('form').each(function(f){
    	var id=f.id
    	//update by dulijun at 20160306
    	window["'"+f.attributes['id'].value+"'"] = f
    })
});

/** 从theme中转移过来 */
//document.write("<link href='"+appRoot+"css/style.css' type=text/css rel=stylesheet>");
//document.write("<link href='"+appRoot+"css/qt.css' type=text/css rel=stylesheet>");
/*Read the theme config from user cookie*/
var stylefile = "red";
var frameColor = "#DE3A41";
var skinName = Cookie.read("userskin");
if(skinName != "" && skinName != null){
	stylefile = skinName;
	if(skinName == "red")frameColor = "#DE3A41";
	if(skinName == "gray")frameColor = "#7E7E7E";
	if(skinName == "blue")frameColor = "#3A62DC";
	if(skinName == "green")frameColor = "#46A848";
}
//document.write("<link href='"+appRoot+"css/"+stylefile+".css' type=text/css rel=stylesheet>");


var Eui = {}

//导入数据
Eui.showImport = function(title,headFile,callback){
	var url = spellUrl("/script/import/import_data.html",{headFile:headFile});
	openDialogFrame(url,title,600,800,callback);
}

//导出bill的html形式
Eui.getBillHtml = function(divId,params){
	Eui.getHtmlPrint(divId,'bill',params)
}

//导出bill
Eui.exportBill = function(params){

	Eui.exportPrint('bill',params)
}


//导出crosstab
Eui.getCrosstabHtml = function(divId,params){
	Eui.getHtmlPrint(divId,'crosstab',params)
}

//导出crosstab
Eui.exportCrosstabReport = function(params){
	Eui.exportPrint('crosstab',params)
}

//导出crosstab
Eui.getHtmlPrint = function(divId,path,params){

	if (!params.queryName) alert('must support queryName')
	//这里为何不加contextRoot ？在loadPage中加了
	var path = "/d/"+path+"/"+ params.queryName +".html";
	
	if (params)
		path += "?"+$H(params).toQueryString()
	Rpc.loadPage(divId,path);
}

Eui.exportPrint = function(path,params){
	if (!params.queryName) alert('must support queryName')
	var type = params.exportType
	var path = contextRoot + 'd/'+path+'/'+ params.queryName +'.'+type

	if (params){
		if ($type(params) != 'hash')
			params = $H(params)
		path += '?'+params.toQueryString()
	}
	if (type=='pdf'||type=='xls'||type=='rtf'){
		document.location.href=path
	}else if (type=='xml'||type=='html')
		window.open(path)
}

/* 显示导航数据 */
Eui.showNavigation = function(){
	//给form对象赋值
	var nav = $("nav");
	if (!nav) return;
	if (parent.pageType=='dialog'){
		nav.parentNode.style.display = "none";
		return;
	}
	var modulePath = "";
	var uniqueId = "";
	if(parent.$("frameset1")){
		modulePath = parent.$("frameset1").longdesc;
		uniqueId = parent.$("frameset1").uniqueId
	}
	else{
		return;
	}
	nav.innerHTML = "<span class=dot>&nbsp;&nbsp;&nbsp;&nbsp;</span>"+modulePath;
	Eui.buildHelpLink(nav,uniqueId)
}
Eui.buildHelpLink = function(pDiv,uniqueId){
	if(Eui.clickHelpLink){
		var bw = pDiv.getParent("body").getCoordinates().width - 10;
		var w = 30;
		var div = new Element("DIV")
						.setStyles({top : '9px', left : (bw-w)+'px', width:w+'px','position': 'absolute'})
						.inject(pDiv)
		div.innerHTML = "<a href=#>帮助</a>"
		div.getElement("A").addEvent("click",function(){Eui.clickHelpLink(uniqueId)})
	}
}
Eui.clickHelpLink = null;
/**
 * 缺省的onDelete方法
 */
Eui.onDel = function(service,items,entityName,desc,refFunc){	
	if (!items)
		showWarning("请选择需要删除的"+entityName+"。");
	else{
		if(showQuestion("是否删除这些"+entityName+(desc?desc:"？"))){
			DWR.call(service,items,function(){
				showInformation("删除成功！");
				if (refFunc){
					refFunc();//刷新页面
				}
			},{blockScreen:true});
		}
	}
}

/* 生成tabdiv
 * @param divId 生成tab的div id
 * @param tabs tab数组或者map 每个tab数据格式为
 *        {name:"tab_xxx",text:"示例tab",tabFunc:function(){alert("点击tab触发的方法")}}
 */
Eui.buildTabs = function(divId,tabs){
	var div = $(divId);
	var table = new Element("TABLE");
	table.border = "0";
	table.cellSpacing = "0";
	table.cellPadding = "0";
	table.style.width = "100%";
	table.style.margin = "0px";
	var tbody = new Element("TBODY");
	table.appendChild(tbody);
	var tr = new Element("TR");
	tr.className="frameBody";
	tbody.appendChild(tr);
	td = new Element("TD");
	td.className = "treeBar";
	td.valign="bottom";
	if (!(tabs instanceof Array))
	{
		var newArray = []
		for (prop in tabs){
			newArray.push(tabs[prop]);
		}
		tabs = newArray;
	}
	for (var i = 0;i<tabs.length;i++){
		var tab = tabs[i];
		var a = new Element("A");
		a.id = tab.name;
		a.tabFunc = typeof tab.tabFunc == "function"?tab.tabFunc:function(){};
		a.onclick = function(){
			try{
				this.tabFunc();
			}catch(e){showError(e.description);return false;}
			Eui.switchTab(this);
			return false;
		}
		a.href = "#";
		if (i == 0)
			a.className = "treeTabc";
		else
			a.className = "treeTab";
		a.innerHTML = tab.text;
		a.onfocus = function(){
			this.blur();
		}
		td.appendChild(a);
		tr.appendChild(td);
		div.appendChild(table);
	}
}

//被选中的tab样式变化方法
Eui.switchTab = function(tab){
	if (!tab) return;
	var tabs = tab.parentNode.childNodes;
	for (var i = 0;i<tabs.length;i++){
		var t = tabs[i];
		if (t.id == tab.id){
			t.className = "treeTabc"
		}else{
			t.className = "treeTab"
		}
	}
}
/** 统计报表 查询 条件 */
Eui.showStatBtn = function(divId,headId,options){
	if (!options) options = {}
	if (!options.form) return;
	var form = options.form;
	var showHead = function(){
		var statType = Common.getRadioValue("statType");
		var statClass = Common.getRadioValue("statClass");
		if (!headId) return;
		$("statTime").innerHTML = Format.today(true);
		$("statoper").innerHTML = Common.cOperator().name;
		$("statorg").innerHTML = Common.cOrg().name;
		$("statClassSpan").innerHTML = statClass?Common.getText('stat_class',statClass):"无";
		//$("statTimeType").innerHTML = "业务时间";
		$("beginTime").innerHTML = "";
		$("endTime").innerHTML = "";
		if(statType == Constants.CLEAR_STAT_DYNA){
			var sDate = form.beginDate.value;
			var eDate = form.endDate.value;
			$("beginTime").innerHTML = Format.getBeginTimeOfDay(sDate);
			$("endTime").innerHTML = Format.getEndTimeOfDay(eDate);
			if(!Eui.checkTimeOrder(form.beginDate,form.endDate))
			return false;
		}else if(statType == Constants.CLEAR_STAT_DAY){
			var sDate = form.statDate.value;
			$("beginTime").innerHTML = Format.getBeginTimeOfDay(sDate);
			$("endTime").innerHTML = Format.getEndTimeOfDay(sDate);
		}else if(statType == Constants.CLEAR_STAT_MONTH){
			var sDate = form.statDate.value;
			$("beginTime").innerHTML = Format.getBeginTimeOfMonth(sDate);
			$("endTime").innerHTML = Format.getEndTimeOfMonth(sDate);
		}else if(statType == Constants.CLEAR_STAT_YEAR){
			var sDate = form.statDate.value;
			$("beginTime").innerHTML = Format.getBeginTimeOfYear(sDate);
			$("endTime").innerHTML = Format.getEndTimeOfYear(sDate);
		}
		return true;
	}
	Rpc.loadPage(divId,"/script/report/stat_btnview_div.html")
	Eui.setStatPeriod();
	if (options.statFunc && typeof options.statFunc == "function")
		form.statBtn.onclick = function(){showHead();options.statFunc()};
	if (!headId) 
		return;
	Rpc.loadPage(headId,"/script/report/pivotable_head_div.html")
	$("pivotable_head_title").innerHTML = document.title;

}

/**
 * 生成起止日期
 * @param divId 显示模板的区域id
 * @param options
 */
Eui.getDateInput = function(label,formName,inputName,checkType,cannotEmpty,withTime){
	var idStr = "";
	if(withTime)idStr += " id='"+inputName+"AndTime'";
	var d = "<label>"+label+"</label> <input type=\"text\" id=\""+inputName+"\" name=\""+inputName+"\" "+idStr+" onblur=\"checkV(this,'"+checkType+"',"+cannotEmpty+")\">";
		d += "<a href=\"javascript:void(0)\" title=\"选择"+label+"\" onclick=\"showDatePicker($('"+formName+"')['"+inputName+"']);\" class=\"date\">&nbsp;&nbsp;&nbsp;</a></span>";
	if(cannotEmpty){
		d += "<span class=des>*</span>";
	}
	return d;
}
Eui.getBeginDateInput = function(label,formName,beginName,endName,checkType,cannotEmpty){
	var d = "<label>"+label+"</label> <input type=\"text\" id=\""+beginName+"\" name=\""+beginName+"\" onblur=\"if(checkV(this,'"+checkType+"',"+cannotEmpty+"))Eui.checkTimeOrder($('"+formName+"')['"+beginName+"'],$('"+formName+"')['"+endName+"'])\">";
		d += "<a href=\"javascript:void(0)\" title=\"选择"+label+"\" onclick=\"showDatePicker($('"+formName+"')['"+beginName+"']);\" class=\"date\">&nbsp;&nbsp;&nbsp;</a>";
	if(cannotEmpty){
		d += "<span class=des>*</span>";
	}
	return d;
}
Eui.getEndDateInput = function(label,formName,beginName,endName,checkType,cannotEmpty){
	var d = "<label>"+label+"</label> <input type=\"text\" id=\""+endName+"\" name=\""+endName+"\" onblur=\"if(checkV(this,'"+checkType+"',"+cannotEmpty+"))Eui.checkTimeOrder($('"+formName+"')['"+beginName+"'],$('"+formName+"')['"+endName+"'])\">";
		d += "<a href=\"javascript:void(0)\" title=\"选择"+label+"\" onclick=\"showDatePicker($('"+formName+"')['"+endName+"']);\" class=\"date\">&nbsp;&nbsp;&nbsp;</a>";
	if(cannotEmpty){
		d += "<span class=des>*</span>";
	}
	return d;
}
/**
 * 初始化单个日期输入框
 * @param targetId	 显示日期框的区域的id，如td的id
 * @param label		日期的label，如"完成日期"
 * @param formName	 表单的id
 * @param inputName	生成日期输入框的name
 * @param checkType	校验类型			   
 * @param cannotEmpty  是否可以为空  true|false
*/
Eui.initDateInput = function(targetId,label,formName,inputName,checkType,cannotEmpty){
	$(targetId).innerHTML = Eui.getDateInput(label,formName,inputName,checkType,cannotEmpty);
}
/**
 * 初始化开始日期输入框
 * @param targetId	 显示日期框的区域的id，如td的id
 * @param label		日期的label，如"完成日期"
 * @param formName	 表单的id
 * @param beginName	生成开始日期输入框的name
 * @param endName	  生成结束日期输入框的name
 * @param checkType	校验类型			   
 * @param cannotEmpty  是否可以为空  true|false
*/
Eui.initBeginDateInput = function(targetId,label,formName,beginName,endName,checkType,cannotEmpty){
	$(targetId).innerHTML = Eui.getBeginDateInput(label,formName,beginName,endName,checkType,cannotEmpty);
}
/**
 * 初始化结束日期输入框（参数同上）
*/
Eui.initEndDateInput = function(targetId,label,formName,beginName,endName,checkType,cannotEmpty){
	$(targetId).innerHTML = Eui.getEndDateInput(label,formName,beginName,endName,checkType,cannotEmpty);
}

/**
 * 初始化开始结束日期
 */
Eui.initbeginEndDateInput = function(formName,checkStr,beginId,endId,cannotEmpty){
	if (!beginId) beginId = "beginDateTd"
	if (!endId) endId = "endDateTd"
	if (!checkStr) checkStr = "_pastDate"
	cannotEmpty = cannotEmpty !== false
	var form = $(formName)
	var ds = new Date().format("yyyy-MM-dd")
	Eui.initBeginDateInput(beginId,"起始日期",formName,"beginDate","endDate",checkStr,cannotEmpty);
	Eui.initEndDateInput(endId,"结束日期",formName,"beginDate","endDate",checkStr,cannotEmpty);
	form.beginDate.value = ds
	form.endDate.value = ds
}
/**
 * 设置统计周期
 */
Eui.setStatPeriod = function(){
	var form = Page.form;
	var formName = form.id;//"statForm";
	var st = Common.getRadioValue("statType");
	if(st == Constants.CLEAR_STAT_DYNA){
		var beStr = "<table border=0 cellspacing=0 cellpadding=0 width=100% class=col2><tr><td>";
			beStr += Eui.getBeginDateInput("起始日期",formName,"beginDate","endDate","_pastDate",true);
			beStr += "</td><td>";
			beStr += Eui.getEndDateInput("结束日期",formName,"beginDate","endDate","_pastDate",true);
			beStr += "</td></tr></table>";
		$("statDateTd").innerHTML = beStr;
		form.beginDate.value = Format.today();
		form.endDate.value = Format.today();
	}
	else{
		$("statDateTd").innerHTML = Eui.getDateInput("统计日期",formName,"statDate","_pastDate",true);
		form.statDate.value = Format.today();
	}
}
/**
 * 生成大小关联的输入框
*/
Eui.getCompareInputA = function(formName,labelA,labelB,inputNameA,inputNameB,checkType,compareType,cannotEmpty){
	var str = "<label>"+labelA+"</label> <input type=\"text\" name=\""+inputNameA+"\" onblur=\"if(Eui.checkDubleObjs($('"+formName+"')['"+inputNameA+"'],$('"+formName+"')['"+inputNameB+"'],'"+checkType+"','"+checkType+"',"+cannotEmpty+","+cannotEmpty+"))Eui.compareValue($('"+formName+"')['"+inputNameA+"'],$('"+formName+"')['"+inputNameB+"'],'"+compareType+"','"+labelA+"','"+labelB+"')\">";
	if(cannotEmpty){
		str += "<span class=des>*</span>";
	}
	str += " ";
	return str;
}
Eui.getCompareInputB = function(formName,labelA,labelB,inputNameA,inputNameB,checkType,compareType,cannotEmpty){
	var str = "<label>"+labelB+"</label> <input type=\"text\" name=\""+inputNameB+"\" onblur=\"if(Eui.checkDubleObjs($('"+formName+"')['"+inputNameA+"'],$('"+formName+"')['"+inputNameB+"'],'"+checkType+"','"+checkType+"',"+cannotEmpty+","+cannotEmpty+"))Eui.compareValue($('"+formName+"')['"+inputNameA+"'],$('"+formName+"')['"+inputNameB+"'],'"+compareType+"','"+labelA+"','"+labelB+"')\">";
	if(cannotEmpty){
		str += "<span class=des>*</span>";
	}
	str += " ";
	return str;
}
Eui.initCompareInput = function(formName,targetIdA,targetIdB,labelA,labelB,inputNameA,inputNameB,checkType,compareType,cannotEmpty){
	$(targetIdA).innerHTML = Eui.getCompareInputA(formName,labelA,labelB,inputNameA,inputNameB,checkType,compareType,cannotEmpty);
	$(targetIdB).innerHTML = Eui.getCompareInputB(formName,labelA,labelB,inputNameA,inputNameB,checkType,compareType,cannotEmpty);
}


/**
 * 校验起始日期是否大于结束日期
*/
Eui.checkTimeOrder = function(bObj,eObj){
	var bDate = bObj.value;
	var eDate = eObj.value;
	if(bDate == "" || eDate == ""){
		return true;
	}
	//格式错误直接返回
	if(!checkV(bObj,"_pastDate"))return false;
	if(!checkV(eObj,"_pastDate"))return false;
	//大小判断
	bDate = bDate.split("-");
	bDate = Date.parse(new Date(bDate[0],(new Number(bDate[1]) -1),bDate[2]));
	eDate = eDate.split("-");
	eDate = Date.parse(new Date(eDate[0],(new Number(eDate[1]) -1),eDate[2]));
	if( eDate >= bDate){
		Validator._normalStyle(bObj);
		Validator._normalStyle(eObj);
		return true;
	}
	Validator._errorStyle(bObj,"起始日期不能大于结束日期");
	Validator._errorStyle(eObj,"结束日期不能小于起始日期");
	return false;
}
Eui.checkDubleObjs = function(objA,objB,checkTypeA,checkTypeB,cannotEmptyA,cannotEmptyB){
	var v1 = checkV(objA,checkTypeA,cannotEmptyA);
    var v2 = checkV(objB,checkTypeB,cannotEmptyB);
	if(v1 == true && v2 == true){
		return true;
	}
	return false;
}
/**
 * 比较两个对象的值的大小，大小类型的比较适用于整数和浮点数，等于类型的比较适用于任何类型。
 * @param compareType -比较类型[大于:"gt",大于等于:"ge",等于:"e",小于等于"le",小于:"lt"]
*/
Eui.compareValue = function(objA,objB,compareType,labelA,labelB){
	if(objA.value == "" || objB.value == ""){
		Validator._normalStyle(objA);
		Validator._normalStyle(objB);
		return true;
	}
	if(compareType == "e" && objA.value != objB.value){
		Validator._errorStyle(objA,labelA + "与" +　labelB + "的值不一致");
		Validator._errorStyle(objB,labelB + "与" +　labelA + "的值不一致");
		return false;
	}
	var valueA = new Number(objA.value);
	var valueB = new Number(objB.value);
	if(compareType == "gt" && valueA >= valueB){
		Validator._errorStyle(objA,labelA + "必须小于" +　labelB);
		Validator._errorStyle(objB,labelB + "必须大于" +　labelA);
		return false;
	}
	else if(compareType == "ge" && valueA > valueB){
		Validator._errorStyle(objA,labelA + "必须小于等于" +　labelB);
		Validator._errorStyle(objB,labelB + "必须大于等于" +　labelA);
		return false;
	}
	if(compareType == "lt" && valueA <= valueB){
		Validator._errorStyle(objA,labelA + "必须大于" +　labelB);
		Validator._errorStyle(objB,labelB + "必须小于" +　labelA);
		return false;
	}
	else if(compareType == "le" && valueA < valueB){
		Validator._errorStyle(objA,labelA + "必须大于等于" +　labelB);
		Validator._errorStyle(objB,labelB + "必须小于等于" +　labelA);
		return false;
	}
	else{
		Validator._normalStyle(objA);
		Validator._normalStyle(objB);
	}
	return true;
}


function WebPrint(){}
WebPrint.getPrintFrame= function(){
	var p = parent;
	while(true){
		if (p.printFrame) return p.printFrame;
		if (p==p.parent) return;
		if (p==null) return;
		p = p.parent;
	}
}
WebPrint.print = function(div,options){
	var p = WebPrint.getPrintFrame();
	if(p){
		p.document.body.innerHTML = $(div).innerHTML;
		p.print(options);
	}
}
/** 从print.js中转移过来 */
WebPrint.preview = function(div,options){
	var p = WebPrint.getPrintFrame();

	if(p){
		p.document.body.innerHTML = $(div).innerHTML;
		p.preview(options);
	}
}

WebPrint.pageSetup = function(){
	var p = WebPrint.getPrintFrame();
	if(p){
		p.pageSetup();
	}
}



/**
 * 以下从funlib中转移过来
*/
Common.initDict = function(select,dictType,nullLabel,code,text){
	if (!select) return;
	if (!dictType) return;
	var options = {
				list:typeof(dictType)=='string'? Common.getItems(dictType): dictType
			}
		
	if (nullLabel)
		options.nullLabel = nullLabel;
	if (code)
		options.code = code;
	if (text)
		options.text = text;
	Common._initSelect(select,options);	
}


Common._initSelect = function(select,obj){
	if (typeof select == "string")
		select = $(select);
	if (!select){alert("Common.initSelect:null error");return;}
	select.options.length=0;
	if (obj.onchange)
		select.onchange = obj.onchange;
	if (obj.nullLabel)
		select.options[select.options.length]=new Option(obj.nullLabel,'');
	if (!obj.list) return;
	var code = obj.code||obj.code==0?obj.code:'code';
	var text = obj.text?obj.text:'text';
	for (var i=0;i<obj.list.length;i++){
		var optv = obj.list[i];
		var codes = "";
		if (code instanceof Array){
		
			for (var c=0;c<code.length;c++){
				if (codes)
					codes += ",";
				codes += optv[code[c]];
			}	
		}else
			codes = optv[code];
		select.options[select.options.length]=new Option(optv[text],codes);
			
		if (obj.defText==optv[text]||(obj.defCode&&obj.defCode==optv[code])){
			select.selectedIndex = select.options.length-1;
		}
	}
	if (obj.disabled)
	{
		select.disabled = true;
		select.style.background = '#FFFFCC'
	}
}


Common.getText = function(dict,code){

	var item = this.getItem(dict,code)
	return item==null?null:item.text
}

Common.getItem = function(dict,code){

	var itemMap = this._getItemMap(dict)
	if (!itemMap) return;
	
	return itemMap[code]
}

Common.getSubsetItems = function(dict,codes){
	var itemMap = this._getItemMap(dict)
	if (!itemMap) return;
	
	var list = [];
	for(var i=0;i<codes.length;i++){
		if (itemMap[codes[i]])
			list.push(itemMap[codes[i]]);
	}
	return list;
}

Common._getItemMap = function(dict){
	if (!dict) return;
	var localCache = this.getLocalCache()

	var itemMap = localCache['dict_m_'+dict];
	
	if (!itemMap){
		
		this._loadDict(dict)
		
		itemMap = localCache['dict_m_'+dict];
	}	
	
	return itemMap
}

//得到浏览器本地缓存，目前存在workbench对象中
Common.getLocalCache = function(){
	var cache = this.wbWin.localCache;
	if (!cache)
	{
		cache = {}
		this.wbWin.localCache = cache
	}
	return cache;
	
}

Common.specialDicts = {}

/** 可以定义特殊的dict和它的reloadFunc ,例如帐户类型*/
Common.registerSpecialDict = function(dict,reloadFunc){
	Common.specialDicts[dict] = reloadFunc
}

Common.getItems = function(dict,codes){
	if (!dict) return;
	var localCache = this.getLocalCache()

	var itemList = localCache['dict_l_'+dict];
	if (!itemList){
		
		this._loadDict(dict)
		
		itemList = localCache['dict_l_'+dict];
	}	
	
	return itemList;
}

	
Common._loadDict = function(dict){

	var localCache = this.getLocalCache()
	
	var specialLoadFunc = Common.specialDicts[dict]
	var items 
	if (specialLoadFunc)
		items = specialLoadFunc();
	else
		items = DWR.syncCall("loginService.getDictItems",dict);
	var map = {};
	var item;
	if (!items) items = {}
	for(var i=0;i<items.length;i++) {
		item = items[i];
		map[item.code] = item;
	}
	itemList = items;
	localCache['dict_l_'+dict]=items;
	localCache['dict_m_'+dict]=map;
}

Common.clearDict = function(dict){
	var localCache = this.getLocalCache()
	localCache['dict_l_'+dict]=null;
	localCache['dict_m_'+dict]=null;
}
Common.cOrg = function(){
	var org = this.getLocalCache()['cOrg']
	return clone(org);//{id:org.id,uniqueId:org.uniqueId,name:org.name,orgLevel:org.orgLevel,parent:org.parent,isInternal:org.isInternal}
}
Common.rootOrg = function(){
	var org = this.getLocalCache()['rootOrg']
	return clone(org);//{id:org.id,uniqueId:org.uniqueId,name:org.name,orgLevel:org.orgLevel,parent:org.parent,isInternal:org.isInternal}
}


Common.getMaxResult = function(){
	var localCache = this.getLocalCache()
	var token = 'queryTable.maxResult'
	var maxResult = localCache[token]
	if (!maxResult){
		var v = DWR.syncCall("propertyService.getSystemPropertyValue","magicTableLength");
		maxResult = v ? v : 10;
		localCache[token] = maxResult
	}
	return maxResult;
}

Common.cOperator = function(){
	var person = this.getLocalCache()['cOper']
	if (person)
		return {id:person.id,name:person.name,uniqueId:person.uniqueId};
	else
		return {}
}


/** 得到workbench */
Common._getWB =function(p){
	p = Common.rootWin(p);
	if (p.pageType=="dialog"){
		return this._getWB(p.opener?p.opener:p.dialogArguments)
	}
	return p;
}

Common.getOpener = function (){
	var p = Common.rootWin();
	return p.opener?p.opener:p.dialogArguments	
}


Common.getPhoto = function (link){

	if (!link) return appRoot + "images/basic/blank.gif";
	return contextRoot + "d/photo/"+link;
}

Common.getIdentify = function (){
	return contextRoot + "d/identify/"+(Math.random());
}

function setPages(pages){
	window._switch_pages = pages
}

function switchPage(pageId,handle){
	if (!window._switch_pages) return;
	for (var i=0;i<window._switch_pages.length;i++){
		var c = $(window._switch_pages[i]);
		if (!c) continue;
		if (c.id == pageId){
			c.style.display = "";
		}else{
			c.style.display = "none";
		}
	}
	if (typeof handle=="function"){
		handle();
	}
}

try{
	Common.wbWin = Common._getWB()
}catch(e){}


//返回登录页面
function returnToLogin(){
	if (Common.wbWin.opener){
		try{
				Common.wbWin.opener.document.location.href= appRoot +'login.html?logout=true';
			
		}catch(e){
		}finally{
			var p = Common.rootWin();
			if (p.pageType=="dialog"){
				p.close();
			}
			try{
				Common.wbWin.close();
			}catch(e){}
		}
	}else{
		Common.wbWin.document.location.href= appRoot +'login.html?logout=true';
	}
}


/* 提示错误的对话框 */
function showError(strMessage,height,width,scroll,resize){
	return openDialog(appRoot + "common/message.html?msgtype=error",strMessage,height,width,null,scroll,resize);
}

/* 提示信息的对话框 */
function showInformation(strMessage,height,width,scroll,resize){
	return openDialog(appRoot + "common/message.html?msgtype=information",strMessage,height,width,null,scroll,resize);
}

function _showStrMessage(type,strMessage,height,width,scroll,resize){
	if(supportModalDialog())
		return openDialog(appRoot + "common/message.html?msgtype="+type,strMessage,height,width,null,scroll,resize);
	else
		alert(strMessage);
}
/* 提示可否的对话框 */
function showQuestion(strMessage,height,width,scroll,resize){
	if (supportModalDialog())
		v = (true == openDialog(appRoot + "common/message.html?msgtype=question", strMessage, height, width, null, scroll, resize));
	else
		v = confirm(strMessage);
	return v;
}
/* 提示注意的对话框 */
function showWarning(strMessage,height,width,scroll,resize){
	return openDialog(appRoot + "common/message.html?msgtype=warning",strMessage,height,width,null,scroll,resize);
}

/* 提示输入数据的对话框 */
function showPrompt(plabel,checkType,defaultValue,maxlength,pdescription,cantempty,callback){
	var url = "/common/prompt.html?checktype=" + (checkType?checkType:"");
	url += "&defaultvalue=" + (defaultValue?defaultValue:"");
	url += "&plabel=" + (plabel?plabel:"");
	url += "&maxlength=" + (maxlength?maxlength:"");
	url += "&pdescription=" + (pdescription?pdescription:"");
	url += "&cantempty=" + (cantempty?cantempty:"");
	return openDialogFrame(url,"提示信息",180,320,callback); 
}
