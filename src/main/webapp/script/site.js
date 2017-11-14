function Site(){}
Site.uploadQueue = [];
Site.upload = function(form,handle){
	if (form.action=='_processing'){
		return;
	}
		
	if (this.uploadFrame == null)
	{
		this.uploadFrame = this.createIFrame('uploadFrame',Site.onUploadOK);
	}
	var action = form.action;
	var target = form.target;
	var task = {'form':form, 'target': target, 'action':action, 'handle':handle};
	if (this.currentUpload!=null)
	{
		this.uploadQueue.push(task);
	}
	else{
		this.currentUpload = task;
	}
	form.target = this.uploadFrame.name;
	try{
		form.submit();
	}catch(e){
		this.uploadQueue = [];
		this.currentUpload = null;
		this.uploadFrame = null;
		alert('上传失败:'+e.message);
	}
	form.action = '_processing';
}

Site.onUploadOK = function(){
	if (Site.currentUpload==null){
		return;
	}
	var task = Site.currentUpload;
	var form = task.form;
	form.target = task.taget;
	form.action = task.action;
	var result = Site.uploadFrame.contentWindow.document.body.innerHTML;
	Site.currentUpload = null;
	if (Site.uploadQueue.length>0)
	{
		var task2 = Site.uploadQueue.shift();
		Site.currentUpload = task2;
		var form2 = task2.form;
		form2.target = Site.uploadFrame.name;
		form2.submit();
		form2.action = null;
	}
	if (task.handle!=null)
		task.handle(result);
}

//创建隐藏帧
Site.createIFrame = function(fname, loadFunc){
	var cframe = $(fname)
	if (!cframe){
		cframe = new Element('iframe',{
			name : fname,
			id : fname,
			styles : {
				position : 'absolute',
				left : "0px",
				top : "0px",
				height : "1px",
				width : "1px",
				visibility : "hidden"
			}
		}).inject(document.body)
		if (loadFunc) cframe.addEvent('load',loadFunc)
	}
	return cframe;
}


//添加form隐藏属性
Site._createHidden = function(formObj,name,value){
	if (!formObj[name]){
		new Element("input",{
			name : name,
			type : 'hidden',
			value : value
		}).inject(formObj)
	}
}
//预览图片
Site.previewPic = function(obj,view,width,height){
	obj.select();
	$(view).focus() //兼容IE9
	var imgSrc = document.selection.createRange().text
	if (!width)
		width = 120;
	if (!height)
		height = 148;
	var newPreview = $(view);
	newPreview.innerHTML = "";
	if (!newPreview.hasClass("preview"))
		newPreview.addClass("preview")
	newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	newPreview.style.width = width + "px";
	newPreview.style.height = height + "px";
}
//预览图片
Site.previewPicByImg = function(imgSrc,view,width,height){
	if (!width)
		width = 120;
	if (!height)
		height = 148;
	var newPreview = $(view);
	newPreview.innerHTML = "";
	if (!newPreview.hasClass("preview"))
		newPreview.addClass("preview")
	newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	newPreview.style.width = width + "px";
	newPreview.style.height = height + "px";
}

//上传图片并保存
Site.uploadPic = function(form,entityType,entityId,entityName,callback){
	var formObj = typeof form!='object'?$(form):form;
	if (!entityId||!entityType){
		showError("无"+(entityName?entityName:"")+"信息，不能上传图片");
		return
	}	
	if (!formObj.photoFile||!formObj.photoFile.value){
		showError("请选择一张图片上传");
		return
	}	
	formObj.action= contextRoot + "d/uploadAndSave/photo";
	Site._createHidden(formObj,"entityId",entityId)
	Site._createHidden(formObj,"entityType",entityType)
	Site._createHidden(formObj,"entityName",entityName)
	Site.upload(formObj,function(r){
		var obj;
		if (r)
			eval("obj="+r)
		else
			obj = {}
		if (obj.photoId){
			showInformation("图片保存成功！");
		}else{
			if (obj.error){
				showError(obj.error)
			}
		}
		if (callback)
			callback(obj)
	});	
}

/**
 *上传商户凭证资料
 *@param form 要提交的表单名称
 *@param uType 照片类型
 */
Site.uploadUserPhoto = function(form,uType){
	var formObj = typeof form!='object'?$(form):form;
	if(!formObj["phototype_"+uType].value){
		alert("没有上传图片")
		return
	}
	formObj["phototype_"+uType].name="photoFile"
	formObj.photoType.value=uType
	formObj.action= contextRoot+ "d/upload/userphoto";
	Loading.blockScreen();
	Site.upload(formObj,function(r){
		var obj;
		if (r){
			eval("obj="+r)
		}else{
			obj = {}
		}
		if(obj.serverFileName){
			alert("上传成功")
			if(!$("img_icon_"+uType)){
				new Element("img",{src:appRoot+"images/icon/icon_ok.png",width:20,height:20,id:"img_icon_"+uType}).inject(formObj["phototype_"+uType],"after")
			}else{
				$("img_icon_"+uType).src=appRoot+"images/icon/icon_ok.png"
			}
		}else if(obj.error){
			alert(obj.error)
			if(!$("img_icon_"+uType)){
				new Element("img",{src:appRoot+"images/icon/icon_no.png",width:20,height:20,id:"img_icon_"+uType}).inject(formObj["phototype_"+uType],"after")
			}else{
				$("img_icon_"+uType).src=appRoot+"images/icon/icon_no.png"
			}
		}
		formObj["phototype_"+uType].name="phototype_"+uType
		Loading.cancelBlockScreen();
	});	
}
/**
 *上传代理商凭证资料
 *@param form 要提交的表单名称
 *@param uType 照片类型
 */
