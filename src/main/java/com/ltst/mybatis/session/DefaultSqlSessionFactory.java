package com.ltst.mybatis.session;

import com.ltst.mybatis.binging.MapperRegistry;
import com.ltst.mybatis.execute.SqlExecute;

public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry){
        this.mapperRegistry = mapperRegistry;
    }
    @Override
    public SqlSession openSqlSession() {
        return new DefaultSqlSession(this.mapperRegistry,new SqlExecute());
    }
}
