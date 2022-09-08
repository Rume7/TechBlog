package com.codehacks.blog.services;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.models.Comment;
import com.codehacks.blog.repositories.AuthorRepository;
import com.codehacks.blog.repositories.BlogPostRepository;
import com.codehacks.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void createABlogPost(final BlogPost blogPost) {
        blogPost.setDateCreated(Instant.now());
        Author author1 = blogPost.getAuthor();
        List<Comment> allComments = blogPost.getComments();
        allComments.parallelStream()
                .forEach(comment -> comment.setDateCreatedComment(Instant.now()));
        commentRepository.saveAll(allComments);
        authorRepository.save(author1);
        blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostByTitle(final String title) {
        Optional<BlogPost> aPost = getAllBlogPosts().stream()
                .filter(post -> post.getTitle().equalsIgnoreCase(title))
                .findAny();
        return aPost.orElse(new BlogPost());
    }

    public List<BlogPost> getBlogPostsByAuthor(final Author author) {
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

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(final Author author, Date startDate) {
        Instant currentDate = startDate.toInstant();
        return getAllBlogPosts().parallelStream()
                .filter(post -> post.getAuthor().equals(author))
                .filter(blog -> blog.getDateCreated().compareTo(currentDate) == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<BlogPost> getAllBlogPostsByAuthorAndDate(final Author author, Date startDate, Date endDate) {
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
    public void updateBlogContent(final BlogPost blogPost) {
        BlogPost bgPost = getBlogPostByTitle(blogPost.getTitle());
        if (bgPost != null) {
            bgPost.setContent(blogPost.getContent());
            bgPost.setAuthor(blogPost.getAuthor());
            bgPost.setComments(blogPost.getComments());
            blogPostRepository.save(bgPost);
        }
    }

    public void deleteABlogPost(final String title) {
        BlogPost post = getBlogPostByTitle(title);
        if(post != null) {
            blogPostRepository.delete(post);
        }
    }
}
