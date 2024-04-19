package com.sujey.instituto.Models;


import java.util.ArrayList;

public interface BaseDeDatos {

    boolean updateStudent(Student student);

    boolean saveStudent(Student student);

    ArrayList<Student> getEstudiantes();
}