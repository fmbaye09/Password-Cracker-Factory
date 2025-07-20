package factory;

import cracker.DictionaryCracker;
import cracker.Cracker;
import target.OnlineTarget;
import target.Target;

// Fabrique pour créer un cracker dictionnaire et une cible en ligne
public class DictionaryOnlineFactory implements CrackerFactory {
    private String dictionaryPath;
    private String url;

//On passe le chemin du fichier dictionnaire et l'URL du site cible
    public DictionaryOnlineFactory(String dictionaryPath, String url) {
        this.dictionaryPath = dictionaryPath;
        this.url = url;
    }


    
    //Crée la stratégie dictionnaire
    @Override
    public Cracker createCracker() {
        return new DictionaryCracker(dictionaryPath);
    }

    // Crée la cible en ligne (requête HTTP)
    @Override
    public Target createTarget() {
        return new OnlineTarget(url);
    }
} 