package com.clinton.cozyblog.blog.controllers;

import com.clinton.cozyblog.blog.exception.ResourceNotFoundException;
import com.clinton.cozyblog.blog.models.Article;
import com.clinton.cozyblog.blog.repositories.ArticleRepository;
import com.clinton.cozyblog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozyBlog")
public class UserController {

    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/")
    public List<Article> getAllArticles(){
        return  articleRepository.findAll();
    }
    //this one will take action when user clicks a specific previewed article
    @GetMapping("/singleArticle/{id}")
    public 
}

