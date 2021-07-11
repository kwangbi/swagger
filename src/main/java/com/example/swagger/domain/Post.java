package com.example.swagger.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 25)
    private String title;

    @Column(nullable = false,length = 400)
    private String content;

    public Post(final String title,final String content){
        this.title = title;
        this.content = content;
    }

    public Post() {

    }

    public void update(final Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
    }


}
