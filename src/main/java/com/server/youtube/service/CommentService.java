package com.server.youtube.service;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.server.youtube.domain.Comment;
import com.server.youtube.domain.QComment;
import com.server.youtube.repo.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDAO dao;

    @Autowired
    private JPAQueryFactory queryFactory;



    private final QComment qComment = QComment.comment;

    // 댓글 추가
    public Comment create(Comment vo){

       return dao.save(vo);

    }

    // 해당 비디오 별 상위 댓글들  보여주기 -> SQL문 짜보기 !

    /*
    *  SELECT * FROM comment
    * WHERE video_code = 1
    * AND parent_code = null
    * ORDER BY comment_date DESC
    *
    *
    *
    * */
    public List<Comment> getTopComments(int videoCode){
        return queryFactory

                .selectFrom(qComment)
                .where(qComment.videoCode.eq(videoCode))
                .where(qComment.parentCode.eq(0))
                .orderBy(qComment.commentDate.desc())
                .fetch();
    }







}
