package com.clinton.cozyblog.blog.models;

import com.clinton.cozyblog.blog.controllers.ArticleTypes;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "article")
public class Article {
       @Id
       @GeneratedValue(strategy = IDENTITY)
       private long articleId;
       @Column (name="creator_id", nullable=false)
       private long creatorId;

       @Enumerated(EnumType.STRING)
       @Column(name = "article_types", nullable = false)
       private ArticleTypes articleType;
       //{Tutorial,Design,Other};
       @Column (name = "article_content", nullable = false)
       private String articleContent;//Just a string of json that will be later worked on the client side
       @CreatedDate
       private LocalDateTime dateCreated;
       @UpdateTimestamp
       private LocalDateTime lastUpdated;
       //use lombok to do the constructors, setters and getters --You can't afford to download the dependencies so you might as well code them up yourself
       //Default no args constructor
       public Article() {};
       //Our constructor dictating the way we want to be on initialization
       public Article(long articleId, long creatorId, ArticleTypes articleType, String articleContent) {
              this.articleId = articleId;
              this.creatorId = creatorId;
              this.articleType = articleType;
              this.articleContent = articleContent;
       }


       public long getArticleId() {
              return articleId;
       }

       public void setArticleId(long articleId) {
              this.articleId = articleId;
       }

       public long getCreatorId() {
              return creatorId;
       }

       public void setCreatorId(long creatorId) {
              this.creatorId = creatorId;
       }

       public ArticleTypes getArticleType() {
              return articleType;
       }

       public void setArticleType(ArticleTypes articleType) {
              this.articleType = articleType;
       }

       public String getArticleContent() {
              return articleContent;
       }

       public void setArticleContent(String articleContent) {
              this.articleContent = articleContent;
       }

       @Override
       public String toString() {
              return "Article [id=" + articleId + ",  creatorId=" + creatorId + ", articleType=" + articleType + ", articleContent=" + articleContent + "]";

       }}
