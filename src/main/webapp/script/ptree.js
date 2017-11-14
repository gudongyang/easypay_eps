var treeIconPath = appRoot + "images/tree/";
var webTreeConfig = {
    rootIcon: treeIconPath + "folder.png",
    openRootIcon: treeIconPath + "openfolder.png",
    folderIcon: treeIconPath + "folder.png",
    openFolderIcon: treeIconPath + "openfolder.png",
    fileIcon: treeIconPath + "file.png",
    iIcon: treeIconPath + "t_i.png",
    lIcon: treeIconPath + "t_l.png",
    lMinusIcon: treeIconPath + "l_minus.png",
    lPlusIcon: treeIconPath + "l_plus.png",
    tIcon: treeIconPath + "t_t.png",
    tMinusIcon: treeIconPath + "t_minus.png",
    tPlusIcon: treeIconPath + "t_plus.png",
    blankIcon: treeIconPath + "blank.png",
    defaultText: "[新节点]",
    defaultAction: "javascript:void(0);",
    defaultBehavior: "classic",
    usePersistence: true
};

var webTreeHandler = {
    idCounter: 0,
    idPrefix: "t-",
    all: {},
    behavior: null,
    selected: null,
    onSelect: null, /* should be part of tree, not handler */
    getId: function () {
        return this.idPrefix + this.idCounter++;
    },
    toggle: function (oItem) {
        this.all[oItem.id.replace('-plus', '')].toggle();
    },
    select: function (oItem) {
        this.all[oItem.id.replace('-icon', '')].select();
    },
    focus: function (oItem) {
        this.all[oItem.id.replace('-anchor', '')].focus();
    },
    blur: function (oItem) {
        this.all[oItem.id.replace('-anchor', '')].blur();
    },
    keydown: function (oItem, e) {
        return this.all[oItem.id].keydown(e.keyCode);
    },
    insertHTMLBeforeEnd: function (oElement, node) {
        var sHTML = node.toString();
        if (oElement.insertAdjacentHTML != null) {
            oElement.insertAdjacentHTML("BeforeEnd", sHTML)
            return;
        }
        var df;	// DocumentFragment
        var r = oElement.ownerDocument.createRange();
        r.selectNodeContents(oElement);
        r.collapse(false);
        df = r.createContextualFragment(sHTML);
        oElement.appendChild(df);
    },
    init: function () {
        this.idCounter = 0;
        this.idPrefix = "t-";
        this.all = {};
        this.behavior = null;
        this.selected = null;
        this.onSelect = null;
        /* should be part of tree, not handler */
    }
};


/*
 * TreeAbstractNode class
 */

function TreeAbstractNode(sText, sAction, sValue, options) {
    this.childNodes = [];
    this.id = webTreeHandler.getId();
    this.text = sText || webTreeConfig.defaultText;
    this.action = sAction || webTreeConfig.defaultAction;
    this.isLeaf = sValue;
    this.options = options;
    this._last = false;
    webTreeHandler.all[this.id] = this;
}

/*
 * To speed thing up if you're adding multiple nodes at once (after load)
 * use the bNoIdent parameter to prevent automatic re-indentation and call
 * the obj.ident() method manually once all nodes has been added.
 */
TreeAbstractNode.prototype.setText = function (sText) {
    document.getElementById(this.id + "-anchor").innerHTML = sText;
    this.text = sText;
}
TreeAbstractNode.prototype.add = function (node, bNoIdent) {
    node.parentNode = this;
    this.childNodes[this.childNodes.length] = node;
    var root = this;
    if (this.childNodes.length >= 2) {
        this.childNodes[this.childNodes.length - 2]._last = false;
    }
    while (root.parentNode) {
        root = root.parentNode;
    }
    if (root.rendered) {
        if (this.childNodes.length >= 2) {
            document.getElementById(this.childNodes[this.childNodes.length - 2].id + '-plus').src = ((this.childNodes[this.childNodes.length - 2].folder) ? ((this.childNodes[this.childNodes.length - 2].open) ? webTreeConfig.tMinusIcon : webTreeConfig.tPlusIcon) : webTreeConfig.tIcon);
            this.childNodes[this.childNodes.length - 2].plusIcon = webTreeConfig.tPlusIcon;
            this.childNodes[this.childNodes.length - 2].minusIcon = webTreeConfig.tMinusIcon;
            this.childNodes[this.childNodes.length - 2]._last = false;
        }
        this._last = true;
        var foo = this;
        while (foo.parentNode) {
            for (var i = 0; i < foo.parentNode.childNodes.length; i++) {
                if (foo.id == foo.parentNode.childNodes[i].id) {
                    break;
                }
            }
            if (i == foo.parentNode.childNodes.length - 1) {
                foo.parentNode._last = true;
            }
            else {
                foo.parentNode._last = false;
            }
            foo = foo.parentNode;
        }
        webTreeHandler.insertHTMLBeforeEnd(document.getElementById(this.id + '-cont'), node);
        if ((!this.folder) && (!this.openIcon)) {
            this.icon = webTreeConfig.folderIcon;
            this.openIcon = webTreeConfig.openFolderIcon;
        }
        if (!this.folder) {
            this.folder = true;
            this.collapse(true);
        }
        if (!bNoIdent) {
            this.indent();
        }
    }
    return node;
}

