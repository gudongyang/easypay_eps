function RuleMgnt() {
}
RuleMgnt.currentRuleSetId = null
RuleMgnt.editPage = null
RuleMgnt.audit = true
RuleMgnt.queryRuleSets = function (aSet) {
    if (aSet) {
        searchForm.year.value = aSet.beginTime.getYear()
    }
    var year = parseInt(searchForm.year.value)
    DWR.call("ruleMgntService.findRuleSetsByYear", searchForm.orgId.value, RULETYPEID, searchForm.year.value, function (results) {

        if (aSet)
            RuleMgnt.currentRuleSetId = aSet.id
        else
            RuleMgnt.currentRuleSetId = null

        var yearBegin = new Date(year, 0, 1)
        var yearEnd = new Date(year + 1, 0, 1)
        var now = new Date()
        var left, width

        var leftMargin = 50

        var timeOfDay = 24 * 3600 * 1000
        var dayOfYear = (yearEnd - yearBegin) / timeOfDay

        var labelHtml = "<div class=ruleTimeLabelDiv>"
        var firstOfMonth
        for (var i = 0; i < 12; i++) {
            firstOfMonth = new Date(year, i, 1)
            left = ((firstOfMonth - yearBegin) / timeOfDay) / dayOfYear * 700 + leftMargin
            labelHtml += "<div class=ruleTimeLabel style='left:" + (left - 10) + "px'>"
            labelHtml += firstOfMonth.format('MM月')
            labelHtml += "</div>"
        }
        labelHtml += "</div>"

        var html = "<div>"
        html += labelHtml

        var spanHtml
        var beginTime, endTime

        var ruleSet
        var result
        for (var k = 0; k < results.length; k++) {
            result = results[k]
            spanHtml = "<div class=ruleOrgDiv>"
            spanHtml += result.orgLevel
            spanHtml += "</div>"
            spanHtml += "<div class=ruleTimeSpanDiv>"
            for (var i = 0; i < result.ruleSets.length; i++) {
                ruleSet = result.ruleSets[i]
                beginTime = ruleSet[1]
                if (beginTime < yearBegin) beginTime = yearBegin
                endTime = ruleSet[2]
                if (endTime > yearEnd) endTime = yearEnd

                if (RuleMgnt.currentRuleSetId == null && beginTime <= now && endTime > now) {
                    //判断是否为有效规则
                    RuleMgnt.currentRuleSetId = ruleSet[0]
                }
                left = ((beginTime - yearBegin) / timeOfDay) / dayOfYear * 700 + leftMargin
                width = ((endTime - beginTime) / timeOfDay) / dayOfYear * 700

                spanHtml += "<a href=# title="
                spanHtml += ruleSet[1].format('yyyy/MM/dd') + '至' + ruleSet[2].format('yyyy/MM/dd')
                spanHtml += " class=ruleTimeSpan"
                spanHtml += " id=ruleSet" + ruleSet[0] + " onclick='RuleMgnt.showRuleSet(" + ruleSet[0] + ")' style='left:" + left + "px;width:" + width + "px'>&nbsp;"
                spanHtml += "</a>"
            }
            spanHtml += "</div>"
            html += spanHtml
        }
        html += "</div>"
        $('ruleSetTimes').innerHTML = html
        if (RuleMgnt.currentRuleSetId) {
            RuleMgnt.showRuleSet(RuleMgnt.currentRuleSetId)
        } else {
            //清除当前的ruleSet显示
            $('detailDiv').innerHTML = ""
        }
    });
}


//提交审核
RuleMgnt.submitForAudit = function () {
    if (!this.currentRuleSetId) {
        showInformation("请选择需要提交的规则!");
        return
    }
    if (!(showQuestion("确定提交吗?"))) {
        return;
    }
    DWR.call("ruleMgntService.submitForAudit", this.currentRuleSetId, function (set) {
        showInformation("提交成功!");
        RuleMgnt.queryRuleSets(set)
    }, {blockScreen: "true"});
}

//显示ruleSet
RuleMgnt.showRuleSet = function (ruleSetId) {
    if (!$('ruleSet' + ruleSetId)) return

    if (this.currentRuleSetId != null && $('ruleSet' + this.currentRuleSetId) != null) {
        $('ruleSet' + this.currentRuleSetId).className = "ruleTimeSpan"
    }
    $('ruleSet' + ruleSetId).className = "ruleTimeActiveSpan"
    this.currentRuleSetId = ruleSetId
    RuleMgnt.showRuleSetDetail("detailDiv", ruleSetId, true)
}

