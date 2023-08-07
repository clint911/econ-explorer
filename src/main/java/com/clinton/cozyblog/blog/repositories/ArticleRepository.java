package com.clinton.cozyblog.blog.repositories;

import com.clinton.cozyblog.blog.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article, Long> {
}
