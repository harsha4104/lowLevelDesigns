package SnakeLadderLLD.board;

import SnakeLadderLLD.cell.Cell;

import java.util.*;
public class Board {

    public Map<Integer, Cell> cells = new HashMap<>();

    public Board(int row, int col){
        int number = 1;
        for(int i=row-1;i >= 0;i--){
            if(i%2 == 0){
                for(int j=0;j<col;j++){
                   Cell cell = new Cell(i, j, number);
                    cells.put(number++, cell);
                }
            }
            else{
                for(int j = col-1; j>=0;j--){
                   Cell cell = new Cell(i, j ,number);
                    cells.put(number++, cell);
                }
            }
        }
    }
}
