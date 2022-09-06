package com.codehacks.blog.services;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.repositories.AuthorRepository;
import com.codehacks.blog.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void createABlogPost(BlogPost blogPost) {
        Author author1 = blogPost.getAuthor();
        authorRepository.save(author1);
        blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    /*
    public BlogPost getBlogPostByTitle(String title) {
        BlogPost allPosts = blogPostRepository.getBlogPostByTitle(title);
        return allPosts;
    }*/

    public List<BlogPost> getBlogPostsByAuthor(Author author) {
        List<BlogPost> allPosts = blogPostRepository.findAll().parallelStream()
                .filter(blog -> blog.getAuthor().equals(author))
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostByDate(Date dateOfPost) {
        Instant currentDate = dateOfPost.toInstant();
        List<BlogPost> allPosts = blogPostRepository.findAll().parallelStream()
                .filter(blog -> blog.getDateCreated().compareTo(currentDate) == 0)
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostsBetweenDates(Date startDate, Date endDate) {
        Instant start = startDate.toInstant();
        Instant end = endDate.toInstant();
        return blogPostRepository.findAll().parallelStream()
                .filter(blog -> blog.getDateCreated().isAfter(start))
                .filter(blog -> blog.getDateCreated().isBefore(end))
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate) {
        Instant currentDate = startDate.toInstant();
        return blogPostRepository.findAll().parallelStream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateCreated().compareTo(currentDate) == 0)
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate, Date endDate) {
        Instant start = startDate.toInstant();
        Instant end = startDate.toInstant();
        return blogPostRepository.findAll().parallelStream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateCreated().isAfter(start))
                .filter(blog -> blog.getDateCreated().isBefore(end))
                .collect(Collectors.toList());
    }

    /*
    @Transactional
    public void updateBlogContent(BlogPost blogPost) {
        BlogPost bgPost = blogPostRepository.getBlogPostByTitle(blogPost.getTitle());
        if (bgPost != null) {
            bgPost.setContent(blogPost.getContent());
            bgPost.setAuthors(blogPost.getAuthors());
            bgPost.setComments(blogPost.getComments());
            blogPostRepository.save(bgPost);
        }
    }

    public void deleteABlogPost(String title) {
        blogPostRepository.deleteBlogPostByTitle(title);
    }*/
}
