package javaTesting.functionalInterface;

public class ClassToUseMethodReferenceGeneric {

    <T> void callGeneric(FunctionInterfaceWithMethodReferenceGeneric<T> ginterface, T a){
        ginterface.add(a);
    }
}
