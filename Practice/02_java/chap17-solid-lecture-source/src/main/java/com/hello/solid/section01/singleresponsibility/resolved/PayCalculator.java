package com.hello.solid.section01.singleresponsibility.resolved;

public class PayCalculator {

    public void calculatePay(Employee emp) {
        int pay = emp.getWorkingHours() * emp.getPayRate();
        System.out.println(emp.getName() + "의 급여를 계산합니다.: " + pay + "원");
    }
}
