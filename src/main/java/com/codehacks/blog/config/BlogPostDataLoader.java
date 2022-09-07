package com.codehacks.blog.config;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.models.Comment;
import com.codehacks.blog.repositories.CommentRepository;
import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogPostDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(BlogPost.class);

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (blogPostService.getAllBlogPosts().size() == 0) {
            Comment comment1 = new Comment("Your application runs well", "Gary Smith");
            Comment comment2 = new Comment("Your application needs a change.", "Susan Boyle");
            List<Comment> commentList1 = List.of(comment1, comment2);
            BlogPost post1 = new BlogPost("Concurrency", "Learning multithreading",
                    new Author("Wale", "Thompson", "walethompson@gmail.com"));
            post1.setComments(commentList1);


            Comment comment3 = new Comment("Review your system design.", "Glen Abey");
            Comment comment4 = new Comment("Let's do pair programming.", "Sandra Clark");
            List<Comment> commentList2 = List.of(comment3, comment4);
            BlogPost post2 = new BlogPost("Threads", "coding threads in java 6",
                    new Author("Sally", "Graham", "sally_graham@gmail.com"));
            post2.setComments(commentList2);


            BlogPost post3 = new BlogPost("Itext", "programming in pdf",
                    new Author("Barry", "White", "barry@yahoo.com"));

            BlogPost post4 = new BlogPost("Spring Actions", "Aspect oriented programming",
                    new Author("Samantha", "Booke", "booke@hotmail.com"));

            commentRepository.save(comment1);
            commentRepository.save(comment2);
            commentRepository.save(comment3);
            commentRepository.save(comment4);

            blogPostService.createABlogPost(post1);
            blogPostService.createABlogPost(post2);
            blogPostService.createABlogPost(post3);
            blogPostService.createABlogPost(post4);
        }
        logger.info("Number of BlogPost items: {}", blogPostService.getAllBlogPosts().size());
    }
}
