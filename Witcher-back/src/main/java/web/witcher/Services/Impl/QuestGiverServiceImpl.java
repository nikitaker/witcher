package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import web.witcher.Entities.QuestGiver;
import web.witcher.Entities.Sword;
import web.witcher.Repositories.QuestGiverRepository;
import web.witcher.Repositories.SwordRepository;
import web.witcher.Services.QuestGiverService;
import web.witcher.Services.SwordService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestGiverServiceImpl implements QuestGiverService {

    @Autowired
    private QuestGiverRepository questGiverRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<QuestGiver> getAll() { return questGiverRepository.findAll(); }
    @Override
    public List<QuestGiver> newGiver(String questgiverName,
                              String monsterName,
                              int startPrice,
                              int money,
                              int charisma){
        SimpleJdbcInsert insertGiver = new SimpleJdbcInsert(jdbcTemplate).withTableName("questgiver");
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("questgiver", questgiverName);
        parameters.put("monstername", monsterName);
        parameters.put("startprice", startPrice);
        parameters.put("money", money);
        parameters.put("charisma", charisma);

        insertGiver.execute(parameters);
        return questGiverRepository.findAll();
    };
}
