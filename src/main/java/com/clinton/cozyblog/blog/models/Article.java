package com.clinton.cozyblog.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "article")
public class Article {
       private long articleId;
       private String creatorId;
       private LocalDateTime dateCreated;
       private String articleType; //Tutorials or Design
       private String articleContent;//Just a string of json that will be later worked on the client side

       //use lombok to do the constructors, setters and getters


}
