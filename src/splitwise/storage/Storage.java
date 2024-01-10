package splitwise.storage;

import splitwise.user.User;
import java.util.*;
public interface Storage {

    void addInWallet(User user, int value);

    void removeFromWallet(User user, int value);

    Map<Integer, Map<User, Integer>> getListOfWallets();

    void addUser(User user);

    void remove(User user);
}
