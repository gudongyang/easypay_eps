webTreeConfig.loadingText = "正在载入...";
webTreeConfig.loadErrorTextTemplate = "载入错误 \"%1%\"";
webTreeConfig.emptyErrorTextTemplate = "错误 \"%1%\" 无法载入...";

/*
 * LoadTree class
 */

function LoadTree(sText, sXmlSrc, sAction, sBehavior, sIcon, sOpenIcon, sValue, options) {
    // call super
    this.Tree = Tree;
    this.Tree(sText, sAction, sBehavior, sIcon, sOpenIcon, sValue, options);

    // setup default property values
    this.src = sXmlSrc;
    this.loading = false;
    this.loaded = false;
    this.errorText = "";
    this.srcNodeMap = {};
    this.srcNodeMap[sXmlSrc] = this.id;
    // check start state and load if open
    if (this.open)
        _startLoadXmlTree(this.src, this);
    else {
        // and create loading item if not
        this._loadingItem = new TreeItem(webTreeConfig.loadingText);
        this.add(this._loadingItem);
    }
}

LoadTree.prototype = new Tree;

// override the expand method to load the xml file
LoadTree.prototype._webfxtree_expand = Tree.prototype.expand;
LoadTree.prototype.expand = function () {
    if (!this.loaded && !this.loading) {
        // load
        _startLoadXmlTree(this.src, this);
    }
    this._webfxtree_expand();
};
LoadTree.prototype.getNode = function (id) {
    return webTreeHandler.all[id];
}
/*
 * LoadTreeItem class
 */

function LoadTreeItem(sText, sXmlSrc, sAction, eParent, sIcon, sOpenIcon, isLeaf, options) {
    // call super
    this.TreeItem = TreeItem;
    this.TreeItem(sText, sAction, eParent, sIcon, sOpenIcon, isLeaf, options);
    // setup default property values
    this.src = sXmlSrc;
    this.loading = false;
    this.loaded = false;
    this.errorText = "";

    // check start state and load if open
    if (this.open)
        _startLoadXmlTree(this.src, this);
    else {
        // and create loading item if not
        this._loadingItem = new TreeItem(webTreeConfig.loadingText);
        this.add(this._loadingItem);
    }
}

LoadTreeItem.prototype = new TreeItem;

// override the expand method to load the xml file
LoadTreeItem.prototype._webfxtreeitem_expand = TreeItem.prototype.expand;
LoadTreeItem.prototype.expand = function () {
    if (!this.loaded && !this.loading) {
        // load
        _startLoadXmlTree(this.src, this);
    }
    this._webfxtreeitem_expand();
};
// reloads the src file if already loaded
LoadTree.prototype.reload =
    LoadTreeItem.prototype.reload = function () {
        // if loading do nothing
        if (this.loaded) {
            var open = this.open;
            // remove
            while (this.childNodes.length > 0)
                this.childNodes[this.childNodes.length - 1].remove();
            this.loaded = false;

            this._loadingItem = new TreeItem(webTreeConfig.loadingText);
            this.add(this._loadingItem);
            if (open)
                this.expand();
        }
        else if (this.open && !this.loading)
            _startLoadXmlTree(this.src, this);
    };

/*
 * Helper functions
 */

//利用xmlhttp载入xml文件

//处理从后台获取的子节点对象
function createTreeNode(isLeaf, text, id, action, icon, openIcon, options) {
    var node = new LoadTreeItem(text, id, action, null, icon, openIcon, isLeaf, options);
    if (tree)
        tree.srcNodeMap[id] = node.id;
    return node;
}
var newTreeNodeObj;

function newNodeToTree(parentNode, options) {

    if (parentNode.isLeaf) {
        showError(options.childAddText ? options.childAddText : "不能为叶子节点增加对象");
        return;
    }
    if (!parentNode.loaded && !parentNode.loading) {
        newTreeNodeObj = {};
        parentNode.expand();
    }
    else {
        var moduleNode = _createNode({});
        parentNode.add(moduleNode);
        parentNode.expand();
        tree.getSelected().deSelect();
        webTreeHandler.select(moduleNode);
        moduleNode.focus();
        showProperty();
    }
}

function _xmlFileLoaded(jsChildNodes, jsParentNode) {
    if (jsParentNode.loaded)
        return;

    var bIndent = false;
    var bAnyChildren = false;
    jsParentNode.loaded = true;
    jsParentNode.loading = false;
    for (var i = 0; i < jsChildNodes.length; i++) {
        jsParentNode.add(_createNode(jsChildNodes[i]));
    }
    var newNode;
    if (newTreeNodeObj) {
        newNode = _createNode(newTreeNodeObj);
        jsParentNode.add(newNode);
        newTreeNodeObj = null;
    }
    // remove dummy
    if (jsParentNode._loadingItem != null) {
        jsParentNode._loadingItem.remove();
        bIndent = true;
    }

    if (bIndent) {
        // indent now that all items are added
        jsParentNode.indent();
    }

    // show error in status bar
    if (jsParentNode.errorText != "")
        window.status = jsParentNode.errorText;
    if (newNode) {
        tree.getSelected().deSelect();
        webTreeHandler.select(newNode);
        newNode.focus();
        showProperty();
    }

}
