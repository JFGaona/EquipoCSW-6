package com.parcial;

public class AuthenticationService {
    private AuthenticationStrategy strategy;

    public void setStrategy(AuthenticationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean authenticate() {
        if (strategy == null) {
            System.out.println("Authentication method is not set.");
            return false;
        }
        return strategy.authenticate(); // Ahora sin argumentos
    }
}
