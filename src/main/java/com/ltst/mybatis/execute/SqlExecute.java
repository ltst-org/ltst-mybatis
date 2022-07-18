package com.ltst.mybatis.execute;

import java.lang.reflect.Method;

public class SqlExecute {

    /**
     * test sql executor , use to show which interface need run which method.
     * @param clzss need execute interface
     * @param method need execute method
     * @return className + methodName
     */
    public String execute(Class clzss, Method method){
        return "execute "+clzss.getName()+","+method.getName();
    }
}
