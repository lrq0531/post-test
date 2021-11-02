package com.wptest.postwall.service;

import com.wptest.postwall.dto.PostsDto;
import com.wptest.postwall.dto.PostsWithCommentsDto;

import java.io.IOException;

public interface PostService {
    public static String URL_ALL_POSTS = "https://jsonplaceholder.typicode.com/posts";


    public PostsDto fetchPosts() throws IOException;
    public PostsWithCommentsDto fetchAndPopulateComments() throws IOException;
}
