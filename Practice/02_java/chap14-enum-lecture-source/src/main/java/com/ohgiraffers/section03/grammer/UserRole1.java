package com.ohgiraffers.section03.grammer;

public enum UserRole1 {
    GUEST,
    CONSUMER,
    PRODUCER,
    ADMIN;

    /* 설명. 각 필드에 들어갈 객체들에 단순 메소드 하나 추가해 보기 */
    public String getNameToLowerCase() {
        return this.name().toLowerCase();
    }
}
