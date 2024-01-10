package SnakeLadderLLD;

import SnakeLadderLLD.player.Player;

import java.util.ArrayList;

public class Executor {

    public static void main(String[] args){

        Player player1  = new Player("Harsh");
        Player player2 = new Player("Jay");

        GamePlayer gamePlayer1 = new GamePlayer(player1, 0);
        GamePlayer gamePlayer2 = new GamePlayer(player2, 0);

        Game game = new Game(new GamePlayer[]{gamePlayer1, gamePlayer2}, new ArrayList<>(), new ArrayList<>(), 10, 10, 1);

        game.playGame();
    }
}
