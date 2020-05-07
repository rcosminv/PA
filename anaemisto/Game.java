package com.example.anaemisto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "team_Sequence", sequenceName = "GAME_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "game")
    private List<Player> players;

    public Game(String name, Long id) {
        this.name=name;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
