package com.wptest.postwall.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Post {

    private long userId;
    private long id;
    private String title;
    private String body;
}
