package com.hcmute.bookingve.Models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @Column(columnDefinition = "varchar(255)")
    private String username;
    @Column(columnDefinition = "varchar(255)")
    private String password;
    @Column(columnDefinition = "int")
    private int userId;
    @Column(columnDefinition = "int")
    private int roleId;
    @Column(columnDefinition = "int")
    private int partnerId;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean isActive;

    public Account(int accountId, String username, String password,
                   int userId, int roleId, boolean isActive, int partnerId) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.roleId = roleId;
        this.partnerId = partnerId;
        this.isActive = isActive;
    }

    public Account() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}