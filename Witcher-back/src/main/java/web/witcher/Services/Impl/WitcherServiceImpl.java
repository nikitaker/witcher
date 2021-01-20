package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Sword;
import web.witcher.Entities.Witcher;
import web.witcher.Repositories.SwordRepository;
import web.witcher.Repositories.WitcherRepository;
import web.witcher.Services.SwordService;
import web.witcher.Services.WitcherService;

import java.util.List;

@Service
public class WitcherServiceImpl implements WitcherService {

    @Autowired
    private WitcherRepository witcherRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Witcher> getAll() { return witcherRepository.findAll(); }

    @Override
    public String battle(String witcherName, String monsterName){
        SimpleJdbcCall battleFunc = new SimpleJdbcCall(jdbcTemplate).withFunctionName("battle");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("witcherNameIn", witcherName)
                .addValue("monsterNameIn", monsterName);
        return battleFunc.executeFunction(String.class, in);
    }
}
