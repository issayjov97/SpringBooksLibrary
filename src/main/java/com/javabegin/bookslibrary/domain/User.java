package com.javabegin.bookslibrary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(targetEntity = UserRoles.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private List<UserRoles> rolesList;


    @Override
    public String toString() {
        return username;
    }
}
