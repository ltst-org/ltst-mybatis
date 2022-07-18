package com.ltst.mybatis.binging;

import com.ltst.mybatis.execute.SqlExecute;

import java.lang.reflect.Proxy;

/**
 * Mapper Proxy Factory
 * use to create mapper Proxy by sqlExecute
 * @param <T>
 */
public class MapperProxyFactory<T> {
    private Class mapperInterface;
    public MapperProxyFactory(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }

    /**
     * create new Instance
     * @param sqlExecute
     * @return
     */
    public T newInstance(SqlExecute sqlExecute){
        MapperProxy mapperProxy = new MapperProxy(sqlExecute,mapperInterface);
        Object proxyInstance = Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
        return (T)proxyInstance;
    }
}
