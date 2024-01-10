package splitwise.service;

import splitwise.user.User;
import java.util.*;
public interface SplitService {

    void splitExpense(double amount, User paidBy, List<User> splitBetween);
}
