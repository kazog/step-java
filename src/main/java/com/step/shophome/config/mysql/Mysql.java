package com.step.shophome.config.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Create By: Meng
 * Create Date: 2022-03-26
 */
public class Mysql {
    private final static String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final static String SQL_URL = "jdbc:mysql://localhost:3306/test3?userSSL=false&serverTimezone=UTC";
    private final static String SQL_URL = "jdbc:mysql://127.0.0.1:3306/test3?userSSL=false&serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PWD = "admin123";

    public static void init() {
        try{
            // 加载驱动程序
            Class.forName(SQL_DRIVER);
            // 链接
            Connection con = DriverManager.getConnection(SQL_URL, USER, PWD);
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("MySQL Driver init!");
    }

}
