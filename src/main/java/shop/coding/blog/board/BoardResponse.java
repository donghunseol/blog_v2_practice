package shop.coding.blog.board;

import lombok.Data;

public class BoardResponse {

    @Data
    public static class SaveDTO{
        private String username;
        private String title;
        private String content;
    }
}
