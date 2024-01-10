package javaTesting.functionalInterface;

public class FuncationalInterfaceExecutor {

    public static void main(String[] args){

//        FunctionalInterface myinterface = (a)-> System.out.print(a);
//        myinterface.printName("Jay");


//        final int var = 10;
//        FunctionInterfaceVariableCapture myInterface = (a)->{
//            for(int i=0;i<5;i++) {
//                a += var;
//            }
//            System.out.println(a);
//        };

//        myInterface.addWithParameter(10);


        ClassToUseMethodReference classToUseMethodReference = new ClassToUseMethodReference();

        classToUseMethodReference.someMethod((a)->{
            for(int i=0;i<5;i++)
                System.out.println(a);
        }, "Harsh");

        ClassToUseMethodReferenceGeneric classToUseMethodReferenceGeneric = new ClassToUseMethodReferenceGeneric();

        classToUseMethodReferenceGeneric.callGeneric((a)->{
            for(int i=0;i<5;i++){
                System.out.println(a);
            }
        }, 10);
    }
}