//显示ruleSet
RuleMgnt.showRuleSetDetail = function (showDivId, ruleSetId, showBtn) {

    Rpc.loadPage(showDivId, "/query/ruleset_detail_div.html");

    DWR.call("ruleMgntService.getRuleSet", ruleSetId, function (result) {
        Common.showDetail(showDivId, result);
        if (result.ruleTexts) {
            var html = "<table cellSpacing=0 cellPadding=2 width=100% border=0 class=ruleTable>"
            html += "<tr><th width=15%>执行顺序</th><th>判断条件</th><th>执行结果</th></tr>"
            var ruleTexts
            for (var j = 0; j < result.ruleTexts.length; j++) {
                ruleTexts = result.ruleTexts[j]
                html += "<tr><td align=center>"
                html += (j + 1)
                html += "</td><td>"
                html += ruleTexts.judge
                html += "</td><td>"
                html += ruleTexts.result
                html += "</td></tr>"
            }
            for (var j = 0; j < 3; j++) {
                html += "<tr></tr>"
            }
            html += "</table>"
            $("ruleListDiv").innerHTML = html
        }
        if (showBtn) {

            var btnHtml = ""
            if (result.createOrg == Common.cOrg().id) {
                if (!RuleMgnt.audit || result.status == RuleStatus.DRAFT) {
                    btnHtml += "<button onclick=RuleMgnt.onDelete()>删 除</button>"
                    btnHtml += "<button onclick=RuleMgnt.onEdit()>编 辑</button>"
                    if (RuleMgnt.audit)
                        btnHtml += "<button onclick=RuleMgnt.submitForAudit()>提交审核</button>"
                } else if (result.status == RuleStatus.NORMAL) {
                    btnHtml += "<button onclick=RuleMgnt.onCancel()>申请撤销</button>&nbsp;&nbsp;"
                } else if (result.status == RuleStatus.REQUEST) {
                    btnHtml += "<button onclick=RuleMgnt.cancelRequest()>申请撤销</button>&nbsp;&nbsp;"
                }
            }

            $("ruleSetBtnDiv").innerHTML = btnHtml
        }
    });
}
RuleMgnt.cancelRequest = function () {
    var id = this.currentRuleSetId;
    if (!id) {
        showInformation("请选择需要提交撤销申请的规则!");
        return
    }
    if (!(showQuestion("确定撤销申请吗?"))) {
        return;
    }
    DWR.call("ruleMgntService.cancelRequest", id, function () {
        showInformation("撤销申请成功!");
        this.currentRuleSetId = null
        RuleMgnt.showRuleSet(id);
    }, {blockScreen: "true"});
}
//点击进入新增页面
RuleMgnt.onNew = function () {
    Rpc.loadPage("detailDiv", "/query/ruleset_edit_div.html");
    Eui.initDateInput("beginTimeDiv", "生效日期", "ruleSetForm", "beginTime", null, true);
    Eui.initDateInput("endTimeDiv", "失效日期", "ruleSetForm", "endTime", "futureDate", true);

    var html = "<table cellSpacing=0 cellPadding=2 width=100% border=0 class=ruleTable>"
    html += "<tr><th width=15%>执行顺序</th><th>判断条件</th><th>执行结果</th><th width=20%><button onclick=RuleMgnt.onEditRule()>新条件</button></th></tr>"

    for (var j = 0; j < 3; j++) {
        html += "<tr></tr>"
    }
    html += "</table>"
    $("ruleListDiv").innerHTML = html

}

RuleMgnt.onEditRule = function () {
    var v = openDialogFrame(this.editPage, '编辑规则', 300, 460)
    if (v) {
        var v2 = clone(v)
        DWR.call("ruleMgntService.getRuleTextByParams", RULETYPEID, v2, function (ruleText) {
            var tbody = $("ruleListDiv").childNodes[0].childNodes[0]
            var tr = document.createElement("TR");
            tr.ruleValue = v2
            var td = document.createElement("TD");
            td.align = "center"
            td.innerHTML = tbody.childNodes.length - 3
            tr.appendChild(td);
            td = document.createElement("TD");
            td.innerHTML = ruleText.judge
            tr.appendChild(td);
            td = document.createElement("TD");
            td.innerHTML = ruleText.result
            tr.appendChild(td);
            td = document.createElement("TD");
            td.innerHTML = "<a href=# onclick=RuleMgnt.deleteRule(this)>删除</a>&nbsp;<a href=# onclick=RuleMgnt.ruleUp(this)>上移</a>&nbsp;<a href=# onclick=RuleMgnt.ruleDown(this)>下移</a>&nbsp;"
            tr.appendChild(td);
            tbody.insertBefore(tr, tbody.childNodes[tbody.childNodes.length - 3])
        });

    }
}

RuleMgnt.deleteRule = function (ruleA) {
    var ruleTr = ruleA.parentNode.parentNode
    ruleTr.parentNode.removeChild(ruleTr)
    this.refreshRuleIndex()
}

RuleMgnt.ruleUp = function (ruleA) {
    var ruleTr = ruleA.parentNode.parentNode
    var ind = parseInt(ruleTr.childNodes[0].innerHTML)
    var tbody = ruleTr.parentNode
    if (ind > 1) {
        tbody.removeChild(ruleTr)
        tbody.insertBefore(ruleTr, tbody.childNodes[ind - 1])
        this.refreshRuleIndex()
    }
}

