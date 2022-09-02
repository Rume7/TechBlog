package com.codehacks.blog.services;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogPostService {

    // TODO : Implement all CRUD operations

    @Autowired
    private BlogPostRepository blogPostRepository;

    public void createABlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getBlogPostByTitle(String title) {
        return null;
        /*
        List<BlogPost> allPosts = blogPostRepository.findAll().stream()
                .filter(blog -> blog.getPost().equals(title))
                .collect(Collectors.toList());
        return allPosts;
         */
    }

    public List<BlogPost> getBlogPostsByAuthor(Author author) {
        /*
        List<BlogPost> allPosts = blogPostRepository.findAll().stream()
                .filter(blog -> blog.getAuthor().equals(author))
                .collect(Collectors.toList());
        return allPosts;
         */
        return null;
    }

    public List<BlogPost> getBlogPostByDate(Date dateOfPost) {
        return null;
        /*
        return blogPostRepository.findAll().stream()
                .filter(blog -> blog.getDateOfPost().compareTo(dateOfPost) == 0)
                .collect(Collectors.toList());
                */
    }

    public List<BlogPost> getBlogPostsBetweenDates(Date start, Date end) {
        return null;
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate) {
        /*
        return blogPostRepository.findAll().stream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateOfPost().compareTo(startDate) == 0)
                .collect(Collectors.toList());
         */
        return null;
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate, Date endDate) {
        /*
        return blogPostRepository.findAll().stream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateOfPost().after(startDate))
                .filter(blog -> blog.getDateOfPost().before(endDate))
                .collect(Collectors.toList());

         */
        return null;
    }

    public void updateBlogContent(BlogPost blogPost) {
        // blogPostRepository
    }

    public void deleteABlogPost(String title) {
        blogPostRepository.deleteBlogPostByTitle(title);
    }
}
