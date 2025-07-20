package factory;

import cracker.DictionaryCracker;
import cracker.Cracker;
import target.LocalTarget;
import target.Target;

// Fabrique pour créer un cracker dictionnaire et une cible locale
public class DictionaryLocalFactory implements CrackerFactory {
    private String dictionaryPath;

    // On passe le chemin du fichier dictionnaire
    public DictionaryLocalFactory(String dictionaryPath) {
        this.dictionaryPath = dictionaryPath;
    }

    // Crée la stratégie dictionnaire
    @Override
    public Cracker createCracker() {

        return new DictionaryCracker(dictionaryPath);
    }

    // crée la cible locale (login/mot de passe en dur)
    @Override
    public Target createTarget() {

        
        return new LocalTarget();
    }
} 