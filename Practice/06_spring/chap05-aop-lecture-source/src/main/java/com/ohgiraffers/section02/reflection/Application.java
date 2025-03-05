package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {

        /* 설명.
         *  리플렉션(reflection)이란?
         *   컴파일 된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법이다.
         *   스프링 프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용된다.
         *   스프링에서는 런타임 시 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있게 하는 기술이기도 하다.
        * */

        /* 설명. 1. Class 타입의 Class 메타정보 추출 */
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5 = double[].class;
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;
            System.out.println("class6 = " + class6);
            System.out.println("class7 = " + class7);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 2. 필드 정보 추출 */
        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("modifiers: " + Modifier.toString(field.getModifiers())
                                + ", type: " + field.getType()
                                + ", name: " + field.getName());
        }
        
        /* 설명. 3. 생성자 정보 추출 */
        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name: " + constructor.getName());

            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("parameterType: " + param.getTypeName());
            }
        }

        /* 설명. reflection 기술로 추출한 생성자만 별도로 취급하여 객체를 생성할 수도 있다. */
//        System.out.println(constructors[0]);
        try {
            Account acc = (Account) constructors[0]
                        .newInstance("20", "110-111-123456", "1234", 10000);
            System.out.println(acc.getBalance());

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 4. 메소드 정보 추출 */
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " "
                                + method.getReturnType().getSimpleName() + " "
                                + method.getName());
            if ("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        try {

            /* 설명. nonstatic 메소드만 따로 실행하고 싶을 땐 해당 메소드가 실행되기 위한 객체를 넘겨서 실행할 수 있다.(invoke) */
            getBalanceMethod.invoke(((Account)constructors[2].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}
