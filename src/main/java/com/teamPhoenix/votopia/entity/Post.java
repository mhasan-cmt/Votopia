package com.teamPhoenix.votopia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postID;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "post_description")
    private String description;
}

