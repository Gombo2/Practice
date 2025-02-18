package com.hello.solid.section05.dependencyinversion.resolved;

public class NotificationService {

    /* 설명. 추상화에 의존 */
    private final MessageSender messageSender;

    /* 설명. 의존관계의 객체 주입(하위 구현체가 매번 다르다.) */
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String message) {
        messageSender.sendMessage(message);
    }
}
