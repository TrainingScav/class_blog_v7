package com.tenco.blog.board;

import com.tenco.blog.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 클라이언트에게 넘어온 데이터를
 * Object로 변화해서 전달하는 DTO 역할을 담당한다
 */
public class BoardRequest {

    // 게시글 저장 DTO
    @Data
    public static class SaveDTO {
        @NotBlank(message = "제목을 입력 해 주세요.")
        @Size(min = 5, max = 30, message = "제목을 최소 5자 최대 30자로 입력 해주세요.")
        private String title;

        @NotBlank(message = "내용을 입력 해 주세요.")
        @Size(min = 20, max = 200, message = "내용을 최소 20자 최대 200자로 입력 해주세요.")
        private String content;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(this.title)
                    .user(user)
                    .content(this.content)
                    .build();
        }
    }

    // 게시글 수정용 DTO 설계
    @Data
    public static class UpdateDTO {
        @NotBlank(message = "제목을 입력 해 주세요.")
        @Size(min = 5, max = 30, message = "제목을 최소 5자 최대 30자로 입력 해주세요.")
        private String title;

        @NotBlank(message = "내용을 입력 해 주세요.")
        @Size(min = 20, max = 200, message = "내용을 최소 20자 최대 200자로 입력 해주세요.")
        private String content;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(this.title)
                    .user(user)
                    .content(this.content)
                    .build();
        }
    }
}
