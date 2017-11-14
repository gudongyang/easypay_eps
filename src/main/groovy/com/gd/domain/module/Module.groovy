package com.gd.domain.module

/**
 * 模块entity类
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @author wangyuguo
 * @since 0.2
 */
class Module extends com.gd.magic.RootEntity {

    int layer
    String description                    //描述
    String iconUrl                        //小图标
    String logoUrl                        //大图标
    String name                            //模块名
    String acceptedIp
    String pageUrl
    Module parent                        //父模块
    String uniqueId                        //唯一编码
    int moduleIndex
    String orgLevels                    //模块机构等级
    String cond
    String actions

    public void preUpdate(boolean isNew) {
        if (isNew) {

            assert uniqueId: "模块标识不能为空"

            assert !Module.loadByUniqueId(uniqueId): "模块" + uniqueId + "已经存在"

            StringTokenizer st = new StringTokenizer(uniqueId, ".")
            layer = st.countTokens()
            if (st.countTokens() > 1) {

                String parentId = uniqueId.substring(0, uniqueId.lastIndexOf("."))

                parent = Module.loadByUniqueId(parentId)

                assert parent: "父模块" + parentId + "不存在"
            }

        }
        super.preUpdate(isNew)
    }

    public void postUpdate(boolean isNew) {
        moduleIndex = id
        super.postUpdate(isNew)
    }

    public void preRemove() {
        Module.removeByParent(this)
        super.preRemove()
    }

}
