package com.ohgiraffers.section03.map.run;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다.*/
        Map<Object, Object> hMap = new HashMap<>();
//        hMap.put("one",new java.util.Date());
        hMap.put(new String("one"), new java.util.Date());
        hMap.put(12,"red apple");
        hMap.put(33, 123);

        /* 설명. Map은 key를 통해 value를 뽑는 것이 기본적이며 key는 객체의 동등비교를 통해 확인된다. */
        System.out.println("키가 \"one\" 인 value값: " + hMap.get("one"));

        System.out.println(hMap);

        /* 목차. 1. key가 중복되는 경우*/
        /* 설명. 우리가 만든 객체도 key로 사용할 수 있으며 이때 해당 객체는 e,h가 반드시 오버라이딩 되어 있어야 한다.*/
        /* 궁금. e,h 이따 강사님 푸쉬한거 확인해서 고치기.*/
        hMap.put(new BookDTO(1,"홍길동전","허균",50000),1);
        hMap.put(new BookDTO(1,"홍길동전","허균",50000),2);
        System.out.println("BookDTO 객체를 활용한 key와 value 두 쌍을 두개 추가 후 : " + hMap);

        /* 설명. 2. value가 중복되는 경우. */
        hMap.put(44, 123);
        System.out.println("value가 중복되는 key와 value 쌍을 추가 후 : " + hMap);


        System.out.println();

        /* 설명. Map을 활용해 보자*/
        Map<String,String> hMap2 = new HashMap<>();
        hMap2.put("one", "java 17");
        hMap2.put("two", "mariaDB 10");
        hMap2.put("three", "servlet/jsp");
        hMap2.put("four", "springboot 3.0");
        hMap2.put("five", "vue");

        System.out.println("hMap2 = " + hMap2);

        /* 설명. Map에 담긴 값을 순회해서 확인하는 방법 */
        /* 목차. 1. keySet()을 활용해 key를 Set으로 바꾸고 iterator를 돌리는 방법*/
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter = keys.iterator();

        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println("key = " + key + " value = " + hMap2.get(key));
        }


        /* 설명. 2. entrySet()을 활용하는 방법 */
        Set<Map.Entry<String, String>> set = hMap2.entrySet();
        Iterator<Map.Entry<String,String>> iter2 = set.iterator();
        while (iter2.hasNext()) {
            Map.Entry<String,String> entry = iter2.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}
