package web.witcher.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Armor;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Long> {
}
