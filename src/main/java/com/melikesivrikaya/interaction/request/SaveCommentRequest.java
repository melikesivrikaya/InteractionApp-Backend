package com.melikesivrikaya.interaction.request;

import lombok.Data;

@Data
public class SaveCommentRequest {
    private Long id,postId,userId;
    private String text;

}
