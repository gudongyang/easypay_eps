function Crosstab() {

    this.data = null;
    this.rowTitles = null;
    this.rowLayouts = null;

    this.setData = function (data) {
        this.data = data;
    }


    this.show = function (divId) {
        if (this.data == null) return;

        var html = "<table  border='0' cellspacing='0' cellpadding='5' class='plist' style='width:720px'>"
        var data = this.data
        var dimensions = data.dimensions
        var rowTitles = data.rowTitles
        var columnTitles = data.columnTitles
        var dataMatrix = data.dataMatrix
        var rowSpans = data.rowLayouts
        var columnSpans = data.columnLayouts
        var measureInRow = data.measureInRow
        if (data.rowSize == 0) measureInRow = true
        else if (data.columnSize == 0) measureInRow = false

        var colHeadLength = data.columnSize
        var rowHeadLength = data.rowSize
        var measureSize = data.measureSize
        if (measureInRow) rowHeadLength++
        else
            colHeadLength++;

        //show table head
        var span
        var title
        var colHeadWidthUnit = measureInRow ? 1 : measureSize;
        var rowHeadHeightUnit = !measureInRow ? 1 : measureSize;

        var colStyles = new Array()				//记录column是total(2)还是subtotal(1)
        for (var i = 0; i < colHeadLength + 1; i++) {

            html += "<tr>"
            if (i == 0) {
                if (colHeadLength > 1 && rowHeadLength > 0)
                    html += "<th rowspan=" + colHeadLength + " colspan=" + rowHeadLength + " wrap>&nbsp;</th>"

                if (measureInRow || colHeadLength > 1) {

                    for (var j = 0; j < colHeadLength; j++) {

                        html += "<th >"
                        if (!measureInRow && j == colHeadLength - 1) {
                            html += "统计值"

                        } else
                            html += dimensions[data.rowSize + j].title
                        html += "</th>"
                    }
                }
            }
            if (i == colHeadLength) {
                for (var j = 0; j < rowHeadLength; j++) {

                    html += "<th wrap>"
                    if (measureInRow && j == rowHeadLength - 1)
                        html += "统计值"
                    else
                        html += dimensions[j].title
                    html += "</th>"
                }
            }
            if (i == 0) {
                if (measureInRow || colHeadLength > 1) {
                    var leftSpan = colHeadWidthUnit * columnTitles.length - colHeadLength
                    if (leftSpan > 0)
                        html += "<th colspan=" + leftSpan + " wrap>&nbsp;</th>"
                }
            }
            if (i > 0) {
                if (!measureInRow && i == colHeadLength) {
                    for (var j = 0; j < columnTitles.length; j++) {
                        for (var k = 0; k < measureSize; k++) {
                            html += "<th wrap "
                            if (colStyles[j] != null) {
                                html += "class=" + (colStyles[j] == 2 ? "colTotal" : "colSubTotal")
                            }
                            html += ">"
                            html += dimensions[data.rowSize + data.columnSize + k].title
                            html += "</th>"
                        }

                    }
                }
                else {
                    for (var j = 0; j < columnTitles.length; j++) {
                        span = columnSpans[j][i - 1];
                        title = columnTitles[j][i - 1];
                        if (span == 0) {
                            continue;
                        }


                        html += "<th "
                        if (title == null) {
                            colStyles[j] = i == 1 ? 2 : 1
                            html += "class=" + (i == 1 ? "colTotal" : "colSubTotal")
                        }
                        if (span >= 1)
                            html += " colSpan=" + colHeadWidthUnit * span		//正好相反
                        else if (span < 0)
                            html += " colSpan=" + colHeadWidthUnit		//正好相反

                        if (span < -1)
                            html += " rowSpan=" + (-1 * span)		//正好相反
                        html += " wrap>"
                        html += title != null ? title : (i == 1 ? '总计' : columnTitles[j][i - 2] + ' 汇总')
                        html += "</th>"
                    }
                }
            }
            html += "</tr>"
        }
        //show table content
        var measureLoop = measureInRow ? measureSize : 1
        var rowStyle
        var cellClass
        for (var i = 0; i < rowTitles.length; i++) {
            rowStyle = 0
            for (var k = 0; k < measureLoop; k++) {
                html += "<tr>"
                for (var j = 0; j < rowHeadLength; j++) {

                    if (measureInRow && j == rowHeadLength - 1) {
                        html += "<th wrap "
                        if (rowStyle > 0)
                            html += " class=" + (rowStyle == 2 ? "rowTotal" : "rowSubTotal")
                        html += ">"
                        html += dimensions[data.rowSize + data.columnSize + k].title
                        html += "</th>"
                    }
                    else if (k == 0) {

                        span = rowSpans[i][j];
                        title = rowTitles[i][j]
                        if (span == 0) {
                            continue;
                        }

                        html += "<th "
                        if (span >= 1)
                            html += " rowSpan=" + rowHeadHeightUnit * span
                        else if (span < 0)
                            html += " rowSpan=" + rowHeadHeightUnit
                        if (span < -1)
                            html += " colSpan=" + (-1 * span)
                        if (title == null) {
                            rowStyle = j == 0 ? 2 : 1
                            html += " class=" + (j == 0 ? "rowTotal" : "rowSubTotal")
                        }
                        html += " wrap>"
                        html += title == null ? (j == 0 ? '总计' : rowTitles[i][j - 1] + ' 汇总') : title
                        html += "</th>"
                    }

                }

                for (var j = 0; j < columnTitles.length; j++) {
                    cellClass = null
                    html += "<td nowrap align=right"
                    if (rowStyle > 0 || colStyles[j] != null) {
                        cellClass = this.getClassForCell(rowStyle, colStyles[j])
                        html += " class=" + cellClass
                    }
                    html += " wrap>"
                    html += dataMatrix[k][i][j]
                    html += "</td>"
                    if (!measureInRow && measureSize > 1) {
                        for (var l = 1; l < measureSize; l++) {
                            html += "<td nowrap align=right"
                            if (cellClass) {
                                html += " class=" + cellClass
                            }
                            html += " wrap>"
                            html += dataMatrix[l][i][j]
                            html += "</td>"
                        }
                    }
                }
                html += "</tr>"
            }

        }
        html += "</table>"
        $(divId).innerHTML = html;
    };

    this.getClassForCell = function (rowStyle, colStyle) {
        if (rowStyle == 2 && colStyle == 2)
            return "totalTotal"
        else if (rowStyle == 2 && colStyle == 1)
            return "totalSubTotal"
        else if (rowStyle == 2)
            return "rowTotal"
        else if (rowStyle == 1 && colStyle == 2)
            return "subTotalTotal"
        else if (rowStyle == 1 && colStyle == 1)
            return "subTotalSubTotal"
        else if (rowStyle == 1)
            return "rowSubTotal"
        else if (colStyle == 2)
            return "colTotal"
        else if (colStyle == 1)
            return "colSubTotal"
    }
}