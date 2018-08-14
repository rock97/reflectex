package com.jd.reflectex.test;

import com.jd.reflectex.test.bean.People;
import com.jd.reflectex.test.bean.Student;
import com.jd.reflectex.util.CopyUtils;

import java.util.Date;

import javax.swing.*;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-25 18:44
 */
public class TestCopyUtils {
    public static void main(String[] args) {
        People people = new People();
        Student student = new Student();
        people.setName("lizhihua");
        people.setDate(new Date());
        people.setAge(23);
        people.setAddress("北京市");
        CopyUtils.createCopy(TestCopyUtils.class,"copy",People.class,Student.class);
        Date date = new Date();
        for (int i = 0 ;i<10000;i++){
            copy(people,student);
        }
        Date date1 = new Date();
        System.out.println("date1 = " + (date1.getTime()-date.getTime()));
        System.out.println(student.getAddress());
    }
    public static void copy(People people,Student student){

    }
}
