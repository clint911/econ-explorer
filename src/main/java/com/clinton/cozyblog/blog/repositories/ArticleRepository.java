package com.clinton.cozyblog.blog.repositories;

import com.clinton.cozyblog.blog.controllers.ArticleTypes;
import com.clinton.cozyblog.blog.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import  java.util.List;

public interface ArticleRepository  extends JpaRepository<Article, Long> {
 //If this doesn't work remove this code inside it worked well without it
 List<Article> findByType(ArticleTypes type);
}
