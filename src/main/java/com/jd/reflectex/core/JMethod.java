package com.jd.reflectex.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-18 23:08
 */
public class JMethod {

    private String classSimpleName;
    private String name;
    private String returnType;
    private Method method;

    public String invoke(String... args) {
        StringBuilder methodInvoke = new StringBuilder(64);
        methodInvoke.append(classSimpleName).append(".").append(name).append("(");
        for (int i = 0; i < args.length; i++) {
            if(i==args.length-1){
                if(args[i].endsWith(";")) {
                    methodInvoke.append(args[i].substring(0, args[i].length() - 1));
                }else{
                    methodInvoke.append(args[i]);
                }
            }else{
                methodInvoke.append(args[i]).append(",");

            }
        }
        methodInvoke.append(");");
        return methodInvoke.toString();
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void setName(String methodName) {
        name = methodName;
    }

    public String getName() {
        return name;
    }

    public String invoke(Object obj,Object... objects) {
        StringBuilder methodInvoke = new StringBuilder(64);
        methodInvoke.append("$1").append(".").append(name).append("(");
        for (int i = 0; i < objects.length; i++) {
            if (i==objects.length-1){
                methodInvoke.append("$"+(i+2));
            }else {
                methodInvoke.append("$"+(i+2)).append(",");
            }
        }
        methodInvoke.append(");");
        return methodInvoke.toString();
    }

    public String getClassSimpleName() {
        return classSimpleName;
    }

    public void setClassSimpleName(String classSimpleName) {
        this.classSimpleName = classSimpleName;
    }

    protected void setMethod(Method method){
        this.method = method;
    }
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass){
        return method.isAnnotationPresent(annotationClass);
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return method.getAnnotation(annotationClass);
    }
}
