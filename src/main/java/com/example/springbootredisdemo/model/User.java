package com.example.springbootredisdemo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Liton
 * Date: 26-Mar-2023 5:27 PM
 */

@Data
public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
