package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.Like;
import com.melikesivrikaya.interaction.model.Post;
import com.melikesivrikaya.interaction.model.User;
import com.melikesivrikaya.interaction.repository.LikeRepository;
import com.melikesivrikaya.interaction.request.SaveLikeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{
    public final LikeRepository likeRepository;
    public final UserService userService;
    public final PostService postService;
    @Override
    public List<Like> getAllLikeWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());
        }
        else {
            return likeRepository.findAll();
        }
    }

    @Override
    public Like getLike(Long likeId) {
        Optional<Like> like  = likeRepository.findById(likeId);
        if (like.isPresent()){
            return like.get();
        }
        return null;
    }

    @Override
    public Like saveLike(SaveLikeRequest request) {
        User user = userService.getUser(request.getUserId());
        Post post = postService.getPost(request.getPostId());
        if (user != null && post != null){
            Like like = new Like();
            like.setId(request.getId());
            like.setUser(user);
            like.setPost(post);
            return likeRepository.save(like);
        }
        return null;
    }

    @Override
    public void deleteLike(Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if (like.isPresent()){
            likeRepository.deleteById(likeId);
        }
    }
}
