package com.hcmute.bookingve.Models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "Account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AccountId;
    @Column(columnDefinition = "varchar(255)")
    private String Username;
    @Column(columnDefinition = "varchar(255)")
    private String Password;
    @Column(columnDefinition = "int")
    private int UserId;
    @Column(columnDefinition = "int")
    private int RoleId;
    @Column(columnDefinition = "int")
    private int PartnerId;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean IsActive;

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public int getPartnerId() {
        return PartnerId;
    }

    public void setPartnerId(int partnerId) {
        PartnerId = partnerId;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public Account(int accountId, String username, String password, int userId, int roleId, int partnerId, Boolean isActive) {
        AccountId = accountId;
        Username = username;
        Password = password;
        UserId = userId;
        RoleId = roleId;
        PartnerId = partnerId;
        IsActive = isActive;
    }

    public Account() {

    }
}