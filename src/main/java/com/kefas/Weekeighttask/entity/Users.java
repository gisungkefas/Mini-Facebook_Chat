package com.kefas.Weekeighttask.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long user_id;

    private String firstname;

    private String lastname;

    private String email;

    private String phoneNumber;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> task;
}
