package com.cws.alarm.util;

import com.easyj.core.dao.DAO;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.TableMapping;

/**
 * DAO工具类
 * Created by Can on 2015/8/11.
 */
public class DAOUtils {

    /**
     * 获取层级路径
     *
     * @param parentId 父ID
     * @param id       当前ID
     * @return
     */
    public final static String getLevelPath(Class<? extends Model> model, Object parentId, Object id, String pathFieldName) {
        if (parentId == null) {
            return String.valueOf(id);
        } else {
            Model dao = DAO.get(model);
            Model modelObj = dao.findById(parentId);
            if (modelObj == null) return String.valueOf(id);
            String parentPath = modelObj.getStr(pathFieldName);
            return parentPath == null ? String.valueOf(id) : parentPath + "," + id;
        }
    }

    /**
     * 替换子级层级路径
     *
     * @param oldPath 旧的层级路径
     * @param newPath 新的层级路径
     */
    public final static void updateChildLevelPath(Class<? extends Model> model, String oldPath, String newPath, String pathFieldName) {
        //替换子级
        String oldStr = "," + oldPath + ",";
        String newStr = "," + newPath + ",";
        String likeStr = oldPath + ",%";
        Db.update(String.format("update %s set %s = REPLACE(TRIM(REPLACE(REPLACE(CONCAT(',',%s,','),?,?),',',' ')),' ',',') where path like ?",
                TableMapping.me().getTable(model).getName(), pathFieldName, pathFieldName), oldStr, newStr, likeStr);
    }

    /**
     * 更新冗余的层级路径
     *
     * @param oldPath          旧的层级路径
     * @param levelIdFieldName 层级ID字段名称
     */
    public final static void updateRedundancyLevelPath(Class<? extends Model> model, String oldPath, String levelIdFieldName, String levelPathFieldName, String primaryTableLevelPathFieldName, Class<? extends Model> primaryTableModel) {
        String topLevel = oldPath.split(",")[0];
        String topLevelStr = topLevel + ",%";
        String sql = String.format("update %s a,%s b set a.%s = b.%s where a.%s = b.id and (a.%s like ? or a.%s = ?)",
                TableMapping.me().getTable(model).getName(),
                TableMapping.me().getTable(primaryTableModel).getName(),
                levelPathFieldName, primaryTableLevelPathFieldName, levelIdFieldName, levelPathFieldName, levelIdFieldName);
        Db.update(sql, topLevelStr, topLevel);
    }
}
