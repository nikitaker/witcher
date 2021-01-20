package web.witcher.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Sword;

@Repository
public interface SwordRepository extends JpaRepository<Sword, Long> {
}
