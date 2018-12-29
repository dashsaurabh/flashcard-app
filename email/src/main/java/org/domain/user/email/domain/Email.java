package org.domain.user.email.domain;

public abstract class Email {
    private String receiver;
    private String subject;

    public Email(String receiver, String subject) {
        this.receiver = receiver;
        this.subject = subject;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }
}
