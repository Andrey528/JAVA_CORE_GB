package hw.hw4.AuthProject;

import hw.hw4.AuthProject.exceptions.WrongLoginException;
import hw.hw4.AuthProject.exceptions.WrongPasswordException;
import hw.hw4.AuthProject.models.Authorization;

/**
 * 1. Задача: Проверка логина и пароля
 * 1 - Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
 * 2 - Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
 * 3 -Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
 * 4 - WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
 * 5 - В основном классе программы необходимо по-разному обработать исключения.
 * 6 - Метод возвращает true, если значения верны или false в другом случае.
 */
public class Main {
    public static void main(String[] args) {
        String[][] credentials = {
                {"ivan", "123456789012345678901", "123456789012345678901"},
                {"dsfagfdgasdfgsdfgsdfgsdfg", "", ""},
                {"ivan", "sdgsfdgfsdag", "fddsfa"},
                {"ivan", "sdagdsa", "sdagdsa"},
                {"ivan", "sdagdsa", "edgmdf"}
        };
        for (int i = 0; i < credentials.length; i++) {
            try
            {
                System.out.println(Authorization.checkCredentials(credentials[i][0], credentials[i][1], credentials[i][2]));
            } catch (WrongLoginException e) {
                e.printStackTrace();
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
