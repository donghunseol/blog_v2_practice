package shop.coding.blog.board;

import lombok.Data;

public class BoardRequest {

    @Data
    public static class UpdateDTO{
        private String username;
        private String title;
        private String content;
    }

    @Data
    public static class SaveDTO{
        private String username;
        private String title;
        private String content;
    }
}
