package com.codehacks.blog.services;

import com.codehacks.blog.models.Comment;

import java.util.List;

public interface BlogPostAnalyticsInterface {

    public Integer getNumberOfCommentsPerBlogPost(String title);

    public Integer getNumberOfCommentsForAllBlogPosts();

    public List<Comment> getCommentsForABlogPost(String title);

    public Integer getStarRatingForABlogPost(String title);

}
