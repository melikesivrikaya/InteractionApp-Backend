package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.Post;
import com.melikesivrikaya.interaction.model.User;
import com.melikesivrikaya.interaction.repository.PostRepository;
import com.melikesivrikaya.interaction.repository.UserRepository;
import com.melikesivrikaya.interaction.request.SavePostRequest;
import com.melikesivrikaya.interaction.request.UpdatePostRequest;
import com.melikesivrikaya.interaction.responses.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    public final PostRepository postRepository;
    public final UserRepository userRepository;
    @Override
    public List<PostResponse> getAllPost(Optional<Long> userId) {
        List<Post> list;
        if (userId.isPresent()){
            list = postRepository.findPostByUserId(userId.get());
        }
        list = postRepository.findAll();
        return list.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());

    }

    @Override
    public Post getPost(Long postId) {
        if(isPost(postId)){
            return postRepository.findById(postId).get();
        }
        return null;
    }

    @Override
    public Post savePost(SavePostRequest postRequest) {
        Optional<User> user = userRepository.findById(postRequest.getUserId());
        if (user.isPresent()){
            Post post = new Post();
            post.setId(postRequest.getId());
            post.setText(postRequest.getText());
            post.setTitle(postRequest.getTitle());
            post.setUser(user.get());
            return postRepository.save(post);
        }
        return null;
    }

    @Override
    public Post updatePost(UpdatePostRequest postRequest) {
        Optional<Post> post = postRepository.findById(postRequest.getId());
        if(post.isPresent()){
            post.get().setTitle(postRequest.getTitle());
            post.get().setText(postRequest.getText());
            return postRepository.save(post.get());
        }
        return null;
    }

    @Override
    public void deletePost(Long postId) {
        if (isPost(postId)){
            postRepository.deleteById(postId);
        }
    }


    public boolean isPost(Long postId){
       Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            return true;
        }
        return false;
    }
}
