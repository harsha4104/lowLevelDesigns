package tictoctoe.game;

import tictoctoe.board.*;
import tictoctoe.gamePlayer.GamePlayer;

import java.util.LinkedList;
import java.util.*;



public class Game {

    Board board;

    public Game(Board board){
        this.board = board;
    }

    public void playGame(){

        Queue<GamePlayer> queue = new LinkedList<>();

       while(true){
           Scanner scanner = new Scanner(System.in);

           int inputX = scanner.nextInt();
           int inputY = scanner.nextInt();

           if(!board.validCell(inputX,inputY)){
               continue;
           }

           board.updateBoard(inputX,inputY,queue.peek().boardValue);

           if(board.checkForWinner(queue.peek().boardValue)){
               System.out.println(queue.peek().boardValue+" Won");
               break;
           }

           if(board.checkForDraw()){
               System.out.println("Match Draw");
               break;
           }

           queue.add(queue.poll());
       }
    }
}
