package com.jd.reflectex.test.lambda;

import com.jd.reflectex.test.bean.People;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-07-25 16:52
 */
public class Java8Tester {
    public static void main(String[] args) {
        People people = new People();
        people.setName("lizhihua");

        TestfunctionalInterface testFI = p -> p.getName();

        String name = testFI.getName(people);
        System.out.println("name = " + name);

    }
    private static void lambdaTest(){
        int i=10,j=20;
        Java8Tester tester = new Java8Tester();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) ->   a * b ;

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(1, j, addition));
        System.out.println("10 - 5 = " + tester.operate(i, j, subtraction));
        System.out.println("10 x 5 = " + tester.operate(i, j, multiplication));
        System.out.println("10 / 5 = " + tester.operate(i, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

       // TestfunctionalInterface testfi = value -> {System.out.println("hello"+value);return value;};
      //  String say = testfi.say("lambda ");
      //  System.out.println("say = " + say);
    }
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
