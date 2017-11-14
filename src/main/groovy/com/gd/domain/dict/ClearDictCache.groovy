package com.gd.domain.dict

import com.gd.magic.ejb3.AfterCommit

/**
 * 清除字典任务
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @since v0.1
 */
class ClearDictCache implements AfterCommit {
    def dictCache
    String category

    ClearDictCache(def dictCache, String category) {
        this.dictCache = dictCache
        this.category = category
    }

    public void execute(boolean success) {
        dictCache.remove(category + "_list")
        dictCache.remove(category + "_map")
    }
}