TreeAbstractNode.prototype.toggle = function () {
    if (this.folder) {
        if (this.open) {
            this.collapse();
        }
        else {
            this.expand();
        }
    }
}

TreeAbstractNode.prototype.select = function () {
    document.getElementById(this.id + '-anchor').focus();
}

TreeAbstractNode.prototype.deSelect = function () {
    document.getElementById(this.id + '-anchor').className = '';
    document.getElementById(this.id + '-anchor').style.backgroundColor = '#FFFFFF';
    document.getElementById(this.id + '-anchor').style.color = '#000000';
    webTreeHandler.selected = null;
}

TreeAbstractNode.prototype.focus = function () {
    if ((webTreeHandler.selected) && (webTreeHandler.selected != this)) {
        webTreeHandler.selected.deSelect();
    }
    webTreeHandler.selected = this;
    if ((this.openIcon) && (webTreeHandler.behavior != 'classic')) {
        document.getElementById(this.id + '-icon').src = this.openIcon;
    }
    document.getElementById(this.id + '-anchor').className = 'selected';
    document.getElementById(this.id + '-anchor').style.backgroundColor = '';
    document.getElementById(this.id + '-anchor').style.color = '';
    document.getElementById(this.id + '-anchor').focus();
    if (webTreeHandler.onSelect) {
        webTreeHandler.onSelect(this);
    }
}

TreeAbstractNode.prototype.blur = function () {
    if ((this.openIcon) && (webTreeHandler.behavior != 'classic')) {
        document.getElementById(this.id + '-icon').src = this.icon;
    }
    document.getElementById(this.id + '-anchor').className = 'selected-inactive';
}

TreeAbstractNode.prototype.doExpand = function () {
    if (webTreeHandler.behavior == 'classic') {
        document.getElementById(this.id + '-icon').src = this.openIcon;
    }
    if (this.childNodes.length) {
        document.getElementById(this.id + '-cont').style.display = 'block';
    }
    this.open = true;
    if (webTreeConfig.usePersistence) {
        Cookie.write(this.id.substr(18, this.id.length - 18), '1');
    }
}

TreeAbstractNode.prototype.doCollapse = function () {
    if (webTreeHandler.behavior == 'classic') {
        document.getElementById(this.id + '-icon').src = this.icon;
    }
    if (this.childNodes.length) {
        document.getElementById(this.id + '-cont').style.display = 'none';
    }
    this.open = false;
    if (webTreeConfig.usePersistence) {
        Cookie.write(this.id.substr(18, this.id.length - 18), '0');
    }
}

TreeAbstractNode.prototype.expandAll = function () {
    this.expandChildren();
    if ((this.folder) && (!this.open)) {
        this.expand();
    }
}

TreeAbstractNode.prototype.expandChildren = function () {
    for (var i = 0; i < this.childNodes.length; i++) {
        this.childNodes[i].expandAll();
    }
}

TreeAbstractNode.prototype.collapseAll = function () {
    this.collapseChildren();
    if ((this.folder) && (this.open)) {
        this.collapse(true);
    }
}

TreeAbstractNode.prototype.collapseChildren = function () {
    for (var i = 0; i < this.childNodes.length; i++) {
        this.childNodes[i].collapseAll();
    }
}

