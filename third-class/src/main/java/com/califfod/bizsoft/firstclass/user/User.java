package com.califfod.bizsoft.firstclass.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String note;
    private boolean married;
    private Date birthday;
    private String profession;
}
