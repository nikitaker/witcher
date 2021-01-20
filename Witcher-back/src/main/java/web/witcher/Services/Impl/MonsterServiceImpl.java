package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Monster;
import web.witcher.Repositories.MonsterRepository;
import web.witcher.Services.MonsterService;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public List<Monster> getAll() { return monsterRepository.findAll(); }
}
