package modelo;

import java.util.ArrayList;

public class Vivienda {
    //ATRIBUTOS DE LA ENTIDAD (CAMPOS EN LA BASE DE DATOS)
    private int idVivienda;
    private String calle;
    private int numeroExterior;
    private String colonia;
    private int cuartos;
    private boolean tieneAgua;
    private boolean tieneLuz;
    private boolean tieneGas;
    private int idLocalidad;
    private int idMunicipio;
    private int idTipoVivienda;
    //ATRIBUTOS DE LA LÓGICA DEL NEGOCIO.
    private int totalHabitantes;
    private String tipoVivienda_descripcion;
    private ArrayList<String> actividadesEconomicas;

    //CONSTRUCTOR VACÍO
    public Vivienda() {
    }

    //CONSTRUCTOR
    public Vivienda(int idVivienda, String calle, int numeroExterior, String colonia, int cuartos, boolean tieneAgua, boolean tieneLuz, boolean tieneGas, int idLocalidad, int idMunicipio, int idTipoVivienda) {
        this.idVivienda = idVivienda;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.colonia = colonia;
        this.cuartos = cuartos;
        this.tieneAgua = tieneAgua;
        this.tieneLuz = tieneLuz;
        this.tieneGas = tieneGas;
        this.idLocalidad = idLocalidad;
        this.idMunicipio = idMunicipio;
        this.idTipoVivienda = idTipoVivienda;
    }
    
    //GETTERS Y SETTERS.
    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
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

    public boolean isTieneAgua() {
        return tieneAgua;
    }

    public void setTieneAgua(boolean tieneAgua) {
        this.tieneAgua = tieneAgua;
    }

    public boolean isTieneLuz() {
        return tieneLuz;
    }

    public void setTieneLuz(boolean tieneLuz) {
        this.tieneLuz = tieneLuz;
    }

    public boolean isTieneGas() {
        return tieneGas;
    }

    public void setTieneGas(boolean tieneGas) {
        this.tieneGas = tieneGas;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(int idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public int getTotalHabitantes() {
        return totalHabitantes;
    }

    public void setTotalHabitantes(int totalHabitantes) {
        this.totalHabitantes = totalHabitantes;
    }

    public String getTipoVivienda_descripcion() {
        return tipoVivienda_descripcion;
    }

    public void setTipoVivienda_descripcion(String tipoVivienda_descripcion) {
        this.tipoVivienda_descripcion = tipoVivienda_descripcion;
    }

    public ArrayList<String> getActividadesEconomicas() {
        return actividadesEconomicas;
    }

    public void setActividadesEconomicas(ArrayList<String> actividadesEconomicas) {
        this.actividadesEconomicas = actividadesEconomicas;
    }
}
