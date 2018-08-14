package com.jd.reflectex.test.bean;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-05-30 17:43
 */

public class Student {
    private String name;
    private Integer age;
    private Date date;
    private String address;
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}
