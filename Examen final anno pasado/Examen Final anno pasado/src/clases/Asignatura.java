/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alvarodintenalonso
 */
public class Asignatura implements Comparable<Asignatura>{
    //Atributos
    private int codigoAsig;
    private String nombreAsig;
    private int horasAnuales;
    private Profesor profesor;
    private ArrayList<Alumno> listaAlumnos;

    //Getter and Setter
    public int getCodigoAsig() {
        return codigoAsig;
    }

    public void setCodigoAsig(int codigoAsig) {
        this.codigoAsig = codigoAsig;
    }

    public String getNombreAsig() {
        return nombreAsig;
    }

    public void setNombreAsig(String nombreAsig) {
        this.nombreAsig = nombreAsig;
    }

    public int getHorasAnuales() {
        return horasAnuales;
    }

    public void setHorasAnuales(int horasAnuales) {
        this.horasAnuales = horasAnuales;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    //Constructor
    public Asignatura(int codigoAsig, String nombreAsig, int horasAnuales, Profesor profesor) {
        this.codigoAsig = codigoAsig;
        this.nombreAsig = nombreAsig;
        this.horasAnuales = horasAnuales;
        this.profesor = profesor;
        this.listaAlumnos = new ArrayList<>();
    }

    public Asignatura(int codigoAsig, String nombreAsig, int horasAnuales, Profesor profesor, ArrayList<Alumno> listaAlumnos) {
        this.codigoAsig = codigoAsig;
        this.nombreAsig = nombreAsig;
        this.horasAnuales = horasAnuales;
        this.profesor = profesor;
        this.listaAlumnos = listaAlumnos;
    }
    
    

    //Metodos
    public void anadirAlumno(Alumno alumno){
        listaAlumnos.add(alumno);
    }
   
    public void buscarAlumnoAsignatura (String dni){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getDni().equalsIgnoreCase(dni)) {
                System.out.println("Asignatura / " + this.getNombreAsig() + ", Codigo= " + this.getCodigoAsig() + ", Horas anuales= " + this.getHorasAnuales() + ", Profesor= " + this.getProfesor().getNombre());
            }
        }
    
    }
    
    
    
    
    public void buscarProfesorAsignatura(String dni){
       
            if (this.profesor.getDni().equalsIgnoreCase(dni)) {
                System.out.println("Asignatura / " + this.getNombreAsig() + ", Codigo= " + this.getCodigoAsig() + ", Horas anuales= " + this.getHorasAnuales() + ", Número de alumnos= " + this.listaAlumnos.size());
            
        }
    }
    
    
    public void buscarAnnoAsignatura(int anno, String asignatura){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getFechaMatriculacion().getYear() == anno && this.nombreAsig.equalsIgnoreCase(asignatura)) {
                System.out.println(listaAlumnos.get(i).toString());
            }
        }
    
    }
    
    
    
    @Override
    public int compareTo(Asignatura o) {
        
        
        if(horasAnuales > o.getHorasAnuales()){
            return 1;
        } else if(horasAnuales < o.getHorasAnuales()){
            return -1;
        } else {
            return 0;
        }
        
       
    }

    @Override
    public String toString() {
        return "Asignatura / " + "codigoAsig=" + codigoAsig + ", nombreAsig=" + nombreAsig + ", horasAnuales=" + horasAnuales + ", profesor=" + profesor + ", listaAlumnos=" + listaAlumnos;
    }
    

    public String getDatosFormateados() {
        return "asignatura:" + this.codigoAsig + ":" + this.nombreAsig + ":" + this.horasAnuales + ":" + this.profesor + ":" + this.listaAlumnos;
    }
}
