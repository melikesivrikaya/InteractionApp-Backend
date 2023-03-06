package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.Like;
import com.melikesivrikaya.interaction.request.SaveLikeRequest;

import java.util.List;
import java.util.Optional;


public interface LikeService {
    List<Like> getAllLikeWithParam(Optional<Long> userId, Optional<Long> postId);

    Like getLike(Long likeId);

    Like saveLike(SaveLikeRequest request);

    void deleteLike(Long likeId);
}
