package web.witcher.Repositories;

import org.springframework.stereotype.Repository;
import web.witcher.Entities.Witcher;
import web.witcher.Repositories.Custom.CustomRepository;

@Repository
public interface WitcherRepository extends CustomRepository<Witcher, Long> {

}
