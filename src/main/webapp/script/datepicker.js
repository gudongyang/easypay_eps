/*时间控件开始*/
function public_setHour(hourStr, eltName) {
    var value;
    try {
        var value = parseFloat(hourStr);
        if (value > 23 || value < 0) {
            value = "00";
        }
        else if (value < 9) {
            value = "0" + value;
        }
        else if (value > 9 && value < 24) {
        }
        else {
            value = "00";
        }
    }
    catch (e) {
        value = "00";
    }
    $("timeForm").hour.value = value;
}

function public_getMinute(eltName) {
    if ($("timeForm").minute.value == "") {
        return 0;
    }
    return parseFloat($("timeForm").minute.value);
}

function public_setMinute(minuteStr, eltName) {
    var value;
    try {
        var value = parseFloat(minuteStr);
        if (value > 59 || value < 0) {
            value = "00";
        }
        else if (value < 9) {
            value = "0" + value;
        }
        else if (value > 9 && value < 59) {
        }
        else {
            value = "00";
        }
    }
    catch (e) {
        value = "00";
    }
    $("timeForm").minute.value = value;
}


function public_getSecond(eltName) {
    if ($("timeForm").second.value == "") {
        return 0;
    }
    return parseFloat($("timeForm").second.value);
}

function public_setSecond(secondStr, eltName) {
    var value;
    try {
        var value = parseFloat(secondStr);
        if (value > 59 || value < 0) {
            value = "00";
        }
        else if (value < 9) {
            value = "0" + value;
        }
        else if (value > 9 && value < 59) {
        }
        else {
            value = "00";
        }
    }
    catch (e) {
        value = "00";
    }
    $("timeForm").second.value = value;
}


function public_getTime() {
    var hourStr = $("timeForm").hour.value;
    var minuteStr = $("timeForm").minute.value;
    var secondStr = $("timeForm").second.value;
    if (!Validator.Integer.test(hourStr) || hourStr > 23 || hourStr < 0) {
        hourStr = "00";
    }
    if (!Validator.Integer.test(minuteStr) || minuteStr > 59 || minuteStr < 0) {
        minuteStr = "00";
    }
    if (!Validator.Integer.test(secondStr) || secondStr > 59 || secondStr < 0) {
        secondStr = "00";
    }
    return hourStr + ":" + minuteStr + ":" + secondStr;

    if (hourStr < 10 && hourStr.length < 2)
        hourStr = "0" + hourStr;
    if (minuteStr < 10 && minuteStr.length < 2)
        minuteStr = "0" + minuteStr;
    if (secondStr < 10 && secondStr.length < 2)
        secondStr = "0" + secondStr;
}

/*以下是控件内部使用的函数*/
var currInput = -1;

function fnHandleUp(eltName) {
    switch (currInput) {
        case -1:
            return;
        case 0:
            $("timeForm").elements[currInput].focus();
            var value = $("timeForm").elements[currInput].value;
            if (value.charAt(0) == '0') {
                value = parseInt(value.charAt(1));
            }
            else {
                value = parseInt(value);
            }
            if (value == 23) {
                $("timeForm").elements[currInput].value = "00";
                return;
            }
            value = value + 1;
            if (value <= 9) {
                value = "0" + value;
            }
            $("timeForm").elements[currInput].value = value;
            return;
        case 1:
        case 2:
            $("timeForm").elements[currInput].focus();
            var value = $("timeForm").elements[currInput].value;
            if (value.charAt(0) == '0') {
                value = parseInt(value.charAt(1));
            }
            else {
                value = parseInt(value);
            }
            if (value == 59) {
                $("timeForm").elements[currInput].value = "00";
                return;
            }
            value = value + 1;
            if (value <= 9) {
                value = "0" + value;
            }
            $("timeForm").elements[currInput].value = value;
            return;
    }
}

