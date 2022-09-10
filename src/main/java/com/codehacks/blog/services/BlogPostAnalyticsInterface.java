package com.codehacks.blog.services;

import com.codehacks.blog.models.Comment;

import java.util.List;
import java.util.Map;

public interface BlogPostAnalyticsInterface {

    public Map<String, List<Comment>> getCommentsForAllBlogPosts();

    public Map<String, Integer> getNumberOfCommentsForAllBlogPosts();

    public Double getAverageStarRatingForABlogPost(String title);

}
