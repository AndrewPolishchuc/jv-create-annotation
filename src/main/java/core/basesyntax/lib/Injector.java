package core.basesyntax.lib;

import core.basesyntax.exceptions.MissingAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Injector {

    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Object dao;
        for (Field declaredField : clazz.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Inject.class)) {
                declaredField.setAccessible(true);
                dao = Factory.getDaoImpl(declaredField.getType());
                checkAnnotation(dao);
                declaredField.set(instance, dao);
            }
        }
        return instance;
    }

    private static void checkAnnotation(Object object) {
        if (Objects.nonNull(object) && !object.getClass().isAnnotationPresent(Dao.class)) {
            throw new MissingAnnotationException("Missing annotation @Dao");
        }
    }
}