function fnHandleDown(eltName) {
    switch (currInput) {
        case -1:
            return;
        case 0:
            $("timeForm").elements[currInput].focus();
            var value = $("timeForm").elements[currInput].value;
            if (value.charAt(0) == '0') {
                value = parseInt(value.charAt(1));
            }
            else {
                value = parseInt(value);
            }
            if (value == 0) {
                $("timeForm").elements[currInput].value = "23";
                return;
            }
            value = value - 1;
            if (value <= 9) {
                value = "0" + value;
            }
            $("timeForm").elements[currInput].value = value;
            return;
        case 1:
        case 2:
            $("timeForm").elements[currInput].focus();
            var value = $("timeForm").elements[currInput].value;
            if (value.charAt(0) == '0') {
                value = parseInt(value.charAt(1));
            }
            else {
                value = parseInt(value);
            }
            if (value == 0) {
                $("timeForm").elements[currInput].value = "59";
                return;
            }
            value = value - 1;
            if (value <= 9) {
                value = "0" + value;
            }
            $("timeForm").elements[currInput].value = value;
            return;
    }
}

function fnHandleFoucs(index, eltName) {
    $("timeForm").elements[index].focus();
    currInput = index;
}

function fnHandleBlur(index, eltName) {
    $("timeForm").elements[index].value = $("timeForm").elements[index].value;
    if ($("timeForm").elements[index].value == "") {
        $("timeForm").elements[index].value = "00";
    }
    switch (index) {
        case 0:
            var value = $("timeForm").elements[index].value;
            if (parseFloat(value) < 0 || parseFloat(value) > 23) {
                $("timeForm").elements[index].value = "00";
                $("timeForm").elements[index].focus();
                return false;
            }
            if (value.length < 2 && $("timeForm").elements[index].value != "")
                $("timeForm").elements[index].value = "0" + $("timeForm").elements[index].value;
            return;
        case 1:
        case 2:
            var value = $("timeForm").elements[index].value;
            if (parseFloat(value) < 0 || parseFloat(value) > 59) {
                $("timeForm").elements[index].value = "00";
                $("timeForm").elements[index].focus();
                return false;
            }
            if (value.length < 2 && $("timeForm").elements[index].value != "")
                $("timeForm").elements[index].value = "0" + $("timeForm").elements[index].value;
            return;
    }
//currInput = -1;
}

function fnHandleOnKeyPress() {
    if (event.keyCode >= 48 && event.keyCode <= 57)
        return true;
    else
        return false;
}

function fnHandleOnkeydown(eltName, obj) {
    if (event.keyCode == 38) {
        fnHandleUp(eltName);
    }
    if (event.keyCode == 40) {
        fnHandleDown(eltName);
    }
}

function formatTime(intTime) {
    if (intTime < 10) {
        intTime = "0" + intTime;
        return intTime;
    }
    else {
        return intTime;
    }
}

function initTime(eltName) {
    var now = new Date();
    strhour = now.getHours();
    strminute = now.getMinutes();
    strsecond = now.getSeconds();
    $("timeForm").hour.value = formatTime(strhour);
    $("timeForm").minute.value = formatTime(strminute);
    $("timeForm").second.value = formatTime(strsecond);
}


/*日期控件开始*/
function DatePicker(oDate) {
    // check arguments
    if (arguments.length == 0) {
        this._selectedDate = new Date;
        this._none = false;
    }
    else {
        this._selectedDate = oDate || new Date();
        this._none = oDate == null;
    }

    this._matrix = [[], [], [], [], [], [], []];
    this._showNone = false;
    this._showToday = false;
    this._firstWeekDay = 0;	// start week with monday according to standards
    this._redWeekDay = 6;	// sunday is the default red day.

    this._dontChangeNone = false;
}

// two static fields describing the name of the months abd days
DatePicker.months = [
    "一月", "二月", "三月", "四月",
    "五月", "六月", "七月", "八月",
    "九月", "十月", "十一月", "十二月"];
DatePicker.days = ["一", "二", "三", "四", "五", "六", "日"];


DatePicker.prototype.onchange = function () {
};

// create the nodes inside the date picker

