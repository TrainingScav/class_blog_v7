package com.tenco.blog.reply;

import com.tenco.blog._core.errors.exception.Exception400;
import com.tenco.blog.board.Board;
import com.tenco.blog.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class ReplyRequest {

    @Data
    public static class SaveDTO {
        @NotBlank(message = "게시물 ID가 필요합니다.")
        private Long boardId; // 댓글이 달릴 게시글 ID

        @NotBlank(message = "내용을 입력 해 주세요.")
        @Size(min = 20, max = 100, message = "내용을 최소 20자 최대 100자로 입력 해주세요.")
        private String comment; // 댓글 내용

        public Reply toEntity(User sessionUser, Board board) {
            return Reply.builder()
                    .comment(comment.trim())
                    .user(sessionUser)
                    .board(board)
                    .build();
        }

    }

}
