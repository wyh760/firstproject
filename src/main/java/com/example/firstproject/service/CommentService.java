package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {

/*******************************************
        // 조회: 댓글 목록
        List<Comment> comments = commentRepository.findByArticleId(articleId);

       // 변환 : 엔티티 -dto
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i =0; i < comments.size(); i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);

        }
        // 반환
        return  dtos;
********************************************************/

        // 반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))      // 엔티티 > Dto 반환
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // 게시글 조회 및 예외처리
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다!") );

        // 댓글 엔티티 조회 (dto -> 엔티티)
        Comment comment = Comment.createComment(dto, article);  // article 본문 있는 기사.  dto : 생성될 댓글

        // 댓글 엔티티를 DB로 저장
        Comment created = commentRepository.save(comment);

        // DTO를 변경하여 반환
        return  CommentDto.createCommentDto(created);
    }

    @Transactional  // 수정 트렌젝션
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회 및 예외처리
        Comment  target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다!") );

        // 댓글 수정
        target.patch(dto) ;  // 기존데이터에  dto 업데이트 될 문을 patch를 통해 업데이트를 한다.

        // 댓글 엔티티를 DB로 저장
        Comment updated = commentRepository.save(target);

        // DTO를 변경하여 반환
        return  CommentDto.createCommentDto(updated);
    }

    @Transactional  // 삭제 트렌젝션.
    public CommentDto delete(Long id) {
        // 대상 찾기
        Comment target = commentRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상 댓글이 없습니다!") );

        //대상 삭제
        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
