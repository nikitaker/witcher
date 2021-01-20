package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Monster")
public class Monster {

    @Id
    @Column(name = "monsterName")
    private String monsterName;

    @Column(name = "type_id")
    private int type_id;

    @Column(name = "color")
    private String color;
    
    @Column(name = "height")
    private int height;
    
    @Column(name = "armsNum")
    private int armsNum;
    
    @Column(name = "atack")
    private int atack;
    
    @Column(name = "health")
    private int health;
    

}
