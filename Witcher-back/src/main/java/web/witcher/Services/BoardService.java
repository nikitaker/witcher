package web.witcher.Services;

import web.witcher.Entities.Board;

import java.util.List;


public interface BoardService {

    List<Board> getAll();
    int makeDeal(String witcherName, String otherName);
}
