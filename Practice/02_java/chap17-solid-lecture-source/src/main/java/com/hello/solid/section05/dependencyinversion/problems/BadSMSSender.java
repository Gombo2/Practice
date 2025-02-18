package com.hello.solid.section05.dependencyinversion.problems;

public class BadSMSSender {
    public void sendSMS(String message) {
        System.out.println("Bad SMS 발송: " + message);
    }
}
