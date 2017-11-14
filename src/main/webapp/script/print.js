function WebPrint() {
}
WebPrint.getPrintFrame = function () {
    var p = parent;
    while (true) {
        if (p.printFrame) return p.printFrame;
        if (p == p.parent) return;
        if (p == null) return;
        p = p.parent;
    }
}
WebPrint.print = function (div) {
    var p = WebPrint.getPrintFrame();
    if (p) {
        p.document.body.innerHTML = $(div).innerHTML;
        p.print();
    }
}

WebPrint.preview = function (div) {
    var p = WebPrint.getPrintFrame();

    if (p) {
        p.document.body.innerHTML = $(div).innerHTML;
        p.preview();
    }
}

WebPrint.pageSetup = function () {
    var p = WebPrint.getPrintFrame();
    if (p) {
        p.pageSetup();
    }
}

