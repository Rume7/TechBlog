package com.codehacks.blog.blogpost_v2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;
    private String comment;
    private Date dateCreatedComment;
    private String commenterName;

    private Long blog_id;

}
