package web.witcher.Entities;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Oil")
public class Oil {

    @Id
    @Column(name = "oilName")
    private String oilName;

    @Column(name = "price")
    private String price;

    @Column(name = "atack")
    private String atack;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "typeId")
    private MonsterType monsterType;

}
