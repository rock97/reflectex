package com.jd.reflectex.test;

import com.jd.reflectex.core.JField;
import com.jd.reflectex.core.JavaClass;
import com.jd.reflectex.test.annotation.Getter;
import com.jd.reflectex.test.bean.Cat;
import com.jd.reflectex.util.JavaClassUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-27 17:47
 */
public class GtterTest {
    public static void main(String[] args) {
        testGetter();

    }

    private static void testGetter(){
        JavaClass<Cat> catJavaClass = new JavaClass<>(Cat.class);
        Stream<JField> stream = catJavaClass.getFileds().stream();
        List<String> list = new ArrayList<>();
        stream.filter(a->catJavaClass.isAnnotationPresent(Getter.class)).
                map(jField -> "public   "+jField.getFieldType() +" "
                        +getMethod("get",jField.getName())+"(){"+
                        "return "+jField.getName()+";}")
                .forEach(s -> list.add(s));

        JavaClassUtil.insertMethod(Cat.class,list);
    }
    private static String getMethod(String gset,String field){
        return gset+field.substring(0, 1).toUpperCase() + field.substring(1);
    }
}
