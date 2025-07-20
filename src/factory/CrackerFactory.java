package factory;

import cracker.Cracker;
import target.Target;

/*
  Interface de fabrique abstraite pour créer dynamiquement un cracker et une cible.
*/
public interface CrackerFactory {
    //crée une instance de la stratégie d'attaque.

    Cracker createCracker();

    //crée une instance de la cible d'authentification.
    Target createTarget();
} 