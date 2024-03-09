public class VendingMachine {
    private AuthenticationService authService;
    private boolean isAuthenticated = false;

    public VendingMachine() {
        this.authService = new UserPasswordAuthenticationService();
        // Inicialización existente...
    }

    public void authenticateUser(String username, String password) {
        isAuthenticated = authService.authenticate(username, password);
        if (isAuthenticated) {
            System.out.println("Autenticación exitosa. Acceso a funcionalidades administrativas permitido.");
        } else {
            System.out.println("Autenticación fallida. Por favor, intente de nuevo.");
        }
    }

    // Asegurarse de que las acciones administrativas verifiquen `isAuthenticated`
    // antes de proceder
}