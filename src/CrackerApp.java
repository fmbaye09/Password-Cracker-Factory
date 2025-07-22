import factory.BruteForceLocalFactory;
import factory.BruteForceOnlineFactory;
import factory.CrackerFactory;
import factory.DictionaryLocalFactory;
import factory.DictionaryOnlineFactory;
import cracker.Cracker;
import target.Target;


public class CrackerApp {
    public static void main(String[] args) {
        // Vérification du nombre d'arguments
        if (args.length < 6) {
        System.out.println("Usage : java -cp bin CrackerApp --type <bruteforce|dictionary> --target <local|online> --login <login> [--max <longueur>] [--alphabet <abc>] [--dict <chemin>] [--url <url>]");
            return;
        }

        String type = null;
         String targetType = null;
        String login = null;
        int maxLength = 4;

        String alphabet = "azerty1234";
        String dictPath = "dictionary.txt";
         String url = null;

        //Lecture des arguments de la ligne de commande
        for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                case "--type":
                    type = args[++i];
                    break;
                case "--target":
                    targetType = args[++i];
                    break;
                case "--login":
                    login = args[++i];
                    break;
                case "--max":
                    maxLength = Integer.parseInt(args[++i]);
                    break;
                case "--alphabet":
                    alphabet = args[++i];
                    break;
                case "--dict":
                    dictPath = args[++i];
                    break;
                case "--url":
                    url = args[++i];
                    break;
            }
            
        
          }

// vérification des arguments obligatoires
        if (type == null || targetType == null || login == null) {
            System.out.println("Erreur : --type, --target et --login sont obligatoires.");
            return;
        }






        CrackerFactory factory = null;
        //sélection de la fabrique selon la combinaison attaque/cible
        if (type.equalsIgnoreCase("bruteforce")) {
            if (targetType.equalsIgnoreCase("local")) {
                factory = new BruteForceLocalFactory(maxLength, alphabet);
            } 
            else if (targetType.equalsIgnoreCase("online")) {
                if (url == null) {
                    System.out.println("Erreur : --url est obligatoire pour la cible online.");
                    return;
                }
                factory = new BruteForceOnlineFactory(maxLength, alphabet, url);
            }
        } else if (type.equalsIgnoreCase("dictionary")) {
            if (targetType.equalsIgnoreCase("local")) {
                factory = new DictionaryLocalFactory(dictPath);
            }   else if (targetType.equalsIgnoreCase("online")) {
                if (url == null) {
                    System.out.println("Erreur : --url est obligatoire pour la cible online.");
                    return;
                }
                factory = new DictionaryOnlineFactory(dictPath, url);
            }
        }

        if (factory == null) {
            System.out.println("Erreur : combinaison type/cible non supportee.");
            return;
        }





        // Création du cracker et de la cible, puis lancement de l'attaque
        Cracker cracker = factory.createCracker();
        Target target = factory.createTarget();
        cracker.crack(target, login);
    }
} 