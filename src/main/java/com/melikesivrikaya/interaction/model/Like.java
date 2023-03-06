package com.melikesivrikaya.interaction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "likes")
public class Like {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) // database den çekildiğinde hepsini getirme
    @JsonIgnore
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY) // database den çekildiğinde hepsini getirme
    @JsonIgnore
    @JoinColumn(name = "postId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;
}
