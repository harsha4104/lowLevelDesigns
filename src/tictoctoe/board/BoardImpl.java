package tictoctoe.board;

import tictoctoe.enums.BoardValue;

import java.util.*;
public class BoardImpl implements Board{

    List<Cell> cells;

    int row;
    int col;

    public BoardImpl(int row, int col) {
        this.row = row;
        this.col = col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells.add(new Cell(i, j, BoardValue.Z));
            }
        }
    }

    @Override
    public void updateBoard(int row, int col, BoardValue boardValue) {
        for(Cell cell: cells){
            if(cell.x == row && cell.y == col){
                cell.boardValue = boardValue;
            }
        }
    }

    @Override
    public boolean checkForWinner(BoardValue boardValue){

        // implementation

        return false;
    }

    @Override
    public boolean validCell(int x, int y) {
        if(x >=0 && x < row && y >=0 && y < col){
            for(Cell cell: cells){
                if(cell.x == x && cell.y == y && cell.boardValue == BoardValue.Z){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean checkForDraw() {
        for(Cell cell: cells){
            if(cell.boardValue == BoardValue.Z){
                return false;
            }
        }

        return true;
    }

    @Override
    public void resetBoard() {
        for(Cell cell: cells){
            cell.boardValue = BoardValue.Z;
        }
    }
}
