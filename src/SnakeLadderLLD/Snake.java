package SnakeLadderLLD;

import SnakeLadderLLD.Exception.SnakeNotValidException;

public class Snake extends Item{
    public Snake(int start, int end) throws SnakeNotValidException {
        if(!isValidStartEnd(start, end)){
            throw new SnakeNotValidException("Snake is not valid");
        }

        this.start = start;
        this.end = end;
    }

    private boolean isValidStartEnd(int start, int end){
        if(start < end){
            return true;
        }

        return false;
    }
}
