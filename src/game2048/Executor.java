package game2048;

import game2048.board.Board;
import game2048.game.Game;

public class Executor {

    public static void main(String[] args){

        Board board = new Board(4,4);

        Game game = new Game(board);

        game.play();
    }
}
