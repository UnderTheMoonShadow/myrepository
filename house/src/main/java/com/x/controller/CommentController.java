package com.x.controller;

import com.x.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/comment")
@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping("/com.do")
    public Map<String, Object> com(Integer id){
        return commentService.com(id);
    }
}
