function SystemMgnt() {
}

//系统管理模块js方法
SystemMgnt.photoWidth = "120";

SystemMgnt.orderOrgLevel = function () {
    var items = Common.getItems("org_level");
    var orgLevels = []
    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        orgLevels.push(item);
    }
    for (var i = 0; i < orgLevels.length; i++) {
        for (var j = 0; j < orgLevels.length - i - 1; j++) {
            if (orgLevels[j].code > orgLevels[j + 1].code) {
                var t = orgLevels[j]
                orgLevels[j] = orgLevels[j + 1]
                orgLevels[j + 1] = t;
            }
        }
        if (orgLevels[orgLevels.length - i]) {
            orgLevels[orgLevels.length - i].parent = orgLevels[orgLevels.length - i - 1]
            orgLevels[orgLevels.length - i - 1].child = orgLevels[orgLevels.length - i]
        }
    }
    return orgLevels
}

SystemMgnt.selOperator = function (handle, options) {
    if (!options || !options.orgId) {
        showWarning("请选择单位");
        return;
    }
    var url = spellUrl("/basic/sel_operator.html", options)
    openDialogFrame(url, "选择操作员", 500, 700, handle)
}

//选择商品
SystemMgnt.selGifts = function (handle, options) {
    if (!options) options = {}
    var url = spellUrl("/basic/sel_gifts.html", options)
    openDialogFrame(url, '选择商品', 550, 740, handle)
}

//选择角色
SystemMgnt.selRole = function (handle, options) {
    if (!options || !options.orgLevel) {
        showWarning("请选择单位");
        return;
    }
    var url = spellUrl("/basic/sel_role.html", options)
    openDialogFrame(url, '选择角色', 450, 640, handle)
}


//选择加油站
SystemMgnt.selStation = function (handle, options) {
    if (!options) options = {}
    options.isStation = true;
    options.orgLevel = Constants.ORG_LEVEL_STATION;
    options.qtTitle = "加油站列表";
    var url = spellUrl("/basic/sel_orglist.html", options)
    return openDialogFrame(url, "选择加油站", 435, 700, handle)
}

//选择机构列表
SystemMgnt.selOrgList = function (handle, options) {
    if (!options) options = {}
    var url = spellUrl("/basic/sel_orglist.html", options)
    return openDialogFrame(url, "选择机构", 435, 700, handle)
}

//选择单位
SystemMgnt.selOrg = function (handle, options) {
    var url = spellUrl("/basic/sel_org.html", options)
    openDialogFrame(url, '选择单位', 300, 400, handle);
}
/**
 * 设置模板页面初始数据
 */
SystemMgnt.initData = function (form, data) {
    if (!form || !data) return;
    for (prop in data) {
        if (data.hasOwnProperty(prop)) {
            SystemMgnt.confCtrl(form, data[prop], prop);
        }
    }
}

/**
 * 设置模板页面控件
 */
SystemMgnt.confCtrl = function (form, obj, name) {
    if (!obj) return;
    var c = form[name];
    if (!c) return;
    var b = obj.disabled;
    if (b) {
        c.disabled = true;
        if (obj.tagName == "SELECT") {
            c.className = "disabled";
        }
        else {
            c.className = "readonly";
        }
    } else {
        c.disabled = false;
        c.className = "";
    }
}

/**
 * 显示操作员
 * @param divId 显示模板的区域id
 * @param id操作员id
 * @param options
 */
SystemMgnt.showOperator = function (divId, id, options) {
    if (!options) options = {}
    if (typeof id != "object")
        DWR.call("partyService.getOperatorById", id, function (result) {
            SystemMgnt.loadOperatorView(divId, result, options);
        });
    else {
        SystemMgnt.loadOperatorView(divId, id, options);
    }
}

SystemMgnt.loadOperatorView = function (divId, result, options) {
    var ns = "operator_detail";
    Rpc.loadPage(divId, "/basic/operator_detail_div.html");
    var operator = {}
    if (result) {
        operator = result.operator;
        operator.orgname = result.orgName;
        operator.registerTime = operator.registerTime ? operator.registerTime.format() : "";
        operator.gender = Common.getText("gender", operator.gender)
        operator.nation = Common.getText("nation", operator.nation)
        operator.province = Common.getText("province", operator.province)
        operator.country = Common.getText("country", operator.country)
        operator.groups = result.groups
    }

    var tbody = $("operator_groups").parentNode;
    for (var i = 0; operator.groups && i < operator.groups.length; i++) {
        var g = operator.groups[i]
        var tr = document.createElement("TR")
        tbody.appendChild(tr)
        var td = document.createElement("TD")
        td.innerHTML = g.uniqueId
        tr.appendChild(td)
        td = document.createElement("TD")
        td.innerHTML = "<a href=# onclick='SystemMgnt.showDlgGroup(" + g.id + ")'>" + g.name + "</a>";
        tr.appendChild(td)
        td = document.createElement("TD")
        td.innerHTML = g.description ? g.description : ''
        tr.appendChild(td)
    }

    Common.showDetail("operatortable", operator);
    if (operator.photo)
        $('operatorPhotoDet').innerHTML = "<img id=picsrc src='" + Common.getPhoto(operator.photo) + "' width='" + SystemMgnt.photoWidth + "'>";
    else
        $('operatorPhotoDet').innerHTML = "";
}

