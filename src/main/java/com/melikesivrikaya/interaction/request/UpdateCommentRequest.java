package com.melikesivrikaya.interaction.request;

import lombok.Data;

@Data
public class UpdateCommentRequest {
    private Long id;
    private String text;
}
