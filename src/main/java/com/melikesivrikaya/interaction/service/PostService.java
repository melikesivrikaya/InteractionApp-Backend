package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.Post;
import com.melikesivrikaya.interaction.request.SavePostRequest;
import com.melikesivrikaya.interaction.request.UpdatePostRequest;
import com.melikesivrikaya.interaction.responses.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponse> getAllPost(Optional<Long> userId);

    Post getPost(Long postId);

    Post savePost(SavePostRequest postRequest);

    Post updatePost(UpdatePostRequest postRequest);

    void deletePost(Long postId);
}
