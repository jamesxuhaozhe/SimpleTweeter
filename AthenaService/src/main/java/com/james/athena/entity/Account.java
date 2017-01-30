package com.james.athena.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by haozhexu on 1/29/17.
 */
@Entity
@Data
@Accessors(chain = true)
public class Account {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String emailAddress;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private String password;
}
