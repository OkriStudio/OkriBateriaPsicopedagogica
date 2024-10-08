package com.example.okribateriapsicopedagogica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText emailField = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordField = findViewById(R.id.editTextTextPassword);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        // Validar las credenciales
        if (email.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this, PrincipalMenu.class);
            startActivity(intent);
        } else if (email.equals("alumno") && password.equals("123")) {
            Intent intent = new Intent(this, principal_menu2.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}


