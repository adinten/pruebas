/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;

/**
 *
 * @author alvarodintenalonso
 */
public class Alumno extends Persona{
    private LocalDate fechaMatriculacion;
    private String nacionalidad;
    

    //Setter and getter
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    

    //Constructor
    public Alumno(String dni, String nombre, String nacionalidad) {
        super(nombre, dni);
        this.fechaMatriculacion = LocalDate.now();
        this.nacionalidad = nacionalidad;
    }

    public Alumno(String dni, String nombre, String nacionalidad, LocalDate fechaNatriculacion) {
        super(nombre, dni);
        this.fechaMatriculacion = fechaNatriculacion;
        this.nacionalidad = nacionalidad;
    }
    
    
    @Override
    public String toString() {
        return "Alumno / " + super.toString() + ", Fecha de matriculacion=" + fechaMatriculacion + ", Nacionalidad=" + nacionalidad;
    }

    @Override
    public String getDatosFormateados() {
        return "A:" + getDni() + ":" + getNombre() + ":" + nacionalidad + ":" + fechaMatriculacion;
    }
    
    
}
