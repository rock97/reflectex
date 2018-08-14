package com.jd.reflectex.test;

import com.jd.reflectex.core.JField;
import com.jd.reflectex.core.JMethod;
import com.jd.reflectex.core.JavaClass;
import com.jd.reflectex.test.bean.People;
import com.jd.reflectex.test.bean.Student;
import com.jd.reflectex.util.JavaMethodUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-06 15:17
 */
public class CopyTest {
    public static void main(String[] args) {

        JavaClass org = new JavaClass(Student.class);
        JavaClass dest = new JavaClass(People.class);
        List<JField> orgFileds = org.getFileds();
        StringBuilder sb = new StringBuilder(200);

        GetMethod getMethod = (String gset, String field)->gset+field.substring(0, 1).toUpperCase() + field.substring(1);

        orgFileds.stream().filter(jField -> dest.hasJFiled(jField))
                    .map(jField -> org.getMethod(getMethod.getMethod("set",jField.getName())).invoke(dest.getMethod(getMethod.getMethod("get",jField.getName())).invoke())).forEach(s -> sb.append(s));

        System.out.println("sb = " + sb);
        JavaMethodUtil.overwrite(CopyTest.class,"copy",sb.toString());
    }
    interface  GetMethod{
        String getMethod(String gset,String field);
    }
    public   void copy(People people,Student student){}
}
