package com.blueyonder.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String role;
}
