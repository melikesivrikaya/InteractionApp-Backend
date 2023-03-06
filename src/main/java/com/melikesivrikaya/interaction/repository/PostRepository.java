package com.melikesivrikaya.interaction.repository;

import com.melikesivrikaya.interaction.model.Post;
import com.melikesivrikaya.interaction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findPostByUserId(Long userId);

}
