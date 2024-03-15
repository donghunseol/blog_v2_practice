package shop.coding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardNativeRepository {
    private final EntityManager em;

    @Transactional
    public void updateById(Integer id, String username, String title, String content){
        Query query = em.createNativeQuery("update board_tb set username=?, title=?, content=? where id =?")
                .setParameter(1, username)
                .setParameter(2, title)
                .setParameter(3, content)
                .setParameter(4, id);
        query.executeUpdate();
    }

    @Transactional
    public void deleteById(Integer id){
        Query query = em.createNativeQuery("delete from board_tb where id = ?").setParameter(1, id);
        query.executeUpdate();
    }

    public Board findById(Integer id){
        Query query = em.createNativeQuery("select  * from board_tb where id = ?", Board.class);
        query.setParameter(1, id);
        return (Board) query.getSingleResult();
    }

    public List<Board> findAll(){
        Query query = em.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return query.getResultList();
    }

    @Transactional
    public void save(BoardRequest.SaveDTO responseDTO){
        Query query = em.createNativeQuery("insert into board_tb(username, title, content, created_at) values (?, ?, ?, now())")
                .setParameter(1, responseDTO.getUsername())
                .setParameter(2, responseDTO.getTitle())
                .setParameter(3, responseDTO.getContent());
        query.executeUpdate();
    }
}
