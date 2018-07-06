package com.zjn.base;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理器接口
 */
public interface HandlerResultSet {
    public Object doHandler(ResultSet rs) throws SQLException;
}
