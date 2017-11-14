/**
 * 兼容chrome
 */
Element.Properties.column = {

    get: function(){
        return this.column;
    },

    set: function(value){
        this.column = value;
        this.setAttribute('column', value);
    }
};
Element.Properties.titleIndex = {

    get: function(){
        return this.titleIndex;
    },

    set: function(value){
        this.titleIndex = value;
        this.setAttribute('titleIndex', value);
    }
};

/**
 * displayColumns 显示的列[0,1,4,5]
 */
function QueryTable(queryName,searchFormId,tableId,columns,options){
	/**
	* 依赖的外界方法 $、esc,checkForm,Array.prototype.add & remove,
	*/
	if(!options) 
		options = {}
		
	this.inited = false;
	this.queryName = queryName;
	this.tableId = tableId;
	QT.tables[tableId] = this
	$(this.tableId).style.width = "100%"
	this.searchFormId = searchFormId;			
	this.dataSrc = null;
	this.title = options.title?options.title:"";
	this.service = options.service;
	this.clickRowFunc = options.clickRowFunc;
	this.failOrder = options.failOrder;
	
	this.start=0;
	var mr
	try{
		var mr  = Cookie.read("pageLen");
		if (!mr)mr = Common.getMaxResult();
		mr = parseInt(mr)
	}catch(e){}
	this.maxResult = mr?mr:10
	
	this.total=0;
	
	this.pageMultiple = 10;
	this.minRows = 10;

	this.params = null;
	this.paramFunc = options.paramFunc;
	
	this.columns = [];							//定制的列信息,默认是全部列
	
	var cColumns								//当前显示的column
	
	var me = this;
	var dataDiv									//数据Div
	var searched = false;						//是否已经查询
	var columnsConf = options.columnsConf;
	var showData = options.showData;
	var isPage = options.isPage == false?false : true;							//是否显示翻页

	var itemMap = {}							//存储tr、td map
	
	
	var initcols = false;						//初始化列是否完成
	var loading = false;						//载入数据标志
	var orderFlag = false;						//是否可以排序
	
	
	var orderColumn;
	
	var exportLayer = null;
	var confLayer = null;						//定制显示列的层对象
	var flagLayer = null;						//标志托拽列放置位置的层对象
	
	var htId = me.tableId +"_table_head";				//head table id
	var dtId = me.tableId +"_table_data";				//data table id
	var tableWidth = 0;									//table 宽度

	
	//获得查询条件方法
	var getParams = function(){
		if (me.paramFunc)
			return me.paramFunc()
		else if (me.searchFormId)
			return Common.getValues(me.searchFormId)
		else
			return {}
	}
	//获取源数据
	var gds = function(){
		return me.dataSrc
	}
	//初始化列宽度
	var buildColumnsWidth1 = function(){
		tableWidth = dataDiv.offsetWidth
		var cbc = 0	//checkbox数量
		var nw = 0 //没有width的列的数量
		var total = 0 //有width列的宽度综合
		var column
		
		for (var i=0;i<cColumns.length;i++){
			column = cColumns[i];
			
			if (column.isSelect){
				column.width = QueryTable.CR_SIZE;
				cbc++
			}else if (!column.oWidth)
				nw++
			else
				total += column.oWidth
		}
		
		var dataW = tableWidth - cbc * QueryTable.CR_SIZE  	//除去radio,checkbox之后
			
		var defWidth = Math.floor(dataW / (cColumns.length-cbc))
	
		var bw = dataW - defWidth * nw 
		
		for (var i=0;i<cColumns.length;i++){
			var column = cColumns[i];
			if (column.type == "checkbox" || column.type == "radio") continue;
			
			var w = column.oWidth
			if (!w){
				column.width = defWidth;
			}else{
				column.width = Math.round(bw * w/total);
			}
		}
	}
	
	//初始化显示区域，title，button，数据区域
	var initView = function(){	
		var div = $(me.tableId)
		$(me.tableId+'_title').innerHTML = me.title?me.title:'';
		
		createHeadTable(me.tableId+"_heads");

		dataDiv.style.height = options.height?options.height:"250px";
		dataDiv.style.width = (tableWidth + 17) + "px";
		if (!showData){
			createEmptyTable();
			if (isPage)
				createPaginate(me.tableId+"_page");
		}else{
			me.showTable();
		}
		if (options.initFunc)
			options.initFunc();
		me.inited = true;
	}
	
	/** 创建按钮
	 * @param id 按钮的id
	 * @param value 按钮内容
	 * @param actions 点击按钮触发的方法
	 */
	var createButton = function(id,value,actions,disabled,title){

		var btn = new Element('button',{
					type : 'button',
					html : value
				})
		if (title)
			btn.title = title
		if (id) btn.id = id
		if (disabled) btn.disabled = true
		if (actions) btn.addEvent('click',function(){actions.call()})	//default not transfer target to handler
		return btn;
	}

	//生成button
	var createButtons = function(divId){
		var div = $(divId);
		if (options.exportable == true){
			var b = createButton("export","导 出");
			div.appendChild(b);
			b.addEvent("click",exportClick);	//need transfer btn to exportClick
			b.addEvent("mouseout",hideExportLayer);
		}
		if (!options.buttons) return
		for (var i = 0; i<options.buttons.length; i++){
			var b = options.buttons[i]
			if (typeof b == "object"){
				b = createButton(b.id?me.tableId + "_btn_" + b.id:'',b.value,b.actions,b.disabled,b.title)
			}
			if (b && b.type == "button")
				div.appendChild(b)
		}
	}
	var exportClick = function(){
		var cl = getExportLayer(this);
		cl.style.display = "";
		cl.innerHTML = "";
		var bts = ["xml","pdf","xls","csv","rtf"]
		for (var i=0;i<bts.length;i++){
			var c = bts[i];
			var div = new Element("DIV");
			var a = new Element("DIV",{
				'class':QueryTable.EXPORT_DIV_OUT,
				html : c,
				styles : {
					'text-align' : 'center'
				},
				events : {
					'mouseout' : function(){this.className = QueryTable.EXPORT_DIV_OUT},
					'mouseover' : function(){this.className = QueryTable.EXPORT_DIV_OVER},
					'click' : function(){exportList(this.innerHTML)}
					
				}
			})
			div.appendChild(a);
			cl.appendChild(a);
		}
	}
	//创建table
	var ct = function(div,id){
		if (typeof div != "object")
			div = $(div)
		var table = new Element("TABLE");
		if (id) table.id = id;
		table.width = tableWidth;
		table.border = "0";
		table.cellPadding = 0;
		table.cellSpacing = 0;
		div.appendChild(table);
		var tbody = new Element("TBODY");
		table.appendChild(tbody);
		return tbody;
	}
	//生成checkbox、radio
	var ci = function(type,value){
		var input = new Element("input",{
			type : type,
			value : value
		})
		
		return input
	}
	//生成表头
	var createHeadTable = function(divId){
		$(divId).empty();
		var tbody = ct(divId,htId);	
		//生成数据表头,包括定制、托拽列宽度的功能
		var tr = new Element("TR");
		tbody.appendChild(tr);
		tr.style.height = "34px";
		for (var i=0; i<cColumns.length; i++){
			var c = cColumns[i];
			var td = new Element("TD",{
				column : c.col,
				titleIndex : i ,
				styles : {
					width : c.width + "px"
				}
			})
			tr.appendChild(td)
			if (c.type == "checkbox"){
				var input = ci("checkbox");
				td.appendChild(input) 
				input.addEvent("click",cbAll)
			}else if (c.type == "radio"){
				var input = ci("radio");
				td.appendChild(input) 
			}else{
				var div1 = new Element("DIV");
				
				td.appendChild(div1);
				if (i>0&&!cColumns[i-1].isSelect){																	//checkbox的列宽度不变
					div1.className = QueryTable.HEADER_LEFT_CLASS;
					div1.addEvent("mousedown",sizingDown)
				}else{
					div1.className = QueryTable.NORMAL_LEFT_CLASS;
				}
				var div = new Element("DIV",{
					html : c.name?I18N.getText('qt_'+me.queryName+'.'+c.name,c.title):c.title,
					orderby : c.col,
					styles : {
						width :(c.width - div1.offsetWidth - 4) + "px",
						height : "24px",
						overflow : "hidden"
					},
					events : {
						mousedown : dragDown
					}
				});
				if (c.defOrder) {
					div.dasc = c.defOrder === true?"desc":c.defOrder;
					div.className = div.dasc == "desc"?QueryTable.ORDERBY_DESC:QueryTable.ORDERBY_ASC;
					me.orderby = c.col + " " + div.dasc;
					orderColumn = div;
				}
				if (c.align)
					div.style.textAlign = c.align;
				if (!me.failOrder && c.order != false)
					div.addEvent("order",orderFunc)
				td.appendChild(div)
			}
		}
		
	}
	
	//生成数据表格
	var createDataTable = function(){
	
		var html = "<table width="+tableWidth+" border=0 cellPadding=0 cellSpacing=0>"

		var result = me.dataSrc
		me.start = result.start;
		me.total = result.total;
		me.objects = result.objects;
		var datas = result.objects;
		//var tbody = ct(dataDiv.id,dtId);
		var cols = $(htId).getElements('td');
		var titleWidths = cols.map(function(td){
			return td.style.width;//td.getSize().x
		})
		
		var trHeight = isIE()?"24px":"25px"
		for(var i=0; i<datas.length; i++){
			var d = datas[i];
			html += createTR(d,trHeight, cols,i);
		}
		html += "</table>"
		dataDiv.innerHTML = html
		
		if (isPage)
			createPaginate(me.tableId+"_page");
		searched = true;
	}
	//生成数据表行数据
	var createTR = function(data , trHeight, cols,lineNo){
		var tr = "<tr height="+trHeight+" onmouseover=QT.trOver(this) onmouseout=QT.trOut(this) onclick=QT.trClick(this,event)>"
		
		var c 
		var columns = me.columns
		for (var i = 0; i < columns.length; i++) {
			c = columns[i];
			if (c.name) data[c.name] = data[i]
		}
		var count = 0
		for (var i=0; i<cols.length; i++){
			var htd = cols[i];
			c = cColumns[htd.titleIndex];
			tr+="<td"
			if (lineNo==0){
				tr+= " width="+htd.style.width
			}
			tr += " >"
			if (data){
				var v = data[htd.column];
				v = c.render?c.render(v,data):v
				if (c.isSelect) {
					tr += "<input class=rowcheck type="
					tr += c.type
					tr += " value="
					tr += v
					tr += " onclick='QT.cbOne(this,this.type==\"radio\"?!this.checked:this.checked)'>"
						
				}
				else {
					tr += "<div"
					if (c.align&&c.align!='left'&&c.align!='')
						tr+=" align=" + c.align
					tr += ">"
					tr += v == null ? "&nbsp;" : v
					tr += "</div>"
				}
			}else{
				tr+="&nbsp;"
			}
			tr+="</td>"
			count++
		}
		tr+="</tr>"
		return tr;
	}

	var hideFlag = function(){
		var fl = getFlagLayer()
		fl.style.display = "none"
	}
	
	var dragDown = function(e){
		e = new Event(e).stop();
		
		var clone = new Element('div')
						.setStyles(this.getCoordinates()) // this returns an object with left/top/bottom/right, so its perfect
						.setStyles({'opacity': 0.7, 'position': 'absolute'})
						.set('class',QueryTable.DRAG_LAYER_CLASS)
						.inject(document.body);
		var dflag = new Element('div',{
						html : '',
						'class':QueryTable.DARG_LAYER_CONTENT_NO,
						styles : {
							width : '20px',
							height : '20px',
							'float' : 'left'
						}
					})
		clone.grab(dflag)
		var dtext = new Element('div',{
						html : this.get('html'),
						'class' : QueryTable.DARG_LAYER_CONTENT_TITLE,
						styles : {
							overflow : "hidden"
						}
					})
		clone.grab(dtext)
		var orig = this
		var origTd = this.getParent()
	  	var origInd = origTd.cellIndex

	 	var drag = clone.makeDraggable({
			droppables: this.getParent('tr').getChildren(),
			onCancel: function(element){ // due to MooTool's inheritance, all [Drag][]'s Events are also available.
				element.destroy()
				hideFlag()
				orig.fireEvent('order')
      		},
      		onDrop: function(element, droppable){
      			if (droppable && !droppable.getElement("INPUT")){
      				var dropInd = droppable.cellIndex
		  			if (dropInd!=origInd&&dropInd!=origInd+1){
	      				origTd.inject(droppable,'before')
		  				dataDiv.getElements('tr').each(function(tr){
		  					tr.getChildren()[origInd].inject(tr.getChildren()[dropInd],'before')
		  				})
		  			}
      			}
	  			
      	   	    element.destroy()
				hideFlag()
		    },
		    onEnter: function(element, droppable){
		    	if (droppable.getElement("INPUT")) return;
		        element.getChildren()[0].set('class',QueryTable.DARG_LAYER_CONTENT_YES)
		        var fl = getFlagLayer()
		        var pos = droppable.getPosition()
		        fl.setStyles({left: pos.x-4,top : pos.y-15})
		        fl.style.display = ""
		    },
	 
		    onLeave: function(element, droppable){
		        element.getChildren()[0].set('class',QueryTable.DARG_LAYER_CONTENT_NO)
				hideFlag()
		    }
		 	
		}); // this returns the dragged element
 
		drag.start(e); // start the event manual
	}
	
	//排序
	var orderFunc = function(){
		if (!this.get('orderby')) return;
		if (!orderFlag) return;
		
		if (this.dasc == "asc") {
			this.className = QueryTable.ORDERBY_DESC;
			this.dasc = "desc"
		}else{
			this.className = QueryTable.ORDERBY_ASC;
			this.dasc = "asc"
		}
		if (orderColumn && orderColumn!=this)
			orderColumn.className = "";
		orderColumn = this;
		
		me.orderby = this.get('orderby') + " "+this.dasc;
	
		me.start = 0;
		me.onclickActions(0);
	}

	//搜索提示
	var createEmptyTable = function(){

		var h = dataDiv.offsetHeight -1;
		dataDiv.innerHTML = "<div style=\"height:"+h + "px;\" class='"+QueryTable.EMPTY_TABLE_CLASS+"'><div style=\"margin-top:"+(h/2-14)+"\" class='gray'><!---->提示：输入查询条件后点击[查询]按钮，查询结果会显示在这里</div></div>";
		searched = false;
	}
	//获得标记层对象
	var getFlagLayer = function(){
		if (!flagLayer){
			flagLayer = new Element("DIV")
			flagLayer.className = QueryTable.FLAG_LAYER_CLASS;
			flagLayer.style.display = "none";
			var div1 = new Element("DIV")
			div1.className = QueryTable.COL_MOVE_TOP;
			var div2 = new Element("DIV")
			div2.className = QueryTable.COL_MOVE_MIDDLE;
			div2.style.height = $(htId).offsetHeight;
			var div3 = new Element("DIV")
			div3.className = QueryTable.COL_MOVE_BOTTOM;
			flagLayer.appendChild(div1);
			flagLayer.appendChild(div2);
			flagLayer.appendChild(div3);
			$(me.tableId).appendChild(flagLayer);
		}
		return flagLayer;
	}
	//获得导出层对象
	var getExportLayer = function(ex){
		if (!exportLayer){
			var positon = ex.getPosition()
			exportLayer = new Element("DIV",{
				id : me.tableId + "_export_layer",
				'class' : QueryTable.CONF_LAYER_CLASS,
				styles : {
					left : positon.x + "px",
					top : (positon.y + ex.offsetHeight - 4) + "px",
					width : (ex.offsetWidth - 8) + "px"
				},
				events : {
					mouseout : hideExportLayer,
					mouseover : showExportLayer
				}
			})
			$(me.tableId).appendChild(exportLayer);
		}
		return exportLayer;
	}
	//获得定制列层对象
	var getConfLayer = function(conf){
		if (!confLayer){
			var positon = conf.getPosition();
			confLayer = new Element("DIV",{
				id : me.tableId + "_conf_layer",
				'class' : QueryTable.CONF_LAYER_CLASS,
				styles : {
					left : positon.x + "px",
					top : (positon.y + conf.offsetHeight) + "px"
				},
				events : {
					mouseout : hidConfLayer,
					mouseover : showConfLayer
				}
			})
			$(me.tableId).appendChild(confLayer);
		}
		return confLayer;
	}
	//定制方法
	var confFunc = function(){
		var cl = getConfLayer(this);
		cl.style.display = "";
		cl.innerHTML = "";
		
		for (var i=0;i<me.columns.length;i++){
			var c = me.columns[i];
			if (c.hidden) continue;			
			var div = new Element("DIV");
			
			var cb = new Element("input",{
				checked : c.checked,
				type : 'checkbox',
				value : i
			}).inject(div)
			var span = new Element("span",{
				html : c.title
			}).inject(div)
			cl.appendChild(div);
			cb.addEvent("click",selColumn)
		}
		return false;
	}
	//定制需要显示的列
	var selColumn = function(){
		var c = me.columns[this.value];
		var b = c.checked;
		c.checked = this.checked;
			
		cColumns = me.columns.filter(function(col){
			return col.checked
		})
		
		buildColumnsWidth1()
		
		createHeadTable(me.tableId+"_heads");
		createDataTable()
	} 
	var hidConfLayer = function(){
		if (confLayer) confLayer.style.display = "none";
	}
	var showConfLayer = function(){
		if (confLayer) confLayer.style.display = "";
	}
	var hideExportLayer = function(){
		if (exportLayer) exportLayer.style.display = "none";
	}
	var showExportLayer = function(){
		if (exportLayer) exportLayer.style.display = "";
	}
	
	//托拽方法
	var sizingDown = function(e){
		e = new Event(e).stop();
		
		var clone = new Element('div')
						.setStyles(this.getCoordinates()) // this returns an object with left/top/bottom/right, so its perfect
						.setStyles({ width:'1px','position': 'absolute'})
						.set('class','separlayer')
						.inject(document.body);
	  	var orig = this
	  	var lastDrop = this.getParent().getPrevious()
	  	var nextDrop = this.getParent()
	  
	 	var drag = clone.makeDraggable({
			container : this.getParent('tr'),
			droppables: [lastDrop,nextDrop],
			onCancel: function(element){ // due to MooTool's inheritance, all [Drag][]'s Events are also available.
				element.destroy()
      		},
      		onDrop: function(element, droppable){
      			if (droppable){
      				var dx = droppable.getPosition().x
			        var w = element.getPosition().x - orig.getPosition().x
			        var pw = lastDrop.getSize().x + w
					var cw = nextDrop.getSize().x - w;
					if (pw>12&&cw>12){
						
						var pd = lastDrop.getElements('div')[1];
						var cd = nextDrop.getElements('div')[1];
						pd.setStyles({width : (pd.getSize().x+w) + "px"});
						cd.setStyles({width : (cd.getSize().x-w) + "px"});
						lastDrop.setStyles({width : pw + "px"});
						nextDrop.setStyles({width : cw + "px"});
						
	  					var ind = nextDrop.cellIndex
						dataDiv.getElements('tr').each(function(tr){
		  					tr.getChildren()[ind-1].setStyles({width : pw + "px"});
		  					tr.getChildren()[ind].setStyles({width : cw + "px"});
		  				})
						
					}
      			}
      	   	    element.destroy()
		    }

		}); // this returns the dragged element
 
		drag.start(e); // start the event manual
		
	}

	var getPrevious = function(e){
		var node = e.previousSibling;
		while (node){
			if (node.style.display == "none"){
				node = node.previousSibling;
			}else
				return node;
		}
		return null
	}
	
	var cbAll = function(){
		var checked =  this.checked
		dataDiv.getElements('.rowcheck').each(function(checker){
			checker.checked = checked
			checker.getParent('tr').style.backgroundColor = checked?QueryTable.CHECKED_COLOR:"";
		})
		
	}
	
	//页脚翻页
	var createPaginate = function(divId){
		var dataSrc = me.dataSrc
		var previewText = "<img width=18 height=15 src='../images/arrow_left.gif' onmouseover=this.src='../images/arrow_left_over.gif' onmouseout=this.src='../images/arrow_left.gif'>";
		var nextText =  "<img width=18 height=15 src='../images/arrow_right.gif' onmouseover=this.src='../images/arrow_right_over.gif' onmouseout=this.src='../images/arrow_right.gif'>";
		var previewTextOff = "<img width=18 height=15 src='../images/arrow_leftoff.gif'>";
		var nextTextOff =  "<img width=18 height=15 src='../images/arrow_rightoff.gif'>";
		var total = dataSrc.total;
		var start = dataSrc.start;
		var maxResult = me.maxResult;
		var pageHTML="";
		
		var temp = total-(total%maxResult!=0?total%maxResult:maxResult);
		var pages=temp/maxResult+1;	
		pageHTML += "<table cellSpacing=0 cellPadding=4 width=100% border=0 class=page><tr>";
		pageHTML += "<td width=33%>"+I18N.getText('js_qt_each_page',"每页")+"<select id="+me.tableId+"pageLen name="+me.tableId+"pageLen>";
		for (var i = 1;i<=me.minRows;i++){
			pageHTML += "<option value="+(i*me.pageMultiple)+""+(i*me.pageMultiple==maxResult?" selected":"")+">"+(i*me.pageMultiple)+"</option>"				
		}
		pageHTML += "</select>"+I18N.getText('js_qt_items',"  条")+I18N.getText('js_qt_total',dataSrc.oversize?" 超过 ":" 共 ")+"<span>"+total+"</span>"+I18N.getText('js_qt_items',"  条")
		
		if (dataSrc.statTitle) pageHTML += ","+dataSrc.statTitle;
		pageHTML += "</td>";
				
		pageHTML += "<td width=33% align=center>"
		var text = I18N.getText('js_qt_first',"首页")
		if (start>0)
			pageHTML += "<a id='"+me.tableId+"first' href=# title='"+text+"'>"+text+"</a>";
		else
			pageHTML += text;
		pageHTML += "&nbsp;";
		
		text = I18N.getText('js_qt_previous',"上一页")
		if (start>=maxResult)
			pageHTML += "<a id='"+me.tableId+"forward' href=# title='前"+maxResult+"条'>"+text+"</a>";
		else
			pageHTML += text;
		pageHTML += "&nbsp;";
			
		text = I18N.getText('js_qt_next',"下一页")

		if ((start+maxResult)<total){
			pageHTML+="<a id='"+me.tableId+"next' href=# title='后"+maxResult+"条'>"+text+"</a>";
		}else{
			pageHTML+= text;
		}
		pageHTML += "&nbsp;";
							
		text = I18N.getText('js_qt_last',"末页")
		if (start < (pages-1)*maxResult)
			pageHTML += "<a id='"+me.tableId+"last' href=# title='"+text+"'>"+text+"</a>";
		else
			pageHTML += text;
			
		pageHTML += "</td>";
		
		pageHTML += "<td width=33%  align=right>";
		var pageTotal = pages?pages:1
		var currentPage = Math.round(start/maxResult,0)+1;
		
		pageHTML += I18N.getText('js_qt_total_pages',"共 ")+"<span>"+pageTotal+"</span>"+I18N.getText('js_qt_pages_empty',"  页")+"&nbsp;&nbsp;";
		pageHTML += I18N.getText('js_qt_pages',"第")+"<input type='text' size='1' id="+me.tableId+"pageNo value="+(currentPage?currentPage:1)+">"+I18N.getText('js_qt_pages_empty',"页")+"<button type='button' id="+me.tableId+"go_button name="+me.tableId+"pageNo>GO</button>";
		
		pageHTML +="</td>";	
		pageHTML += "</tr></table>";
		$(divId).innerHTML = pageHTML;
		if ($(me.tableId + "first"))
			$(me.tableId + "first").addEvent("click",function(){me.onclickActions(0);return false;})
		if ($(me.tableId + "forward"))
			$(me.tableId + "forward").addEvent("click",function(){me.onclickActions(start-maxResult);return false;})
		if ($(me.tableId + "next"))
			$(me.tableId + "next").addEvent("click",function(){me.onclickActions(start+maxResult);return false;})
		if ($(me.tableId + "last"))
			$(me.tableId + "last").addEvent("click",function(){me.onclickActions((pages-1)*maxResult);return false;})
		if ($(me.tableId + "go_button"))
			$(me.tableId + "go_button").addEvent("click",function(){
				var pNo = parseInt($(me.tableId + "pageNo").value);
				if (!searched) return;
				if (isNaN(pNo)) {showWarning("请输入页码");return;}
				if (pNo>1 && pNo > pages){showWarning("输入页码数大于最大页数");return;}
				me.onclickActions((pNo-1)*maxResult);
			})
		if ($(me.tableId + "pageLen"))
			$(me.tableId + "pageLen").addEvent("change",function(){
					me.maxResult = this.value;
					Cookie.write("pageLen",this.value,{path: '/', duration: 1000})
					me.onclickActions(0);
				})
	}
	
	var initColumns = function(rColumns){
		var dcMap = null;
		if (options.displayColumns){
			dcMap = {}
			for (var i=0;i<options.displayColumns.length;i++){
				dcMap[options.displayColumns[i]] = true;
			}
		}
			
		var c0,c1;
		//cbc radio或者checkbox的数量
		var len = Math.max(rColumns.length,columns.length);
		
		cColumns = []
		for(var i=0;i<len;i++){
			c0 = columns[i];
			c1 = rColumns[i];
			if (!c0&&!c1) continue;
			if (!c0 && c1.name) c0 = columns[c1.name]
			if (!c0) c0 = c1
			else
			{
				c0 = new Hash(c0).extend(new Hash(c1));
			}
			if (!c0.title)c0.hidden = true
			if (c0.type == "checkbox" || c0.type == "radio"){
				c0.hidden = null
				c0.isSelect = true
			} 
			c0.col = i;
			if (c0.hidden|| dcMap && (!dcMap[i] && (!c0.name?true:!dcMap[c0.name]))) { //后台定义了hidden,前台设置了displayColumn,不在其中不显示,不显示
				c0.checked = false
			}
			else {
				cColumns.push(c0)
				c0.checked = true;
			}	
			var w = parseInt(c0.width);
			if (!isNaN(w)){ 
				c0.oWidth = w;
			}
			
			me.columns.push(c0);
		}

		initcols = true;
		buildColumnsWidth1();
		
		initView();
	}	
	//默认button
	//导出文件方法
	var exportList = function(type){
		var params = getParams()
		var path = contextRoot + "d/list/"+ me.queryName +"."+type
		
		if (params)
			path += "?"+ $H(params).toQueryString()
		
		//TODO put 'orderBy' , 'maxResult' and 'showFields'
		if (type=='pdf'||type=='xls'||type=='rtf'||type=='csv'){
			document.location.href=path
		}else if (type=='xml')
			window.open(path)
	}

	this.getBoxValue = function(isArray){
		
		var cbs = dataDiv.getElements('input.rowcheck[checked]');
		var ids 
		var objs = me.objects;
		if (isArray)
			ids = cbs.map(function(cb){return objs[cb.getParent('tr').rowIndex]})
		else
			ids = String(cbs.map(function(cb){return cb.value}))
		return ids;
	}
	
	this.getRadioValue = function(all){
		
		var cb = dataDiv.getElement('input.rowcheck[checked]');
		
		if (cb){
			return all?me.objects[cb.getParent('tr').rowIndex]:cb.value;
		}
	}
	
	this.getBts = function(){
		return $(me.tableId + "_btns").getElements("button")
	}

	this.showTable = function(){
		if (!initcols) {showData = true;return};
		if (loading) return;
		this.start = 0
		this.onclickActions(this.start);
	}
	this.getBtnById = function(id){
		return $(me.tableId + "_btn_" + id)
	}
	this.onclickActions = function(start){
		orderFlag = true;
		if (this.checkFunc){
			if (!this.checkFunc())
				return;
		}else if (this.searchFormId&&!checkForm(this.searchFormId)){
			return;
		}
		this.params = getParams();
		if (this.queryName){
			loading = true;			
			DWR.call("ejbQueryService.selectData",this.queryName,this.params,this.orderby,start,this.maxResult,null,function(pageObj){
				
		
				me.dataSrc = pageObj;
				createDataTable();	
				if (me.callback)
					me.callback(pageObj.objects)
			},{finalFunc:function(){loading = false;},blockScreen:true})//loading:this.tableId
		}else{
			if (!me.dataSrc)
				me.dataSrc = {start : 0,total : 0,objects : []}		//空数据
			
			createDataTable();		//for test datasource
		}
	}
	var initDiv = function(){
		var div = $(me.tableId)
		var html = '';
			html += '<div class="listBorder">';
			html += '<div class="listBar"'+(options.displayBar == "none"||options.displayBar == false?' style="display:none;"':'')+'>';
	        html += '<div class="listTitle"><span id="'+me.tableId+'_title"></span>&nbsp;<a href=# id="'+me.tableId+'_conf">'+I18N.getText('js_qt_customize','定制')+'</a></div>';
	        html += '<div class="listBtn" id="'+me.tableId+'_btns">'
	        html += '</div></div>';
			html += "<div class=list>";
			html += '<div id="'+me.tableId+'_heads" class="qthead"></div>'
			html += '<div id="'+me.tableId+'_datas" class="qtdata"></div>'
			html += '<div id="'+me.tableId+'_page"></div></div>';
		
		div.innerHTML = html;
		dataDiv = $(me.tableId+'_datas')
		var confDiv = $(me.tableId+"_conf")
		if (columnsConf === false)
			confDiv.style.display = "none";
		else{
			confDiv.addEvent("click",confFunc);
			confDiv.addEvent("mouseout",hidConfLayer);
		}
		createButtons(me.tableId+"_btns");
	}();
	this.initTable = function(){
		//初始化columns，从后台取得columns设置，与前台设置columns设置组合
		me.dataSrc = {start : 0,total : 0,objects : []}		//空数据
		me.columns = []
		if (me.queryName)
			DWR.call("ejbQueryService.getTableMeta",me.queryName, getParams(),function(meta){
				if (!me.title)
					me.title = I18N.getText('qt_'+me.queryName,meta.title);
				initColumns(meta.columns);	
			});
		else
			initColumns([]);
	}	
	
	this.clearTable = function(){
		me.dataSrc = {start : 0,total : 0,objects : []}		//空数据
		createEmptyTable();
		if (isPage)
			createPaginate(me.tableId+"_page");
	}
	
	this.initTable();
}
function QT(){}
QT.tables = {}		//querytable的缓存


