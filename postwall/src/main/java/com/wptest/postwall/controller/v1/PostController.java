package com.wptest.postwall.controller.v1;

import com.wptest.postwall.dto.CommentsDto;
import com.wptest.postwall.dto.PostsWithCommentsDto;
import com.wptest.postwall.dto.PostsDto;
import com.wptest.postwall.service.CommentService;
import com.wptest.postwall.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("posts")
    public ResponseEntity<PostsDto> fetchPosts() {

        try {
            PostsDto postsDto = postService.fetchPosts();
            return ResponseEntity.status(HttpStatus.OK).body(postsDto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("comments")
    public ResponseEntity<CommentsDto> fetchComments(@RequestParam(required = false) Long postId) {

        try {
            CommentsDto commentsDto = new CommentsDto();
            if(postId == null) {
                commentsDto = commentService.fetchComments();
            }
            else {
                commentsDto = commentService.fetchCommentsForPost(postId);
            }
            return ResponseEntity.status(HttpStatus.OK).body(commentsDto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("posts-with-comments")
    public ResponseEntity<PostsWithCommentsDto> fetchPostsWithComments() {

        try {
            PostsWithCommentsDto postsDto = postService.fetchAndPopulateComments();

            return ResponseEntity.status(HttpStatus.OK).body(postsDto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

}
