package com.example.okribateriapsicopedagogica;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class PerfilActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView rutTextView;
    private TextView emailTextView;
    private TextView courseTextView;
    private Spinner genderSpinner;
    private Spinner batteryStatusSpinner;
    private Button saveButton;
    private HashMap<String, String> studentInfo; // Variable para almacenar la info del estudiante

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nameTextView = findViewById(R.id.nameTextView);
        rutTextView = findViewById(R.id.rutTextView);
        emailTextView = findViewById(R.id.emailTextView);
        courseTextView = findViewById(R.id.courseTextView);
        genderSpinner = findViewById(R.id.genderSpinner);
        batteryStatusSpinner = findViewById(R.id.batteryStatusSpinner);
        saveButton = findViewById(R.id.saveButton);

        // Obtener información del estudiante
        studentInfo = (HashMap<String, String>) getIntent().getSerializableExtra("studentInfo");

        if (studentInfo != null) {
            nameTextView.setText(studentInfo.get("nombre"));
            rutTextView.setText(studentInfo.get("rut"));
            emailTextView.setText(studentInfo.get("correo"));
            courseTextView.setText(studentInfo.get("curso"));
        }

        setupSpinners();

        saveButton.setOnClickListener(v -> {
            // Recoger los datos de los campos
            String updatedName = nameTextView.getText().toString();
            String updatedRut = rutTextView.getText().toString();
            String updatedEmail = emailTextView.getText().toString();
            String updatedCourse = courseTextView.getText().toString();
            String selectedGender = genderSpinner.getSelectedItem().toString();
            String selectedBatteryStatus = batteryStatusSpinner.getSelectedItem().toString();

            // Guardar cambios en el repositorio
            if (studentInfo != null) {
                studentInfo.put("nombre", updatedName);
                studentInfo.put("rut", updatedRut);
                studentInfo.put("correo", updatedEmail);
                studentInfo.put("curso", updatedCourse);
                studentInfo.put("genero", selectedGender);
                studentInfo.put("estadoBaterias", selectedBatteryStatus);

                // Aquí podrías actualizar el repositorio o la base de datos si es necesario
                StudentRepository.getInstance().updateStudent(studentInfo);

                Toast.makeText(PerfilActivity.this, "Cambios guardados", Toast.LENGTH_SHORT).show();
                finish(); // Cerrar la actividad
            } else {
                Toast.makeText(PerfilActivity.this, "Error al guardar cambios", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> batteryAdapter = ArrayAdapter.createFromResource(this,
                R.array.battery_status_array, android.R.layout.simple_spinner_item);
        batteryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        batteryStatusSpinner.setAdapter(batteryAdapter);
    }
}
