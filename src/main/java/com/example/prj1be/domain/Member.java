package com.example.prj1be.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Member {
    private String id;
    private String nickName;
    private String password;
    private String email;
    private LocalDateTime inserted;
    private List<Auth> auth;

    public boolean isAdmin() {
        if (auth != null) {
            return auth
                    .stream()
                    .map(e -> e.getName())
                    .anyMatch(n -> n.equals("admin"));
        }
        return false;
    }
}