package com.clinton.cozyblog.blog.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long commentId;
@Column(name = "commentor_id", nullable = false)
 private long commentorId;
@Column(name = "text_content", nullable = false)
 private String textContent;


 @CreatedDate
 private LocalDateTime dateCommented;
 @UpdateTimestamp
 private LocalDateTime lastUpdated;
 public Comment(){};
 public Comment(long commentId, long commentorId, String textContent) {
  this.commentId = commentId;
  this.commentorId = commentorId;
  this.textContent = textContent;
 }
 private  long getCommentId() {
  return  commentId;
 }
 private void setCommentId(long commentId) {
  this.commentId = commentId;
 }

 public long getCommentorId() {
  return commentorId;
 }

 public void setCommentorId(long commentorId) {
  this.commentorId = commentorId;
 }

 public String getTextContent() {
  return textContent;
 }

 public void setTextContent(String textContent) {
  this.textContent = textContent;
 }
 @Override
 public String toString() {
  return "Comment [id=" + commentId + ", commentorId=" + commentorId + ", + textContent=" + textContent + "]";

 }
}
