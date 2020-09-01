package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.MissingAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getAnnotation(Inject.class) != null) {
                declaredField.setAccessible(true);
                if (declaredField.getType().equals(UserDao.class)
                        && checkAnnotation(Factory.getUserDaoImpl().getClass())) {
                    declaredField.set(instance, Factory.getUserDaoImpl());
                }
                if (declaredField.getType().equals(BetDao.class)
                        && checkAnnotation(Factory.getBetDaoImpl().getClass())) {
                    declaredField.set(instance, Factory.getBetDaoImpl());
                }
            }
        }
        return instance;
    }

    private static boolean checkAnnotation(Class clazz) {
        if (!clazz.isAnnotationPresent(Dao.class)) {
            throw new MissingAnnotationException("Missing annotation @Dao");
        }
        return true;
    }
}
