package com.example.insane.firstforumAnother.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tuser")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
    @Column(name = "has_admin")
    private boolean hasAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHasAdmin() {
        return hasAdmin;
    }

    public void setHasAdmin(boolean hasAdmin) {
        this.hasAdmin = hasAdmin;
    }
}
