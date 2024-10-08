package com.example.okribateriapsicopedagogica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;

public class registrar_alumno extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_registrar_cuenta, container, false);

        Button registerButton = view.findViewById(R.id.btn_register);
        registerButton.setOnClickListener(v -> {
            String nombre = ((EditText) view.findViewById(R.id.editTextName)).getText().toString().trim();
            String apellido = ((EditText) view.findViewById(R.id.editTextLastname)).getText().toString().trim();
            String rut = ((EditText) view.findViewById(R.id.editTextRut)).getText().toString().trim();
            String correo = ((EditText) view.findViewById(R.id.editTextEmail)).getText().toString().trim();
            String contraseña = ((EditText) view.findViewById(R.id.editTextPassword)).getText().toString().trim();
            String curso = ((Spinner) view.findViewById(R.id.spinnerCourse)).getSelectedItem().toString();

            if (nombre.isEmpty() || apellido.isEmpty() || rut.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(getActivity(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            HashMap<String, String> studentInfo = new HashMap<>();
            studentInfo.put("nombre", nombre);
            studentInfo.put("apellido", apellido);
            studentInfo.put("rut", rut);
            studentInfo.put("correo", correo);
            studentInfo.put("contraseña", contraseña);
            studentInfo.put("curso", curso);

            StudentRepository.getInstance().addStudent(studentInfo);

            // Ir al fragmento de revisión
            revision_alumnos revisionFragment = new revision_alumnos();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.contendor, revisionFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}
