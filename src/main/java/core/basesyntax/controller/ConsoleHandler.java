package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.imp.BetDaoImpl;
import core.basesyntax.dao.imp.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {

    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name and password:");
            String userCommand = scanner.nextLine();
            if (userCommand.equalsIgnoreCase("end")) {
                return;
            }
            User user;
            try {
                String[] userData = userCommand.split(" ");
                String name = userData[0];
                String password = userData[1];
                user = new User(name, password);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("The entered data is incorrect");
                continue;
            }
            userDao.add(user);
            System.out.println(user);
            addBets(scanner);
        }
    }

    private void addBets(Scanner scanner) {
        while (true) {
            System.out.println("Enter value and risk of bet:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                break;
            }
            Bet bet;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("The entered data is incorrect");
                continue;
            }
            betDao.add(bet);
            System.out.println(bet);
        }
    }
}
