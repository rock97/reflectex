package com.jd.reflectex.util;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-06 10:26
 */
public class JavaMethodUtil {
    private static final ClassPool pool = ClassPool.getDefault();

    /**
     * 在方法体最后面插入代码
     * @param cs
     * @param methodName
     * @param code
     */
    public static void insertAfter(Class cs,String methodName,String code){
        try {
            String csName = cs.getName();
            CtClass cc=pool.get(csName);
            CtMethod method = cc.getDeclaredMethod(methodName);
            String classPath = getClassName(cc, csName);
            DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(classPath));
            String gentCode = gentCode(cs, methodName, code);
            System.out.println("gentCode = " + gentCode);
            method.insertAfter(gentCode);
            cc.toBytecode(dataOutput);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重写方法体内的代码
     * @param cs
     * @param methodName
     * @param code
     */
    public static void overwrite(Class cs,String methodName,String code){
        try {
            String csName = cs.getName();
            CtClass cc=pool.get(csName);
            CtMethod method = cc.getDeclaredMethod(methodName);
            String classPath = getClassName(cc, csName);
            DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(classPath));
            String gentCode = gentCode(cs, methodName, code);
            System.out.println("gentCode = " + gentCode);
            method.setBody("{"+gentCode+"}");
            cc.toBytecode(dataOutput);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在方法体最前面插入代码
     * @param cs
     * @param methodName
     * @param code
     */
    public static void insertBefore(Class cs,String methodName,String code){
        try {
            String csName = cs.getName();
            CtClass cc=pool.get(csName);
            CtMethod method = cc.getDeclaredMethod(methodName);
            String classPath = getClassName(cc, csName);
            DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(classPath));
            String gentCode = gentCode(cs, methodName, code);
            System.out.println("gentCode = " + gentCode);
            method.insertBefore(gentCode);
            cc.toBytecode(dataOutput);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理原始代码
     * @param cs
     * @param methodName
     * @param code
     * @return
     */
    private static String gentCode(Class cs,String methodName,String code){
        try {
            String csName = cs.getName();
            CtClass cc = pool.get(csName);
            CtMethod method = cc.getDeclaredMethod(methodName);
            CtClass[] parameterTypes = method.getParameterTypes();
            for (int i = 1; i <= parameterTypes.length; i++) {
                String className = parameterTypes[i-1].getSimpleName();
                code = code.replaceAll(className, "\\$" + i);
            }
            CtClass returnType = method.getReturnType();
            String returnTypeName = returnType.getName();
            if(!returnTypeName.equals("void")){
                code = "return "+code;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }
    private static String getClassName( CtClass cc,String className){
        URL resource = cc.getClass().getResource("/");
        return resource.getPath() + className.replace(".", "/") + ".class";
    }

}
