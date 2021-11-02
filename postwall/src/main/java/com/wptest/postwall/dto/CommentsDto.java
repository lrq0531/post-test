package com.wptest.postwall.dto;

import com.wptest.postwall.model.Comment;
import com.wptest.postwall.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CommentsDto {
    public List<Comment> commentList;
}
