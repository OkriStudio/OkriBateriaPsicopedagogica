package com.example.okribateriapsicopedagogica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class revision_alumnos extends Fragment {

    private TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_revision_alumnos, container, false);
        tableLayout = view.findViewById(R.id.tableLayout);
        EditText searchEditText = view.findViewById(R.id.searchEditText);
        Button searchButton = view.findViewById(R.id.searchButton);

        // Obtener la lista de estudiantes desde el repositorio
        ArrayList<HashMap<String, String>> studentsList = StudentRepository.getInstance().getStudentsList();
        displayStudents(studentsList);

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

        return view;
    }

    private void displayStudents(ArrayList<HashMap<String, String>> list) {
        tableLayout.removeViews(1, tableLayout.getChildCount() - 1); // Limpiar filas existentes, excepto la cabecera

        for (HashMap<String, String> student : list) {
            TableRow row = new TableRow(getActivity());
            row.setBackgroundResource(R.drawable.table_row_background);
            row.setOnClickListener(v -> {
                // Crear un Intent para ir a la PerfilActivity
                Intent intent = new Intent(getActivity(), PerfilActivity.class);
                intent.putExtra("studentInfo", student); // Pasar la información del estudiante
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
        TextView textView = new TextView(getActivity());
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
