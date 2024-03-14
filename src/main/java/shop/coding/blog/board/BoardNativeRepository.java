package shop.coding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardNativeRepository {
    private final EntityManager em;

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
    public void save(BoardResponse.SaveDTO responseDTO){
        Query query = em.createNativeQuery("insert into board_tb(username, title, content, created_at) values (?, ?, ?, now())")
                .setParameter(1, responseDTO.getUsername())
                .setParameter(2, responseDTO.getTitle())
                .setParameter(3, responseDTO.getContent());
        query.executeUpdate();
    }
}
