package com.ltst.mybatis.binging;

import com.ltst.mybatis.dao.ICar;
import com.ltst.mybatis.dao.IUser;
import com.ltst.mybatis.execute.SqlExecute;
import com.ltst.mybatis.session.DefaultSqlSessionFactory;
import com.ltst.mybatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestMapperProxy {

    @Test
    public void test01(){
        SqlExecute ex1 = new SqlExecute();
        MapperProxyFactory<IUser> factory = new MapperProxyFactory<IUser>(IUser.class);
        IUser interfaceProxy = factory.newInstance(ex1);
        System.out.println(interfaceProxy);//this line will syout com.ltst.mybatis.binging.MapperProxy
        String proxyObjResult = interfaceProxy.queryUserNameById();
        System.out.println(proxyObjResult);
    }

    @Test
    public void test02(){
        //创建扫描器
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.scanMapper("com.ltst.mybatis.dao");
        //创建默认的Session工厂，并将扫描器赋值给它
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        //创建SqlSession
        SqlSession sqlSession = defaultSqlSessionFactory.openSqlSession();
        //使用SqlSession获取 ICar
        ICar mapper = sqlSession.getMapper(ICar.class);
        //模拟使用mapper执行sql
        String result = mapper.getCarById("123456");
        System.out.println(result);
    }
}
