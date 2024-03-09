package com.parcial;

import java.util.Scanner;

public class UsernamePasswordAuthentication implements AuthenticationStrategy {

    private final String validUsername = "admin";
    private final String validPassword = "password"; // En una aplicación real, esto NO debe estar codificado así.

    @Override
    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed. Incorrect username or password.");
            return false;
        }
    }
}
