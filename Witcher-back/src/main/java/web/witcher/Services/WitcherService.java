package web.witcher.Services;

import web.witcher.Entities.Witcher;

import java.util.List;


public interface WitcherService {

    List<Witcher> getAll();
    String battle(String witcherName, String monsterName);
}
