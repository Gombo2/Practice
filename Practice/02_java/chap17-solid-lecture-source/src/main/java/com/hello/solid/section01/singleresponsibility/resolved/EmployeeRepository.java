package com.hello.solid.section01.singleresponsibility.resolved;

public class EmployeeRepository {
    public void save(Employee emp) throws IllegalAccessException {
        validateEmployeeDate(emp);
        System.out.println(emp.getName() + "의 정보를 데이터베이스에 저장합니다.");
    }

    /* 설명. validation 체크용 메소드는 private으로 작성하고 굳이 외부로 노출하지 않는다. */
    private void validateEmployeeDate(Employee emp) throws IllegalAccessException {
        if (emp == null) {
            throw new IllegalAccessException("직원 정보가 null일 수 없습니다.");
        }

        if (emp.getName() == null || emp.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("직원 이름은 필수 입니다.");
        }
    }
}
