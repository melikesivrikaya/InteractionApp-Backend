package com.melikesivrikaya.interaction.request;

import lombok.Data;

@Data
public class SaveUserRequest {
    private String name;
    private String password;
}
