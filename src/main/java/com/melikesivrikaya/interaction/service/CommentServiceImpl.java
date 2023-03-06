package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.Comment;
import com.melikesivrikaya.interaction.model.Post;
import com.melikesivrikaya.interaction.model.User;
import com.melikesivrikaya.interaction.repository.CommentRepository;
import com.melikesivrikaya.interaction.request.SaveCommentRequest;
import com.melikesivrikaya.interaction.request.UpdateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    public final CommentRepository commentRepository;
    public final UserService userService;
    public final PostService postService;
    @Override
    public List<Comment> getCommentByUserIdAndCommentId(Optional<Long> userId,Optional<Long> postId) {
       if(userId.isPresent() && postId.isPresent()){
           return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
       }
       else if(userId.isPresent()){
           return commentRepository.findByUserId(userId.get());
       } else if (postId.isPresent()) {
           return commentRepository.findByPostId(postId.get());
       }
        return commentRepository.findAll();
    }

    @Override
    public Comment saveComment(SaveCommentRequest request) {
        User user = userService.getUser(request.getUserId());
        Post post = postService.getPost(request.getPostId());
        if(user != null && post != null){
            Comment comment = new Comment();
            comment.setId(request.getId());
            comment.setText(request.getText());
            comment.setPost(post);
            comment.setUser(user);
            return commentRepository.save(comment);
        }
        return null;
    }

    @Override
    public Comment updateComment(UpdateCommentRequest request) {
        Optional<Comment> comment = commentRepository.findById(request.getId());
        if (comment.isPresent()){
            comment.get().setText(request.getText());
            return commentRepository.save(comment.get());
        }
        return null;
    }

    @Override
    public void deleteComment(Long commentId) {
        if(commentRepository.findById(commentId).isPresent()){
            commentRepository.deleteById(commentId);
        }
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }


}
