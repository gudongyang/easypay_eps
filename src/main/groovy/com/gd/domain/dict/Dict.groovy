package com.gd.domain.dict

import com.gd.magic.anno.Column
import com.gd.magic.anno.Entity

/**
 * 字典类
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @since v0.1
 */
@Entity(cacheUsage = "nonstrict-read-write")
abstract class Dict extends com.gd.magic.AssignedIdEntity {

    @Column(isTransient = true)
    int code

    String text                        //字典文本
    String english                    //engelish
    String iconUrl                    //字典图标

    public void preUpdate(boolean isNew) {
        assert id: X("PRE_UPDATE_ID")
        assert text: X("PRE_UPDATE_TEXT")
        super.preUpdate(isNew)
    }

    /**
     * 获取字典项代码
     * @return 字典项代码
     */
    public int getCode() {
        return (int) id
    }

    /**
     * 设置字典项代码
     * @param code 字典代码
     */
    public void setCode(int code) {
        id = code
    }
}
