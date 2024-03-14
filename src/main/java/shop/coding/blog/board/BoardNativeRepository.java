package shop.coding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class BoardNativeRepository {
    private final EntityManager em;

    @Transactional
    public void save(BoardResponse.SaveDTO responseDTO){
        Query query = em.createNativeQuery("insert into board_tb(username, title, content, created_at) values (?, ?, ?, now())")
                .setParameter(1, responseDTO.getUsername())
                .setParameter(2, responseDTO.getTitle())
                .setParameter(3, responseDTO.getContent());
        query.executeUpdate();
    }
}
