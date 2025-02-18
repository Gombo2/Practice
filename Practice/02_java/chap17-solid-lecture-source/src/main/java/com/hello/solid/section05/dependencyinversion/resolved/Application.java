package com.hello.solid.section05.dependencyinversion.resolved;

/* 설명.
 *  NotificationService가 추상화된 MessageSender 인터페이스에 의존하고,
 *  구체적인 구현(EmailSender, SMSSender)는 이 인터페이스를 구현한다.
 *  다른 메시지 발송 방식 추가하더라도 NotificationService의  코드에는 전혀 영향을 주지 않는다.
 *  이를 통해 실행 시점에 필요한 구현체를 유연하게 전달할 수 있다.
* */
public class Application {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        NotificationService emailService = new NotificationService(emailSender);
        NotificationService smsService = new NotificationService(smsSender);

        emailService.sendNotification("이메일로 발송될 공지입니다.");
        smsService.sendNotification("SMS로 발송될 공지입니다.");
    }
}
