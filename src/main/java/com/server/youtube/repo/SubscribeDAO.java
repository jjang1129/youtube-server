package com.server.youtube.repo;

import com.server.youtube.domain.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SubscribeDAO extends JpaRepository<Subscribe, Integer> {
     // 해당 채널의 구독자 수
    // SELECT count(*) FROM subscribe WHERE channel_code = :channelCode
    @Query(value = "SELECT count(*) FROM subscribe WHERE channel_code = :channelCode", nativeQuery = true)
    int count(@Param("channelCode") int channelCode); // 받아오는값 @Param으로 명시해주기

    @Query(value = "SELECT sub_code FROM subscribe WHERE channel_code = :channelCode AND id = :id", nativeQuery = true)
    List<Integer> findSub(@Param("channelCode") int channelCode, @Param("id") String id);

}
