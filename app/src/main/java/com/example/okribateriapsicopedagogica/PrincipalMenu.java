package com.example.okribateriapsicopedagogica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PrincipalMenu extends AppCompatActivity {

    private boolean isOptionsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal_menu);

        // borde
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // botón flotante
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        // las opciones
        Button option1 = findViewById(R.id.option1);
        Button option2 = findViewById(R.id.option2);
        Button option3 = findViewById(R.id.option3);
        Button option4 = findViewById(R.id.option4);
        Button option5 = findViewById(R.id.option5);
        Button option6= findViewById(R.id.option6);
        Button option7 = findViewById(R.id.option7);

        //botón flotante
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOptionsVisible) {
                    // Ocultar las opciones
                    option1.setVisibility(View.GONE);
                    option2.setVisibility(View.GONE);
                    option3.setVisibility(View.GONE);
                    option4.setVisibility(View.GONE);
                    option5.setVisibility(View.GONE);
                    option6.setVisibility(View.GONE);
                    option7.setVisibility(View.GONE);
                } else {
                    // Mostrar las opciones
                    option1.setVisibility(View.VISIBLE);
                    option2.setVisibility(View.VISIBLE);
                    option3.setVisibility(View.VISIBLE);
                    option4.setVisibility(View.VISIBLE);
                    option5.setVisibility(View.VISIBLE);
                    option6.setVisibility(View.VISIBLE);
                    option7.setVisibility(View.VISIBLE);
                }
                // Cambiar el estado
                isOptionsVisible = !isOptionsVisible;
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PrincipalMenu.this, PrincipalMenu.class);
                startActivity(intent);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PrincipalMenu.this, ForoAlumnos.class);
                startActivity(intent);
            }
        });


        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PrincipalMenu.this, FormularioBateria.class);
                startActivity(intent);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PrincipalMenu.this, ForoAlumnos.class);
                startActivity(intent);
            }
        });
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PrincipalMenu.this, ForoAlumnos.class);
                startActivity(intent);
            }
        });


    }
}
