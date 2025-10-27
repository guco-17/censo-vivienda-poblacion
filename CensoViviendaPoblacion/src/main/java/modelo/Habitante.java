package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Habitante {
    //ATRIBUTOS DE LA ENTIDAD (CAMPOS EN LA BD)
    private int idHabitante;
    private int codigoHabitante;
    private String nombre;
    private String paterno;
    private String materno;
    private Date fechaNacimiento;
    private String genero;
    private String estadoCivil;
    private String nivelEducacion;
    //LLAVE FORANEA
    private int idVivienda;
    private Vivienda vivienda;
    //ATRIBUTOS DE LA LOGICA DE NEGOCIO
    private int edad;
    private ArrayList<ActividadEconomica> actividadesEconomicas;
    private String calleVivienda;
    private int codigoVivienda;
    private String nombreLocalidad;
    private String nombreMunicipio;
    
    //CONSTYRUCTOR VACIO
    public Habitante() {
    }

    //CONSTRUCTOR
    public Habitante(int idHabitante, int codigoHabitante,  String nombre, String paterno, String materno, Date fechaNacimiento, String genero, String estadoCivil, String nivelEducacion, int idVivienda) {
        this.idHabitante = idHabitante;
        this.codigoHabitante = codigoHabitante;
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

    public int getCodigoHabitante() {
        return codigoHabitante;
    }

    public void setCodigoHabitante(int codigoHabitante) {
        this.codigoHabitante = codigoHabitante;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public ArrayList<ActividadEconomica> getActividadesEconomicas() {
        return actividadesEconomicas;
    }

    public void setActividadesEconomicas(ArrayList<ActividadEconomica> actividadesEconomicas) {
        this.actividadesEconomicas = actividadesEconomicas;
    }

    public String getCalleVivienda() {
        return calleVivienda;
    }

    public void setCalleVivienda(String calleVivienda) {
        this.calleVivienda = calleVivienda;
    }

    public int getCodigoVivienda() {
        return codigoVivienda;
    }

    public void setCodigoVivienda(int codigoVivienda) {
        this.codigoVivienda = codigoVivienda;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
}