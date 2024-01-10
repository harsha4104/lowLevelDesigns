package splitwise.storage;

import splitwise.user.User;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage{

    Map<User, Integer> userBalance = new HashMap<>();
    Map<Integer, Map<User,Integer>> map = new HashMap<>();

    @Override
    public void addInWallet(User user, int value) {
        Map<User, Integer> userMap = map.get(user.getId());
        userMap.put(user, userMap.get(user)+value);
    }

    @Override
    public void removeFromWallet(User user, int value) {
        Map<User, Integer> userMap = map.get(user.getId());
        userMap.put(user, userMap.get(user)-value);
    }

    @Override
    public Map<Integer, Map<User, Integer>> getListOfWallets() {
        return map;
    }

    @Override
    public void addUser(User user) {
        Map<User, Integer> userMap = new HashMap<>();
        userMap.put(user, 0);
        map.put(user.getId(), userMap);
    }

    @Override
    public void remove(User user) {
        map.remove(user.getId());
    }
}
