package com.melikesivrikaya.interaction.request;

import lombok.Data;

@Data
public class SaveLikeRequest {
    private Long id,userId,postId;
}
