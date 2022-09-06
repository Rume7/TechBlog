package com.codehacks.blog.config;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.models.BlogPost;
import com.codehacks.blog.services.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BlogPostDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(BlogPost.class);

    @Autowired
    private BlogPostService blogPostService;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (blogPostService.getAllBlogPosts().size() == 0) {
            BlogPost post1 = new BlogPost("Concurrency", "Learning multithreading",
                    new Author("Wale", "Thompson", "walethompson@gmail.com"));

            BlogPost post2 = new BlogPost("Threads", "coding threads in java 6",
                    new Author("Sally", "Graham", "sally_graham@gmail.com"));

            BlogPost post3 = new BlogPost("Itext", "programming in pdf",
                    new Author("Barry", "White", "barry@yahoo.com"));

            BlogPost post4 = new BlogPost("Spring Actions", "Aspect oriented programming",
                    new Author("Samantha", "Booke", "booke@saphire.com"));

            blogPostService.createABlogPost(post1);
            blogPostService.createABlogPost(post2);
            blogPostService.createABlogPost(post3);
            blogPostService.createABlogPost(post4);
        }
        logger.info("Number of BlogPost items: {}", blogPostService.getAllBlogPosts().size());
    }
}
