package com.melikesivrikaya.interaction.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private Long id;
    private String name;
    private String password;

}
