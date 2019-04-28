package com.hunau.util;/* *
 * @Description:传递控件信息
 * @param :EditField
 * @Return: EditField
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/4/20 15:44
 * @开发版本：综合练习V0.1
 */

import com.hunau.mysql.usersql;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;

public class Listen implements ActionListener {
    /*class usersql {
        public void usersql1(int a){
            int j=a;
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
                for(int i=0;i<j;i++)rs.next();
                name=rs.getString(2);
                pwd=rs.getString(3);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
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
            }
        }
    }
    public String name;
    public String pwd;*/
    private JTextField jtf;
    private JPasswordField jpf;
    private JTextArea jta;
    //private JFrame jfame;
    private usersql a=new usersql();
    //定义构造函数
    public Listen(){
    }
    public Listen(JTextField jtf){
        this.jtf=jtf;
    }
    public Listen(JTextField jtf,JPasswordField jpf){
        this.jtf=jtf;
        this.jpf=jpf;
    }
    public Listen(JTextField jtf,JPasswordField jpf,JTextArea jta){
        this.jtf=jtf;
        this.jpf=jpf;
        this.jta=jta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {//定义处理事件的方法
        String btnsel = e.getActionCommand();//返回与此动作相关的命令字符串
        if(btnsel.equals("登录")){
            int i=1;
            String name;
            String pwd;
            /*JTextField nametext = new JTextField();
            JPasswordField pwdtext = new JPasswordField();
            JTextArea resttext = new JTextArea();*/
                while (true){
                    a.usersql1(i);
                    name=a.name();
                    pwd=a.pwd();
                if (jtf.getText().equals(name) && jpf.getText().equals(pwd)) {
                    jta.setText("登陆成功！\n您的账户名是" + jtf.getText());
                    break;
                }
                if (i==4 && ((!jpf.getText().equals(pwd)) || !jtf.getText().equals(name))){
                    jpf.setText("");
                    jta.setText("");
                    JOptionPane.showMessageDialog(null, "登录失败！", "提示", JOptionPane.YES_OPTION);
                    break;
                }
                else i++;
                }
        }
        else if (btnsel.equals("清空")){
            jtf.setText("");
            jpf.setText("");
            jta.setText("清除成功！");
        }
    }
}
