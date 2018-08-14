package com.jd.reflectex.test.lambda;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-23 13:43
 */
public class MethodHandleTest {
    public static void main(String[] args) {

    }
    static class ClassA{
        public void println(String s){
            System.out.println("hi ,"+s+"i'm classA");
        }
    }
    static class ClassB{
        public void println(String s){
            System.out.println("hi ,"+s+"i'm classB");
        }
    }
    /*public static MethodHandle getPringlnMH(Object obj){
        MethodType methodType = MethodType.methodType(Void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(),"println",methodType).bindTo(obj);
    }*/
}
