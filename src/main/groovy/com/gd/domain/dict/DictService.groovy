package com.gd.domain.dict

import com.gd.magic.ServiceLifecyle
import net.sf.ehcache.Cache
import net.sf.ehcache.CacheManager
import net.sf.ehcache.Element

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

/**
 * 字典service类
 *
 * @copyright ( c ) Copyright GD Corporation 2007.
 * @author gutianyang
 * @since 0.2
 */
class DictService implements ServiceLifecyle {

    static PRFIX_DICT = "DICT_"
    public static final String DICT_CACHE = "dictCache";

    DictConfig config = new DictConfig()
    CacheManager cacheManager = CacheManager.getInstance();
    Cache dictCache = null;

    public void onCreate() {
        dictCache = cacheManager.getCache(DICT_CACHE);
        if (dictCache == null) {
            cacheManager.addCache(DICT_CACHE);
            dictCache = cacheManager.getCache(DICT_CACHE);
        }

    }

    public void onShutdown() {

    }

    def getCommonDictTypes() {
        return config.getCommonDictTypes()
    }
    /**
     * 取得所有字典类型
     * @return 字典类型列表
     */
    def getDictTypes(Boolean editable, String text, String code) {
        def list = config.getCommonDictTypes()
        def result = []
        for (dict in list) {
            if ((editable == null || editable.booleanValue() == dict.editable)
                    && (text == null || dict.text.indexOf(text) != -1)
                    && (code == null || dict.code == code))
                result.add(dict)
        }
        return result
    }

    /**
     * 取得字典类型对象
     * @param category 字典类型
     * @return 字典类型对象
     */
    def getDictType(def category) {
        return config.getDictType(category)
    }

    private String trimValue(String v) {
        if (!v) return null
        String v1 = v.trim()
        return v1.equals("") ? null : v1
    }

    /**
     * 取得字典项对象
     * @param category 字典类型
     * @param code 字典代码
     * @return 字典项对象
     */
    def getItemByText(def category, String text) {
        def list = getItems(category)
        if (list) {
            for (item in list) {
                if (item.text == text)
                    return item
            }
        }
    }
    /**
     * 取得字典项对象
     * @param category 字典类型
     * @param code 字典代码
     * @return 字典项对象
     */
    @com.gd.magic.anno.Service(dwr = true)

    def getItem(def category, int code) {
        if (code == 0) return

        def itemMap = config.getItemMap(category)

        if (itemMap)
            return itemMap[code]

        def dt = getDictType(category)
        assert dt: X("GETITEM_DICT_TYPE", category)

        String key = category + "_map"
        Element ele = dictCache.get(key)
        if (ele == null) {
            loadFromDb(category)
            ele = dictCache.get(key)
        }
        if (ele == null) return

        return ele.getObjectValue()[code]

    }

    private void loadFromDb(String category) {
        logger.debug("loading dictionary from db :" + category)
        Connection conn = ejbService.currentConnection()
        PreparedStatement pst = conn.prepareStatement("select id,text,english,iconUrl from " + PRFIX_DICT + category + " order by id")
        ResultSet rs = null
        try {
            rs = pst.executeQuery()
            def list = []
            def map = [:]
            def dict
            while (rs.next()) {
                dict = [code: rs.getInt(1), text: trimValue(rs.getString(2)), english: trimValue(rs.getString(3)), iconUrl: trimValue(rs.getString(4))]
                list.add(dict)
                map[dict.code] = dict
            }

            dictCache.put(new Element(category + "_list", list))
            dictCache.put(new Element(category + "_map", map))

        } catch (Exception e) {
            logger.error("error loading dictionary from db :" + category)
        } finally {
            if (rs)
                try {
                    rs.close()
                } catch (Exception e) {
                }
            try {
                pst.close()
            } catch (Exception e) {
            }
        }
    }
    /**
     * 取得字典项列表
     * @param category 字典类型
     * @return 字典项列表
     */
    def getItems(def category) {
        def itemList = config.getItemList(category)

        if (itemList)
            return itemList

        def dt = getDictType(category)
        assert dt: X("GETITEM_DICT_TYPE", category)

        String key = category + "_list"
        Element ele = dictCache.get(key)
        if (ele == null) {
            loadFromDb(category)
            ele = dictCache.get(key)
        }
        if (ele == null) return

        return ele.getObjectValue()
    }

