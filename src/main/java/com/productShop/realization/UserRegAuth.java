package com.productShop.realization;

import com.productShop.builders.UserBuilder;
import com.productShop.models.User;
import com.productShop.util.ScannerConnection;

import java.util.Scanner;

/**
 * Реализация логики работы с пользователем.
 * Консольных запуск работы с пользователем и дальнейшие действия с ним:
 * ввод данных, аутентификация, регистрация
 */

public class UserRegAuth {
    RUser user;

    public void start() {//первая страница магазина(автор/регистр)
        try (Scanner scanner = ScannerConnection.getScanner()) {
            while (true) {
                user = new RUser();
                System.out.println("Выберите действие:\n0)Завершить работу\n1)Войти\n2)Зарегистрироваться");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        if (authorization()) new RShop(user).start();
                        break;
                    case 2:
                        registration();
                        break;
                    default:
                        System.out.println("Ошибка ввода команды, повторите действие");
                }
            }
        } catch (Exception ex) {
            System.out.println("Команда отсутствует ");
        }
    }

    private boolean authorization() {
        System.out.println("Авторизация пользователя");
        if (user.authorization(inputLogAndPass())) {
            System.out.println("Авторизация прошла успешно");
            return true;
        } else {
            System.out.println("Ошибка авторизации\nНеправильный логин или пароль");
            return false;
        }
    }

    private void registration() {
        System.out.println("Регистрация нового пользователя");
        if (user.registration(inputLogAndPass())) {
            System.out.println("Регистрация прошла успешно");
        } else {
            System.out.println("Ошибка регистрации\nПопробуйте ввести другой логин или пароль");
        }
    }

    private User inputLogAndPass() {
        Scanner scanner = ScannerConnection.getScanner();
        UserBuilder user = new UserBuilder();
        System.out.println("Введите логин");
        user.setLogin(scanner.next());
        System.out.println("Введите пароль");
        user.setPassword(scanner.next());
        return user.build();
    }
}