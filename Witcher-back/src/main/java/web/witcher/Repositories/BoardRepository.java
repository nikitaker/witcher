package web.witcher.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
}
