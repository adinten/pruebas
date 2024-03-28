/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author alvarodintenalonso
 */
public class GestionColegio {

    private ArrayList<Asignatura> listaAsignaturas;
    private ArrayList<Persona> listaPersonal;

    //Setter and getter
    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    //Constructor
    public GestionColegio(ArrayList<Asignatura> listaAsignaturas, ArrayList<Persona> listaPersonal) {
        this.listaAsignaturas = listaAsignaturas;
        this.listaPersonal = listaPersonal;
    }

    public GestionColegio() {
        listaAsignaturas = new ArrayList<>();
        listaPersonal = new ArrayList<>();
    }

    //Métodos
    //listar Alumnos
    public void listarAlumnos() {
        for (Persona alumno : listaPersonal) {
            if (alumno instanceof Alumno) {
                System.out.println(alumno);
            }
        }
    }

    //Listar profesores
    public void listarProfesores() {
        for (Persona profesor : listaPersonal) {
            if (profesor instanceof Profesor) {
                System.out.println(profesor);
            }
        }
    }

    //listar asignaturas
    public void listarAsignaturas() {
        for (Asignatura asignaturas : listaAsignaturas) {

            System.out.println(asignaturas);

        }
    }

    //Dar de alta alumno
    public void altaAlumno(String dni, String nombre, String nacionalidad) {
        listaPersonal.add(new Alumno(dni, nombre, nacionalidad));
    }

    public void altaAlumno(String dni, String nombre, String nacionalidad, LocalDate fechaMatriculacion) {
        listaPersonal.add(new Alumno(dni, nombre, nacionalidad));
    }

    //Dar de alta Profesor
    public void altaProfesor(String dni, String nombre, String departamento) {
        listaPersonal.add(new Profesor(dni, nombre, departamento));
    }

    //Dar alta Asignatura
    public void altaAsignatura(int codigoAsig, String nombreAsig, int horasAnuales, String dniProfesor) {
        Profesor profesor = buscarProfesor(dniProfesor);

        if (buscarBooleanProfesor(dniProfesor) && !buscarBooleanAsignatura(codigoAsig)) {
            listaAsignaturas.add(new Asignatura(codigoAsig, nombreAsig, horasAnuales, profesor));
            Collections.sort(listaAsignaturas);
            System.out.println("Asignatura creada");
        }

    }

    //Matricular alumno en asignatura
    public void matricularAlumno(int codigoAsig, String dni) {

        Alumno alumno = buscarAlumno(dni);
        Asignatura asignatura = buscarAsignatura(codigoAsig);

        if (buscarBooleanAsignatura(codigoAsig) && buscarBooleanAlumno(dni)) {
            asignatura.anadirAlumno(alumno);

            System.out.println("Alumno Matriculado");
        } else {
            if (alumno == null) {
                System.out.println("El Alumno no existe");
            }
            if (asignatura == null) {
                System.out.println("La asignatura no existe");
            }
        }

    }

    //Mostrar expediente Alumno
    public void mostrarExpedienteAlumno(String dni) {
        Alumno alumno = buscarAlumno(dni);
        System.out.println(alumno.toString());
        for (int i = 0; i < listaAsignaturas.size(); i++) {
            listaAsignaturas.get(i).buscarAlumnoAsignatura(dni);
        }

    }

    //Mostrar expediente Profesor
    public void mostrarExpedienteProfesor(String dni) {
        Profesor profesor = buscarProfesor(dni);
        System.out.println(profesor.toString());

        for (int i = 0; i < listaAsignaturas.size(); i++) {
            listaAsignaturas.get(i).buscarProfesorAsignatura(dni);
        }

    }

    //listar alumnos de una asignatura y año
    public void listarAlumnosAnnoAsignaturas(int anno, String asignatura) {
        for (int i = 0; i < listaAsignaturas.size(); i++) {
            listaAsignaturas.get(i).buscarAnnoAsignatura(anno, asignatura);
        }

    }

    //buscar ALumno
    public Alumno buscarAlumno(String dni) {
        for (Persona persona : listaPersonal) {
            if (persona instanceof Alumno alumno) {
                if (persona.getDni().equals(dni)) {
                    return alumno;
                }
            }
        }
        return null;
    }

    //buscar Boolean ALumno
    public boolean buscarBooleanAlumno(String dni) {
        for (Persona persona : listaPersonal) {
            if (persona instanceof Alumno) {
                if (persona.getDni().equals(dni)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Buscar profesor
    public Profesor buscarProfesor(String dni) {
        for (Persona persona : listaPersonal) {
            if (persona instanceof Profesor profesor) {
                if (persona.getDni().equals(dni)) {
                    return profesor;
                }
            }
        }
        return null;
    }

    //Buscar boolean profesor
    public boolean buscarBooleanProfesor(String dni) {
        for (Persona persona : listaPersonal) {
            if (persona instanceof Profesor) {
                if (persona.getDni().equalsIgnoreCase(dni)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Buscar asignatura
    public Asignatura buscarAsignatura(int codigoAsig) {

        for (Asignatura asignatura : listaAsignaturas) {

            if (asignatura.getCodigoAsig() == codigoAsig) {
                return asignatura;
            }

        }
        return null;
    }

    //Buscar boolean asignatura
    public boolean buscarBooleanAsignatura(int codigoAsig) {

        for (Asignatura asignatura : listaAsignaturas) {

            if (asignatura.getCodigoAsig() == codigoAsig) {
                return true;
            }

        }
        return false;
    }


    public void guardarDatos() throws FileNotFoundException {

        PrintWriter escritor = new PrintWriter("datos.txt");
        for (Persona persona : listaPersonal) {
            escritor.println(persona.getDatosFormateados());
        }

        for (Asignatura asignatura : listaAsignaturas) {
            escritor.println(asignatura.getDatosFormateados());
        }
        escritor.close();
    }

    public void cargarDatos() throws FileNotFoundException {
        Scanner lector = new Scanner(new File("datos.txt"));
        while (lector.hasNextLine()) {
            String[] datos = lector.nextLine().split(":");
            if (datos[0].equals("A")) {
                // Es un alumno
                altaAlumno(datos[1], datos[2], datos[3], LocalDate.parse(datos[4]));
            } else if (datos[0].equals("P")) {
                // Es un profesor
                altaProfesor(datos[1], datos[2], datos[3]);
            } else {
                // Es una asignatura
                //listaAsignaturas.add(new Asignatura(Integer.parseInt(datos[1]),datos[2], Integer.parseInt(datos[3]), (profesor)datos[4], datos[5]));
                altaAsignatura(Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4]);
            }
        }
        Collections.sort(listaAsignaturas);
        lector.close();
    }

}
