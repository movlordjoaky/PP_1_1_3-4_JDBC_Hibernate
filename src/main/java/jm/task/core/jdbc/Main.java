package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        // реализуйте алгоритм здесь
        List<User> users;

        try (UserServiceImpl userService = new UserServiceImpl()) {
            userService.createUsersTable();

            userService.saveUser("Alexia", "Daugherty", (byte) 88);
            System.out.printf("User с именем %s добавлен в базу данных\n", "Alexia");
            userService.saveUser("Леонард", "Хофстедтер", (byte) 18);
            System.out.printf("User с именем %s добавлен в базу данных\n", "Леонард");
            userService.saveUser("うずまき", "ナルト", (byte) 54);
            System.out.printf("User с именем %s добавлен в базу данных\n", "うずまき");
            userService.saveUser("Walter", "White", (byte) 27);
            System.out.printf("User с именем %s добавлен в базу данных\n", "Walter");
            userService.removeUserById(1L);

            users = userService.getAllUsers();
            users.forEach(System.out::println);

            userService.cleanUsersTable();

            userService.dropUsersTable();
        }
    }
}
