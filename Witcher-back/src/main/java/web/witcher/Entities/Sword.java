package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Sword")
public class Sword {

    @Id
    @Column(name = "swordName")
    private String swordName;

    @Column(name = "price")
    private int price;

    @Column(name = "atack")
    private int atack;

}
