package shop.coding.blog.board;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardNativeRepository.class)
@DataJpaTest
public class BoardNativeRepositoryTest {
    @Autowired
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void findById_test(){
        // given
        int id = 1;

        // when
        Board board = boardNativeRepository.findById(id);
        System.out.println(board);

        // then
        Assertions.assertThat(board.getUsername()).isEqualTo("ssar");
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
    }

    @Test
    public void findAll_test(){
        // given

        // when
        List<Board> boardList = boardNativeRepository.findAll();
        System.out.println("findAll_test/size : " + boardList.size());
        System.out.println("findAll_test/First/username : " + boardList.getFirst().getUsername());

        // then
        Assertions.assertThat(boardList.size()).isEqualTo(4);
        Assertions.assertThat(boardList.getFirst().getUsername()).isEqualTo("love");
    }
}
