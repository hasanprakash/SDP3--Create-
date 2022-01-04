package com.sdp.sdp3.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    @Column(name = "image_name")
    private String imageName;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "author_name", nullable = true)
    private String authorName;
    @Column(name = "hash_tags", nullable = true)
    @Convert(converter = StringListConverter.class)
    private List<String> hash_tags;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime localDateTime;
}