DatePicker.prototype.create = function (doc) {
    if (doc == null) doc = document;

    this._document = doc;

    // create elements
    this._el = doc.createElement("div");
    this._el.className = "datePicker";


    // header
    var div = doc.createElement("div");
    div.className = "header";
    this._el.appendChild(div);

    var headerTable = doc.createElement("table");
    headerTable.className = "headerTable";
    headerTable.cellSpacing = 0;
    headerTable.cellPadding = 0;
    div.appendChild(headerTable);

    var tBody = doc.createElement("tbody");
    headerTable.appendChild(tBody);

    var tr = doc.createElement("tr");
    tBody.appendChild(tr);

    var td = doc.createElement("td");

    this._previousMonth = doc.createElement("button");
    this._previousMonth.className = "previousButton";
    this._previousMonth.title = "上一月";
    this._previousMonth.value = "&lt;";

    this._previousYear = doc.createElement("button");
    this._previousYear.className = "previousButton";
    this._previousYear.title = "上一年";
    this._previousYear.value = "&lt;&lt;";
    td.appendChild(this._previousYear);
    td.appendChild(this._previousMonth);

    tr.appendChild(td);

    td = doc.createElement("td");
    td.className = "labelContainer";
    tr.appendChild(td);

    this._topLabel = doc.createElement("a");
    this._topLabel.className = "topLabel";
    this._topLabel.href = "#";
    this._topLabel.appendChild(doc.createTextNode(String.fromCharCode(160)));
    td.appendChild(this._topLabel);

    this._labelPopup = doc.createElement("div");
    this._labelPopup.className = "labelPopup";
    // no insertion

    td = doc.createElement("td");
    this._nextYear = doc.createElement("button");
    this._nextYear.className = "nextButton";
    this._nextYear.title = "下一年";
    this._nextYear.value = "&gt;&gt;";
    this._nextMonth = doc.createElement("button");
    this._nextMonth.className = "nextButton";
    this._nextMonth.title = "下一月";
    this._nextMonth.value = "&gt;";
    td.appendChild(this._nextMonth);
    td.appendChild(this._nextYear);
    tr.appendChild(td);
    // grid
    div = doc.createElement("div");
    div.className = "grid";
    this._el.appendChild(div);
    this._table = div;

    // footer
    var footerTable = doc.createElement("table");
    footerTable.className = "footerTable";
    footerTable.cellSpacing = 0;
    this._el.appendChild(footerTable);

    tBody = doc.createElement("tbody");
    footerTable.appendChild(tBody);

    tr = doc.createElement("tr");
    tr.align = "center";
    tBody.appendChild(tr);

    td = doc.createElement("td");
    td.vAlign = "middle";
    td.className = "pickBar";
    this._todayButton = doc.createElement("button");
    this._todayButton.className = "todayButton";
    this._todayButton.appendChild(doc.createTextNode("今 天"));
    td.appendChild(this._todayButton);
    tr.appendChild(td);
    td.appendChild(doc.createTextNode(String.fromCharCode(160)));
    td.appendChild(doc.createTextNode(String.fromCharCode(160)));
    td.appendChild(doc.createTextNode(String.fromCharCode(160)));
    td.appendChild(doc.createTextNode(String.fromCharCode(160)));
    this._noneButton = doc.createElement("button");
    this._noneButton.className = "noneButton";
    this._noneButton.appendChild(doc.createTextNode("清 空"));
    td.appendChild(this._noneButton);
    tr.appendChild(td);


    this._createTable(doc);

    this._updateTable();
    this._setTopLabel();

//	if ( this._showNone )
//		this._noneButton.style.visibility = "hidden";
//	if ( this._showToday )
//		this._todayButton.style.visibility = "hidden";

    // IE55+ extension
    this._previousMonth.hideFocus = true;
    this._nextMonth.hideFocus = true;
    this._previousYear.hideFocus = true;
    this._nextYear.hideFocus = true;
    this._todayButton.hideFocus = true;
    this._noneButton.hideFocus = true;
    // end IE55+ extension

    // hook up events
    var dp = this;
    // buttons
    this._previousYear.onclick = function () {
        dp._dontChangeNone = true;
        dp.goToPreviousYear();
        dp._dontChangeNone = false;
    };
    this._nextYear.onclick = function () {
        dp._dontChangeNone = true;
        dp.goToNextYear();
        dp._dontChangeNone = false;
    };
    this._previousMonth.onclick = function () {
        dp._dontChangeNone = true;
        dp.goToPreviousMonth();
        dp._dontChangeNone = false;
    };
    this._nextMonth.onclick = function () {
        dp._dontChangeNone = true;
        dp.goToNextMonth();
        dp._dontChangeNone = false;
    };
    this._todayButton.onclick = function () {
        dp.goToToday();
        backValue();
    };
    this._noneButton.onclick = function () {
        dp.setDate(null);
        backValue();
    };
    this._el.onselectstart = function () {
        return false;
    };

    this._table.onclick = function (e) {
        try {
            // find event
            if (e == null) e = doc.parentWindow.event;

            // find td
            var el = e.target != null ? e.target : e.srcElement;
            while (el.nodeType != 1)
                el = el.parentNode;
            while (el != null && el.tagName && el.tagName.toLowerCase() != "td")
                el = el.parentNode;

            // if no td found, return
            if (el == null || el.tagName == null || el.tagName.toLowerCase() != "td")
                return;

            var d = new Date(dp._selectedDate);
            var n = Number(el.firstChild.data);
            if (isNaN(n) || n <= 0 || n == null)
                return;

            d.setDate(n);
            dp.setDate(d);
            backValue();
        }
        catch (e) {
        }
    };
    // show popup
    this._topLabel.onclick = function (e) {
        dp._showLabelPopup();
        return false;
    };

    this._el.onkeydown = function (e) {
        if (e == null) e = doc.parentWindow.event;
        var kc = e.keyCode != null ? e.keyCode : e.charCode;

        if (kc < 37 || kc > 40) return true;

        var d = new Date(dp._selectedDate).valueOf();
        if (kc == 37) // left
            d -= 24 * 60 * 60 * 1000;
        else if (kc == 39) // right
            d += 24 * 60 * 60 * 1000;
        else if (kc == 38) // up
            d -= 7 * 24 * 60 * 60 * 1000;
        else if (kc == 40) // down
            d += 7 * 24 * 60 * 60 * 1000;

        dp.setDate(new Date(d));
        return false;
    };
    // ie6 extension
    this._el.onmousewheel = function (e) {
        if (e == null) e = doc.parentWindow.event;
        var n = -e.wheelDelta / 120;
        var d = new Date(dp._selectedDate);
        var m = d.getMonth() + n;
        d.setMonth(m);


        dp._dontChangeNone = true;
        dp.setDate(d);
        dp._dontChangeNone = false;

        return false;
    }

    return this._el;
};

