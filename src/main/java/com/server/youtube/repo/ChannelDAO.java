package com.server.youtube.repo;

import com.server.youtube.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelDAO extends JpaRepository<Channel, Integer> {


}
