package com.kh.reactbackend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "email",length = 100, unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "is_online")
    private Boolean isOnline;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cards> cards = new ArrayList<>();

}
