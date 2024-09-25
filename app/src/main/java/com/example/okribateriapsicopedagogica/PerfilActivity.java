package com.example.okribateriapsicopedagogica;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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



        HashMap<String, String> studentInfo = (HashMap<String, String>) getIntent().getSerializableExtra("studentInfo");


        if (studentInfo != null) {
            nameTextView.setText(studentInfo.get("nombre"));
            rutTextView.setText(studentInfo.get("rut"));
            emailTextView.setText(studentInfo.get("correo"));
            courseTextView.setText(studentInfo.get("curso"));
        }


        setupSpinners();


        saveButton.setOnClickListener(v -> {

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