QT.getTable = function(ele){
	var tableId = $(ele).getParent('.listBorder').getParent().id
	return QT.tables[tableId]
}
QT.checkRadio;								//被选中的radio
QT.cbOne = function(ele,checked){
	var color = "";
	ele = $(ele)
	ele.checked = checked;
		
	var tr = ele.getParent('tr')
	if (ele.type == "radio") {
		if (QT.checkRadio && ele != QT.checkRadio){
			var otr = QT.checkRadio.getParent('tr');
			if (otr)
				otr.style.backgroundColor = "";
			QT.checkRadio.checked = false
		}
		QT.checkRadio = ele
	}
	if (ele.checked) color = QueryTable.CHECKED_COLOR;
	
	tr.style.backgroundColor = color;
	var table = QT.getTable(tr)
	if (table&& table.clickRowFunc){
		table.clickRowFunc(table.objects[tr.rowIndex],tr)
	}
}

QT.trOver = function(tr){
	tr.style.backgroundColor = QueryTable.OVER_COLOR;
}
	
QT.trOut = function(tr){
	var color = "";
	var cb = $(tr).getElement('.rowcheck')
	if (cb&&cb.checked) color = QueryTable.CHECKED_COLOR;
	tr.style.backgroundColor = color;
}
	
QT.trClick = function(tr,e){
	e = window.event?window.event:e
	if (e){
		var target = e.target?e.target:e.srcElement
		//checkbox 或者超链接点上的，不算
		if (target.tagName=="INPUT"||target.tagName=="A")
			return;
	}
	
	var cb = $(tr).getElement('.rowcheck')
	if (cb){
		QT.cbOne(cb,!cb.checked)
	}	
}
	
