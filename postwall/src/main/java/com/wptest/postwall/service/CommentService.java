package com.wptest.postwall.service;

import com.wptest.postwall.dto.CommentsDto;

import java.io.IOException;

public interface CommentService {
    public static String URL_ALL_COMMENT = "https://jsonplaceholder.typicode.com/comments";
    public static String URL_COMMENT_FOR_POST = "https://jsonplaceholder.typicode.com/comments?postId=";


    public CommentsDto fetchComments() throws IOException;
    public CommentsDto fetchCommentsForPost(Long postId) throws IOException;
}
