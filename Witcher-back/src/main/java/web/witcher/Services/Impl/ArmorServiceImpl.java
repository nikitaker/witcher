package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Armor;
import web.witcher.Repositories.ArmorRepository;
import web.witcher.Services.ArmorService;

import java.util.List;

@Service
public class ArmorServiceImpl implements ArmorService {

    @Autowired
    private ArmorRepository armorRepository;

    @Override
    public List<Armor> getAll() {
        return armorRepository.findAll();
    }
}
