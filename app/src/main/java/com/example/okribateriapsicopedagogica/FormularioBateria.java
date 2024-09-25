package com.example.okribateriapsicopedagogica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class FormularioBateria extends AppCompatActivity {

    EditText editTextNombre, editTextRUT;
    RadioGroup radioGroupHistoria, radioGroupRazonamiento, radioGroupMatematicas, radioGroupLenguaje;
    Button buttonEnviar;
    Spinner spinnerCurso;
    HashMap<String, HashMap<String, String>> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_bateria);

        // Inicializar vistas
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextRUT = findViewById(R.id.editTextRUT);
        radioGroupHistoria = findViewById(R.id.radioGroupHistoria);
        radioGroupRazonamiento = findViewById(R.id.radioGroupRazonamiento);
        radioGroupMatematicas = findViewById(R.id.radioGroupMatematicas);
        radioGroupLenguaje = findViewById(R.id.radioGroupLenguaje);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        spinnerCurso = findViewById(R.id.spinnerCurso);

        // Inicializar el HashMap para guardar los resultados
        alumnos = new HashMap<>();

        // Configurar el Spinner y array de los cursos
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.courses_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurso.setAdapter(adapter);


        buttonEnviar.setOnClickListener(view -> {
            String nombre = editTextNombre.getText().toString();
            String rut = editTextRUT.getText().toString();
            int puntajeTotal = calcularPuntaje();

            if (nombre.isEmpty() || rut.isEmpty()) {
                Toast.makeText(FormularioBateria.this, "Por favor complete todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }


            String curso = spinnerCurso.getSelectedItem().toString();


            HashMap<String, String> infoAlumno = new HashMap<>();
            infoAlumno.put("nombre", nombre);
            infoAlumno.put("rut", rut);
            infoAlumno.put("curso", curso);
            infoAlumno.put("puntaje", String.valueOf(puntajeTotal));
            infoAlumno.put("rendimiento", determinarRendimiento(puntajeTotal));

            alumnos.put(rut, infoAlumno);


            Intent intent = new Intent(FormularioBateria.this, TablaBaterias.class);
            intent.putExtra("alumnos", alumnos);
            startActivity(intent);
            // Feedback
            Toast.makeText(FormularioBateria.this, "Formulario enviado correctamente.", Toast.LENGTH_SHORT).show();
        });
    }

    private int calcularPuntaje() {
        int puntaje = 0;
        puntaje += obtenerPuntajePregunta(radioGroupHistoria);
        puntaje += obtenerPuntajePregunta(radioGroupRazonamiento);
        puntaje += obtenerPuntajePregunta(radioGroupMatematicas);
        puntaje += obtenerPuntajePregunta(radioGroupLenguaje);
        return puntaje;
    }

    private int obtenerPuntajePregunta(RadioGroup radioGroup) {
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId == -1) return 0;

        RadioButton radioButton = findViewById(radioButtonId);
        String respuesta = radioButton.getText().toString();

        switch (respuesta) {
            case "A":
                return 3;
            case "B":
            case "C":
                return 1;
            default:
                return 0;
        }
    }

    private String determinarRendimiento(int puntaje) {
        if (puntaje >= 9) {
            return "Alto";
        } else if (puntaje >= 6) {
            return "Medio";
        } else {
            return "Bajo";
        }
    }
}
