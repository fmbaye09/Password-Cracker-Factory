package cracker;

import target.Target;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
  Implémentation de la stratégie d'attaque par dictionnaire.
 Teste chaque mot de passe d'un fichier dictionnaire sur la cible.*/
public class DictionaryCracker implements Cracker {
    private String dictionaryPath;

    
    //Constructeur du dictionnaire cracker.
    
    public DictionaryCracker(String dictionaryPath) {
        this.dictionaryPath = dictionaryPath;
    }

    // Lance l'attaque dictionnaire sur la cible.
 
    @Override
    public void crack(Target target, String login) {
        System.out.println("[Dictionnaire] Début de l'attaque dictionnaire...");
        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (target.authenticate(login, line)) {
                    System.out.println("Mot de passe trouvé : " + line);
                    return;
                }
            }
            System.out.println("Mot de passe non trouvé dans le dictionnaire.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du dictionnaire : " + e.getMessage());
        }
    }
} 