package modelo;

import java.util.ArrayList;

public class Vivienda {
    //ATRIBUTOS DE LA ENTIDAD (CAMPOS EN LA BASE DE DATOS)
    private int idVivienda;
    private int codigoVivienda;
    private String calle;
    private int numeroExterior;
    private String colonia;
    private int cuartos;
    private String tieneAgua;
    private String tieneLuz;
    private String tieneGas;
    private int idLocalidad;
    private int idTipoVivienda;
    //ATRIBUTOS DE LA LÓGICA DEL NEGOCIO.
    private ArrayList<Habitante> habitantes;
    private int totalHabitantes;

    //CONSTRUCTOR VACÍO
    public Vivienda() {
    }

    //CONSTRUCTOR
    public Vivienda(int idVivienda, int codigoVivenda, String calle, int numeroExterior, String colonia, int cuartos, String tieneAgua, String tieneLuz, String tieneGas, int idLocalidad, int idTipoVivienda) {
        this.idVivienda = idVivienda;
        this.codigoVivienda = codigoVivenda;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.colonia = colonia;
        this.cuartos = cuartos;
        this.tieneAgua = tieneAgua;
        this.tieneLuz = tieneLuz;
        this.tieneGas = tieneGas;
        this.idLocalidad = idLocalidad;
        this.idTipoVivienda = idTipoVivienda;
    }

    //GETTERS Y SETTERS
    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public int getCodigoVivienda() {
        return codigoVivienda;
    }

    public void setCodigoVivienda(int codigoVivienda) {
        this.codigoVivienda = codigoVivienda;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(int numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCuartos() {
        return cuartos;
    }

    public void setCuartos(int cuartos) {
        this.cuartos = cuartos;
    }

    public String getTieneAgua() {
        return tieneAgua;
    }

    public void setTieneAgua(String tieneAgua) {
        this.tieneAgua = tieneAgua;
    }

    public String getTieneLuz() {
        return tieneLuz;
    }

    public void setTieneLuz(String tieneLuz) {
        this.tieneLuz = tieneLuz;
    }

    public String getTieneGas() {
        return tieneGas;
    }

    public void setTieneGas(String tieneGas) {
        this.tieneGas = tieneGas;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(int idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public ArrayList<Habitante> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(ArrayList<Habitante> habitantes) {
        this.habitantes = habitantes;
    }

    public int getTotalHabitantes() {
        return totalHabitantes;
    }

    public void setTotalHabitantes(int totalHabitantes) {
        this.totalHabitantes = totalHabitantes;
    }
}
