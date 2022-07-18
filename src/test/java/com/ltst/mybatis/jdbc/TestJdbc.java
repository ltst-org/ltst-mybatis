package com.ltst.mybatis.jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestJdbc {
    /**
     * 测试用例开始前创建T_USER表
     */
    @BeforeAll
    public static void initSqlLite(){
        try {
            //1 设置驱动
            Class.forName("org.sqlite.JDBC");
            //2. 获取数据库连接
            Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            //3. 根据连接获取  statement
            Statement statement = connection.createStatement();
            //4. 创建表 T_USER
            String sql = "CREATE TABLE T_USER" +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    "NAME CHAR(20) NOT NULL);";
            //5. 执行SQL
            statement.execute(sql);
            //关闭连接
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 测试用例完成后删除 T_USER 表
     */
    @AfterAll
    public static void destorySqlLite(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement statement = connection.createStatement();
            String sql = "DROP TABLE T_USER";
            statement.execute(sql);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testJdbc01(){
        try {
            //1 设置 driver 驱动
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            //3 根据连接创建 statement
            Statement statement = connection.createStatement();
            //4 使用statement 执行SQL
            boolean execute = statement.execute("select * from T_USER");
            //5 根据statement 获取执行结果
            ResultSet resultSet = statement.getResultSet();
            System.out.println("执行是否成功 {"+execute+"}");
            while (resultSet.next()){
                System.out.println("返回结果 {"+resultSet.getInt("ID")+"}");
                System.out.println("返回结果 {"+resultSet.getString("Name")+"}");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("无法找到driver 对应的 class文件");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("SQL 执行异常");
            throw new RuntimeException(e);
        }
    }
}
