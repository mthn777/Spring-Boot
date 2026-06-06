package com.week4.devTools.services;

import com.week4.devTools.dto.PostDTO;

import java.util.List;

public interface PostServices {

    PostDTO getPostById(Long id);

    List<PostDTO> getAllPost();

    PostDTO createNewPost(PostDTO postDTO);
}
