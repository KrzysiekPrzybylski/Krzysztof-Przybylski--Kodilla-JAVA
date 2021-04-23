package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.cfg.AvailableSettings.USER;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table (name = "USER")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    @OneToMany
    private List<BookBorrow> booksBorrow = new ArrayList<>();
}
