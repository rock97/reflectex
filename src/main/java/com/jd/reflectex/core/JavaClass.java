package com.jd.reflectex.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-18 23:07
 */
public class JavaClass<T> {

    private static final Map<String,JMethod> jMethods = new ConcurrentHashMap<>();
    private static final Map<String,JField> jFileds = new ConcurrentHashMap<>();
    private List<JMethod> jMethodList;
    private List<JField> jFieldList;
    private String className;
    private String classSimpleName;
    private Class<T> cs;
    public JavaClass(Class<T> cs) {
        this.cs = cs;
        this.className = cs.getName();
        this.classSimpleName = cs.getSimpleName();
        Field[] fields = cs.getDeclaredFields();
        Method[] methods = cs.getMethods();
        jMethodList = new ArrayList<>();
        jFieldList = new ArrayList<>();
        for (Field field : fields) {
            JField jFiled = new JField();
            jFiled.setField(field);
            jFiled.setClassSimpleName(classSimpleName);
            jFiled.setName(field.getName());
            jFiled.setFieldType(field.getType().getName());
            jFieldList.add(jFiled);
            jFileds.put(getKey(field.getName()),jFiled);
        }
        for (Method method : methods) {
            JMethod jMethod1 = new JMethod();
            jMethod1.setMethod(method);
            jMethod1.setName(method.getName());
            jMethod1.setClassSimpleName(classSimpleName);
            String name = method.getReturnType().getName();
            jMethod1.setReturnType(name);
            jMethodList.add(jMethod1);
            jMethods.put(getKey(method.getName()),jMethod1);
        }
    }

    public T newInstance() throws IllegalAccessException, InstantiationException {
        return cs.newInstance();
    }

    public JMethod getMethod(String name) {
        return jMethods.get(getKey(name));
    }

    public JField getFiled(String name){
        return jFileds.get(getKey(name));
    }

    public List<JMethod> getMethods() {
        return jMethodList;
    }

    public List<JField> getFileds() {
        return jFieldList;
    }

    public boolean hasJMethod(JMethod jMethod) {
        return jMethods.containsKey(getKey(jMethod.getName()));
    }

    public boolean hasJFiled(JField jFiled) {
        return jFileds.containsKey(getKey(jFiled.getName()));
    }

    public String getClassSimpleName() {
        return classSimpleName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassSimpleName(String classSimpleName) {
        this.classSimpleName = classSimpleName;
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass){
        return cs.isAnnotationPresent(annotationClass);
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
       return cs.getAnnotation(annotationClass);
    }

    private String getKey(String key){
        return this.className+"#"+key;
    }
}
