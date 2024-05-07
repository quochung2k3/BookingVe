package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Column(name = "UserId")
    @OneToMany(mappedBy = "Account",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Account> accounts;

    @Column(name = "user_id")
    @OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Reservation> reservations;
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
