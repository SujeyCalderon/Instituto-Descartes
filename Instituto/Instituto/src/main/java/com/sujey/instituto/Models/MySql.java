package com.sujey.instituto.Models;

import java.util.ArrayList;

public class MySql implements BaseDeDatos {
    private static ArrayList<Student> estudiantes = new ArrayList<>();
    @Override
    public boolean updateStudent(Student student) {
        for (int i = 0; i < estudiantes.size(); i++) {
            Student existingStudent = estudiantes.get(i);
            if (existingStudent.getNombre().equals(student.getNombre())) {
                estudiantes.set(i, student);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveStudent(Student student) {
        return estudiantes.add(student);
    }

    @Override
    public ArrayList<Student> getEstudiantes() {
        return estudiantes;
    }


}