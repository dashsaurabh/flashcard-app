package org.domain.user.management.exceptions;

public class UserIdNotAvailableException extends RuntimeException{

    public UserIdNotAvailableException(String message) {
        super(message);
    }
}
