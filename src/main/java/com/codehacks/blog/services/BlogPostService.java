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
        return blogPostRepository.findAll().stream().toList();
    }

    public List<BlogPost> getBlogPostByTitle(String title) {
        List<BlogPost> allPosts = getAllBlogPosts().parallelStream()
                .filter(post -> post.getTitle().equalsIgnoreCase(title))
                .sorted()
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostsByAuthor(Author author) {
        List<BlogPost> allPosts = getAllBlogPosts().parallelStream()
                .filter(blog -> blog.getAuthor().equals(author))
                .sorted()
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostByDate(Date dateOfPost) {
        Instant currentDate = dateOfPost.toInstant();
        List<BlogPost> allPosts = getAllBlogPosts().parallelStream()
                .filter(blog -> blog.getDateCreated().compareTo(currentDate) == 0)
                .sorted()
                .collect(Collectors.toList());
        return allPosts;
    }

    public List<BlogPost> getBlogPostsBetweenDates(Date startDate, Date endDate) {
        Instant start = startDate.toInstant();
        Instant end = endDate.toInstant().plusSeconds(24*60*60);
        return getAllBlogPosts().parallelStream()
                .filter(blog -> blog.getDateCreated().isAfter(start))
                .filter(blog -> blog.getDateCreated().isBefore(end))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate) {
        Instant currentDate = startDate.toInstant();
        return getAllBlogPosts().parallelStream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateCreated().compareTo(currentDate) == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(Author author, Date startDate, Date endDate) {
        Instant start = startDate.toInstant();
        Instant end = startDate.toInstant().plusSeconds(24*3600);
        return getAllBlogPosts().parallelStream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateCreated().isAfter(start))
                .filter(blog -> blog.getDateCreated().isBefore(end))
                .sorted()
                .collect(Collectors.toList());
    }


    @Transactional
    public void updateBlogContent(BlogPost blogPost) {
        BlogPost bgPost = getBlogPostByTitle(blogPost.getTitle())
                            .stream()
                            .filter(author -> blogPost.getAuthor().equals(author))
                            .findFirst()
                            .get();
        if (bgPost != null) {
            bgPost.setContent(blogPost.getContent());
            bgPost.setAuthor(blogPost.getAuthor());
            bgPost.setComments(blogPost.getComments());
            blogPostRepository.save(bgPost);
        }
    }

    public void deleteABlogPost(String title) {
        BlogPost post = getBlogPostByTitle(title).stream().findAny().orElse(null);
        if(post != null) {
            blogPostRepository.delete(post);
        }
    }
}