TreeAbstractNode.prototype.indent = function (lvl, del, last, level, nodesLeft) {
    /*
     * Since we only want to modify items one level below ourself,
     * and since the rightmost indentation position is occupied by
     * the plus icon we set this to -2
     */
    if (lvl == null) {
        lvl = -2;
    }
    var state = 0;
    for (var i = this.childNodes.length - 1; i >= 0; i--) {
        state = this.childNodes[i].indent(lvl + 1, del, last, level);
        if (state) {
            return;
        }
    }
    if (del) {
        if ((level >= this._level) && (document.getElementById(this.id + '-plus'))) {
            if (this.folder) {
                document.getElementById(this.id + '-plus').src = (this.open) ? webTreeConfig.lMinusIcon : webTreeConfig.lPlusIcon;
                this.plusIcon = webTreeConfig.lPlusIcon;
                this.minusIcon = webTreeConfig.lMinusIcon;
            }
            else if (nodesLeft) {
                document.getElementById(this.id + '-plus').src = webTreeConfig.lIcon;
            }
            return 1;
        }
    }
    var foo = document.getElementById(this.id + '-indent-' + lvl);
    if (foo) {
        if ((foo._last) || ((del) && (last))) {
            foo.src = webTreeConfig.blankIcon;
        }
        else {
            foo.src = webTreeConfig.iIcon;
        }
    }
    return 0;
}

/*
 * Tree class
 */

function Tree(sText, sAction, sBehavior, sIcon, sOpenIcon, sValue, options) {
    this.base = TreeAbstractNode;
    this.base(sText, sAction, sValue, options);
    this.icon = sIcon || webTreeConfig.rootIcon;
    this.openIcon = sOpenIcon || webTreeConfig.openRootIcon;
    /* Defaults to open */
    if (webTreeConfig.usePersistence) {
        this.open = (Cookie.read(this.id.substr(18, this.id.length - 18)) == '0') ? false : true;
    } else {
        this.open = true;
    }
    this.folder = true;
    this.rendered = false;
    this.onSelect = null;
    if (!webTreeHandler.behavior) {
        webTreeHandler.behavior = sBehavior || webTreeConfig.defaultBehavior;
    }
}

Tree.prototype = new TreeAbstractNode;

Tree.prototype.setBehavior = function (sBehavior) {
    webTreeHandler.behavior = sBehavior;
};

Tree.prototype.getBehavior = function (sBehavior) {
    return webTreeHandler.behavior;
};

Tree.prototype.getSelected = function () {
    if (webTreeHandler.selected) {
        return webTreeHandler.selected;
    }
    else {
        return null;
    }
}

Tree.prototype.remove = function () {
}

Tree.prototype.expand = function () {
    this.doExpand();
}

Tree.prototype.collapse = function (b) {
    if (!b) {
        this.focus();
    }
    this.doCollapse();
}

Tree.prototype.getFirst = function () {
    return null;
}

Tree.prototype.getLast = function () {
    return null;
}

Tree.prototype.getNextSibling = function () {
    return null;
}

Tree.prototype.getPreviousSibling = function () {
    return null;
}

Tree.prototype.keydown = function (key) {
    if (key == 39) {
        if (!this.open) {
            this.expand();
        }
        else if (this.childNodes.length) {
            this.childNodes[0].select();
        }
        return false;
    }
    if (key == 37) {
        this.collapse();
        return false;
    }
    if ((key == 40) && (this.open) && (this.childNodes.length)) {
        this.childNodes[0].select();
        return false;
    }
    return true;
}

Tree.prototype.toString = function () {
    var str = "<div id=\"" + this.id + "\" ondblclick=\"webTreeHandler.toggle(this);\" class=\"treeitem\" onkeydown=\"return webTreeHandler.keydown(this, event)\">" +
        "<img id=\"" + this.id + "-icon\" class=\"treeicon\" src=\"" + ((webTreeHandler.behavior == 'classic' && this.open) ? this.openIcon : this.icon) + "\" onclick=\"webTreeHandler.select(this);\">" +
        "<a href=\"" + this.action + "\" id=\"" + this.id + "-anchor\" onfocus=\"webTreeHandler.focus(this);\" onblur=\"webTreeHandler.blur(this);\"" +
        (this.target ? " target=\"" + this.target + "\"" : "") +
        ">" + this.text + "</a></div>" +
        "<div id=\"" + this.id + "-cont\" class=\"treecontainer\" style=\"display: " + ((this.open) ? 'block' : 'none') + ";\">";
    var sb = [];
    for (var i = 0; i < this.childNodes.length; i++) {
        sb[i] = this.childNodes[i].toString(i, this.childNodes.length);
    }
    this.rendered = true;
    return str + sb.join("") + "</div>";
};

/*
 * TreeItem class
 */

function TreeItem(sText, sAction, eParent, sIcon, sOpenIcon, sValue, options) {
    this.base = TreeAbstractNode;

    this.base(sText, sAction, sValue, options);
    /* Defaults to close */
    if (webTreeConfig.usePersistence) {
        this.open = (Cookie.read(this.id.substr(18, this.id.length - 18)) == '1') ? true : false;
    } else {
        this.open = false;
    }
    if (sIcon) {
        this.icon = sIcon;
    }
    if (sOpenIcon) {
        this.openIcon = sOpenIcon;
    }
    if (eParent) {
        eParent.add(this);
    }
}

