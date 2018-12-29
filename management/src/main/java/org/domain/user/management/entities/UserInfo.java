package org.domain.user.management.entities;

import org.domain.user.management.entities.common.Auditable;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_info")
public class UserInfo extends Auditable<String>   {

    @Id
    private UUID id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String status;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userInfo", cascade = CascadeType.ALL, optional = false)
    private UserVerification verification;

    public UserInfo() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserVerification getVerification() {
        return verification;
    }

    public void setVerification(UserVerification verification) {
        this.verification = verification;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", verification=" + verification +
                '}';
    }
}
