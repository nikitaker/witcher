package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Potion;
import web.witcher.Repositories.PotionRepository;
import web.witcher.Services.PotionService;

import java.util.List;

@Service
public class PotionServiceImpl implements PotionService {

    @Autowired
    private PotionRepository potionRepository;

    @Override
    public List<Potion> getAll() { return potionRepository.findAll(); }
}
