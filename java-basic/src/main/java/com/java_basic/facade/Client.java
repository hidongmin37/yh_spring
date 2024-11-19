package com.java_basic.facade;




public class Client {

    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");
        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("dongmin");
        emailMessage.setTo("jangdong");
        emailMessage.setSubject("오징어게임");
        emailMessage.setTo("밖은 더 지옥이더라고..");
        emailSender.sendEmail(emailMessage);
    }
}
