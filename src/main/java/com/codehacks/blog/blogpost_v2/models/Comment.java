package com.codehacks.blog.blogpost_v2.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name="Comments")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Input comment")
    private String comment;

    private Instant dateCreatedComment;

    @NotBlank
    private String commenterName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blogpost_id")
    private Long blog_id;

    public Comment(String comment, String commenterName) {
        this.comment = comment;
        this.dateCreatedComment = Instant.now();
        this.commenterName = commenterName;
    }
}
