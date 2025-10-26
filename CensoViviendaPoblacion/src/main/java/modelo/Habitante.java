package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Habitante {
    //ATRIBUTOS DE LA ENTIDAD (CAMPOS EN LA BD)
    private int idHabitante;
    private String nombre;
    private String paterno;
    private String materno;
    private Date fechaNacimiento;
    private char genero;
    private String estadoCivil;
    private String nivelEducacion;
    private int idVivienda;
    //ATRIBUTOS DE LA LOGICA DE NEGOCIO
    private int edad;
    private String viviendaCalle;
    private ArrayList<String> actividadesEconomicas;
    
    //CONSTYRUCTOR VACIO
    public Habitante() {
    }

    //CONSTRUCTOR
    public Habitante(int idHabitante, String nombre, String paterno, String materno, Date fechaNacimiento, char genero, String estadoCivil, String nivelEducacion, int idVivienda) {
        this.idHabitante = idHabitante;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.nivelEducacion = nivelEducacion;
        this.idVivienda = idVivienda;
    }

    //GETTERS Y SETTERS
    public int getIdHabitante() {
        return idHabitante;
    }

    public void setIdHabitante(int idHabitante) {
        this.idHabitante = idHabitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getViviendaCalle() {
        return viviendaCalle;
    }

    public void setViviendaCalle(String viviendaCalle) {
        this.viviendaCalle = viviendaCalle;
    }

    public ArrayList<String> getActividadesEconomicas() {
        return actividadesEconomicas;
    }

    public void setActividadesEconomicas(ArrayList<String> actividadesEconomicas) {
        this.actividadesEconomicas = actividadesEconomicas;
    }

}
