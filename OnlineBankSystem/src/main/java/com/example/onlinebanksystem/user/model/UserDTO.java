package com.example.onlinebanksystem.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public class UserDTO {
    private String TCNo;
    private String password;

    public UserDTO(String TCNo) {
        this.TCNo = TCNo;
    }

    public User toUser(){
        User user = new User();
        user.setTCNo(TCNo);
        user.setPassword(password);
        return user;
    }


}
