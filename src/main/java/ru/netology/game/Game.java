package ru.netology.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    private Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player first = findByName(playerName1);
        Player second = findByName(playerName2);
        if (first == null) {
            throw new NotRegisteredException("Player is not registered: " + playerName1);
        }
        if (second == null) {
            throw new NotRegisteredException("Player is not registered: " + playerName2);
        }
        if (first.getStrength() > second.getStrength()) {
            return 1;
        }
        if (first.getStrength() < second.getStrength()) {
            return 2;
        }
        return 0;
    }
}
