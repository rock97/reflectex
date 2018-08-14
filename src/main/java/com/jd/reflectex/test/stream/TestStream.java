package com.jd.reflectex.test.stream;


import com.jd.reflectex.core.JField;
import com.jd.reflectex.core.JavaClass;
import com.jd.reflectex.test.bean.People;
import com.jd.reflectex.test.bean.Student;

import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-25 17:52
 */
public class TestStream {
    public static void main(String[] args) {

        JavaClass org = new JavaClass(Student.class);
        JavaClass dest = new JavaClass(People.class);

        Stream<JField> orgFieldStream = org.getFileds().stream();

        GetMethod getMethod = (String gset,String field)->gset+field.substring(0, 1).toUpperCase() + field.substring(1);

        Stream<String> stream = orgFieldStream.filter(jField->dest.hasJFiled(jField))
                .map(jField->getMethod.getMethod("set",jField.getName())+"("+getMethod.getMethod("get",jField.getName())+"());");

        stream.forEach(s-> System.out.println(s));

    }

    interface  GetMethod{
        String getMethod(String gset,String field);
       // return gset+field.substring(0, 1).toUpperCase() + field.substring(1);
    }
}
