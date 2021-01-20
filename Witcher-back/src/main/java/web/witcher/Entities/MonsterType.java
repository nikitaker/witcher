package web.witcher.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MonsterType")
public class MonsterType {

    @Id
    @Column(name = "typeId")
    private int typeId;

    @Column(name = "name")
    private String name;

}
