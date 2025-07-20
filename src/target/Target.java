package target;

/*Interface représentant une cible d'authentification.
Toute classe qui implémente cette interface doit fournir une méthode authenticate.*/
public interface Target {
    // Tente d'authentifier le login/mot de passe.

    boolean authenticate(String login, String password);
} 