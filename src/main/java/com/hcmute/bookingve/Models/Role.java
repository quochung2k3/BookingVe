package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "Role")
public class Role implements Serializable {

    @Column(name = "RoleId")
    private int role_id;
    @OneToMany(mappedBy = "Account",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Account> accounts;
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RoleId;
    private String RoleName;

    public Role(int roleId, String roleName) {
        RoleId = roleId;
        RoleName = roleName;
    }

    public Role() {

    }
}
