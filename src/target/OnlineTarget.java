package target;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/* Cible en ligne : authentification via requête HTTP POST vers un site web.
 */
public class OnlineTarget implements Target {
    private String url;

    //constructeur de la cible en ligne.

    public OnlineTarget(String url) {
        this.url = url;
    }

    
//envoie une requête HTTP POST avec login et mot de passe, puis analyse la réponse.

    @Override
    public boolean authenticate(String login, String password) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            String postData = "login=" + login + "&password=" + password;
            OutputStream os = con.getOutputStream();
            os.write(postData.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérifie si la réponse contient "Connexion réussie"
            boolean success = response.toString().contains("Connexion reussie");
            System.out.println("Tentative en ligne avec : " + login + "/" + password + " => " + (success ? "Succes" : "Echec"));
            return success;

        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion HTTP : " + e.getMessage());
            return false;
        }
    }
} 