DatePicker.prototype.setDate = function (oDate) {

    this._hideLabelPopup();

    // if null then set None
    if (oDate == null) {
        if (!this._none) {
            this._none = true;
            this._setTopLabel();
            this._updateTable();

            if (typeof this.onchange == "function")
                this.onchange();
        }
        return;
    }

    // if string or number create a Date object
    if (typeof oDate == "string" || typeof oDate == "number") {
        oDate = new Date(oDate);
    }


    // do not update if not really changed
    if (this._selectedDate.getDate() != oDate.getDate() ||
        this._selectedDate.getMonth() != oDate.getMonth() ||
        this._selectedDate.getFullYear() != oDate.getFullYear() ||
        this._none) {

        if (!this._dontChangeNone)
            this._none = false;

        this._selectedDate = new Date(oDate);

        this._setTopLabel();
        this._updateTable();

        if (typeof this.onchange == "function")
            this.onchange();
    }

    if (!this._dontChangeNone)
        this._none = false;
}


DatePicker.prototype.getDate = function () {
    if (this._none) return null;
    return new Date(this._selectedDate);	// create a new instance
}

// creates the table elements and inserts them into the date picker
DatePicker.prototype._createTable = function (doc) {
    var str, i;
    var rows = 6;
    var cols = 7;
    var currentWeek = 0;

    var table = doc.createElement("table");
    table.className = "gridTable";
    table.cellSpacing = 0;

    var tBody = doc.createElement("tbody");
    table.appendChild(tBody);

    // days row
    var tr = doc.createElement("tr");
    tr.className = "daysRow";

    var td, tn;
    var nbsp = String.fromCharCode(160);
    for (i = 0; i < cols; i++) {
        td = doc.createElement("td");
        td.appendChild(doc.createTextNode(nbsp));
        tr.appendChild(td);
    }
    tBody.appendChild(tr);

    // upper line
    tr = doc.createElement("tr");
    td = doc.createElement("td");
    td.className = "upperLine";
    td.colSpan = 7;
    tr.appendChild(td);
    tBody.appendChild(tr);

    // rest
    for (i = 0; i < rows; i++) {
        tr = doc.createElement("tr");
        for (var j = 0; j < cols; j++) {
            td = doc.createElement("td");
            td.appendChild(doc.createTextNode(nbsp));
            td.onmouseover = function () {
                if (this.innerHTML != "&nbsp;") {
                    this.style.backgroundColor = "#CBE2FF";
                }
            };
            td.onmouseout = function () {
                if (this.innerHTML != "&nbsp;") {
                    this.style.backgroundColor = "";
                }
            };
            tr.appendChild(td);
        }
        tBody.appendChild(tr);
    }
    str += "</table>";

    if (this._table != null)
        this._table.appendChild(table)
};
// this method updates all the text nodes inside the table as well
// as all the classNames on the tds
DatePicker.prototype._updateTable = function () {
    // if no element no need to continue
    if (this._table == null) return;

    var i;
    var str = "";
    var rows = 6;
    var cols = 7;
    var currentWeek = 0;

    var cells = new Array(rows);
    this._matrix = new Array(rows)
    for (i = 0; i < rows; i++) {
        cells[i] = new Array(cols);
        this._matrix[i] = new Array(cols);
    }

    // Set the tmpDate to this month
    var tmpDate = new Date(this._selectedDate.getFullYear(),
        this._selectedDate.getMonth(), 1);
    var today = new Date();
    // go thorugh all days this month and store the text
    // and the class name in the cells matrix
    for (i = 1; i < 32; i++) {
        tmpDate.setDate(i);
        // convert to ISO, Monday is 0 and 6 is Sunday
        var weekDay = ( tmpDate.getDay() + 6 ) % 7;
        var colIndex = ( weekDay - this._firstWeekDay + 7 ) % 7;
        if (tmpDate.getMonth() == this._selectedDate.getMonth()) {

            var isToday = tmpDate.getDate() == today.getDate() &&
                tmpDate.getMonth() == today.getMonth() &&
                tmpDate.getFullYear() == today.getFullYear();

            cells[currentWeek][colIndex] = {text: "", className: ""};

            if (this._selectedDate.getDate() == tmpDate.getDate() && !this._none)
                cells[currentWeek][colIndex].className += "selected ";
            if (isToday)
                cells[currentWeek][colIndex].className += "today ";
            if (( tmpDate.getDay() + 6 ) % 7 == this._redWeekDay) // ISO
                cells[currentWeek][colIndex].className += "red";

            cells[currentWeek][colIndex].text =
                this._matrix[currentWeek][colIndex] = tmpDate.getDate();
            if (colIndex == 6)
                currentWeek++;
        }
    }

    // fix day letter order if not standard
    var weekDays = DatePicker.days;
    if (this._firstWeekDay != 0) {
        weekDays = new Array(7);
        for (i = 0; i < 7; i++)
            weekDays[i] = DatePicker.days[(i + this._firstWeekDay) % 7];
    }

    // update text in days row
    var tds = this._table.firstChild.tBodies[0].rows[0].cells;
    for (i = 0; i < cols; i++)
        tds[i].firstChild.data = weekDays[i];

    // update the text nodes and class names
    var trs = this._table.firstChild.tBodies[0].rows;
    var tmpCell;
    var nbsp = String.fromCharCode(160);
    for (var y = 0; y < rows; y++) {
        for (var x = 0; x < cols; x++) {
            tmpCell = trs[y + 2].cells[x];
            if (typeof cells[y][x] != "undefined") {
                tmpCell.className = cells[y][x].className;
                tmpCell.firstChild.data = cells[y][x].text;
            }
            else {
                tmpCell.className = "";
                tmpCell.firstChild.data = nbsp;
            }
        }
    }
}

