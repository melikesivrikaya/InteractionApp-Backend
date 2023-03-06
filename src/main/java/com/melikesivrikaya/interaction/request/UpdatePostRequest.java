package com.melikesivrikaya.interaction.request;

import lombok.Data;

@Data
public class UpdatePostRequest {
    private Long id;
    private String title;
    private String text;
}
