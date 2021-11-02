package com.wptest.postwall.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class Comment {

    private long postId;
    private long id;
    private String name;
    private String email;
    private String body;

    public Comment(Map commentJsonMap) {
        this.postId = (long) commentJsonMap.get("postId");
        this.id = (long) commentJsonMap.get("id");
        this.name = (String) commentJsonMap.get("name");
        this.email = (String) commentJsonMap.get("email");
        this.body = (String) commentJsonMap.get("body");
    }
}
