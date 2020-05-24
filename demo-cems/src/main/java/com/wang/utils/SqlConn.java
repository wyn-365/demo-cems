package com.wang.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 王一宁
 * @date 2020/4/29 9:20
 */
public class SqlConn {
    /**
     * 连接数据库构造构造方法
     */
    public static Connection getConn(String dbDriver, String dbUrl, String user, String password){
        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn= DriverManager.getConnection(dbUrl,user,password);
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }catch(SQLException e1){
            e1.printStackTrace();
        }
        return conn;
    }
}
