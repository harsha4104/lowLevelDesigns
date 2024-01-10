package tictoctoe.board;

import tictoctoe.enums.BoardValue;

public class Cell {

    public int x;
    public int y;

    public BoardValue boardValue;

    public Cell(int x, int y, BoardValue boardValue) {
        this.x = x;
        this.y = y;
        this.boardValue = boardValue;
    }
}
