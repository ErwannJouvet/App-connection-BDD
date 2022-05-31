package com.example.myparis2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MonProfil extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNom, txtPrenom, txtEmail, txtMdp, txtTel;
    private Button btMiseAjour ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);

        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtEmail = (EditText) findViewById(R.id.idEmail2);
        this.txtMdp = (EditText) findViewById(R.id.idMdp2);
        this.txtTel= (EditText) findViewById(R.id.idTel);
        this.btMiseAjour =(Button) findViewById(R.id.idMiseAJour);

        this.btMiseAjour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.idMiseAJour){
            String nom = this.txtNom.getText().toString();
            String prenom = this.txtPrenom.getText().toString();
            String email = this.txtEmail.getText().toString();
            String mdp = this.txtMdp.getText().toString();
            String tel = this.txtTel.getText().toString();

            //on instancie la classe User et on update

            //on revient menu
            Intent unIntent = new Intent(this, Menu.class);
            this.startActivity(unIntent);

        }
    }
}