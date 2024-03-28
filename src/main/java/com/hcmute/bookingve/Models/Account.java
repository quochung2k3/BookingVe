package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name = "Account")
public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AccountId;
    private String Username;
    private String Password;
    private int UserId;
    private int RoleId;
    private int PartnerId;
    private Boolean IsActive;

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