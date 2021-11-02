package com.wptest.postwall.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wptest.postwall.dto.CommentsDto;
import com.wptest.postwall.dto.PostsDto;
import com.wptest.postwall.dto.PostsWithCommentsDto;
import com.wptest.postwall.model.Comment;
import com.wptest.postwall.model.Post;
import com.wptest.postwall.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private CommentService commentService;

    @Override
    public PostsDto fetchPosts() throws IOException {
        String json = HttpUtil.getRequest(PostService.URL_ALL_POSTS);

        String wrappedJson = "{\"postList\":"+json+"}";

        ObjectMapper mapper = new ObjectMapper();
        PostsDto postsDto = new PostsDto();
        postsDto = mapper.readValue(wrappedJson, PostsDto.class);
        return postsDto;
    }

    @Override
    public PostsWithCommentsDto fetchAndPopulateComments() throws IOException {
        PostsDto posts = fetchPosts();
        CommentsDto comments = commentService.fetchComments();
        Map<Long, List<Comment>> comentsByPostId = comments.commentList.stream()
                .collect(Collectors.groupingBy(Comment::getPostId));
        PostsWithCommentsDto dto = new PostsWithCommentsDto();

        for (Post post: posts.postList) {
            List<Comment> commentsForPost = comentsByPostId.get(post.getId());
            dto.addPost(post, commentsForPost);
        }

        return dto;

    }
}
