package com.example.hieu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "account")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name =  "UserName",unique = true)
    private String userName;
    private String fullName;

    @Column(name = "information",unique = true)
    private String Info;

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
    }

    public User() {

    }
}
