package core.basesyntax.dao.imp;

import core.basesyntax.dao.UserDao;
import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.getUsers().add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return Storage.getUsers();
    }
}

