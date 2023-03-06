package com.melikesivrikaya.interaction.model;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER) // database den çekildiğinde hepsini getirme
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    private String title;
    private String text;
}
