package com.hello.solid.section01.singleresponsibility.problems;

public class BadEmployee {
    private String name;
    private int workingHours;
    private int payRate;
    
    public void calculatePay() {
        
        /* 설명. 급여 계산 로직 작성 */
        System.out.println("급여 계산");
    }

    public void saveEmployee() {
        
        /* 설명. 데이터 저장 로직 작성 */
        System.out.println("직원 정보를 데이터베이스에 저장");
    }

    public void reportWorkingHours() {
        
        /* 설명. 근무시간 보고 로직 작성 */
        System.out.println("근무 시간 보고");
    }
}