SystemMgnt.showDlgGroup = function (id) {
    var url = spellUrl("/basic/dialog_group.html", {id: id})
    openDialogFrame(url, '查看角色信息', 500, 600, function () {
    });
}
/**
 * 编辑操作员
 * @param divId 显示模板的区域id
 * @param id操作员id 为空表示新增
 * @param options
 */
SystemMgnt.editOperator = function (divId, id, options) {
    if (!options) options = {};
    var photoView = "operPhotoView";
    Rpc.loadPage(divId, "/basic/operator_edit_div.html");
    var operatorForm = $("operatorForm");
    Common.initDict(operatorForm.gender, "gender", "－－");		//初始化性别(明细)
    Common.initDict(operatorForm.nation, "nation", "－－");		//初始化民族
    Common.initDict(operatorForm.province, "province", "－－");	//初始化省份
    Common.initDict(operatorForm.country, "country", "－－");	//初始化国家
    var setDetOrg = function (sorg) {					//总部 选择操作员机构方法

        operatorForm.organization.value = sorg.id;
        operatorForm.orgname.value = sorg.name;
    }
    var orglink = $("operator_sel_org");
    if (orglink)
        orglink.onclick = function () {
            SystemMgnt.selOrg(setDetOrg, {funcType: Constants.SELORG_CHILDREN, noGasStation: true})
        }
    var result;
    if (id) {
        result = DWR.syncCall("partyService.getOperatorById", id);
    }
    var operator = {};
    if (result) {
        operator = result.operator;
        operator.orgname = result.orgName;
        operatorForm.reset();
        Common.setValues(operatorForm, operator);
    } else {
        operatorForm.reset();
        setDetOrg(Common.cOrg());
    }

    if (options.isInfo) {
        $("operatorForm_invalidTime").style.display = "none";
        $("operator_sel_org").style.display = "none";
    }
    SystemMgnt.initData(operatorForm, options.initData);

    $(photoView).innerHTML = "<img id='" + photoView + "_img' src='" + Common.getPhoto(operator.photo) + "' width='" + SystemMgnt.photoWidth + "'>";

}
SystemMgnt.saveOperator = function (saveHandle) {
    if (!checkForm("operatorForm")) return;
    var operator = Common.getValues("operatorForm");
    try {
        var v = DWR.syncCall("partyService.saveOperator", operator)
        showInformation("操作员【" + operator.name + "】保存成功")
        if (operator.photoFile) {
            Site.uploadPic(operatorForm, "Operator", v.operator.id, "操作员",
                function () {
                    saveHandle(v)
                }
            )
        } else {
            saveHandle(v);
        }
    } catch (e) {
        showError(e.description);
        return;
    }
}
/**
 * 显示 组织机构
 * @param divId 显示模板的区域id
 * @param id    机构id
 */
SystemMgnt.showOrganization = function (divId, id) {
    if (typeof id != "object")
        DWR.call("partyService.getOrganization", id, function (result) {
            SystemMgnt.showOrgan(divId, result);
        });
    else
        SystemMgnt.showOrgan(divId, id);
}
/**
 * 显示 组织机构
 * @param divId 显示模板的区域id
 * @param id    机构id
 */
SystemMgnt.showOrgan = function (divId, result) {
    Rpc.loadPage(divId, "/basic/organization_detail_div.html");
    var org = {}
    if (result) {
        org = result.organization;
        org.parentname = result.parentName;
        org.checklevel = result.parentLevel;
    }
    Common.showDetail(divId, org);
}
/**
 * 显示 角色
 * @param divId 显示模板的区域id
 * @param id    角色id
 */
SystemMgnt.showGroup = function (divId, id, options) {
    if (!id) return;
    Rpc.loadPage(divId, "/basic/role_detail_div.html");
    var v = DWR.syncCall("partyService.getGroup", id);
    window.tree = null;
    var writeTree = function () {
        webTreeHandler.init();
        tree = new LoadTree("功能模块", null, "javascript:void(0)", null, "../images/tree/root.png", "../images/tree/root.png", "");
        var obj = {id: "root"}
        tree.obj = obj;
        $("role_detail_tree").innerHTML = tree;
        tree.select();
    }
    window._startLoadXmlTree = function (sSrc, jsNode, newNode) {
        DWR.call("partyService.findModuleAclByGroup", id, sSrc, function (result) {
            _xmlFileLoaded(result, jsNode);
        })
    }
    window._createNode = function (r) {
        var obj = {id: r[0], name: r[1], pageUrl: r[2]}
        var node = createTreeNode(obj.pageUrl, obj.name, obj.id, "javascript:void(0)", "../images/tree/module.png", "../images/tree/module.png");
        node.obj = obj;
        return node;
    }
    Common.showDetail("role_detail_det", v)
    writeTree();
}