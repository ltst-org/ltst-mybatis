package com.ltst.mybatis.binging;

import cn.hutool.core.lang.ClassScanner;
import com.ltst.mybatis.execute.SqlExecute;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * 用于扫描注册所有的 mapper接口
 *
 * 提供 存储 mapperInterface、获取 mapper、添加mapper的功能
 */
public class MapperRegistry {
    //扫描到的mapper存储器
    private HashMap<Class<?>,MapperProxyFactory<?>> configMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

    public <T> T getMapper(Class<T> tClass, SqlExecute sqlExecute){
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) configMappers.get(tClass);
        if(Objects.isNull(mapperProxyFactory)){
            throw new NullPointerException("Can not get This Mapper"+tClass.getName());
        }
        return mapperProxyFactory.newInstance(sqlExecute);
    }

    /**
     * 对外开放的加载类
     * @param scanPath
     */
    public void scanMapper(String scanPath){
        Set<Class<?>> classes = ClassScanner.scanPackage(scanPath);
        for (Class<?> clzss : classes) {
            registryMapper(clzss);
        }
    }

    /**
     * 用于注册每一个mapperInterface
     * @param clzss
     */
    private void registryMapper(Class<?> clzss){
        configMappers.put(clzss,new MapperProxyFactory<>(clzss));
    }

}
