package com.melikesivrikaya.interaction.controller;

import com.melikesivrikaya.interaction.model.Post;
import com.melikesivrikaya.interaction.request.SavePostRequest;
import com.melikesivrikaya.interaction.request.UpdatePostRequest;
import com.melikesivrikaya.interaction.responses.PostResponse;
import com.melikesivrikaya.interaction.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    public final PostService postService;
    @GetMapping
    public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }
    @GetMapping("/{postId}")
    public Post getPost(Long postId){
        return postService.getPost(postId);
    }
    @PostMapping
    public Post savePost(@RequestBody SavePostRequest postRequest){
        return postService.savePost(postRequest);
    }
    @PutMapping
    public Post updatePost(@RequestBody UpdatePostRequest postRequest){
        return postService.updatePost(postRequest);
    }
    @DeleteMapping
    public void deletePost(@RequestParam Long postId){
        postService.deletePost(postId);
    }
}
