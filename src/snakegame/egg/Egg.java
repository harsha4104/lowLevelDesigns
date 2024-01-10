package snakegame.egg;

import snakegame.snake.Cell;
public class Egg {

    public Cell cell;
    public int value;

    public Egg(int value, Cell cell){
        this.value = value;
        this.cell = cell;
    }

    public void addEgg(){
        cell.value = 5;
    }

    public void removeEgg(){
        cell.value = 0;
    }
}
