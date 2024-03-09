package com.parcial;

import java.util.Scanner;

public class VendingMachine {
    private boolean isUserAuthenticated = false;
    private int failedAttempts = 0;
    private final int MAX_FAILED_ATTEMPTS = 3;
    private AuthenticationService authService;
    private Inventory inventory;

    public VendingMachine() {
        this.authService = new AuthenticationService();
        this.inventory = new Inventory(10); // Suponiendo una inicialización adecuada de Inventory
    }

    public void showInitialOptions() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("3") && failedAttempts < MAX_FAILED_ATTEMPTS) {
            System.out.println("\nWelcome to the Vending Machine!");
            System.out.println("1. Show Products");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventory.displayProducts(); // Suponiendo que este método existe en Inventory
                    break;
                case "2":
                    startAuthenticationProcess();
                    if (isUserAuthenticated) {
                        displayRestrictedOptions();
                    }
                    break;
                case "3":
                    System.out.println("Thank you for using the Vending Machine. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            System.out.println("User blocked. Contact administrator.");
        }
    }

    public void startAuthenticationProcess() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select your authentication method:");
        System.out.println("1. Username/Password");
        System.out.println("2. PIN");
        System.out.println("3. Social Media");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                authService.setStrategy(new UsernamePasswordAuthentication());
                break;
            case "2":
                authService.setStrategy(new PinAuthentication());
                break;
            case "3":
                authService.setStrategy(new SocialMediaAuthentication());
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                return;
        }

        isUserAuthenticated = authService.authenticate();
        if (!isUserAuthenticated) {
            failedAttempts++;
            System.out.println("Authentication failed. Please try again. Attempts left: "
                    + (MAX_FAILED_ATTEMPTS - failedAttempts));
        }

        if (isUserAuthenticated) {
            System.out.println("Authentication successful.");
        }
    }

    private void displayRestrictedOptions() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("3")) {
            System.out.println("Select an option:");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Manage Coins and Bills");
            System.out.println("3. Log Out");

            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manageInventory();
                    break;
                case "2":
                    manageCoinsAndBills();
                    break;
                case "3":
                    logout();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    private void manageInventory() {
        System.out.println("Inventory Management");
        // Aquí va la lógica específica para gestionar el inventario.
    }

    private void manageCoinsAndBills() {
        System.out.println("Coins and Bills Management");
        // Aquí va la lógica específica para gestionar monedas y billetes.
    }

    private void logout() {
        isUserAuthenticated = false;
        failedAttempts = 0; // Resetear intentos fallidos para un nuevo proceso de autenticación
        System.out.println("You have been logged out.");
        // Volver a mostrar las opciones iniciales permitiría a un nuevo usuario
        // interactuar.
        showInitialOptions();
    }

    // Otros métodos de VendingMachine como getInventory(), refillInventory(), etc.
}
