package javaTesting.EnumTesting;

import java.lang.annotation.Inherited;
import java.lang.annotation.Native;
import java.lang.annotation.Target;

public class Executor {
    public static void main(String[] args){

        for(Rank r: Rank.values()){
            System.out.println(r.name()+" "+r.getRankValue()+" "+r.getRankString());
        }


    }
}
