package SnakeLadderLLD;

import SnakeLadderLLD.board.Board;

import SnakeLadderLLD.Dice.Dice;


import java.util.*;

public class Game {

    Board board;

    Dice dice;

    GamePlayer[] gamePlayers;

    List<Snake> snakes;

    List<Ladder> ladders;
    public Game(GamePlayer[] gamePlayers, List<Snake> snakes, List<Ladder> ladders, int row, int col, int diceCount){
        this.board = new Board(row, col);
        this.snakes = snakes;
        this.ladders = ladders;
        this.gamePlayers = gamePlayers;
        this.dice = new Dice(diceCount);
    }

    public void playGame(){
        Queue<GamePlayer> playersQueue = new LinkedList<>();
        for(GamePlayer gamePlayer: gamePlayers){
            playersQueue.add(gamePlayer);
        }

        while(true){
            GamePlayer gamePlayer = playersQueue.poll();
            int diceNumber = dice.rollDice();
//            System.out.println(diceNumber);
            int nextPosition = diceNumber+gamePlayer.currentCellNumber;
            gamePlayer.currentCellNumber = nextPosition;

//            System.out.println(nextPosition);

            boolean bitten = false;

            for(Snake snake: snakes){
                if(snake.start == nextPosition){
                    nextPosition = snake.end;
                    gamePlayer.currentCellNumber = nextPosition;
                    bitten = true;
                    break;
                }
            }

            for(Ladder ladder: ladders){
                if(ladder.start == nextPosition){
                    nextPosition = ladder.end;
                    gamePlayer.currentCellNumber = nextPosition;
                    break;
                }
            }

            if(gamePlayer.currentCellNumber == this.board.cells.size()){
                System.out.println(gamePlayer.player.name+" Won the game");
                break;
            }

            System.out.println(gamePlayer.player.name+" is now on "+gamePlayer.currentCellNumber);

            playersQueue.add(gamePlayer);

        }
    }

}
