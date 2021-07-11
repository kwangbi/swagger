package com.example.swagger.controller;


import com.example.swagger.dto.PostRequest;
import com.example.swagger.dto.PostResponse;
import com.example.swagger.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/posts")
@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> save(@RequestBody final PostRequest postRequest){
        final PostResponse postResponse = postService.save(postRequest);
        return ResponseEntity.created(URI.create("/posts" + postResponse.getId())).body(postResponse);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> findById(@PathVariable final Long postId){
        return ResponseEntity.ok(postService.findById(postId));
    }

    @PutMapping("{postId}")
    public ResponseEntity<Void> update(@PathVariable final Long postId,@RequestBody final PostRequest postRequest){
        postService.update(postId,postRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable final Long postId){
        postService.delete(postId);
        return ResponseEntity.ok().build();
    }

}