RuleMgnt.ruleDown = function (ruleA) {
    var ruleTr = ruleA.parentNode.parentNode
    var ind = parseInt(ruleTr.childNodes[0].innerHTML)
    var tbody = ruleTr.parentNode

    if (ind < tbody.childNodes.length - 3 - 1) {
        tbody.removeChild(ruleTr)
        tbody.insertBefore(ruleTr, tbody.childNodes[ind + 1])
        this.refreshRuleIndex()
    }
}

RuleMgnt.refreshRuleIndex = function () {
    var tbody = $("ruleListDiv").childNodes[0].childNodes[0]
    for (var i = 1; i < tbody.childNodes.length - 3; i++) {
        tbody.childNodes[i].childNodes[0].innerHTML = i
    }
}

//保存和修改方法
RuleMgnt.onSave = function () {
    if (!checkForm(ruleSetForm))return;
    if (!(showQuestion("您确认保存吗?"))) return

    var formValue = Common.getValues(ruleSetForm);
    formValue.ruleType = RULETYPEID

    var tbody = $("ruleListDiv").childNodes[0].childNodes[0]
    var rules = new Array()
    for (var i = 1; i < tbody.childNodes.length - 3; i++) {
        rules.push(tbody.childNodes[i].ruleValue)
    }
    var service = "ruleMgntService.saveRuleSet"
    if (!RuleMgnt.audit)
        service = "ruleMgntService.saveRuleSetNoAudit"
    DWR.call(service, formValue, rules, function (set) {
        showInformation("保存成功!");
        RuleMgnt.queryRuleSets(set);
    }, {blockScreen: "true"});
}


//进入修改明细
RuleMgnt.onEdit = function () {
    if (!this.currentRuleSetId) {
        showInformation("请选择需要编辑的规则!");
        return
    }
    Rpc.loadPage("detailDiv", "/query/ruleset_edit_div.html");
    Eui.initDateInput("beginTimeDiv", "生效日期", "ruleSetForm", "beginTime", null, true);
    Eui.initDateInput("endTimeDiv", "失效日期", "ruleSetForm", "endTime", "futureDate", true);

    DWR.call("ruleMgntService.editRuleSet", this.currentRuleSetId, function (result) {
        Common.setValues(ruleSetForm, result);
        if (result.ruleTexts) {
            var html = "<table cellSpacing=0 cellPadding=2 width=100% border=0 class=ruleTable>"
            html += "<tr><th width=15%>执行顺序</th><th>判断条件</th><th>执行结果</th><th width=20%><button onclick=RuleMgnt.onEditRule()>新条件</button></th></tr>"
            var ruleTexts
            for (var j = 0; j < result.ruleTexts.length; j++) {
                ruleTexts = result.ruleTexts[j]
                html += "<tr><td align=center>"
                html += (j + 1)
                html += "</td><td>"
                html += ruleTexts.judge
                html += "</td><td>"
                html += ruleTexts.result
                html += "</td><td>"
                html += "<a href=# onclick=RuleMgnt.deleteRule(this)>删除</a>&nbsp;<a href=# onclick=RuleMgnt.ruleUp(this)>上移</a>&nbsp;<a href=# onclick=RuleMgnt.ruleDown(this)>下移</a>&nbsp;"
                html += "</td></tr>"
            }
            for (var j = 0; j < 3; j++) {
                html += "<tr></tr>"
            }
            html += "</table>"
            $("ruleListDiv").innerHTML = html

            var tbody = $("ruleListDiv").childNodes[0].childNodes[0]
            for (var i = 1; i < tbody.childNodes.length - 3; i++) {
                tbody.childNodes[i].ruleValue = result.rules[i - 1]
            }
        }

    });

}
//删除方法
RuleMgnt.onDelete = function () {
    if (!this.currentRuleSetId) {
        showInformation("请选择需要删除的规则!");
        return
    }
    if (!(showQuestion("确定删除吗?"))) {
        return;
    }
    var service = "ruleMgntService.deleteRuleSet"
    if (!RuleMgnt.audit)
        service = "ruleMgntService.deleteRuleSetNoAudit"

    DWR.call(service, this.currentRuleSetId, function () {
        showInformation("删除成功!");
        RuleMgnt.queryRuleSets()
    }, {blockScreen: "true"});
}

//撤销方法
RuleMgnt.onCancel = function () {
    if (!this.currentRuleSetId) {
        showInformation("请选择需要提交撤销申请的规则!");
        return
    }
    if (!(showQuestion("确定提交撤销申请吗?"))) {
        return;
    }
    DWR.call("ruleMgntService.cancelRuleSet", this.currentRuleSetId, function () {
        showInformation("撤销申请提交成功!");
    }, {blockScreen: "true"});
}

//修改保存后返回（暂时是清除明细显示）
RuleMgnt.backShow = function () {
    $("detailDiv").innerHTML = ""
}