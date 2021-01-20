package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Shop")
public class Shop {

    @Id
    @Column(name = "shopId")
    private int shopId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "markup")
    private int markup;

}
