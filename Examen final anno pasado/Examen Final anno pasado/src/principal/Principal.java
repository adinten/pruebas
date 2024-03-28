/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import clases.GestionColegio;
import java.io.FileNotFoundException;
import java.time.LocalDate;

/**
 *
 * @author alvarodintenalonso
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionColegio colegio = new GestionColegio();

        
        //Cargo datos del fichero
        try {

            colegio.cargarDatos();
            System.out.println("Datos del fichero cargados");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        
        /*
        //Doy de alta los alumnos
        colegio.altaAlumno("987456321P", "Juan", "Española");
        colegio.altaAlumno("123987456T", "Alvaro", "Francesa");
        colegio.altaAlumno("523698742H", "Maria", "Española");
        colegio.altaAlumno("569874123W", "Felipe", "Inglesa");
        colegio.altaAlumno("369852147N", "Sandra", "Española");

        //Doy de alta los profesores
        colegio.altaProfesor("654123987Y", "Miguel", "Matematicas");
        colegio.altaProfesor("321789654B", "Laura", "Lengua");
*/
        //Doy de alta las asignaturas
        colegio.altaAsignatura(1, "Matematicas", 500, "654123987Y");
        colegio.altaAsignatura(2, "Lengua", 100, "321789654B");




        //Muestro los alumnos
        System.out.println("\nEstos son alumnos");
        colegio.listarAlumnos();

        //Muestro los profesores
        System.out.println("\nEstos son profesores");
        colegio.listarProfesores();

        //Muestro las asignaturas
        System.out.println("\nEstas son asignaturas, ordenadas por número de horas anuales");
        colegio.listarAsignaturas();

        //Busco un alumno
        System.out.println("\nBusco alumno DNI 369852147N");
        System.out.println(colegio.buscarAlumno("369852147N"));

        //Busco el profesor 
        System.out.println("\nBusco profesor DNI 654123987Y");
        System.out.println(colegio.buscarProfesor("654123987Y"));

        //Busco la asignatura 1
        System.out.println("\nBusco la asignatura con el codigo 1");
        System.out.println(colegio.buscarAsignatura(1));

        //Matriculo a los alumno y compruebo con un profesor
        System.out.println("\nMatriculo al alumno 569874123W en la asignatura 1");
        colegio.matricularAlumno(1, "569874123W");

        System.out.println("\nMatriculo al alumno 523698742H en la asignatura 2");
        colegio.matricularAlumno(2, "523698742H");

        System.out.println("\nMatriculo al alumno 369852147N en la asignatura 2");
        colegio.matricularAlumno(2, "369852147N");

        System.out.println("\nMatriculo al alumno 123987456T en la asignatura 1");
        colegio.matricularAlumno(1, "123987456T");

        System.out.println("\nMatriculo al alumno 123987456T en la asignatura 2");
        colegio.matricularAlumno(2, "123987456T");

        System.out.println("\nMatriculo al profesor 321789654B en la asignatura 3");
        colegio.matricularAlumno(3, "321789654B");

        //Muestro la asignatura 1 con los alumnos matriculados
        System.out.println("\nBusco la asignatura con el codigo 1 y muestro los alumnos matriculados");
        System.out.println(colegio.buscarAsignatura(1));

        //Muestro expediente del alumno 
        System.out.println("\nMuestro el expediente del alumno 123987456T");
        colegio.mostrarExpedienteAlumno("123987456T");

        System.out.println("\nMuestro el expediente del alumno 523698742H");
        colegio.mostrarExpedienteAlumno("523698742H");

        //Muestro expediente del profesor 
        System.out.println("\nMuestro el expediente del profesor 321789654B");
        colegio.mostrarExpedienteProfesor("321789654B");

        System.out.println("\nMuestro el expediente del profesor 654123987Y");
        colegio.mostrarExpedienteProfesor("654123987Y");

        //Mostrar alumnos por año 2024 y asignatura Matematicas
        System.out.println("\nMostrar alumnos del año 2024 y asignatura Matematicas");
        colegio.listarAlumnosAnnoAsignaturas(2024, "Lengua");

        


        //Guardar datos en fichero
        try {
            colegio.guardarDatos();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
