package splitwise.service;

import splitwise.enums.ExpenseType;

import splitwise.user.User;
import java.util.*;

public interface ExpenseService {

    void addExpense(ExpenseType expenseType, User paidBy, List<User> splitBetweeen, double amount);

}
