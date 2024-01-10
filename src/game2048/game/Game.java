package game2048.game;

import game2048.board.Board;

import java.util.Scanner;

public class Game {

    Board board;

    public Game(Board board){
        this.board = board;
    }

    public void play(){

        while(true){

            board.printBoard();
            Scanner scanner = new Scanner(System.in);

            int input = scanner.nextInt();

            if(input == 1){
                board.moveLeft();
            }
            else if(input == 2){
                board.moveDown();
            }
            else if(input == 3){
                board.moveRight();
            }
            else if(input == 4){
                board.moveUp();
            }

            if(board.isGameOver()){
                System.out.println("Game Over");
                break;
            }

            if(board.isPlayerWon()){
                System.out.println("Player Won the game");
                break;
            }
        }
    }

}
