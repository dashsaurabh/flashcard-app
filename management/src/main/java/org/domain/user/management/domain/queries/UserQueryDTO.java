package org.domain.user.management.domain.queries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.domain.user.management.entities.UserStatus;

import java.util.UUID;

@ApiModel(description = "User Query Model")
public class UserQueryDTO {

    @ApiModelProperty(notes = "Unique system id for a user", required = true)
    private UUID id;

    @ApiModelProperty(notes = "Unique external identifier for a user", required = true)
    private String username;

    @ApiModelProperty(notes = "First Name", example = "Charles", required = true)
    private String firstName;

    @ApiModelProperty(notes = "Last Name", example = "Darwin", required = true)
    private String lastName;

    @ApiModelProperty(notes = "Email Id for communication", example = "charles.darwin@gmail.com", required = true)
    private String email;

    @ApiModelProperty(notes = "Status of the user", example = "HOLD, ACTIVE", required = true)
    private UserStatus status;

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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserQueryDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
