package com.califfod.bizsoft.firstclass.student;

import com.califfod.bizsoft.firstclass.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(updatable = false)
    private Date createOn;

    @Column(insertable = false)
    private Date updateOn;
}