    /**
     * 取得字典项文本
     * @param category 字典类型
     * @param code 字典代码
     * @return 字典项文本
     */
    @com.gd.magic.anno.Service(dwr = true)

    def getText(def category, int code) {
        if (code == 0) return
        def di = getItem(category, code)
        return !di ? code : di.text
    }


    @com.gd.magic.anno.Service(dwr = true)

    void delCommonDict(def category, int id) {
        Connection conn = ejbService.currentConnection()
        String sql = "delete from " + PRFIX_DICT + category + " where id=?"
        PreparedStatement pst = conn.prepareStatement(sql)
        try {
            pst.setInt(1, id)
            ejbService.executeSQLDelete(pst)
        } finally {
            try {
                pst.close()
            } catch (Exception e) {
            }
        }

        invalidateCache(category)

    }

    private void invalidateCache(def category) {

        def afterCommit = new ClearDictCache(dictCache, category)
        afterCommit.execute(false)
        //for security, clear after commit
        ejbService.registerAfterCommit(afterCommit)
    }
    /**
     * 保存字典项
     * @param category 字典类型
     * @param dict 字典项
     * @return 是否新建字典
     */
    @com.gd.magic.anno.Service(dwr = true)

    boolean saveCommonDict(def category, def dict) {
        assert dict.id: X("SAVECOMMONDICT_ID")
        assert dict.text: X("SAVECOMMONDICT_TEXT")
        Connection conn = ejbService.currentConnection()

        PreparedStatement pst = conn.prepareStatement("select id,text from " + PRFIX_DICT + category + " where id=? or text=?")
        ResultSet rs = null
        PreparedStatement pst2
        boolean isNew = true
        try {
            pst.setLong(1, dict.id)
            jdbcService.setCharValue(pst, 2, dict.text)

            rs = pst.executeQuery()

            if (rs.next()) {
                def id = rs.getInt(1)
                if (id == dict.id) {
                    isNew = false
                    assert !rs.next(): X("ADDCOMMONDICT_DICT_TEXT", dict.text)
                } else {
                    assert false: X("ADDCOMMONDICT_DICT_TEXT", dict.text)
                }
            }

            if (!isNew) {
                //update
                pst2 = conn.prepareStatement("update " + PRFIX_DICT + category + " set text=?,english=?,iconUrl=? where id=?")

                jdbcService.setCharValue(pst2, 1, dict.text)
                jdbcService.setCharValue(pst2, 2, dict.english)
                jdbcService.setCharValue(pst2, 3, dict.iconUrl)
                jdbcService.setCharValue(pst2, 4, dict.id + "")
                ejbService.executeStatement(pst2)

            } else {
                //insert
                pst2 = conn.prepareStatement("insert into " + PRFIX_DICT + category + "(id,text,english ,iconUrl) values(?,?,?,?)")

                pst2.setInt(1, dict.id)

                jdbcService.setCharValue(pst2, 2, dict.text)
                jdbcService.setCharValue(pst2, 3, dict.english)
                jdbcService.setCharValue(pst2, 4, dict.iconUrl)


                ejbService.executeStatement(pst2)
            }

        } finally {
            if (pst2)
                try {
                    pst2.close()
                } catch (Exception e) {
                }
            try {
                pst.close()
            } catch (Exception e) {
            }
        }
        invalidateCache(category)
        return isNew

    }

    /**
     * 增加字典项
     * @param category 字典类型
     * @param dict 字典项
     */
    void addCommonDict(def category, def dict) {
        assert dict.id: X("SAVECOMMONDICT_ID")
        assert dict.text: X("SAVECOMMONDICT_TEXT")
        Connection conn = ejbService.currentConnection()

        PreparedStatement pst = conn.prepareStatement("select id,text from " + PRFIX_DICT + category + " where id=? or text=?")
        ResultSet rs = null
        try {
            pst.setLong(1, dict.id)

            jdbcService.setCharValue(pst, 2, dict.text)
            rs = pst.executeQuery()
            if (rs.next()) {
                def id = rs.getString(1)
                assert id != dict.id: X("ADDCOMMONDICT_DICT_ID", id)
                def text = rs.getString(2)
                assert text != dict.text: X("ADDCOMMONDICT_DICT_TEXT", text)
            }
        } finally {
            try {
                pst.close()
            } catch (Exception e) {
            }
        }

        pst = conn.prepareStatement("insert into " + PRFIX_DICT + category + "(id,text,english ,iconUrl) values(?,?,?,?)")
        try {
            pst.setLong(1, dict.id)

            jdbcService.setCharValue(pst, 2, dict.text)
            jdbcService.setCharValue(pst, 3, dict.english)
            jdbcService.setCharValue(pst, 4, dict.iconUrl)

            ejbService.executeStatement(pst)
        } finally {
            try {
                pst.close()
            } catch (Exception e) {
            }
        }
        invalidateCache(category)
    }

