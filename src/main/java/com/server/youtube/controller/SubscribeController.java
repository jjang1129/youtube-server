package com.server.youtube.controller;

import com.server.youtube.domain.Subscribe;
import com.server.youtube.repo.SubscribeDAO;
import com.server.youtube.service.SubscribeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class SubscribeController {

    @Autowired
    private SubscribeService service;




    // 구독
    @PostMapping("/sub")
    public ResponseEntity create(@RequestBody  Subscribe vo){
                                 // JSON 방식으로 받게 될거임 그러면 Request BOdy 명시
        System.out.println("구독 컨트롤러 연결!");
        service.create(vo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // 구독취소
    @DeleteMapping("/sub/{subCode}")
    public ResponseEntity remove(@PathVariable(name="subCode") int subCode){

        service.remove(subCode);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // 구독자수 불러오기

    @GetMapping("/sub/{channelCode}/count")
    public ResponseEntity count(@PathVariable(name="channelCode") int channelCode){

        return ResponseEntity.ok(service.count(channelCode));
    }

    // 구독여부확인

    @GetMapping("/sub")
    public ResponseEntity sub(@RequestParam(name = "id", required = false) String id,@RequestParam(name = "channelCode", required = false) int channelCode ){
        Subscribe sub = Subscribe.builder().id(id).channelCode(channelCode).build();
        log.info("객체 : " + sub);
        int num = service.findSub(sub);
        log.info("해당유저가 구독했다면 구독코드 : " + num );
        return  ResponseEntity.ok(num);
    }






}
