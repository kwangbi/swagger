package com.example.swagger.service;

import com.example.swagger.domain.Post;
import com.example.swagger.dto.PostRequest;
import com.example.swagger.dto.PostResponse;
import com.example.swagger.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponse save(final PostRequest postRequest){
        final Post post = postRepository.save(postRequest.toEntity());
        return PostResponse.of(post);
    }

    public List<PostResponse> findAll(){
        final List<Post> posts = postRepository.findAll();
        return posts.stream()
                    .map(PostResponse::of)
                    .collect(Collectors.toList());
    }

    public PostResponse findById(final Long postId){
        final Post post = postRepository.findById(postId)
                                    .orElseThrow(RuntimeException::new);
        return PostResponse.of(post);
    }

    public void update(final Long postId,final PostRequest postRequest){
        final Post post = postRepository.findById(postId)
                            .orElseThrow(RuntimeException::new);
        post.update(post);
    }

    public void delete(final Long postId){
        final Post post = postRepository.findById(postId)
                            .orElseThrow(RuntimeException::new);
        postRepository.delete(post);
    }
}
