package com.hunau.mysql;/* *
 * @Description:对用户信息进行封装
 * @param 用户表字段
 * @Return: 用户表对应字段
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/4/21 11:34
 * @开发版本：综合练习V0.1
 */

import java.sql.*;

public class usersql {
    private String name;
    private String pwd;
    public void usersql1(int a){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {            // 加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogintest", "root", "yuxinwei");
            long end = System.currentTimeMillis();
            // 创建Statement对象
            stmt = conn.createStatement();
            // 执行SQL语句
            rs = stmt.executeQuery("select * from user");
            for(int i = 0; i< a; i++)rs.next();
                name=rs.getString(2);
                pwd=rs.getString(3);
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
    public String name(){
        return name;
    }
    public String pwd(){
        return pwd;
    }
}
