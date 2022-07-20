package com.ltst.mybatis.execute;

import java.lang.reflect.Method;

public class SqlExecute {

    /**
     * test sql executor , use to show which interface need run which method.
     * @param statementId
     * @return className + methodName
     */
    public <T> T execute(String statementId){
        return (T) ("execute "+statementId);
    }
    public <T> T execute(String statementId,Object args){
        return (T) ("execute :"+statementId+",参数:"+args);
    }
}
