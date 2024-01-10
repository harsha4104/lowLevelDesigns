package javaTesting.interfaceTesting;

public class Executor {

    public static void main(String[] args){

        SomeInterface someInterface = new InterfaceExample();
        someInterface.printString();;
        System.out.println(someInterface.getInteger());
        SomeInterface.printStaticString();
        System.out.println(someInterface.getA());
        someInterface.getA();
    }
}
