package com.jd.reflectex.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-18 23:07
 */
public class JField {

    private String classSimpleName;

    private String name;

    private String fieldType;

    private Field field;

    public String getName() {
        return name;
    }

    public String getter() {
        StringBuilder getMethod = new StringBuilder("");
        getMethod.append(classSimpleName).append(".").append(getMethod("get",name)).append("();");
        return getMethod.toString();
    }

    public String setter(String code) {
        StringBuilder setMethod = new StringBuilder("");
        if (code.endsWith(";"))code = code.substring(0,code.length()-1);
        setMethod.append(classSimpleName).append(".").append(getMethod("set",name)).append("(").append(code).append(");");
        return setMethod.toString();
    }


    public void setName(String name) {
        this.name = name;
    }

    private String getMethod(String gset,String field){
        return gset+field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    public String getClassSimpleName() {
        return classSimpleName;
    }

    public void setClassSimpleName(String classSimpleName) {
        this.classSimpleName = classSimpleName;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    protected void setField(Field field) {
        this.field = field;
    }
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass){
        return field.isAnnotationPresent(annotationClass);
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return field.getAnnotation(annotationClass);
    }

    public String getFieldType(){return fieldType;}
}