// sets the label showing the year and selected month
DatePicker.prototype._setTopLabel = function () {
    var str = this._selectedDate.getFullYear() + "年" + DatePicker.months[this._selectedDate.getMonth()];
    if (this._topLabel != null)
        this._topLabel.lastChild.data = str;
}

DatePicker.prototype.goToNextMonth = function () {
    var d = new Date(this._selectedDate);
    d.setMonth(d.getMonth() + 1);
    this.setDate(d);
}

DatePicker.prototype.goToPreviousMonth = function () {
    var d = new Date(this._selectedDate);
    d.setMonth(d.getMonth() - 1);
    this.setDate(d);
}

DatePicker.prototype.goToNextYear = function () {
    var d = new Date(this._selectedDate);
    d.setYear(d.getFullYear() + 1);
    this.setDate(d);
}

DatePicker.prototype.goToPreviousYear = function () {
    var d = new Date(this._selectedDate);
    d.setYear(d.getFullYear() - 1);
    this.setDate(d);
}

DatePicker.prototype.goToToday = function () {
    if (this._none)
    // change the selectedDate to force update if none was true
        this._selectedDate = new Date(this._selectedDate + 10000000000);
    this._none = false;
    this.setDate(new Date());
}

DatePicker.prototype.setShowToday = function (bShowToday) {
    if (typeof bShowToday == "string")
        bShowToday = !/false|0|no/i.test(bShowToday);

    if (this._todayButton != null)
        this._todayButton.style.visibility = bShowToday ? "visible" : "hidden";
    this._showToday = bShowToday;
}

