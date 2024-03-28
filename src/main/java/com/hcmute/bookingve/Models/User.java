package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "User")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    private String FullName;
    private String SDT;
    private String Address;

    public User(int userId, String fullName, String SDT, String address) {
        UserId = userId;
        FullName = fullName;
        this.SDT = SDT;
        Address = address;
    }

    public User() {

    }
}
