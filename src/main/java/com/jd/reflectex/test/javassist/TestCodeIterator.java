package com.jd.reflectex.test.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Mnemonic;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-17 14:39
 */
public class TestCodeIterator {
    public void CodeIterator(String className,String methodName) throws NotFoundException, BadBytecode {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get(className);
        ClassFile classFile = ctClass.getClassFile();
        MethodInfo method = classFile.getMethod(methodName);
        CodeAttribute codeAttribute = method.getCodeAttribute();
        CodeIterator iterator = codeAttribute.iterator();
        while (iterator.hasNext()){
            int index = iterator.next();
            int op = iterator.byteAt(index);
            System.out.println(Mnemonic.OPCODE[op]);
        }
    }
}
