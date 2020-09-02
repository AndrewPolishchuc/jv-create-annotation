package core.basesyntax.db;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Bet> bets = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();

    public static List<Bet> getBets() {
        return bets;
    }

    public static List<User> getUsers() {
        return users;
    }
}
