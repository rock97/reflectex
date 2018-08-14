package com.jd.reflectex.test;

import com.jd.reflectex.core.JMethod;
import com.jd.reflectex.core.JavaClass;
import com.jd.reflectex.test.bean.Calculate;
import com.jd.reflectex.test.bean.People;
import com.jd.reflectex.util.JavaMethodUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-06 10:24
 */
public class ReflecTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        JavaClass<Calculate> javaClass = new JavaClass(Calculate.class);

        Calculate calculate = javaClass.newInstance();

        JMethod add = javaClass.getMethod("add");

        String addinvoke = add.invoke(calculate,int.class, int.class);

        System.out.println("addinvoke = " + addinvoke);
        JavaMethodUtil.overwrite(ReflecTest.class, "add", addinvoke);

        int add1 = add(calculate,23,34);

        System.out.println("add1 = " + add1);
    }

     private static int add(Calculate calculate,int a,int b){
         return 0;
     }
}
