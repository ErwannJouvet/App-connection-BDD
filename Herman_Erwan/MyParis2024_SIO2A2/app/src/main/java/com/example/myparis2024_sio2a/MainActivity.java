package com.example.myparis2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText txtEmail, txtMdp;
    private Button btSeConnecter ;
    private static User userConnecte =null;

    public static  void setUser(User unUser){
        MainActivity.userConnecte = unUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtEmail=(EditText) findViewById(R.id.idEmail);
        this.txtMdp =(EditText) findViewById(R.id.idMdp);
        this.btSeConnecter=(Button) findViewById(R.id.idSeConnecter);

        this.btSeConnecter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSeConnecter){
            String email = this.txtEmail.getText().toString();
            String mdp = this.txtMdp.getText().toString();

            //vérification de la connexion via Json page PHP
            User  unUser = new User ("", "", email,mdp,"");
            Connexion uneC = new Connexion();

            MainActivity ma = this;
            //instanciation d'un processus d'atente d'exécution de la tache asynchrone
            Thread unT = new Thread(new Runnable() {
                @Override
                public void run() {
                    uneC.execute(unUser);
                    //une synchronisation de l'appel :
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (userConnecte == null){
                                Toast.makeText(ma, "Veuillez vérifier vos identifiants",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ma, "Bienvenue "+userConnecte.getNom(),
                                        Toast.LENGTH_SHORT).show();
                                // en cas de connexion : appel de la 2eme Page Menu
                                Intent unIntent = new Intent(ma, Menu.class);
                                unIntent.putExtra("email", email);

                                ma.startActivity(unIntent);
                            }
                        }
                    });
                }
            }) ;
            unT.start();



        }
    }
}
class Connexion extends AsyncTask<User, Void, User>{

    @Override
    protected User doInBackground(User... users) {
        User unUser = users[0];
        String email = unUser.getEmail();
        String mdp = unUser.getMdp();

        String resultatJson ="";
        User unUserResultat = null;

        String parametres ="?email="+email+"&mdp="+mdp;
        String url = "http://127.0.0.1:3306/Promotion_241/Projets/Herman_Erwan/androidParis2024/verifConnexion.php?"+parametres;
        try{
            URL uneUrl = new URL(url);
            HttpURLConnection uneConnexion = (HttpURLConnection)uneUrl.openConnection();
            //on fixe la méthode d'envoi des données
            uneConnexion.setRequestMethod("GET");
            //ouverture d'envoi et réception des donnéees
            uneConnexion.setDoInput(true);
            uneConnexion.setDoOutput(true);
            //on fixe le temps d'attente de la connexion
            uneConnexion.setConnectTimeout(15000);
            //on se connecte
            uneConnexion.connect();

            //lecture des données JSON
                //déclaration d'un fichier de lecture
            InputStreamReader isr =new InputStreamReader(uneConnexion.getInputStream(), "UTF-8");
                //lire dans un buffer : chaine
            BufferedReader br = new BufferedReader(isr);
                //extraction des lignes de la page PHP
                String ligne ="";
                StringBuilder sb = new StringBuilder();//chaine dynamique
                while ((ligne=br.readLine())!=null){
                    sb.append(ligne); //tant qu'il un JSon, on le lit et on le concatene
            }
            //construction du json résultat
            resultatJson = sb.toString();
                Log.e("JSON :", resultatJson);
        }
        catch (Exception exp){
            Log.e("Erreur:", "Connexion Impossible a "+ url);
            exp.printStackTrace();
        }
        //parsing du JSON
        try{
            JSONArray tab = new JSONArray(resultatJson); //tableau de JSON []
            //extraction d'un seul JSON resultat
            JSONObject unObjet = tab.getJSONObject(0); //le premier
            unUserResultat = new User (
                    unObjet.getInt("iduser"),
                    unObjet.getString("nom"), unObjet.getString("prenom"),
                    unObjet.getString("email"), unObjet.getString("mdp"),
                    unObjet.getString("tel")
                    );
        }
        catch(JSONException exp ){
            Log.e("JSON ERREUR: ", "Impossible de parser le json");
            exp.printStackTrace();
        }

        return unUserResultat;
    }

    @Override
    protected void onPostExecute(User user) {
         // on récupère après exécution de la tâche asynchrone l'user
        MainActivity.setUser(user);
    }
}