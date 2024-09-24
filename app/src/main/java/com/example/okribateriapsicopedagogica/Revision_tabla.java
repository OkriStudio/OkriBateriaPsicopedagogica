package com.example.okribateriapsicopedagogica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Revision_tabla extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> studentsList;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revision_tabla);

        // Obtener la lista de estudiantes desde la intención
        studentsList = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("studentsList");

        tableLayout = findViewById(R.id.tableLayout);
        EditText searchEditText = findViewById(R.id.searchEditText);
        Button searchButton = findViewById(R.id.searchButton);

        // Mostrar los estudiantes en la tabla
        displayStudents(studentsList);

        // Búsqueda
        searchButton.setOnClickListener(v -> {
            String query = searchEditText.getText().toString().toLowerCase();
            ArrayList<HashMap<String, String>> filteredList = new ArrayList<>();

            for (HashMap<String, String> student : studentsList) {
                if (student.get("nombre").toLowerCase().contains(query) ||
                        student.get("apellido").toLowerCase().contains(query) ||
                        student.get("rut").toLowerCase().contains(query) ||
                        student.get("correo").toLowerCase().contains(query)) {
                    filteredList.add(student);
                }
            }
            displayStudents(filteredList);
            hideKeyboard();
        });
    }

    private void displayStudents(ArrayList<HashMap<String, String>> list) {
        tableLayout.removeAllViews();

        // Encabezados de la tabla
        TableRow headerRow = new TableRow(this);
        headerRow.addView(createTextView("Nombre"));
        headerRow.addView(createTextView("Apellido"));
        headerRow.addView(createTextView("RUT"));
        headerRow.addView(createTextView("Correo"));
        headerRow.addView(createTextView("Curso"));
        tableLayout.addView(headerRow);

        // Agregar filas para cada estudiante
        for (HashMap<String, String> student : list) {
            TableRow row = new TableRow(this);
            row.setBackgroundResource(R.drawable.table_row_background); // Fondo para cada fila

            row.setOnClickListener(v -> {
                Intent intent = new Intent(Revision_tabla.this, PerfilActivity.class);
                intent.putExtra("studentInfo", student);
                startActivity(intent);
            });

            row.addView(createTextView(student.get("nombre")));
            row.addView(createTextView(student.get("apellido")));
            row.addView(createTextView(student.get("rut")));
            row.addView(createTextView(student.get("correo")));
            row.addView(createTextView(student.get("curso")));

            tableLayout.addView(row);
        }
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
