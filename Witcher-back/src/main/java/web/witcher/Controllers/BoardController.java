package web.witcher.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.witcher.Entities.*;
import web.witcher.Services.*;

import java.util.List;

@CrossOrigin
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private WitcherService witcherService;

    @Autowired
    private QuestGiverService questGiverService;

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/board")
    public ResponseEntity<List<Board>> getBoard(){
        return new ResponseEntity<>(boardService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/witcher")
    public ResponseEntity<List<Witcher>> getWitcher(){
        return new ResponseEntity<>(witcherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/monster")
    public ResponseEntity<List<Monster>> getMonster(){
        return new ResponseEntity<>(monsterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/battle")
    public ResponseEntity<String> battle(@RequestParam("witcherName") String witcherName, @RequestParam("monsterName") String otherName){
        if (witcherName.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (otherName.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(witcherService.battle(witcherName, otherName), HttpStatus.OK);
    }

    @GetMapping("/questgiver")
    public ResponseEntity<List<QuestGiver>> getQuestgiver(){
        return new ResponseEntity<>(questGiverService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/newquestgiver")
    public ResponseEntity<List<QuestGiver>> newquestgiver(@RequestParam("questgiverName") String questgiverName,
                                                @RequestParam("monsterName") String monsterName,
                                                @RequestParam("startPrice") int startPrice,
                                                @RequestParam("money") int money,
                                                @RequestParam("charisma") int charisma){
        if (questgiverName.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (monsterName.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(questGiverService.newGiver(questgiverName, monsterName, startPrice, money, charisma), HttpStatus.OK);
    }

    @GetMapping("/makeDeal")
    public ResponseEntity<Integer> makeDeal(@RequestParam("witcherName") String witcherName, @RequestParam("otherName") String otherName){
        if (witcherName.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if (otherName.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Integer>(boardService.makeDeal(witcherName, otherName), HttpStatus.OK);
    }
}
