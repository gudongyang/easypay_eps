function Loading() { }

Loading.LOADING_ICON = appRoot + "images/grey.gif";
/* 增加在某个区域显示正在载入提示 */
Loading.addLoading = function(id){
	var _layer1 = new Element("div");
	_layer1.className = "loadLayerOut";
	var _layer2 = new Element("div");
	_layer2.className = "loadLayerIn";
	var _loadImg = new Element("img");
	_loadImg.src = this.LOADING_ICON;
	_loadImg.align = "absmiddle";
	var _loadText = document.createTextNode("");
	_layer2.appendChild(_loadImg);
	_layer2.appendChild(_loadText);
	_layer1.appendChild(_layer2);
	var pObj = $(id);
	if(pObj.childNodes[0]){
		pObj.insertBefore(_layer1,pObj.childNodes[0]);
	}
	else{
		pObj.appendChild(_layer1);
	}
}
/* 取消在某个区域显示正在载入提示 */
Loading.removeLoading = function(id){
	var _obj = $(id);
	if(_obj.childNodes[0]){
		if(_obj.childNodes[0].className == "loadLayerOut")
		_obj.removeChild(_obj.childNodes[0]);
	}
}

/* 显示全屏载入提示 */
Loading.showFrameLoading = function(){
	if(parent.$("frameset3")){
		parent.$("frameset3").rows = "*,0,0";
	}
	if(parent.$("tDialog")){
		parent.$("tDialog").style.display ="none";
		parent.$("tLoading").style.display ="block";
	}
}
/* 隐藏全屏载入提示 */
Loading.hideFrameLoading = function(){
	if(parent.$("frameset3")){
		parent.$("frameset3").rows = "0,*,0";
	}
	if(parent.$("tDialog")){
		parent.$("tDialog").style.display ="block";
		parent.$("tLoading").style.display ="none";
	}
}

/*div dialog*/

/* loading时,覆盖全屏 */
Loading.blockScreen = function(){
	if(document.body){
		document.body.focus();
	}
	var html = "<div id='loading' style='position:absolute;left:40%'>";
		html +="<img src='"+this.LOADING_ICON+"' align='middle'> ";
		html +="</div>";
	this._divDialogShow(html,300,150);
}

Loading.cancelBlockScreen = function(){
	var objLoading = $("loading");
	if(objLoading && objLoading.style.display != "none"){
		this._divDialogHide();
		objLoading.style.display = "none";
	}
}
/*div dialog调用接口*/
Loading._divDialogShow = function(showdata,w,h){
	this._screenConvert();
	var objDialog = $("DialogMove");
	if (!objDialog){
		objDialog = new Element("div");
		objDialog.id = "DialogMove";
	}
	var winW = 800;
	var winH = 600;
	if (document.body.clientHeight){
		winW = document.body.clientWidth;
		winH = document.body.clientHeight;
	}
	var DiglogX,DiglogY;
	DiglogX = winW/2 + document.body.scrollLeft - w/2;
	DiglogY = winH/2 + document.body.scrollTop - h/2;
	
	var oS = objDialog.style;oS.display = "block";
	oS.top = DiglogY + "px";
	oS.left = DiglogX + "px";
	oS.margin = "0px";
	oS.padding = "0px";
	oS.width = w + "px";
	oS.height = h + "px";
	oS.position = "absolute";
	oS.zIndex = "6";
	objDialog.innerHTML = showdata;
	if($("DialogMove")){}else{document.body.appendChild(objDialog);}
}
Loading._divDialogHide = function(){
	this._screenClean();
	var objDialog = $("DialogMove");
	if (objDialog)objDialog.style.display = "none";
}
Loading._screenConvert = function(){
	var objScreen = $("ScreenOver");
	if(!objScreen)objScreen = new Element("div");
	var oS = objScreen.style;
	objScreen.id = "ScreenOver";
	oS.display = "block";
	oS.top = oS.left = oS.margin = oS.padding = "0px";
	var wh = "100%";
	if (document.body.clientHeight){
		wh = document.body.clientHeight + "px";
		if(document.body.scrollHeight > document.body.clientHeight){
			wh = document.body.scrollHeight + "px";
		}
	}
	else if (window.innerHeight){
		wh = window.innerHeight + "px";
	}
	else{
		wh = "100%";
	}
	oS.width = "100%";
	oS.height = wh;
	oS.position = "absolute";
	oS.zIndex = "5";
	oS.background = "#cccccc";
	oS.filter = "alpha(opacity=40)";
	oS.opacity = 40/100;
	oS.MozOpacity = 40/100;
	document.body.appendChild(objScreen);
	var html = "<iframe src='"+appRoot+"common/screen.html' frameborder=0 style='position:absolute;visibility:inherit;top:0px;left:0px;z-index:-1;overflow:hidden;width:100%;height:100%;' scrolling=no></iframe>";
	objScreen.innerHTML = html;
}
Loading._screenClean = function(){
	var objScreen = $("ScreenOver");
	if(objScreen)objScreen.style.display = "none";
}
