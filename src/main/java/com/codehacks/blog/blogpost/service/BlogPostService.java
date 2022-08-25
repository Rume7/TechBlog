package com.codehacks.blog.blogpost.service;

import com.codehacks.blog.blogpost.dao.BlogPostRepository;
import com.codehacks.blog.blogpost.entities.Author;
import com.codehacks.blog.blogpost.entities.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public void getBlogPostByTitle(String title) {}

    public List<BlogPost> getBlogPostsByAuthor(Author author){ return null;}

    public List<BlogPost> getBlogPostByDate(Date dateOfPost){ return null;}

    public List<BlogPost> getBlogPostsBetweenDates(Date start, Date end){ return null;}

    public List<BlogPost> getAllBlogPosts() { return null; }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate) { return null; }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate, Date endDate) { return null; }

}
