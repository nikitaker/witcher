package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Board;
import web.witcher.Repositories.BoardRepository;
import web.witcher.Services.BoardService;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Board> getAll() { return boardRepository.findAll(); }

    @Override
    public int makeDeal(String witcherName, String otherName){
        SimpleJdbcCall makeDealFunc = new SimpleJdbcCall(jdbcTemplate).withFunctionName("makeDeal");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("witcherNameIn", witcherName)
                .addValue("questgiverName", otherName);
        return makeDealFunc.executeFunction(int.class, in);
    }
}
