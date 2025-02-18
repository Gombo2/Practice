package com.hello.solid.section01.singleresponsibility.resolved;

public class TimeReporter {
    public void reportHours(Employee emp) {

        /* 설명. 근무시간 보고 관련 책임만 처리하고 초과 근무 유효성 검사는 별도의 메소드로 분리 */
        validateWorkingHours(emp);
        System.out.println(emp.getName() + "의 근무 시간을 보고합니다: " + emp.getWorkingHours());
    }

    private void validateWorkingHours(Employee emp) {
        if (emp.getWorkingHours() > 52) {
            System.out.println("경고: 주 52시간을 초과하는 근무시간이 기록되었습니다.");
        }
    }
}
