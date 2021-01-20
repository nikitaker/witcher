package web.witcher.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Oil;

@Repository
public interface OilRepository extends JpaRepository<Oil, String> {

}
