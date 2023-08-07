package com.clinton.cozyblog.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
 private long commentorId;
 private String textContent;

 private LocalDateTime dateCommented;
 //use lombok for the other lifting
}
