package org.domain.user.management.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_verification")
public class UserVerification {

    @Id
    private UUID id;

    private String token;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    public UserVerification() {
    }

    public UserVerification(UUID id, String token, UserInfo userInfo) {
        this.id = id;
        this.token = token;
        this.userInfo = userInfo;
    }

    public UUID getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "UserVerification{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}