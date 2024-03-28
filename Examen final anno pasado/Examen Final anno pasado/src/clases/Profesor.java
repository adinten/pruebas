/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author alvarodintenalonso
 */
public class Profesor extends Persona{
    //Atributos
    private String departamento;

    //Getter and Setter
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    //Constructor
    public Profesor(String dni, String nombre, String departamento) {
        super(nombre, dni);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor / " + super.toString() + ", Departamento=" + departamento;
    }

    @Override
    public String getDatosFormateados() {
        return "P:" + getDni() + ":" + getNombre() + ":" + departamento;
    }
    
    
}
