package com.wptest.postwall.dto;

import com.wptest.postwall.model.Comment;
import com.wptest.postwall.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PostsWithCommentsDto {
    public List<PostWithComments> postList;
    public void addPost(Post post, List<Comment> comments) {
        PostWithComments postWithComments = new PostWithComments(post, comments);
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }

        this.postList.add(postWithComments);
    }

    class PostWithComments {
        public long userId;
        public long id;
        public String title;
        public String body;
        public List<Comment> commentList;

        public PostWithComments (Post post, List<Comment> comments) {
            this.userId=post.getUserId();
            this.id = post.getId();
            this.title = post.getTitle();
            this.body = post.getBody();
            this.commentList = comments;
        }
    }
}
