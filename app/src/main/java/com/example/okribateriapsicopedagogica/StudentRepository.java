package com.example.okribateriapsicopedagogica;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentRepository {
    private static StudentRepository instance;
    private final ArrayList<HashMap<String, String>> studentsList;

    private StudentRepository() {
        studentsList = new ArrayList<>();
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public ArrayList<HashMap<String, String>> getStudentsList() {
        return studentsList;
    }

    public void addStudent(HashMap<String, String> student) {
        studentsList.add(student);
    }

    // Método para actualizar un estudiante
    public void updateStudent(HashMap<String, String> updatedStudent) {
        for (int i = 0; i < studentsList.size(); i++) {
            HashMap<String, String> student = studentsList.get(i);
            // Asumiendo que "rut" es el identificador único
            if (student.get("rut").equals(updatedStudent.get("rut"))) {
                studentsList.set(i, updatedStudent);
                return; // Salir del método una vez actualizado
            }
        }
    }
}
