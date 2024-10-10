package com.server.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity @Builder
@Data @NoArgsConstructor @AllArgsConstructor
@DynamicInsert
public class Video {

    @Id
    @Column(name="video_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoCode;

    @Column(name="video_url")
    private String videoUrl;

    @Column(name="video_img")
    private String videoImg;

    @Column(name="video_title")
    private String videoTitle;

    @Column(name="video_count")
    private int videoCount;

    @Column(name="video_date")
    private LocalDateTime videoDate;

    @Column(name="video_desc")
    private String videoDesc;

    @ManyToOne // 비디오 (many) 채널 (one)
    @JoinColumn(name="channel_code")  // 채널(one)의 Primary key
    private Channel channel;           // 채널 (one)의 객체
}