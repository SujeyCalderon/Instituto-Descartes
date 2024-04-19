package com.sujey.instituto.Models;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty nombre;
    private final StringProperty apellidos;
    private final StringProperty matricula;
    private final IntegerProperty edad;
    private final StringProperty direccion;

    public Student(String nombre, String apellidos, String matricula, int edad, String direccion) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.matricula = new SimpleStringProperty(matricula);
        this.edad = new SimpleIntegerProperty(edad);
        this.direccion = new SimpleStringProperty(direccion);
    }

    public String getNombre() {
        return nombre.get();
    }

    public int getEdad() {
        return edad.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public IntegerProperty edadProperty() {
        return edad;
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public String getMatricula() {
        return matricula.get();
    }

    public String getDireccion() {
        return direccion.get();
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty matriculaProperty() {
        return matricula;
    }


    public void setMatricula(String matricula) {
        this.matricula.set(matricula);
    }

    @Override
    public String toString() {
        return  "Nombre: " + getNombre() +
                ", Apellidos: " + getApellidos() +
                ", Matricula: " + getMatricula() +
                ", Edad: " + getEdad() +
                ", Dirección: " + getDireccion();
    }
}
