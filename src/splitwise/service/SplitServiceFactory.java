package splitwise.service;

import splitwise.enums.ExpenseType;
public class SplitServiceFactory {

    public static SplitService getSplitService(ExpenseType expenseType){

        if(expenseType.equals(ExpenseType.EQUAL)){
            return new EqualSplitService();
        }
        else if(expenseType.equals(ExpenseType.EXACT)){
            return new ExactSplitService();
        }
        else if(expenseType.equals(ExpenseType.PERCENTAGE)){
            return new PercentageSplitService();
        }
        else{
            return null;
        }
    }
}
