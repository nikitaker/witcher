package web.witcher.Entities;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Potion")
public class Potion {

    @Id
    @Column(name = "potionName")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "prot")
    private String prot;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "typeId")
    private MonsterType monsterType;

}