QueryTable.CR_SIZE = 24;									//checkbox radio列宽度
QueryTable.EMPTY_TABLE_CLASS = "emptytable";				//未执行查询前的空表格样式
QueryTable.TABLE_LAYER_CLASS = "tablelayer";				//未执行查询前的空表格样式
QueryTable.HEADER_LEFT_CLASS = "header_leftdiv";			//拖动列宽度的div样式
QueryTable.NORMAL_LEFT_CLASS = "normal_leftdiv";			//拖动列宽度的div样式

QueryTable.ORDERBY_DESC = "desc";							//倒排样式
QueryTable.ORDERBY_ASC = "asc";								//顺序样式
QueryTable.DRAG_LAYER_CLASS = "draglayer";					//托拽列层样式
QueryTable.DARG_LAYER_CONTENT_YES = "d_l_content_yes";		//可以放置的位置
QueryTable.DARG_LAYER_CONTENT_NO = "d_l_content_no";		//不可以放置的位置
QueryTable.DARG_LAYER_CONTENT_TITLE = "d_l_c_title";		//托拽列内容
QueryTable.FLAG_LAYER_CLASS = "flaglayer";					//列位置标志层
QueryTable.COL_MOVE_TOP = "col_move_top";					
QueryTable.COL_MOVE_MIDDLE = "col_move_middle";					
QueryTable.COL_MOVE_BOTTOM = "col_move_bottom";					
QueryTable.CONF_LAYER_CLASS = "conflayer";					//定制显示列样式
QueryTable.EXPORT_DIV_OUT = "exportdiv_out";				//导出div样式
QueryTable.EXPORT_DIV_OVER = "exportdiv_over";				//导出div样式


QueryTable.OVER_COLOR = "#CBE2FF";
QueryTable.CHECKED_COLOR = "#ffffcc";
