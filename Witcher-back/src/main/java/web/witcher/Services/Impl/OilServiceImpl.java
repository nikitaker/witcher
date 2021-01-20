package web.witcher.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.witcher.Entities.Oil;
import web.witcher.Repositories.OilRepository;
import web.witcher.Services.OilService;


import java.util.List;

@Service
public class OilServiceImpl implements OilService {

    @Autowired
    private OilRepository oilRepository;

    @Override
    public List<Oil> getAll() { return oilRepository.findAll(); }
}
