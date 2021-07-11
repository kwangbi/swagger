package com.example.swagger.dto;

import com.example.swagger.domain.Post;
import lombok.Getter;

@Getter
public class PostRequest {

    private String title;
    private String content;

    public Post toEntity(){
        return new Post(this.title,this.content);
    }

}
