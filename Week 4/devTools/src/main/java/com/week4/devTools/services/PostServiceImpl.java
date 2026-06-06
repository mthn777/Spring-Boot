package com.week4.devTools.services;

import com.week4.devTools.dto.PostDTO;
import com.week4.devTools.entities.PostEntity;
import com.week4.devTools.exception.ResourceNotFoundException;
import com.week4.devTools.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostServices{


    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDTO getPostById(Long id) {
        return modelMapper
                .map(postRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Post don't found of Id : " +id))
                ,PostDTO.class);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<PostDTO> allPost = postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .toList();

        return allPost;
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostDTO.class);
    }


}
