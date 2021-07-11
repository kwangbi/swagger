package com.example.swagger.dto;

import com.example.swagger.domain.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;

    private PostResponse(final Long id,final String title,final String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static PostResponse of(final Post post){
        return new PostResponse(post.getId(),post.getTitle(),post.getContent());
    }
}
