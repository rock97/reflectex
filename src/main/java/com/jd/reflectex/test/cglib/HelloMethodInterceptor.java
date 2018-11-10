package com.jd.reflectex.test.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-10 14:40
 */
public class HelloMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        System.out.println("befor method = " + method.getName());
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("after method = " + method.getName());
        return obj;
    }
}
