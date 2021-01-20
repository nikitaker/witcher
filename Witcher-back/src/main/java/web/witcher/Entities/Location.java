package web.witcher.Entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Location")
public class Location {

    @Id
    @Column(name = "locationName")
    private String locationName;

    @Column(name = "country")
    private String country;

    @Column(name = "questGiver")
    private String questGiver;

    @Column(name = "shopId")
    private int shopId;

}
