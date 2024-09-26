package com.server.youtube.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.server.youtube.domain.Video;

import java.util.List;

public interface VideoDAO  extends JpaRepository <Video, Integer>{


}
