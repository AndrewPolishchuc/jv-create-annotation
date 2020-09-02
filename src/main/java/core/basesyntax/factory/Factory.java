package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.imp.BetDaoImpl;
import core.basesyntax.dao.imp.UserDaoImpl;
import core.basesyntax.exceptions.UnknownDaoImplException;

public class Factory {
    private static final Factory factory = new Factory();

    private Factory() {

    }

    private Factory getInstance() {
        return factory;
    }

    public static BetDao getBetDaoImpl() {
        return new BetDaoImpl();
    }

    public static UserDao getUserDaoImpl() {
        return new UserDaoImpl();
    }

    public static Object getDaoImpl(Class<?> type) {
        if (type.equals(UserDao.class)) {
            return Factory.getUserDaoImpl();
        } else if (type.equals(BetDao.class)) {
            return Factory.getBetDaoImpl();
        }
        throw new UnknownDaoImplException("Unknown dao implementation");
    }
}
