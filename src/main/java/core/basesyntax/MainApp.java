package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class MainApp {

    public static void main(String[] args) throws NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        startApp();
    }

    private static void startApp() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        consoleHandler.handle();
    }
}
