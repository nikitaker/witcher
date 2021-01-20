package web.witcher.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
