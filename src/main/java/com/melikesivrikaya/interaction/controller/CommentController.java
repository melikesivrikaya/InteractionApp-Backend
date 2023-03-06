package com.melikesivrikaya.interaction.controller;

import com.melikesivrikaya.interaction.model.Comment;
import com.melikesivrikaya.interaction.request.SaveCommentRequest;
import com.melikesivrikaya.interaction.request.UpdateCommentRequest;
import com.melikesivrikaya.interaction.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    public final CommentService commentService;
    @GetMapping
    public List<Comment> getAllCommentWithParam(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
        return commentService.getCommentByUserIdAndCommentId(userId,postId);
    }
    @GetMapping("/{postId}")
    public Comment getComment(@PathVariable Long commentId){
        return commentService.getComment(commentId);
    }
    @PostMapping
    public Comment saveComment(@RequestBody SaveCommentRequest request){
        return commentService.saveComment(request);
    }
    @PutMapping
    public Comment updateComment(@RequestBody UpdateCommentRequest request){
        return commentService.updateComment(request);
    }
    @DeleteMapping
    public void deleteComment(@RequestParam Long commentId){
        commentService.deleteComment(commentId);
    }

}
