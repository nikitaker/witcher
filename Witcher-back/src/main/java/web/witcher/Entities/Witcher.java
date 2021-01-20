package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Witcher")
public class Witcher {

    @Id
    @Column(name = "witcherName")
    private String witcherName;

    @Column(name = "armorName")
    private String armorName;
    
    @Column(name = "swordName")
    private String swordName;

    @Column(name = "potionName")
    private String potionName;
    
    @Column(name = "oilName")
    private String oilName;
    
    @Column(name = "health")
    private int health;
    
    @Column(name = "money")
    private int money;
    
    @Column(name = "charisma")
    private int charisma;
    
    @Column(name = "locationName")
    private String locationName;
}
