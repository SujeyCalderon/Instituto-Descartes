package com.sujey.instituto.Models;

import java.util.ArrayList;

public class Instituto {
    private ArrayList<BaseDeDatos> listaEstudiantes;

    public Instituto(ArrayList<BaseDeDatos> basesDeDatos) {
        this.listaEstudiantes = basesDeDatos;
    }

    public void save(Student student) {
        for (BaseDeDatos baseDeDatos : listaEstudiantes) {
            baseDeDatos.saveStudent(student);
        }
    }

    public void update(Student student) {
        for (BaseDeDatos baseDeDatos : listaEstudiantes) {
            baseDeDatos.updateStudent(student);
        }
    }
}