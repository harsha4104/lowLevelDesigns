package game2048.board;

import java.sql.Array;
import java.util.*;
public class Board {
    List<Cell> cells;
    int row;
    int col;



    public Board(int row, int col){
        this.row = row;
        this.col = col;
        this.cells = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                this.cells.add(new Cell(i, j));
            }
        }

        addValueToRandomEmptyCell();
    }

    public void resetBoard(){
        int randomRow = getRandomBetween(row);
        int randomCol = getRandomBetween(col);

        for(Cell cell: cells){
            if(cell.x == randomRow && cell.y == randomCol){
                cell.value = 2;
            }
            else{
                cell.value = 0;
            }
        }

        addValueToRandomEmptyCell();
    }

    public void moveLeft(){
        int k = 0;
        for(int i=0;i<row;i++){
            List<Cell> list = new ArrayList<>();
            for(int j=0;j<col;j++){
                list.add(cells.get(k));
                k++;
            }
            Collections.reverse(list);
            combine(list);
        }
        addValueToRandomEmptyCell();
    }

    public void moveRight(){
        int k = 0;
        for(int i=0;i<row;i++){
            List<Cell> list = new ArrayList<>();
            for(int j=0;j<col;j++){
                list.add(cells.get(k));
                k++;
            }
            combine(list);
        }
        addValueToRandomEmptyCell();
    }

    public void moveDown(){
        for(int j=0; j<col;j++){
            int k = j;
            List<Cell> list = new ArrayList<>();
            for(int i=0;i<row;i++){
                list.add(cells.get(k));
                k = k+row;
            }
            Collections.reverse(list);
            combine(list);
        }
        addValueToRandomEmptyCell();
    }

    public void moveUp(){
        for(int j=0; j<col;j++){
            int k = j;
            List<Cell> list = new ArrayList<>();
            for(int i=0;i<row;i++){
                list.add(cells.get(k));
                k = k+row;
            }
            combine(list);
        }
        addValueToRandomEmptyCell();
    }

    private void addValueToRandomEmptyCell(){
        while(true){
            int rand = new Random().nextInt(cells.size())%cells.size();
            Cell cell = cells.get(rand);

            if(cell.value == 0){
                cell.value = 2;
                break;
            }
        }
    }

    private void combine(List<Cell> list){

        List<Integer> values = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).value > 0){
                values.add(list.get(i).value);
            }
        }

        for(int i=0;i<values.size()-1;i++){
            if(values.get(i) == values.get(i+1)){
                values.set(i, 2*values.get(i));
                values.remove(i+1);
            }
        }

        for(int i=0;i<list.size();i++){
            if(i<values.size()){
                list.get(i).value = values.get(i);
            }
            else{
                list.get(i).value = 0;
            }
        }
    }

    private int getRandomBetween(int n){
        return new Random().nextInt(n)%n;
    }

    public void printBoard(){
        int k=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(cells.get(k).value > 0)
                    System.out.print(cells.get(k).value+" ");
                else{
                    System.out.print("- ");
                }
                k++;
            }
            System.out.println();
        }
    }

    public boolean isPlayerWon(){

        for(int k=0;k<cells.size();k++){
            if(cells.get(k).value == 2048){
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver(){
        int count =0;
        for(int k=0;k<cells.size();k++){
            if(cells.get(k).value > 0){
                count++;
            }
        }

        if(cells.size() == count){
            return true;
        }

        return false;
    }
}
