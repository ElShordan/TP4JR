package com.example.tp4jr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {
    private Button btnPrincipalActivityCorrContact, btnPrincipalActivityLlamTel, btnPrincipalActivitySiteWeb,
                   btnPrincipalActivityCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnPrincipalActivityCorrContact = findViewById(R.id.btnPrincipalActivityCorrContact);
        btnPrincipalActivityLlamTel = findViewById(R.id.btnPrincipalActivityLlamTel);
        btnPrincipalActivitySiteWeb = findViewById(R.id.btnPrincipalActivitySiteWeb);
        btnPrincipalActivityCerrarSesion = findViewById(R.id.btnPrincipalActivityCerrarSesion);

        btnPrincipalActivityCorrContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String corr_elec[] = {"queseyo@gmail.com"};
                enviarEmail(corr_elec, "Contacto", "Hola Mundo");
            }
        });

        btnPrincipalActivityLlamTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numTel = "2954666666";

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + numTel));

                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnPrincipalActivitySiteWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/ElShordan/";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnPrincipalActivityCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void enviarEmail(String corr_elec[], String asunto, String mensaje) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, corr_elec);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}