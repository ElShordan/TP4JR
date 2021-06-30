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

public class LoginActivity extends AppCompatActivity {
    private EditText edtTxtLoginActivityUsername, edtTxtLoginActivityContrasenia;
    private Button btnLoginActivityRegistrar, btnLoginActivityIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtTxtLoginActivityUsername = findViewById(R.id.edtTxtLoginActivityUsername);
        edtTxtLoginActivityContrasenia = findViewById(R.id.edtTxtLoginActivityContrasenia);
        btnLoginActivityRegistrar = findViewById(R.id.btnLoginActivityRegistrar);
        btnLoginActivityIngresar = findViewById(R.id.btnLoginActivityIngresar);

        btnLoginActivityIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtTxtLoginActivityUsername.getText().toString();
                String contrasenia = edtTxtLoginActivityContrasenia.getText().toString();

                if(username.equals("alumno") && contrasenia.equals("123456")) {
                    saveLoginSharedPreferences(username);

                    Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoginActivityRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveLoginSharedPreferences(String username) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", username);
        editor.apply();
    }
}