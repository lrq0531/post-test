package com.wptest.postwall.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wptest.postwall.dto.CommentsDto;
import com.wptest.postwall.util.HttpUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public CommentsDto fetchComments() throws IOException {
        String json = HttpUtil.getRequest(CommentService.URL_ALL_COMMENT);
        CommentsDto commentsDto = getComments(json);
        return commentsDto;
    }

    @Override
    public CommentsDto fetchCommentsForPost(Long postId) throws IOException {
        Map<String, String> keyValues = new HashMap<>();
        keyValues.put("postId", String.valueOf(postId));
        String json = HttpUtil.getRequestWithParameters(CommentService.URL_ALL_COMMENT, keyValues);

        return getComments(json);
    }

    private CommentsDto getComments(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CommentsDto commentsDto = new CommentsDto();
        String wrappedJson = "{\"commentList\":"+json+"}";
        commentsDto = mapper.readValue(wrappedJson, CommentsDto.class);
        return commentsDto;
    }
}
