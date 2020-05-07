package com.example.anaemisto;

import java.util.List;

public interface PlayerSett {
    public List<Player> getAllPlayers();
    public Player findPlayerById(long id);
    public Player createPlayer(Player player);
    public void removePlayer(long id);
}
