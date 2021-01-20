package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Sword;
import web.witcher.Repositories.SwordRepository;
import web.witcher.Services.SwordService;

import java.util.List;

@Service
public class SwordServiceImpl implements SwordService {

    @Autowired
    private SwordRepository swordRepository;

    @Override
    public List<Sword> getAll() { return swordRepository.findAll(); }
}
