package com.example.anaemisto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class Controller {

    @Autowired
    private PlayerSett playerSett;

    public Controller() {
    }

    @GetMapping("/{id}")
    public Player getProduct(@PathVariable("id") long id) {
        return playerSett.findPlayerById(id);
    }
    
    @GetMapping
    public List<Player> getPlayers() {
        return playerSett.getAllPlayers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name) {

        Player player= playerSett.findPlayerById(id);
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        else{
            player.setName(name);
            playerSett.createPlayer(player);
            return new ResponseEntity<>(
                    "Player updated successsfully", HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable long id) {
        Player player = playerSett.findPlayerById(id);

        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.GONE);
        }
        playerSett.removePlayer(id);

        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createPlayer(@RequestBody Player player) {
        playerSett.createPlayer(player);
        return new ResponseEntity<>(
                "Player created successfully", HttpStatus.CREATED);
    }


}
