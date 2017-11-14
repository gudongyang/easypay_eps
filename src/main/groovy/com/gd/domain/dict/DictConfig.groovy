package com.gd.domain.dict

import com.gd.magic.kernel.ReloadableConfig

/**
 * 字典config类
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @since 0.2
 */
class DictConfig extends ReloadableConfig {

    public static final String CONF_FILE = "/conf/magicDict.xml"

    public static final String DICT_LOCALE = "locale"
    public static final String DICT_TIMEZONE = "timeZone"

    public static final String DICT_TYPE = "dict_type"

    def dictMap = [:]
    def dictList = [:]

    /**
     * 读取配置文件
     * @return 配置信息
     */
    public File getConfigFile() {
        return magicHelper.getDeployFile(CONF_FILE)
    }

    /**
     * 获取字典项
     * @param code 字典代码
     * @return 字典项 ( map )
     */
    public def getItemMap(String code) {
        loadIfNeeded()
        return dictMap.get(code)
    }

    /**
     * 获取字典项
     * @param code 字典代码
     * @return 字典项 ( list )
     */
    public def getItemList(String code) {

        loadIfNeeded()
        return dictList.get(code)
    }

    /**
     * 初始化字典配置文件方法
     */
    public void loadConf() {
        try {

            def listMap = [:]
            def file = getConfigFile()
            if (file == null || !file.exists())
                return

            logger.debug(CONF_FILE + " is loaded")

            def root = new XmlSlurper().parse(file)

            // properties
            root.item.each {
                def dict = null
                def type = it.@type.text()
                def code = it.@code.text()
                if (DICT_TYPE.equals(type)) {
                    dict = new DictType()
                    dict.editable = it.@editable.text()
                    dict.id = code
                } else {
                    dict = new CommonDict()
                    dict.id = Integer.parseInt(code)
                }
                dict.text = it.@text.text()
                assert type && dict.text && code: X("LOADCONF_TYPE", [type, dict.text, code])

                def list = listMap[type]
                if (!list) {
                    list = []
                    listMap[type] = list

                }
                list.add(dict)
            }

            if (listMap[DICT_TYPE] == null)
                listMap[DICT_TYPE] = []

            dictList = listMap
            dictMap = toMapMap(listMap)
        } catch (Exception e) {
            logger.error("fail to to load " + CONF_FILE, e)
        }

    }

    /**
     * list转换map
     * @param listMap 字典list
     * @return 字典map
     */
    private def toMapMap(def listMap) {
        def map = [:]
        listMap.each
                {
                    def map2 = [:]
                    it.value.each { map2[it.code] = it }
                    map[it.key] = map2
                }
        return map
    }

    /**
     * 获取字典类别
     * @return 字典类别列表
     */
    def getCommonDictTypes() {
        return getItemList(DICT_TYPE)
    }

    /**
     * 获取字典
     * @param category 字典类别
     * @return 字典项
     */
    def getDictType(def category) {
        return getItemMap(DICT_TYPE)[category]
    }
}
