package javaTesting.interfaceTesting;

public interface SomeInterface {

    int a = 10;

    int getInteger();

    default int getA(){
        return this.a;
    }

    default void printString(){
        System.out.println("Print Default String");;
    }

    private void printPrivateString(){
        System.out.println("Private Print Default String");
    }

    static void printStaticString(){
        System.out.println("Static print Default String");
    }
}
