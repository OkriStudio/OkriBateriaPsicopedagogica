package com.example.okribateriapsicopedagogica;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class RegistrarCuenta extends AppCompatActivity {

    // Lista para guardar los estudiantes
    public static ArrayList<HashMap<String, String>> studentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);

        Button registerButton = findViewById(R.id.btn_register);
        registerButton.setOnClickListener(v -> {
            // Obtener los datos del formulario
            String nombre = ((EditText) findViewById(R.id.editTextName)).getText().toString().trim();
            String apellido = ((EditText) findViewById(R.id.editTextLastname)).getText().toString().trim();
            String rut = ((EditText) findViewById(R.id.editTextRut)).getText().toString().trim();
            String correo = ((EditText) findViewById(R.id.editTextEmail)).getText().toString().trim();
            String contraseña = ((EditText) findViewById(R.id.editTextPassword)).getText().toString().trim();
            String curso = ((Spinner) findViewById(R.id.spinnerCourse)).getSelectedItem().toString();

            // Validar los campos
            if (nombre.isEmpty() || apellido.isEmpty() || rut.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Guardar en HashMap
            HashMap<String, String> studentInfo = new HashMap<>();
            studentInfo.put("nombre", nombre);
            studentInfo.put("apellido", apellido);
            studentInfo.put("rut", rut);
            studentInfo.put("correo", correo);
            studentInfo.put("contraseña", contraseña);
            studentInfo.put("curso", curso);

            // Añadir el estudiante a la lista
            studentsList.add(studentInfo);

            // Ir a la actividad de revisión
            Intent intent = new Intent(RegistrarCuenta.this, Revision_tabla.class);
            intent.putExtra("studentsList", studentsList);
            startActivity(intent);

        });
    }
}
