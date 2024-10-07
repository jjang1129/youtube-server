package com.server.youtube.service;

import com.server.youtube.repo.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.server.youtube.domain.Member;



@Service
public class MemberService {

    @Autowired
    private MemberDAO dao;

    @Autowired
    private PasswordEncoder bcpe;

    public  void signup (Member vo){
        vo.setPassword(bcpe.encode(vo.getPassword())); // 기존 비밀번호를 인코딩한후 다시 저장

        dao.save(vo);
    }

    public Member login(String id , String password){

        // 아이디로 해당 회원이 있는지 먼저 체크 !  없으면 오류로 던져버리기
        Member member = dao.findById(id).orElseThrow(()->new UsernameNotFoundException("Member Not Found"));

        // 입력한 비밀번호와 암호화된 비밀번호를 매치 시킨다
        if(bcpe.matches(password, member.getPassword())){
            return member;
        }
        return null;

    }
}
