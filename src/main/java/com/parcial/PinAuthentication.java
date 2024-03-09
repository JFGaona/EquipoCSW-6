package com.parcial;

public class PinAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate() {
        System.out.println("PIN authentication is not implemented yet.");
        return false;
    }
}
