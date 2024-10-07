package com.server.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity @Builder @Data @AllArgsConstructor @NoArgsConstructor
@DynamicInsert
public class Subscribe {

    @Id
    @Column(name="sub_code")
    @GeneratedValue (strategy = GenerationType.IDENTITY) //추가되자마자 바로 쓰려면
    private int subCode;
    @Column(name="id")
    private String id;
    @Column(name = "channel_code")
    private int channelCode;

}

