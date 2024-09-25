package com.example.okribateriapsicopedagogica;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class TablaBaterias extends AppCompatActivity {

    TableLayout tableLayoutAlumnos;
    EditText searchBar;
    HashMap<String, HashMap<String, String>> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_baterias);

        // Inicializar las vistas
        tableLayoutAlumnos = findViewById(R.id.tableLayoutAlumnos);
        searchBar = findViewById(R.id.searchBar);


        alumnos = (HashMap<String, HashMap<String, String>>) getIntent().getSerializableExtra("alumnos");


        mostrarAlumnos(alumnos);

        // Añadir un TextWatcher para el campo de búsqueda
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarAlumnos(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void mostrarAlumnos(HashMap<String, HashMap<String, String>> listaAlumnos) {
        tableLayoutAlumnos.removeAllViews(); // Limpiar la tabla antes de agregar filas nuevas


        TableRow headerRow = new TableRow(this);
        headerRow.setBackgroundColor(getResources().getColor(R.color.Morado_500));

        TextView headerNombre = new TextView(this);
        headerNombre.setText("Nombre");
        headerNombre.setTextColor(getResources().getColor(android.R.color.white));
        headerNombre.setPadding(8, 8, 8, 8);
        headerRow.addView(headerNombre);

        TextView headerRUT = new TextView(this);
        headerRUT.setText("RUT");
        headerRUT.setTextColor(getResources().getColor(android.R.color.white));
        headerRUT.setPadding(8, 8, 8, 8);
        headerRow.addView(headerRUT);

        TextView headerCurso = new TextView(this);
        headerCurso.setText("Curso");
        headerCurso.setTextColor(getResources().getColor(android.R.color.white));
        headerCurso.setPadding(8, 8, 8, 8);
        headerRow.addView(headerCurso);

        TextView headerPuntaje = new TextView(this);
        headerPuntaje.setText("Puntaje");
        headerPuntaje.setTextColor(getResources().getColor(android.R.color.white));
        headerPuntaje.setPadding(8, 8, 8, 8);
        headerRow.addView(headerPuntaje);

        TextView headerRendimiento = new TextView(this);
        headerRendimiento.setText("Rendimiento");
        headerRendimiento.setTextColor(getResources().getColor(android.R.color.white));
        headerRendimiento.setPadding(8, 8, 8, 8);
        headerRow.addView(headerRendimiento);

        tableLayoutAlumnos.addView(headerRow);


        for (String rut : listaAlumnos.keySet()) {
            HashMap<String, String> infoAlumno = listaAlumnos.get(rut);

            TableRow row = new TableRow(this);
            row.setBackgroundColor(getResources().getColor(R.color.light_blue_100));

            TextView textViewNombre = new TextView(this);
            textViewNombre.setText(infoAlumno.get("nombre"));
            textViewNombre.setPadding(8, 8, 8, 8);
            row.addView(textViewNombre);

            TextView textViewRUT = new TextView(this);
            textViewRUT.setText(infoAlumno.get("rut"));
            textViewRUT.setPadding(8, 8, 8, 8);
            row.addView(textViewRUT);

            TextView textViewCurso = new TextView(this);
            textViewCurso.setText(infoAlumno.get("curso")); // Mostramos el curso
            textViewCurso.setPadding(8, 8, 8, 8);
            row.addView(textViewCurso);

            TextView textViewPuntaje = new TextView(this);
            textViewPuntaje.setText(infoAlumno.get("puntaje"));
            textViewPuntaje.setPadding(8, 8, 8, 8);
            row.addView(textViewPuntaje);

            TextView textViewRendimiento = new TextView(this);
            textViewRendimiento.setText(infoAlumno.get("rendimiento"));
            textViewRendimiento.setPadding(8, 8, 8, 8);
            row.addView(textViewRendimiento);

            tableLayoutAlumnos.addView(row);
        }
    }

    private void filtrarAlumnos(String texto) {
        HashMap<String, HashMap<String, String>> alumnosFiltrados = new HashMap<>();

        for (String rut : alumnos.keySet()) {
            HashMap<String, String> infoAlumno = alumnos.get(rut);
            String nombre = infoAlumno.get("nombre");
            String alumnoRUT = infoAlumno.get("rut");

            if (nombre.toLowerCase().contains(texto.toLowerCase()) || alumnoRUT.contains(texto)) {
                alumnosFiltrados.put(rut, infoAlumno);
            }
        }

        // Mostrar solo los alumnos que coinciden con la búsqueda
        mostrarAlumnos(alumnosFiltrados);
    }
}

