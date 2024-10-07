package com.server.youtube.service;


import com.server.youtube.domain.Subscribe;
import com.server.youtube.repo.SubscribeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    @Autowired
    private SubscribeDAO dao;

    // 구독 추가

    public void create(Subscribe vo){
        dao.save(vo);

    }

    // 구독 취소
    public void remove(int subCode){
        dao.deleteById(subCode);
    }

    //해당 채널의  구독자 수 가져오기
    public int count(int channelCode){

      return dao.count(channelCode);
    }

    public int findSub(Subscribe vo){

        List<Integer> num = dao.findSub(vo.getChannelCode() , vo.getId());
        if(num.size() > 0) {
            int num2 = num.get(0);
            return num2;
        }
        return  0;
    }

}
