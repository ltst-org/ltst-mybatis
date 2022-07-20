package com.ltst.mybatis.session;

import com.ltst.mybatis.binging.MapperRegistry;
import com.ltst.mybatis.execute.SqlExecute;

public class DefaultSqlSession implements SqlSession{

    private MapperRegistry mapperRegistry;
    private SqlExecute sqlExecute;

    public DefaultSqlSession(MapperRegistry mapperRegistry,SqlExecute sqlExecute){
        this.mapperRegistry = mapperRegistry;
        this.sqlExecute = sqlExecute;
    }
    @Override
    public <T> T selectOne(String statementId) {
        return sqlExecute.execute(statementId);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,sqlExecute);
    }
}
