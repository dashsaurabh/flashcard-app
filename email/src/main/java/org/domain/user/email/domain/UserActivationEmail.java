package org.domain.user.email.domain;

public class UserActivationEmail extends Email {
    private String activationMessage;

    public UserActivationEmail(String receiver, String subject, String activationMessage) {
        super(receiver, subject);
        this.activationMessage = activationMessage;
    }

    public String getActivationMessage() {
        return activationMessage;
    }
}
