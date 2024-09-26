package com.server.youtube.controller;


import com.server.youtube.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/channel/*")
public class ChannelController {

    @Autowired
    private ChannelService service;

    @GetMapping("/channel")
    public ResponseEntity viewAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.viewAll());
    }
}
