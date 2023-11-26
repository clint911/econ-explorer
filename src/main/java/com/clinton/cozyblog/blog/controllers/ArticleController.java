package com.clinton.cozyblog.blog.controllers;

import com.clinton.cozyblog.blog.exception.ResourceNotFoundException;
import com.clinton.cozyblog.blog.models.Article;
import com.clinton.cozyblog.blog.repositories.ArticleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cozyBlog")
public class ArticleController {

    /*
    * @Tutorials: Handles get of that page --returns articles of type Tutorial
    * @Each of the controllers for the others follow the above naming and ordering convention
     */
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/")
    public List<Article> getAllArticles(){
        return  articleRepository.findAll();
    }
    /*
    *The below two controller routes handle searching articles by category. This can be handling the Tutorials page,
    * Design page, fix to handle the pages
     */
    @GetMapping("/Tutorials")
    public List<Article> getAllArticlesByTypeTutorials() {
        return articleRepository.findByType(ArticleTypes.Tutorials);
    }
    @GetMapping("/DesignTools")
    public List<Article> getAllArticlesByTypeDesign() {
        return articleRepository.findByType(ArticleTypes.DesignTools);
    }


    //this one will take action when user clicks a specific previewed article
    @GetMapping("/singleArticle/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "id")Long articleId)
        throws ResourceNotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article Not Found For this Id :: " + articleId));
        return ResponseEntity.ok().body(article);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/articles",produces = MediaType.APPLICATION_JSON_VALUE)
    public Article createArticle(@Valid @RequestBody Article article) {
    return  articleRepository.save(article);
    }
    @PutMapping("/singleArticle/{id}")
    public ResponseEntity<Article> updateSingleArticle(@PathVariable(value = "id")Long articleId,
                                                       @Valid @RequestBody Article articleDetails) throws ResourceNotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found for this Id :: " + articleId));
        //some code will go here
        article.setArticleId(articleDetails.getArticleId());
        article.setCreatorId(articleDetails.getCreatorId());
        article.setArticleType(articleDetails.getArticleType());
        article.setArticleContent(articleDetails.getArticleContent());

        final Article updatedSingleArticle = articleRepository.save(article);
        return  ResponseEntity.ok(updatedSingleArticle);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)/* ensures that the responses' http status is 204 (NO CONTENT) and there is absolutely no need to revert any data to the client for a deleted article */
    @DeleteMapping("/singleArticle/{id}")
    public Map<String, Boolean> deleteSingleArticle(@PathVariable(value = "articleId")Long articleId)
        throws  ResourceNotFoundException {
                 Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Article Not Found for this id" + articleId));

        articleRepository.delete(article);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }

}

