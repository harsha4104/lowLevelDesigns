package snakegame.snake;

import java.util.*;
import snakegame.enums.*;
import snakegame.exception.SnakeCollideException;

public class Snake {

    List<Cell> list;
    Direction direction;

    public Snake(){
        list.add(new Cell(3,2));
    }

    public void moving() throws SnakeCollideException {
        list.get(list.size()-1).value = 0;
        list.remove(list.size()-1);
        Cell curr = list.get(0);
        Cell next = new Cell(curr.x, curr.y);
        if(direction.equals(Direction.UP)){
            next.y -=1;
        }
        else if(direction.equals(Direction.DOWN)){
            next.y +=1;
        }
        else if(direction.equals(Direction.LEFT)){
            next.x +=1;
        }
        else if(direction.equals(Direction.DOWN)){
            next.x -=1;
        }
        if(isCollide(next)){
            throw new SnakeCollideException("Snake Collided");
        }
        next.value = 1;
        list.add(0, next);
    }

    public boolean isCollide(Cell next){
        for(int i=0;i<list.size();i++){
            if(list.get(i).x == next.x && list.get(i).y == next.y){
                return true;
            }
        }
        return false;
    }

    public void eatenEgg(int value){
        Cell last = list.get(list.size()-1);
        Cell secondLast = list.get(list.size()-2);
        for(int i=0;i<value-1;i++){
            Cell next = new Cell(last.x, last.y);
            if(last.x == secondLast.x){
                if(last.y == secondLast.y-1){
                    next.y -= 1;
                }
                else{
                    next.y +=1;
                }
            }
            else{
                if(last.x == secondLast.x-1){
                    next.x -= 1;
                }
                else{
                    next.x += 1;
                }
            }
            next.value = 1;
            list.add(next);
        }
    }
}
