package com.codehacks.blog.blogpost.service;

import com.codehacks.blog.blogpost.dao.BlogPostRepository;
import com.codehacks.blog.blogpost.entities.Author;
import com.codehacks.blog.blogpost.entities.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public void createABlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getBlogPostByTitle(String title) {
        List<BlogPost> allPosts = blogPostRepository.findAll().stream()
                .filter(blog -> blog.getPost().equals(title))
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostsByAuthor(Author author) {
        List<BlogPost> allPosts = blogPostRepository.findAll().stream()
                .filter(blog -> blog.getAuthor().equals(author))
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostByDate(Date dateOfPost) {
        return blogPostRepository.findAll().stream()
                .filter(blog -> blog.getDateOfPost().compareTo(dateOfPost) == 0)
                .collect(Collectors.toList());
    }

    public List<BlogPost> getBlogPostsBetweenDates(Date start, Date end) {
        return blogPostRepository.findAll().stream()
                .filter(blog -> blog.getDateOfPost().after(start))
                .filter(blog -> blog.getDateOfPost().before(end))
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate) {
        return blogPostRepository.findAll().stream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateOfPost().compareTo(startDate) == 0)
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate, Date endDate) {
        return blogPostRepository.findAll().stream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateOfPost().after(startDate))
                .filter(blog -> blog.getDateOfPost().before(endDate))
                .collect(Collectors.toList());
    }

    public void updateBlogContent(BlogPost blogPost) {
        // blogPostRepository
    }

    public void deleteABlogPost(String title) {
        blogPostRepository.deleteBlogPostByTitle(title);
    }
}
