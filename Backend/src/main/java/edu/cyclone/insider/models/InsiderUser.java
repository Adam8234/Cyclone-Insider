package edu.cyclone.insider.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class InsiderUser extends BaseModel {
    private String username;
    @JsonIgnore
    private String password;

    private String firstName;
    private String lastName;

    private Boolean isAdmin;
    public InsiderUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setAdmin(Boolean isAdmin) {
        isAdmin = this.isAdmin;
    }
}
