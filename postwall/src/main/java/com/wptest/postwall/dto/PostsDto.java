package com.wptest.postwall.dto;

import com.wptest.postwall.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PostsDto {
    public List<Post> postList;
}
