package com.gd.domain.dict
/**
 * 字典类型类
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @since 0.2
 */
class DictType implements com.gd.magic.ViewObject {

    String id                            //类型代码
    String text                            //类型文本
    boolean editable = false            //是否可增加字典
    /**
     * 获取字典项的代码
     * @return 字典项代码
     */
    public String getCode() {
        return id
    }
}
