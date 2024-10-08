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
}
