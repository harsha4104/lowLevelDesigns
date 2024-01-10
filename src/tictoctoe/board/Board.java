package tictoctoe.board;

import tictoctoe.enums.*;
public interface Board {

    void updateBoard(int x, int y, BoardValue boardValue);

    boolean checkForWinner(BoardValue boardValue);

    boolean validCell(int x, int y);

    boolean checkForDraw();

    void resetBoard();

}
