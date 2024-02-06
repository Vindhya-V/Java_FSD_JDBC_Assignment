package com.blueyonder.ui;

import com.blueyonder.exceptions.PasswordMismatchException;
import com.blueyonder.exceptions.UserNotFoundException;
import com.blueyonder.model.User;
import com.blueyonder.service.UserService;
import com.blueyonder.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String userName = sc.next();
        System.out.println("Enter Password: ");
        String password = sc.next();
        UserService userService = new UserServiceImpl();
        try {
            User user = userService.getUserByName(userName);
            try {
                if (userService.validateUserNameAndPassword(userName, password)) {
                    System.out.println("Hello " + user.getUserName());
                    if (user.getRole().equals("admin")) {
                        List<User> result = userService.getAllUsers();
                        System.out.println("List of Users are: ");
                        result.stream().map(User::getUserName).sorted().forEach(System.out::println);

                    }
                }
            }
            catch (PasswordMismatchException e)
            {
                System.out.println("Invalid password");
            }
        }
        catch (UserNotFoundException e)
        {
            System.out.println("Username not found");
        }

    }
}
