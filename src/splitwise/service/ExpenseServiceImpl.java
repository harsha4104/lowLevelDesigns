package splitwise.service;

import splitwise.enums.ExpenseType;

import splitwise.user.User;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService{
    @Override
    public void addExpense(ExpenseType expenseType, User paidBy, List<User> splitBetweeen, double amount) {

        SplitService splitService = SplitServiceFactory.getSplitService(expenseType);

        splitService.splitExpense(amount, paidBy,splitBetweeen);

    }
}
