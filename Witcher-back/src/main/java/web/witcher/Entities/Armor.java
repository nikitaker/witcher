package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Armor")
public class Armor {

    @Id
    @Column(name = "armorName")
    private String armorName;

    @Column(name = "price")
    private int price;

    @Column(name = "prot")
    private int prot;

}
