package com.cun.util.es.db.mapper;

import com.cun.util.es.db.pojo.MetaDatasource;
import com.cun.util.es.db.pojo.MetaDatasourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MetaDatasourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @SelectProvider(type=MetaDatasourceSqlProvider.class, method="countByExample")
    long countByExample(MetaDatasourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @DeleteProvider(type=MetaDatasourceSqlProvider.class, method="deleteByExample")
    int deleteByExample(MetaDatasourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @Delete({
        "delete from meta_datasource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @Insert({
        "insert into meta_datasource (table_id, file_path, ",
        "database_id, source_table_name, ",
        "query_sql, http_call_url, ",
        "request_method, http_call_params, ",
        "init_params_provider, update_params_provider, ",
        "replace_params, params_provider, ",
        "result_position, del_flag, ",
        "create_time, update_time, ",
        "param_from_table, from_table_name, ",
        "param_condition, param_type, ",
        "request_result_type, source_type)",
        "values (#{tableId,jdbcType=BIGINT}, #{filePath,jdbcType=VARCHAR}, ",
        "#{databaseId,jdbcType=BIGINT}, #{sourceTableName,jdbcType=VARCHAR}, ",
        "#{querySql,jdbcType=VARCHAR}, #{httpCallUrl,jdbcType=VARCHAR}, ",
        "#{requestMethod,jdbcType=VARCHAR}, #{httpCallParams,jdbcType=VARCHAR}, ",
        "#{initParamsProvider,jdbcType=VARCHAR}, #{updateParamsProvider,jdbcType=VARCHAR}, ",
        "#{replaceParams,jdbcType=BIT}, #{paramsProvider,jdbcType=VARCHAR}, ",
        "#{resultPosition,jdbcType=VARCHAR}, #{delFlag,jdbcType=BIT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{paramFromTable,jdbcType=BIT}, #{fromTableName,jdbcType=VARCHAR}, ",
        "#{paramCondition,jdbcType=VARCHAR}, #{paramType,jdbcType=VARCHAR}, ",
        "#{requestResultType,jdbcType=VARCHAR}, #{sourceType,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MetaDatasource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @InsertProvider(type=MetaDatasourceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MetaDatasource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @SelectProvider(type=MetaDatasourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="table_id", property="tableId", jdbcType=JdbcType.BIGINT),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="database_id", property="databaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_table_name", property="sourceTableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_sql", property="querySql", jdbcType=JdbcType.VARCHAR),
        @Result(column="http_call_url", property="httpCallUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_method", property="requestMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="http_call_params", property="httpCallParams", jdbcType=JdbcType.VARCHAR),
        @Result(column="init_params_provider", property="initParamsProvider", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_params_provider", property="updateParamsProvider", jdbcType=JdbcType.VARCHAR),
        @Result(column="replace_params", property="replaceParams", jdbcType=JdbcType.BIT),
        @Result(column="params_provider", property="paramsProvider", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_position", property="resultPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="param_from_table", property="paramFromTable", jdbcType=JdbcType.BIT),
        @Result(column="from_table_name", property="fromTableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_condition", property="paramCondition", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_type", property="paramType", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_result_type", property="requestResultType", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER)
    })
    List<MetaDatasource> selectByExample(MetaDatasourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, table_id, file_path, database_id, source_table_name, query_sql, http_call_url, ",
        "request_method, http_call_params, init_params_provider, update_params_provider, ",
        "replace_params, params_provider, result_position, del_flag, create_time, update_time, ",
        "param_from_table, from_table_name, param_condition, param_type, request_result_type, ",
        "source_type",
        "from meta_datasource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="table_id", property="tableId", jdbcType=JdbcType.BIGINT),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="database_id", property="databaseId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_table_name", property="sourceTableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_sql", property="querySql", jdbcType=JdbcType.VARCHAR),
        @Result(column="http_call_url", property="httpCallUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_method", property="requestMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="http_call_params", property="httpCallParams", jdbcType=JdbcType.VARCHAR),
        @Result(column="init_params_provider", property="initParamsProvider", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_params_provider", property="updateParamsProvider", jdbcType=JdbcType.VARCHAR),
        @Result(column="replace_params", property="replaceParams", jdbcType=JdbcType.BIT),
        @Result(column="params_provider", property="paramsProvider", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_position", property="resultPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="param_from_table", property="paramFromTable", jdbcType=JdbcType.BIT),
        @Result(column="from_table_name", property="fromTableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_condition", property="paramCondition", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_type", property="paramType", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_result_type", property="requestResultType", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_type", property="sourceType", jdbcType=JdbcType.INTEGER)
    })
    MetaDatasource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @UpdateProvider(type=MetaDatasourceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MetaDatasource record, @Param("example") MetaDatasourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @UpdateProvider(type=MetaDatasourceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MetaDatasource record, @Param("example") MetaDatasourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @UpdateProvider(type=MetaDatasourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MetaDatasource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meta_datasource
     *
     * @mbg.generated
     */
    @Update({
        "update meta_datasource",
        "set table_id = #{tableId,jdbcType=BIGINT},",
          "file_path = #{filePath,jdbcType=VARCHAR},",
          "database_id = #{databaseId,jdbcType=BIGINT},",
          "source_table_name = #{sourceTableName,jdbcType=VARCHAR},",
          "query_sql = #{querySql,jdbcType=VARCHAR},",
          "http_call_url = #{httpCallUrl,jdbcType=VARCHAR},",
          "request_method = #{requestMethod,jdbcType=VARCHAR},",
          "http_call_params = #{httpCallParams,jdbcType=VARCHAR},",
          "init_params_provider = #{initParamsProvider,jdbcType=VARCHAR},",
          "update_params_provider = #{updateParamsProvider,jdbcType=VARCHAR},",
          "replace_params = #{replaceParams,jdbcType=BIT},",
          "params_provider = #{paramsProvider,jdbcType=VARCHAR},",
          "result_position = #{resultPosition,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=BIT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "param_from_table = #{paramFromTable,jdbcType=BIT},",
          "from_table_name = #{fromTableName,jdbcType=VARCHAR},",
          "param_condition = #{paramCondition,jdbcType=VARCHAR},",
          "param_type = #{paramType,jdbcType=VARCHAR},",
          "request_result_type = #{requestResultType,jdbcType=VARCHAR},",
          "source_type = #{sourceType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MetaDatasource record);
}