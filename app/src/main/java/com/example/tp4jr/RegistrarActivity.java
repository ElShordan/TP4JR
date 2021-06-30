package com.example.tp4jr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
    private EditText edtTxtRegistrarActivityNomCom,
                     edtTxtRegistrarActivityUsername,
                     edtTxtRegistrarActivityCorrElec,
                     edtTxtRegistrarActivityContrasenia,
                     edtTxtRegistrarActivityRepContra;
    private Button btnRegistrarActivityGrabar, btnRegistrarActivityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtTxtRegistrarActivityNomCom = findViewById(R.id.edtTxtRegistrarActivityNomCom);
        edtTxtRegistrarActivityUsername = findViewById(R.id.edtTxtRegistrarActivityUsername);
        edtTxtRegistrarActivityCorrElec = findViewById(R.id.edtTxtRegistrarActivityCorrElec);
        edtTxtRegistrarActivityContrasenia = findViewById(R.id.edtTxtRegistrarActivityContrasenia);
        edtTxtRegistrarActivityRepContra = findViewById(R.id.edtTxtRegistrarActivityRepContra);
        btnRegistrarActivityGrabar = findViewById(R.id.btnRegistrarActivityGrabar);
        btnRegistrarActivityLogin = findViewById(R.id.btnRegistrarActivityLogin);

        btnRegistrarActivityGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom_com = edtTxtRegistrarActivityNomCom.getText().toString().trim();
                String username = edtTxtRegistrarActivityUsername.getText().toString().trim();
                String corr_elec = edtTxtRegistrarActivityCorrElec.getText().toString().trim();
                String contrasenia = edtTxtRegistrarActivityContrasenia.getText().toString().trim();
                String rep_contra = edtTxtRegistrarActivityRepContra.getText().toString().trim();

                if(nom_com.isEmpty() || username.isEmpty() || corr_elec.isEmpty() || contrasenia.isEmpty() || rep_contra.isEmpty()) {
                    Toast.makeText(RegistrarActivity.this, "Datos incompletos", Toast.LENGTH_SHORT).show();
                }
                else {
                    saveRegistrarSharedPreferences(nom_com, username, corr_elec, contrasenia, rep_contra);

                    Toast.makeText(RegistrarActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrarActivityLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveRegistrarSharedPreferences(String nom_com, String username, String corr_elec, String contrasenia, String rep_contra) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nom_com", nom_com);
        editor.putString("username", username);
        editor.putString("corr_elec", corr_elec);
        editor.putString("contrasenia", contrasenia);
        editor.putString("rep_contra", rep_contra);
        editor.apply();
    }
}