DatePicker.prototype.getShowToday = function () {
    return this._showToday;
}

DatePicker.prototype.setShowNone = function (bShowNone) {
    if (typeof bShowNone == "string")
        bShowNone = !/false|0|no/i.test(bShowNone);

    if (this._noneButton != null)
        this._noneButton.style.visibility = bShowNone ? "visible" : "hidden";
    this._showNone = bShowNone;
}

DatePicker.prototype.getShowNone = function () {
    return this._showNone;
}

// 0 is monday and 6 is sunday as in the ISO standard
DatePicker.prototype.setFirstWeekDay = function (nFirstWeekDay) {
    if (this._firstWeekDay != nFirstWeekDay) {
        this._firstWeekDay = nFirstWeekDay;
        this._updateTable();
    }
}

DatePicker.prototype.getFirstWeekDay = function () {
    return this._firstWeekDay;
}

// 0 is monday and 6 is sunday as in the ISO standard
DatePicker.prototype.setRedWeekDay = function (nRedWeekDay) {
    if (this._redWeekDay != nRedWeekDay) {
        this._redWeekDay = nRedWeekDay;
        this._updateTable();
    }
}

DatePicker.prototype.getRedWeekDay = function () {
    return this._redWeekDay;
}


DatePicker.prototype._showLabelPopup = function () {

    /*
     this._labelPopup new Element( "DIV" );
     div.className = "month-popup";
     div.noWrap = true;
     el.unselectable = div.unselectable = "on";
     el.onselectstart = div.onselectstart = function () { return false; };
     */

    var dateContext = function (dp, d) {
        return function (e) {
            dp._dontChangeNone = true;
            dp._hideLabelPopup();
            dp.setDate(d);
            dp._dontChangeNone = false;
            return false;
        };
    };

    var dp = this;

    // clear all old elements in the popup
    while (this._labelPopup.hasChildNodes())
        this._labelPopup.removeChild(this._labelPopup.firstChild);

    var a, tmp;
    for (var i = -6; i < 6; i++) {
        tmp = new Date(this._selectedDate);
        tmp.setDate(1);	// set day to 1 to prevent overflow with shorter months
        tmp.setMonth(tmp.getMonth() + i);

        a = this._document.createElement("a");
        a.href = "javascript:void 0;";
        a.onclick = dateContext(dp, tmp);
        a.appendChild(this._document.createTextNode(tmp.getFullYear() + "年" + DatePicker.months[tmp.getMonth()]));
        if (i == 0)
            a.className = "selected";
        this._labelPopup.appendChild(a);
    }

    this._topLabel.parentNode.insertBefore(this._labelPopup, this._topLabel.parentNode.firstChild);
};

DatePicker.prototype._hideLabelPopup = function () {
    if (this._labelPopup.parentNode)
        this._labelPopup.parentNode.removeChild(this._labelPopup);
};

/*日期控件结束*/