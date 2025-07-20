package cracker;

import target.Target;

/*Interface représentant une stratégie d'attaque de mot de passe.
 Toute classe qui implémente cette interface doit fournir une méthode crack.*/
public interface Cracker {

    //Lance l'attaque sur la cible avec le login donné.
    void crack(Target target, String login);
} 