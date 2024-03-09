package com.parcial;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la máquina expendedora
        VendingMachine vendingMachine = new VendingMachine();

        // Iniciar mostrando las opciones iniciales que incluyen ver productos sin
        // necesidad de autenticarse
        vendingMachine.showInitialOptions();
    }
}
