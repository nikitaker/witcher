package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "QuestGiver")
public class QuestGiver {

    @Id
    @Column(name = "questGiver")
    private String questGiver;

    @Column(name = "monsterName")
    private String monsterName;

    @Column(name = "startPrice")
    private int startPrice;
    
    @Column(name = "money")
    private int money;

    @Column(name = "charisma")
    private int charisma;
}
