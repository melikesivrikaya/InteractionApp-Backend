package com.melikesivrikaya.interaction.request;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SavePostRequest {
    private Long id;
    private Long userId;
    private String title;
    private String text;
}
