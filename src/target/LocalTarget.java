package target;

/**
 * Cible locale : authentification avec login et mot de passe en dur.
 */
public class LocalTarget implements Target {
    // Identifiants valides codés en dur
    private final String correctLogin = "admin";
    private final String correctPassword = "abcd12";

    /**
     * Vérifie si le login et le mot de passe correspondent aux valeurs attendues.
     * @param login le login à tester
     * @param password le mot de passe à tester
     * @return true si authentification réussie
     */
    @Override
    public boolean authenticate(String login, String password) {
        boolean success = correctLogin.equals(login) && correctPassword.equals(password);
        System.out.println("Tentative avec : " + login + "/" + password + " => " + (success ? "Succes" : "Echec"));
        return success;
    }
} 