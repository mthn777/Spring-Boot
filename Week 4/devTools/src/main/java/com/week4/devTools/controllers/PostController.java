package com.week4.devTools.controllers;

import com.week4.devTools.dto.PostDTO;
import com.week4.devTools.repositories.PostRepository;
import com.week4.devTools.services.PostServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    private final PostServices postServices;

    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }

    @GetMapping(path = "{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable (name = "postId") Long id){
        return new ResponseEntity<>(postServices.getPostById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPost(){
        return new ResponseEntity<>(postServices.getAllPost(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postServices.createNewPost(postDTO), HttpStatus.CREATED) ;
    }


}
