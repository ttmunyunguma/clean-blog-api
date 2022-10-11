package com.example.cleanblog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postedBy;
    private LocalDateTime postedDate;
    @Column(nullable = false)
    private String heading;
    @Column(nullable = false, unique = true)
    private String slug;
    private String subHeading;
    @Column(length = 5000)
    private String postBody;
}
