package com.cun.util.es.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class SqlDateTypeHandler extends BaseTypeHandler<SqlDate> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SqlDate parameter, JdbcType jdbcType) throws SQLException {
        ps.setDate(i, parameter);
    }

    @Override
    public SqlDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Date date = rs.getDate(columnName);
        if (date == null) {
            return null;
        }
        return new SqlDate(date);
    }

    @Override
    public SqlDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Date date = rs.getDate(columnIndex);
        if (date == null) {
            return null;
        }
        return new SqlDate(date);
    }

    @Override
    public SqlDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Date date = cs.getDate(columnIndex);
        if (date == null) {
            return null;
        }
        return new SqlDate(date);
    }
}
