package com.ltst.mybatis.session;

public interface SqlSession {
    /**
     * 根据statementId 获取
     * @param statementId
     * @return
     * @param <T>
     */
    <T> T selectOne(String statementId);

    /**
     * 获取 mapper
     * @param type
     * @return
     * @param <T>
     */
    <T> T getMapper(Class<T> type);
}
