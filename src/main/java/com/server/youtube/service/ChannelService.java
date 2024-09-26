package com.server.youtube.service;


import com.server.youtube.domain.Channel;
import com.server.youtube.repo.ChannelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelDAO dao;

    public List<Channel> viewAll(){

        return dao.findAll();
    }

}
