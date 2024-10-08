package com.example.okribateriapsicopedagogica; // Cambia esto por el nombre de tu paquete

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Baterias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baterias); // Cambia esto por el nombre de tu XML si es diferente

        // Inicializar los botones
        Button buttonGrade1 = findViewById(R.id.buttonGrade1);
        Button buttonGrade2 = findViewById(R.id.buttonGrade2);
        Button buttonGrade3 = findViewById(R.id.buttonGrade3);
        Button buttonGrade4 = findViewById(R.id.buttonGrade4);
        Button buttonGrade5 = findViewById(R.id.buttonGrade5);
        Button buttonGrade6 = findViewById(R.id.buttonGrade6);
        Button buttonGrade7 = findViewById(R.id.buttonGrade7);
        Button buttonGrade8 = findViewById(R.id.buttonGrade8);
        Button buttonReviewBaterias = findViewById(R.id.buttonReviewBaterias);

        // Configuración de click listeners para cada botón
        buttonGrade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes iniciar la actividad correspondiente o realizar otra acción
                Toast.makeText(Baterias.this, "Batería de Grado 1 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 2 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 3 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 4 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 5 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 6 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 7 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGrade8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Baterias.this, "Batería de Grado 8 seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonReviewBaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes iniciar la actividad para revisar baterías
                Intent intent = new Intent(Baterias.this, TablaBaterias.class); // Cambia por tu clase correspondiente
                startActivity(intent);
            }
        });
    }
}
