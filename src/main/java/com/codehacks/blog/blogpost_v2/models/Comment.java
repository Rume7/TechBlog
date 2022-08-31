package com.codehacks.blog.blogpost_v2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private Long comment_id;
    private String comment;
    private Date dateCreatedComment;
    private String commenterName;

    private Long blog_id;

}
