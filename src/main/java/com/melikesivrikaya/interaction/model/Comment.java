package com.melikesivrikaya.interaction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) // database den çekildiğinde hepsini getirme
    @JsonIgnore
    @JoinColumn(name = "postId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY) // database den çekildiğinde hepsini getirme
    @JsonIgnore
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    private String text;
}
