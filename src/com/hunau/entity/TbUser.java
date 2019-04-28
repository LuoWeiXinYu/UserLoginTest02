package com.hunau.entity;/* *
 * @Description:对用户信息进行封装
 * @param '用户表字段'
 * @Return: 用户表对应字段
 * @开发人员：余新伟
 * @开发单位：湖南农业大学物联网工程专业
 * @Date: 2019/4/27 15:05
 * @开发版本：综合练习V0.1
 */

public class TbUser {
    private int id;
    private String name;
    private String pwd;
    private String sexy;
    private boolean isused;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public boolean isIsused() {
        return isused;
    }

    public void setIsused(boolean isused) {
        this.isused = isused;
    }

    @Override
    public String toString() {
        String str="User{" +
                "编号=" + id +
                ", 姓名='" + name + '\'' +
                ", 密码='" + pwd + '\'' +
                ", 性别='" + sexy + '\'' ;
        if (isused) {
            str+= ",是否有效=是}";
        }
        else {
            str+=",是否有效=否}";
        }
        ;;;;
        return str;
    }
}
