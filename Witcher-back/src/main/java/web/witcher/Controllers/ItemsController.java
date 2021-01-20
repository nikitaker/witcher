package web.witcher.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.witcher.Entities.Armor;
import web.witcher.Entities.Oil;
import web.witcher.Entities.Potion;
import web.witcher.Entities.Sword;
import web.witcher.Services.ArmorService;
import web.witcher.Services.OilService;
import web.witcher.Services.PotionService;
import web.witcher.Services.SwordService;

import java.util.List;

@CrossOrigin
@RestController
public class ItemsController {

    @Autowired
    private ArmorService armorService;

    @Autowired
    private SwordService swordService;

    @Autowired
    private PotionService potionService;

    @Autowired
    private OilService oilService;

    @GetMapping("/armor")
    public ResponseEntity<List<Armor>> getArmor(){
        return new ResponseEntity<>(armorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/sword")
    public ResponseEntity<List<Sword>> getSword(){
        return new ResponseEntity<>(swordService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/potion")
    public ResponseEntity<List<Potion>> getPoiton(){
        return new ResponseEntity<>(potionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/oil")
    public ResponseEntity<List<Oil>> getOil(){
        return new ResponseEntity<>(oilService.getAll(), HttpStatus.OK);
    }
}