TreeItem.prototype = new TreeAbstractNode;

TreeItem.prototype.remove = function () {
    var iconSrc = document.getElementById(this.id + '-plus').src;
    var parentNode = this.parentNode;
    var prevSibling = this.getPreviousSibling(true);
    var nextSibling = this.getNextSibling(true);
    var folder = this.parentNode.folder;
    var last = ((nextSibling) && (nextSibling.parentNode) && (nextSibling.parentNode.id == parentNode.id)) ? false : true;
    this.getPreviousSibling().focus();
    this._remove();
    if (parentNode.childNodes.length == 0) {
        document.getElementById(parentNode.id + '-cont').style.display = 'none';
        parentNode.doCollapse();
        parentNode.folder = false;
        parentNode.open = false;
    }
    if (!nextSibling || last) {
        parentNode.indent(null, true, last, this._level, parentNode.childNodes.length);
    }
    if ((prevSibling == parentNode) && !(parentNode.childNodes.length)) {
        prevSibling.folder = false;
        prevSibling.open = false;
        if (document.getElementById(prevSibling.id + '-plus')) {
            iconSrc = document.getElementById(prevSibling.id + '-plus').src;
            iconSrc = iconSrc.replace('minus', '').replace('plus', '');
            document.getElementById(prevSibling.id + '-plus').src = iconSrc;
            //document.getElementById(prevSibling.id + '-icon').src = webTreeConfig.fileIcon;
        }
    }
    if (document.getElementById(prevSibling.id + '-plus')) {
        if (parentNode == prevSibling.parentNode) {
            iconSrc = iconSrc.replace('minus', '').replace('plus', '');
            document.getElementById(prevSibling.id + '-plus').src = iconSrc;
        }
    }
}

TreeItem.prototype._remove = function () {
    for (var i = this.childNodes.length - 1; i >= 0; i--) {
        this.childNodes[i]._remove();
    }
    for (var i = 0; i < this.parentNode.childNodes.length; i++) {
        if (this == this.parentNode.childNodes[i]) {
            for (var j = i; j < this.parentNode.childNodes.length; j++) {
                this.parentNode.childNodes[j] = this.parentNode.childNodes[j + 1];
            }
            this.parentNode.childNodes.length -= 1;
            if (i + 1 == this.parentNode.childNodes.length) {
                this.parentNode._last = true;
            }
            break;
        }
    }
    webTreeHandler.all[this.id] = null;
    var tmp = document.getElementById(this.id);
    if (tmp) {
        tmp.parentNode.removeChild(tmp);
    }
    tmp = document.getElementById(this.id + '-cont');
    if (tmp) {
        tmp.parentNode.removeChild(tmp);
    }
}

TreeItem.prototype.expand = function () {
    this.doExpand();
    document.getElementById(this.id + '-plus').src = this.minusIcon;
}

TreeItem.prototype.collapse = function (b) {
    if (!b) {
        this.focus();
    }
    this.doCollapse();
    document.getElementById(this.id + '-plus').src = this.plusIcon;
}

TreeItem.prototype.getFirst = function () {
    return this.childNodes[0];
}

TreeItem.prototype.getLast = function () {
    if (this.childNodes[this.childNodes.length - 1].open) {
        return this.childNodes[this.childNodes.length - 1].getLast();
    }
    else {
        return this.childNodes[this.childNodes.length - 1];
    }
}

TreeItem.prototype.getNextSibling = function () {
    for (var i = 0; i < this.parentNode.childNodes.length; i++) {
        if (this == this.parentNode.childNodes[i]) {
            break;
        }
    }
    if (++i == this.parentNode.childNodes.length) {
        return this.parentNode.getNextSibling();
    }
    else {
        return this.parentNode.childNodes[i];
    }
}

TreeItem.prototype.getPreviousSibling = function (b) {
    for (var i = 0; i < this.parentNode.childNodes.length; i++) {
        if (this == this.parentNode.childNodes[i]) {
            break;
        }
    }
    if (i == 0) {
        return this.parentNode;
    }
    else {
        if ((this.parentNode.childNodes[--i].open) || (b && this.parentNode.childNodes[i].folder)) {
            return this.parentNode.childNodes[i].getLast();
        }
        else {
            return this.parentNode.childNodes[i];
        }
    }
}
TreeItem.prototype.keydown = function (key) {
    if ((key == 39) && (this.folder)) {
        if (!this.open) {
            this.expand();
        }
        else {
            this.getFirst().select();
        }
        return false;
    }
    else if (key == 37) {
        if (this.open) {
            this.collapse();
        }
        else {
            this.parentNode.select();
        }
        return false;
    }
    else if (key == 40) {
        if (this.open) {
            this.getFirst().select();
        }
        else {
            var sib = this.getNextSibling();
            if (sib) {
                sib.select();
            }
        }
        return false;
    }
    else if (key == 38) {
        this.getPreviousSibling().select();
        return false;
    }
    return true;
}

