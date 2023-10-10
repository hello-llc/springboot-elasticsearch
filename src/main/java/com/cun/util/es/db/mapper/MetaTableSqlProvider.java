package com.cun.util.es.db.mapper;

import com.cun.util.es.db.pojo.MetaTable;
import com.cun.util.es.db.pojo.MetaTableExample.Criteria;
import com.cun.util.es.db.pojo.MetaTableExample.Criterion;
import com.cun.util.es.db.pojo.MetaTableExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MetaTableSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String countByExample(MetaTableExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("meta_table");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String deleteByExample(MetaTableExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("meta_table");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String insertSelective(MetaTable record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("meta_table");
        
        if (record.getCatalogId() != null) {
            sql.VALUES("catalog_id", "#{catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getThemeId() != null) {
            sql.VALUES("theme_id", "#{themeId,jdbcType=BIGINT}");
        }
        
        if (record.getTableZhName() != null) {
            sql.VALUES("table_zh_name", "#{tableZhName,jdbcType=VARCHAR}");
        }
        
        if (record.getTableName() != null) {
            sql.VALUES("table_name", "#{tableName,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetDbId() != null) {
            sql.VALUES("target_db_id", "#{targetDbId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceDepartId() != null) {
            sql.VALUES("source_depart_id", "#{sourceDepartId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getIsPublic() != null) {
            sql.VALUES("is_public", "#{isPublic,jdbcType=INTEGER}");
        }
        
        if (record.getGiveUrl() != null) {
            sql.VALUES("give_url", "#{giveUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGiveType() != null) {
            sql.VALUES("give_type", "#{giveType,jdbcType=INTEGER}");
        }
        
        if (record.getDataLevel() != null) {
            sql.VALUES("data_level", "#{dataLevel,jdbcType=INTEGER}");
        }
        
        if (record.getDataDescribe() != null) {
            sql.VALUES("data_describe", "#{dataDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getAttention() != null) {
            sql.VALUES("attention", "#{attention,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=DATE}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.VALUES("update_by", "#{updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getNetId() != null) {
            sql.VALUES("net_id", "#{netId,jdbcType=INTEGER}");
        }
        
        if (record.getDelFlag() != null) {
            sql.VALUES("del_flag", "#{delFlag,jdbcType=BIT}");
        }
        
        if (record.getCreateFlag() != null) {
            sql.VALUES("create_flag", "#{createFlag,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String selectByExample(MetaTableExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("catalog_id");
        sql.SELECT("theme_id");
        sql.SELECT("table_zh_name");
        sql.SELECT("table_name");
        sql.SELECT("target_db_id");
        sql.SELECT("source_depart_id");
        sql.SELECT("status");
        sql.SELECT("is_public");
        sql.SELECT("give_url");
        sql.SELECT("give_type");
        sql.SELECT("data_level");
        sql.SELECT("data_describe");
        sql.SELECT("attention");
        sql.SELECT("create_time");
        sql.SELECT("create_by");
        sql.SELECT("update_time");
        sql.SELECT("update_by");
        sql.SELECT("net_id");
        sql.SELECT("del_flag");
        sql.SELECT("create_flag");
        sql.FROM("meta_table");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MetaTable record = (MetaTable) parameter.get("record");
        MetaTableExample example = (MetaTableExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("meta_table");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCatalogId() != null) {
            sql.SET("catalog_id = #{record.catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getThemeId() != null) {
            sql.SET("theme_id = #{record.themeId,jdbcType=BIGINT}");
        }
        
        if (record.getTableZhName() != null) {
            sql.SET("table_zh_name = #{record.tableZhName,jdbcType=VARCHAR}");
        }
        
        if (record.getTableName() != null) {
            sql.SET("table_name = #{record.tableName,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetDbId() != null) {
            sql.SET("target_db_id = #{record.targetDbId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceDepartId() != null) {
            sql.SET("source_depart_id = #{record.sourceDepartId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getIsPublic() != null) {
            sql.SET("is_public = #{record.isPublic,jdbcType=INTEGER}");
        }
        
        if (record.getGiveUrl() != null) {
            sql.SET("give_url = #{record.giveUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGiveType() != null) {
            sql.SET("give_type = #{record.giveType,jdbcType=INTEGER}");
        }
        
        if (record.getDataLevel() != null) {
            sql.SET("data_level = #{record.dataLevel,jdbcType=INTEGER}");
        }
        
        if (record.getDataDescribe() != null) {
            sql.SET("data_describe = #{record.dataDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getAttention() != null) {
            sql.SET("attention = #{record.attention,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{record.updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getNetId() != null) {
            sql.SET("net_id = #{record.netId,jdbcType=INTEGER}");
        }
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{record.delFlag,jdbcType=BIT}");
        }
        
        if (record.getCreateFlag() != null) {
            sql.SET("create_flag = #{record.createFlag,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("meta_table");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("catalog_id = #{record.catalogId,jdbcType=BIGINT}");
        sql.SET("theme_id = #{record.themeId,jdbcType=BIGINT}");
        sql.SET("table_zh_name = #{record.tableZhName,jdbcType=VARCHAR}");
        sql.SET("table_name = #{record.tableName,jdbcType=VARCHAR}");
        sql.SET("target_db_id = #{record.targetDbId,jdbcType=BIGINT}");
        sql.SET("source_depart_id = #{record.sourceDepartId,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("is_public = #{record.isPublic,jdbcType=INTEGER}");
        sql.SET("give_url = #{record.giveUrl,jdbcType=VARCHAR}");
        sql.SET("give_type = #{record.giveType,jdbcType=INTEGER}");
        sql.SET("data_level = #{record.dataLevel,jdbcType=INTEGER}");
        sql.SET("data_describe = #{record.dataDescribe,jdbcType=VARCHAR}");
        sql.SET("attention = #{record.attention,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        sql.SET("create_by = #{record.createBy,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=DATE}");
        sql.SET("update_by = #{record.updateBy,jdbcType=INTEGER}");
        sql.SET("net_id = #{record.netId,jdbcType=INTEGER}");
        sql.SET("del_flag = #{record.delFlag,jdbcType=BIT}");
        sql.SET("create_flag = #{record.createFlag,jdbcType=BIT}");
        
        MetaTableExample example = (MetaTableExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(MetaTable record) {
        SQL sql = new SQL();
        sql.UPDATE("meta_table");
        
        if (record.getCatalogId() != null) {
            sql.SET("catalog_id = #{catalogId,jdbcType=BIGINT}");
        }
        
        if (record.getThemeId() != null) {
            sql.SET("theme_id = #{themeId,jdbcType=BIGINT}");
        }
        
        if (record.getTableZhName() != null) {
            sql.SET("table_zh_name = #{tableZhName,jdbcType=VARCHAR}");
        }
        
        if (record.getTableName() != null) {
            sql.SET("table_name = #{tableName,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetDbId() != null) {
            sql.SET("target_db_id = #{targetDbId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceDepartId() != null) {
            sql.SET("source_depart_id = #{sourceDepartId,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getIsPublic() != null) {
            sql.SET("is_public = #{isPublic,jdbcType=INTEGER}");
        }
        
        if (record.getGiveUrl() != null) {
            sql.SET("give_url = #{giveUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGiveType() != null) {
            sql.SET("give_type = #{giveType,jdbcType=INTEGER}");
        }
        
        if (record.getDataLevel() != null) {
            sql.SET("data_level = #{dataLevel,jdbcType=INTEGER}");
        }
        
        if (record.getDataDescribe() != null) {
            sql.SET("data_describe = #{dataDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getAttention() != null) {
            sql.SET("attention = #{attention,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=DATE}");
        }
        
        if (record.getUpdateBy() != null) {
            sql.SET("update_by = #{updateBy,jdbcType=INTEGER}");
        }
        
        if (record.getNetId() != null) {
            sql.SET("net_id = #{netId,jdbcType=INTEGER}");
        }
        
        if (record.getDelFlag() != null) {
            sql.SET("del_flag = #{delFlag,jdbcType=BIT}");
        }
        
        if (record.getCreateFlag() != null) {
            sql.SET("create_flag = #{createFlag,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_table
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, MetaTableExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}