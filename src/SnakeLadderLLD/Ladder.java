package SnakeLadderLLD;

import SnakeLadderLLD.Exception.LadderNotValidException;

public class Ladder extends Item{

    int start;

    int end;

    public Ladder(int start, int end) throws LadderNotValidException {
        if(!isValidStartEnd(start, end)){
            throw new LadderNotValidException("Ladder is not valid");
        }

        this.start = start;
        this.end = end;
    }

    private boolean isValidStartEnd(int start, int end){
        if(start > end){
            return true;
        }

        return false;
    }
}
