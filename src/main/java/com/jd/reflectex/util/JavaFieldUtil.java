package com.jd.reflectex.util;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-08-06 14:07
 */
public class JavaFieldUtil {
    private static final ClassPool pool = ClassPool.getDefault();

    public static void insertField(Class cs, List<String> codes){
        String csName = cs.getName();
        try {
            CtClass cc = pool.get(csName);
            String classPath= getClassName(cc, csName);
            for (String code : codes) {
                CtField field = CtField.make(code, cc);
                cc.addField(field);
            }
            DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(classPath));
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
    private static String getClassName(CtClass cc, String className){
        URL resource = cc.getClass().getResource("/");
        return resource.getPath() + className.replace(".", "/") + ".class";
    }
}
