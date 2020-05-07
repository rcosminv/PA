package com.example.anaemisto;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerUsage implements PlayerSett {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);

    }

    @Override
    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Player findPlayerById(long id) {
        return playerRepository.findOne(1l);
    }

    @Override
    public void removePlayer(long id) {
        playerRepository.delete(id);
    }
}
