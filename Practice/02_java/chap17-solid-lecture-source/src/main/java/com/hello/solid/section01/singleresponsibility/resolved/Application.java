package com.hello.solid.section01.singleresponsibility.resolved;

/* 설명.
 *  바르게 적용한다면 각각의 책임을 별도의 클래스로 분리하고,
 *  각 클래스는 자신의 데이터와 연산을 캡슐화하여 관리한다.
* */
public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        
        /* 설명. 이름, 근무시간, 시급이 설정된 객체 생성 */
        Employee emp = new Employee("홍길동", 40, 25000);
        
        /* 설명. 1. 급여 계산 */
        PayCalculator payCalculator = new PayCalculator();
        payCalculator.calculatePay(emp);

        /* 설명. 2. 데이터베이스 저장 */
        EmployeeRepository employeeRepoeitory = new EmployeeRepository();
        employeeRepoeitory.save(emp);

        /* 설명. 3. 근무시간 보고 */
        TimeReporter timeReporter = new TimeReporter();
        timeReporter.reportHours(emp);
    }
}
