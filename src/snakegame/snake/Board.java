package snakegame.snake;

import java.util.*;
import snakegame.egg.*;
public class Board {

    List<Cell> cells;
    int row;
    int col;


    public Board(int row, int col){
        this.row = row;
        this.col = col;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                cells.add(new Cell(i, j));
            }
        }
    }

    public void printBoard(){
        int k = 0;
        for(int i=0;i<row;i++){
            for(int j = 0; j< col;j++){
                System.out.print(cells.get(k++).value);
            }
        }
    }

    public void addObstacles(){

    }
}
