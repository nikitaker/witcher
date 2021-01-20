package web.witcher.Services;

import org.springframework.web.bind.annotation.RequestParam;
import web.witcher.Entities.QuestGiver;

import java.util.List;


public interface QuestGiverService {

    List<QuestGiver> getAll();

    List<QuestGiver> newGiver(String questgiverName,
                              String monsterName,
                              int startPrice,
                              int money,
                              int charisma);
}