TreeItem.prototype.toString = function (nItem, nItemCount) {
    var foo = this.parentNode;
    var indent = '';
    if (nItem + 1 == nItemCount) {
        this.parentNode._last = true;
    }
    var i = 0;
    while (foo.parentNode) {
        foo = foo.parentNode;
        indent = "<img id=\"" + this.id + "-indent-" + i + "\" src=\"" + ((foo._last) ? webTreeConfig.blankIcon : webTreeConfig.iIcon) + "\">" + indent;
        i++;
    }
    this._level = i;

    if (this.childNodes.length && !this.isLeaf) {
        this.folder = 1;
    }
    else {
        this.open = false;
    }
    if ((this.folder) || (webTreeHandler.behavior != 'classic')) {
        if (!this.icon) {
            this.icon = webTreeConfig.folderIcon;
        }
        if (!this.openIcon) {
            this.openIcon = webTreeConfig.openFolderIcon;
        }
    }
    else if (!this.icon) {
        this.icon = webTreeConfig.fileIcon;
    }
    var label = this.text.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    var str = "<div id=\"" + this.id + "\" value=\"" + this.value + "\" ondblclick=\"webTreeHandler.toggle(this);\" class=\"treeitem\" onkeydown=\"return webTreeHandler.keydown(this, event)\">" +
        indent +
        "<img id=\"" + this.id + "-plus\" src=\"" + ((this.folder) ? ((this.open) ? ((this.parentNode._last) ? webTreeConfig.lMinusIcon : webTreeConfig.tMinusIcon) : ((this.parentNode._last) ? webTreeConfig.lPlusIcon : webTreeConfig.tPlusIcon)) : ((this.parentNode._last) ? webTreeConfig.lIcon : webTreeConfig.tIcon)) + "\" onclick=\"webTreeHandler.toggle(this);\">" +
        "<img id=\"" + this.id + "-icon\" class=\"treeicon\" src=\"" + ((webTreeHandler.behavior == 'classic' && this.open) ? this.openIcon : this.icon) + "\" onclick=\"webTreeHandler.select(this);\">" +
        (this.options ? "<input" + (this.options.checked ? " checked" : "") + " type=checkbox style='height:13px;' ondblclick='' id='checkbox_" + this.src + "' value='" + this.id + "' onclick='" + this.options.click + "'>" : "") +
        "<a href=\"" + this.action + "\" id=\"" + this.id + "-anchor\" onfocus=\"webTreeHandler.focus(this);\" onblur=\"webTreeHandler.blur(this);\"" +
        (this.target ? " target=\"" + this.target + "\"" : "") +
        ">" + label + "</a></div>" +
        "<div id=\"" + this.id + "-cont\" class=\"treecontainer\" style=\"display: " + ((this.open) ? 'block' : 'none') + ";\">";
    var sb = [];
    for (var i = 0; i < this.childNodes.length; i++) {
        sb[i] = this.childNodes[i].toString(i, this.childNodes.length);
    }
    this.plusIcon = ((this.parentNode._last) ? webTreeConfig.lPlusIcon : webTreeConfig.tPlusIcon);
    this.minusIcon = ((this.parentNode._last) ? webTreeConfig.lMinusIcon : webTreeConfig.tMinusIcon);
    return str + sb.join("") + "</div>";
}

TreeItem.prototype.folderToFile = function () {
    var plus = document.getElementById(this.id + "-plus");
    var icon = document.getElementById(this.id + "-icon");
    plus.src = this.plusIcon == webTreeConfig.lPlusIcon ? webTreeConfig.lIcon : webTreeConfig.tIcon;
    icon.src = webTreeConfig.fileIcon;
    this.folder = false;
}
TreeItem.prototype.fileToFolder = function () {
    var plus = document.getElementById(this.id + "-plus");
    var icon = document.getElementById(this.id + "-icon");
    plus.src = plus.src == webTreeConfig.lIcon ? webTreeConfig.lPlusIcon : webTreeConfig.tPlusIcon;
    icon.src = webTreeConfig.folderIcon;
    this.folder = true;
    this.icon = webTreeConfig.folderIcon;
    this.openIcon = webTreeConfig.openFolderIcon;
}