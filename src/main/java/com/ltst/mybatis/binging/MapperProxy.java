package com.ltst.mybatis.binging;

import com.ltst.mybatis.execute.SqlExecute;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Mapper Proxy
 * use to invocation interface
 * @param <T>
 */
public class MapperProxy<T> implements InvocationHandler {

    /**
     * sql executor
     */
    private SqlExecute sqlExecute;
    /**
     * being proxied interface
     */
    private Class<T> mapperInterface;

    public MapperProxy(SqlExecute sqlExecute,Class<T> mapperInterface){
        this.sqlExecute = sqlExecute;
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else{
            return sqlExecute.execute(mapperInterface,method);
        }
    }
}
