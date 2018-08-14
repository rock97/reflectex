package com.jd.reflectex.util;

import com.jd.reflectex.core.JField;
import com.jd.reflectex.core.JavaClass;

import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-05-30 17:09
 */
public class CopyUtils {

    public static void createCopy(Class util, String methodName, Class org, Class dest) {

        JavaClass orgClass = new JavaClass(org);
        JavaClass destClass = new JavaClass(dest);
        Stream<JField> jFieldStream = destClass.getFileds().stream();
        StringBuilder copyCode = new StringBuilder(200);
        jFieldStream.filter(jField -> orgClass.hasJFiled(jField))
                    .map(jField -> jField.setter(orgClass.getFiled(jField.getName()).getter()))
                    .forEach(code->copyCode.append(code));
        JavaMethodUtil.overwrite(util,methodName,copyCode.toString());
    }
}
