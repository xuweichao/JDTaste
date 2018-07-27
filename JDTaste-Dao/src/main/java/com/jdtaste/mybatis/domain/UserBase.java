package com.jdtaste.mybatis.domain;

import lombok.Data;
@Data
public class UserBase {
    private Long id;

    private String account;

    private String password;

    private String email;

    private String phone;

    private String userName;

    private String accessToken;

    private Byte status;



}