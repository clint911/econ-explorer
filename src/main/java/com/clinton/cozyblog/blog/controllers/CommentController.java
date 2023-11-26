package com.clinton.cozyblog.blog.controllers;

import com.clinton.cozyblog.blog.exception.ResourceNotFoundException;
import com.clinton.cozyblog.blog.models.Comment;
import com.clinton.cozyblog.blog.repositories.CommentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
  @Autowired
  private CommentRepository commentRepository;
  /*
   * @dev fetching all the comments
   */

  @GetMapping("/comments")
  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  /*
   * @dev Finding a particular comment by its ID
   */
  @GetMapping("/comment/id")
  public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") Long commentId)
      throws ResourceNotFoundException {
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new ResourceNotFoundException("Comment Not found For this Id :: " + commentId));
    return ResponseEntity.ok(comment);
  }

  /*
   * @dev creating a single comment
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
  public Comment createComment(@Valid @RequestBody Comment comment) {
    return commentRepository.save(comment);
  }

  /*
   * this.commentId = commentId;
   * this.commentorId = commentorId;
   * this.textContent = textContent;
   */
  /*
   * @dev updating a comment, well editing it
   */
  @PutMapping("/singleComment/{id}")
  public ResponseEntity<Comment> updateSingleComment(@PathVariable(value = "id") Long commentId,
      @Valid @RequestBody Comment commentDetails) throws ResourceNotFoundException {
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new ResourceNotFoundException("comment not found for this id" + commentId));
    // setting the comment content
    comment.setCommentId(commentDetails.getCommentId());
    comment.setCommentorId(commentDetails.getCommentId());
    comment.setTextContent(commentDetails.getTextContent());
    final Comment updatedSingleComment = commentRepository.save(comment);
    return ResponseEntity.ok(updatedSingleComment);
  }

}
