package org.fortysixntwo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private int _id;
    private String user_name;
    private String user_email;
    private String user_pass;
}