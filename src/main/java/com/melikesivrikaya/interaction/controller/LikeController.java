package com.melikesivrikaya.interaction.controller;

import com.melikesivrikaya.interaction.model.Like;
import com.melikesivrikaya.interaction.request.SaveLikeRequest;
import com.melikesivrikaya.interaction.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    @GetMapping
    public List<Like> getAllLikeWithParam(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return likeService.getAllLikeWithParam(userId,postId);
    }
    @GetMapping("/{likeId}")
    public Like getLike(@PathVariable Long likeId){
        return likeService.getLike(likeId);
    }
    @PostMapping
    public Like saveLike(@RequestBody SaveLikeRequest request){
        return likeService.saveLike(request);
    }

    @DeleteMapping
    public void deleteLike(@RequestParam Long likeId){
        likeService.deleteLike(likeId);
    }
}
