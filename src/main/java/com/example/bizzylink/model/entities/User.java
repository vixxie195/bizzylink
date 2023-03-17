package com.example.bizzylink.model.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idUser;

    @Column
    private String FName;

    @Column
    private String LName;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String Email;

    @Column
    private String Password;

    @Column
    private String ProfilePhote;

    @Column
    private boolean isBusinessUser;

    @Column
    private int businessIdBusiness;

    @Column
    private int phoneNumberIdNumber;

}