    /**
     * 得到字典表的schema, [creates:[],drops:[]]
     */
    def getSchema() {
        def schema = [:]
        def creates = []
        schema.creates = creates
        def drops = []
        schema.drops = drops
        getCommonDictTypes().each {
            drops.add("drop table " + PRFIX_DICT + it.id)
            creates.add(getCreateSQL(PRFIX_DICT + it.id))
        }
        return schema
    }

    /**
     * 创建字典表
     * @param tableName 字典表名
     * @return 创建字典表sql语句
     */
    String getCreateSQL(def tableName) {
        StringBuffer sb = new StringBuffer("create table ")
        switch (jdbcService.currentDb.dialect) {
            case "org.hibernate.dialect.HSQLDialect":
                sb.append("$tableName(id int,text char(80),english char(30),iconUrl char(50), primary key (id))")
                break;
            case "org.hibernate.dialect.MySQLDialect":
                sb.append("$tableName(id int(10),text char(80),english char(30),iconUrl char(50), primary key (id))")
                break;
            default:
                sb.append("$tableName(id number(10,0),text char(80),english char(30),iconUrl char(50), primary key (id))")
                break;
        }
        return sb.toString()
    }

    /**
     * 保存字典项（页面调用方法）
     * @param category 字典类别
     * @param code 字典代码
     * @param text 字典文本
     * @param english 字典english
     * @param iconUrl 字典图标
     */
    @com.gd.magic.anno.Service(dwr = true)

    void saveDict(String category, int code, String text, String english, String iconUrl) {
        Dict dict = new CommonDict(id: code, text: text, english: english, iconUrl: iconUrl);
        boolean isNew = saveCommonDict(category, dict)

    }

    /**  以下为自动更新字典表 */

    /**
     * 查找magicDict.xml，确定所有的字典表是否存在，不存在的表进行建表
     */
    def createNotExistDictTable() {
        getCommonDictTypes().each {
            createDictTalbe(PRFIX_DICT + it.id)
        }
    }

    /**
     * 建立某个字典表
     */
    def createDictTalbe(tableName) {
        String sql = getCreateSQL(tableName)
        def conn = ejbService.currentConnection();
        def statement
        try {
            statement = conn.createStatement();
            try {
                statement.execute("select * from " + tableName + " where 1=2");
            } catch (Exception e) {
                statement.execute(sql);
                logger.debug("建立字典表成功:" + tableName)
            }
        } finally {
            if (statement)
                try {
                    statement.close()
                } catch (Exception e) {
                }
        }
    }

    def getItemsSmall(def category) {
        def itemList = config.getItemList(category)

        if (itemList)
            return itemList

        def dt = getDictType(category)
        assert dt: X("GETITEM_DICT_TYPE", category)

        String key = category + "_list"
        Element ele = dictCache.get(key)
        if (ele == null) {
            loadFromDbSmall(category)
            ele = dictCache.get(key)
        }
        if (ele == null) return

        return ele.getObjectValue()
    }

    private void loadFromDbSmall(String category) {
        logger.debug("loading dictionary from db :" + category)
        Connection conn = ejbService.currentConnection()
        PreparedStatement pst = conn.prepareStatement("select id,text from " + PRFIX_DICT + category + " order by id")
        ResultSet rs = null
        try {
            rs = pst.executeQuery()
            def list = []
            def map = [:]
            def dict
            while (rs.next()) {
                dict = [code: rs.getInt(1), text: trimValue(rs.getString(2))]
                list.add(dict)
                map[dict.code] = dict
            }

            dictCache.put(new Element(category + "_list", list))
            dictCache.put(new Element(category + "_map", map))

        } catch (Exception e) {
            logger.error("error loading dictionary from db :" + category)
        } finally {
            if (rs)
                try {
                    rs.close()
                } catch (Exception e) {
                }
            try {
                pst.close()
            } catch (Exception e) {
            }
        }
    }

}
