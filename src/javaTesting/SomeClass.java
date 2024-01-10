package javaTesting;

import javaTesting.EnumTesting.Rank;
import javaTesting.interfaceTesting.InterfaceExample;
import javaTesting.interfaceTesting.SomeInterface;

import java.util.*;

public class SomeClass {

    public static void main(String[] args){

//        List<Integer> list = new Stack<>();
//
//        Collection<Integer> collection = new Stack<>();
//
//        Stack<Integer> stack = new Stack<>();
//
//        Map<Integer, Integer> map = new HashMap<>();

//        System.out.println(Rank.FIRST.getRankValue()+" "+Rank.SECOND.getRankString());

        SomeInterface someInterface = new InterfaceExample();
        someInterface.printString();

    }
}
