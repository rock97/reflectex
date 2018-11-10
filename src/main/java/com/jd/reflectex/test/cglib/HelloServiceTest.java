package com.jd.reflectex.test.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.security.spec.EncodedKeySpec;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-10 14:47
 */
public class HelloServiceTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloService hs = (HelloService)enhancer.create();
        hs.sayHello("lizhihua");
    }
}
