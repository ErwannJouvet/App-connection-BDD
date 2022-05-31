package com.example.myparis2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private Button btEvenements, btMesEvenements, btMonProfil;
    private ImageButton btDeConnexion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.btDeConnexion=(ImageButton) findViewById(R.id.idDeconnexion);
        this.btEvenements=(Button) findViewById(R.id.idLesEvnements);
        this.btMesEvenements=(Button) findViewById(R.id.idMesEvenements);
        this.btMonProfil=(Button) findViewById(R.id.idMonProfil);

        this.btMonProfil.setOnClickListener(this);
        this.btMesEvenements.setOnClickListener(this);
        this.btEvenements.setOnClickListener(this);
        this.btDeConnexion.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String email = this.getIntent().getStringExtra("email").toString();
        Intent unIntent = null ;
        switch(v.getId())
        {
            case R.id.idLesEvnements :
                unIntent = new Intent(this, LesEvenements.class);
                unIntent.putExtra("email", email);
                break;
            case R.id.idMesEvenements :
                unIntent = new Intent(this, MesEvenements.class);
                unIntent.putExtra("email", email);
                break;
            case R.id.idMonProfil :
                unIntent = new Intent(this, MonProfil.class);
                unIntent.putExtra("email", email);
                break;
            case R.id.idDeconnexion :
                unIntent = new Intent(this, MainActivity.class);
                break;
        }
        this.startActivity(unIntent);
    }
}