Site.uploadOrgPhoto = function(form,uType){
	var formObj = typeof form!='object'?$(form):form;
	if(!formObj["phototype_"+uType].value){
		alert("没有上传图片")
		return
	}
	formObj["phototype_"+uType].name="photoFile"
	formObj.photoType.value=uType
	formObj.action= contextRoot+ "d/upload/orgphoto";
	Loading.blockScreen();
	Site.upload(formObj,function(r){
		var obj;
		if (r){
			eval("obj="+r)
		}else{
			obj = {}
		}
		if(obj.serverFileName){
			alert("上传成功")
			if(!$("img_icon_"+uType)){
				new Element("img",{src:appRoot+"images/icon/icon_ok.png",width:20,height:20,id:"img_icon_"+uType}).inject(formObj["phototype_"+uType],"after")
			}else{
				$("img_icon_"+uType).src=appRoot+"images/icon/icon_ok.png"
			}
		}else if(obj.error){
			alert(obj.error)
			if(!$("img_icon_"+uType)){
				new Element("img",{src:appRoot+"images/icon/icon_no.png",width:20,height:20,id:"img_icon_"+uType}).inject(formObj["phototype_"+uType],"after")
			}else{
				$("img_icon_"+uType).src=appRoot+"images/icon/icon_no.png"
			}
		}
		formObj["phototype_"+uType].name="phototype_"+uType
		Loading.cancelBlockScreen();
	});	
}
/**
 *上传任意文件到服务器
 *@param form 要提交的表单名称
 *@param callback 回调函数
 */
Site.uploadAnyFile = function(form,callback){
	var formObj = typeof form!='object'?$(form):form;
	if(!formObj["anyFile"].value){
		alert("没有上传文件")
		return
	}
	formObj.action= contextRoot+ "d/upload/anyfile";
	Loading.blockScreen();
	Site.upload(formObj,function(r){
		var obj;
		if (r){
			eval("obj="+r)
		}else{
			obj = {}
		}
		if(obj.serverFileName){
			alert("上传成功")
			if(!$("img_icon_")){
				new Element("img",{src:appRoot+"images/icon/icon_ok.png",width:20,height:20,id:"img_icon_"}).inject(formObj["anyFile"],"after")
			}else{
				$("img_icon_").src=appRoot+"images/icon/icon_ok.png"
			}
		}else if(obj.error){
			alert(obj.error)
			if(!$("img_icon_")){
				new Element("img",{src:appRoot+"images/icon/icon_no.png",width:20,height:20,id:"img_icon_"}).inject(formObj["anyFile"],"after")
			}else{
				$("img_icon_").src=appRoot+"images/icon/icon_no.png"
			}
		}
		Loading.cancelBlockScreen();
		if (callback){
			callback(obj)		
		}
	});	
}
/**
 * 保存商品图片--商品图片在shopgoods表中 不在photo
 * @param {Object} form
 * @param {Object} entityType
 * @param {Object} entityId
 * @param {Object} entityName
 */
Site.uploadGoodsPhoto = function(form,entityType,entityId,entityName,callback){
	var formObj = typeof form!='object'?$(form):form;
	if (!entityId||!entityType){
		showError("无"+(entityName?entityName:"")+"信息，不能上传图片");
		return
	}	
	formObj.action= "/d/uploadGoodsPhoto/";
	Site._createHidden(formObj,"entityId",entityId)
	Site._createHidden(formObj,"entityType",entityType)
	Site._createHidden(formObj,"entityName",entityName)
	Site.upload(formObj,function(r){
		var obj;
		if (r)
			eval("obj="+r)
		else
			obj = {}
		if (obj.goodsId){
			showInformation("图片保存成功！");
		}else{
			if (obj.error){
				alert(obj.error)
			}
		}
		if (callback)
			callback(obj)
	});	
}
/**
 * 上传聚POS的购买POS的图片
 * @param {Object} form
 */
Site.uploadAppGoodsPhoto = function(form,callback){
	var formObj = typeof form!='object'?$(form):form;
	formObj.action= "/d/uploadGoodsPhoto/";
	Site.upload(formObj,function(r){
		var obj;
		if (r)
			eval("obj="+r)
		else
			obj = {}
		if (obj.goodsId){
			showInformation("图片保存成功！");
		}else{
			if (obj.error){
				alert(obj.error)
			}
		}
		if (callback)
			callback(obj)
	});	
}