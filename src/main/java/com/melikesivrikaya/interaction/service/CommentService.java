package com.melikesivrikaya.interaction.service;

import com.melikesivrikaya.interaction.model.Comment;
import com.melikesivrikaya.interaction.request.SaveCommentRequest;
import com.melikesivrikaya.interaction.request.UpdateCommentRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getCommentByUserIdAndCommentId(Optional<Long> userId, Optional<Long> postId);

    Comment saveComment(SaveCommentRequest request);

    Comment updateComment(UpdateCommentRequest request);

    void deleteComment(Long commentId);

    Comment getComment(Long commentId);
}
