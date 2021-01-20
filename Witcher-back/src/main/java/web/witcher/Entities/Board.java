package web.witcher.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Board")
public class Board {

    @Id
    @Column(name = "boardId")
    private int boardId;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "witcherName")
    private Witcher witcherName;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "monsterName")
    private Monster monsterName;

    @Column(name = "price")
    private int price;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "questGiver")
    private QuestGiver questGiver;
}
