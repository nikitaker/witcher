package web.witcher.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Potion;
import web.witcher.Repositories.Custom.CustomRepository;

import java.util.List;

@Repository
public interface PotionRepository extends CustomRepository<Potion, String> {

}
