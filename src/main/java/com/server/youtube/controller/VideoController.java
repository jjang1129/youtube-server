package com.server.youtube.controller;


import com.server.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins ={"*"}, maxAge = 6000)
public class VideoController {

   @Autowired
   private VideoService service;

    @GetMapping("/video")
    public ResponseEntity viewAll(){

        System.out.println("asd1112111");
        return ResponseEntity.status(HttpStatus.OK).body(service.viewAll());
    }




}
