package dev.ayush.springBootStarterCli.controller;

import dev.ayush.springBootStarterCli.model.User;
import dev.ayush.springBootStarterCli.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void runCli() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Spring Boot Starter CLI =====");
        System.out.println("""
                Commands: REGISTER <id> <email>
                LIST
                DELETE <id>
                EXIT""");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("EXIT")) break;
            handle(line);
        }
    }

    private void handle(String line) {
        try {
            String[] parts = line.split(" ");
            switch (parts[0].toUpperCase()) {
                case "REGISTER": {
                    User user = userService.register(Integer.parseInt(parts[1]), parts[2]);
                    System.out.println("User registered: " + user);
                    break;
                }

                case "LIST":{
                    List<User> users = userService.listUsers();
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                }

                case "DELETE": {
                    boolean userDeleted = userService.deleteUser(Integer.parseInt(parts[1]));
                    System.out.println(userDeleted ? "User deleted." : "User not found.");
                    break;
                }

                default:
                    System.out.println("Unknown command!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
