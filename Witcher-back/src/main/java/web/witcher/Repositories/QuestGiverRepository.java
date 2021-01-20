package web.witcher.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.QuestGiver;
import web.witcher.Repositories.Custom.CustomRepository;

import java.util.List;

@Repository
public interface QuestGiverRepository extends CustomRepository<QuestGiver, String> {


}
