/*************焦点图切换js开始***************/
var Tabs = new Class({
    Implements: [Options,Events],

    options:{
        selectedTabCss:'on',
        selectedSectionCss:'on',
        mvSH:1,
        firstShow:0,
        autoInterval:4,
        mouseEvent:'mouseover'
    },
    
    initialize:function(tabs, sections, options){
        this.setOptions(options);
        this.current = this.options.firstShow;
        this.tabs = $$(tabs);
        this.sections = $$(sections);
        this.sectionsLength = $$(sections).length;
        this.attach();
        this.render();
    },

    render:function(){
        this.sections.each(function(section, index){
            if( index !== this.current ) {
                section.style.display="none"
            }else{
                this.showSection(index);
            };
        }, this);
    },

    attach:function(){
        this.tabs.each(function(tab, index){
            tab.addEvent(this.options.mouseEvent,this.tabEvent.bindWithEvent(this,tab));
        }, this);
    },

    tabEvent:function(e,tab){
        e.preventDefault();
        var index = this.tabs.indexOf(tab);
        this.toggleSection(index);
    },

    toggleSection:function(index){
        if(this.current === index) return;
        this.hideSection(this.current);
        this.current = index;
        this.showSection(this.current);
    },

    showSection:function(index){
        var tab = this.tabs[index];
        var section = this.sections[index];
        tab.addClass(this.options.selectedTabCss);
        section.addClass(this.options.selectedSectionCss).show();
        this.fireEvent('onShow',[index,tab,section]);
    },

    hideSection:function(index){
        if (index===false) return;
        var tab = this.tabs[index];
        var section = this.sections[index];
        tab.removeClass(this.options.selectedTabCss);
        section.removeClass(this.options.selectedSectionCss).hide();
        this.fireEvent('onHide',[index,tab,section]);
    }
});
/**
 * implement effects
 */
Tabs.implement({
    showSection:function(index){
        var tab = this.tabs[index];
        var section = this.sections[index];
        switch (this.options.mvSH) {
        case 1: 
            section.setStyles({display:'block',opacity:0}).fade(1);
			tab.addClass(this.options.selectedTabCss);
            break;
        default:
            tab.addClass(this.options.selectedTabCss);
            section.addClass(this.options.selectedSectionCss).show();
        }
        this.fireEvent('onShow',[index,tab,section]);
    },

    hideSection:function(index){
        if (index===false) return;
        var tab = this.tabs[index];
        var section = this.sections[index];
        switch (this.options.mvSH) {
        case 1: 
            section.style.display="none"
            tab.removeClass(this.options.selectedTabCss);
            break;
        default:
            tab.removeClass(this.options.selectedTabCss);
            section.removeClass(this.options.selectedSectionCss).hide();
        }
        this.fireEvent('onHide',[index,tab,section]);
    }
});
/**
 * implement auto change Tab method to Tabs class
 */
Tabs.implement({
    startAuto:function(){
        this.attachAuto();
        this.start();
    },
    
    attachAuto:function(){
        this.bindOver = this.stop.bind(this);
        this.bindOut = this.start.bind(this);
        this.tabs.getParent().addEvents({
            'mouseenter':this.bindOver,
            'mouseleave':this.bindOut
        });
        this.sections.getParent().addEvents({
            'mouseenter':this.bindOver,
            'mouseleave':this.bindOut
        });
    },
    
    start:function(){
        this.autoId = this.autoToggle.periodical(this.options.autoInterval*1000,this);
    },

    stop:function(){
        $clear(this.autoId);
    },

    autoToggle:function(){
        this.numNext = this.current + 1;
        this.numNext = this.numNext >= this.sectionsLength ? 0 : this.numNext;
        this.toggleSection(this.numNext);
    }
});
/**焦点图切换js结束***************************/