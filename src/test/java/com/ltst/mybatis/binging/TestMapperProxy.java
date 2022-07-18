package com.ltst.mybatis.binging;

import com.ltst.mybatis.dao.IUser;
import com.ltst.mybatis.execute.SqlExecute;
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
}
