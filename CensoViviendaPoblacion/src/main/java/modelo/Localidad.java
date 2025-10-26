package modelo;

import modelo.Catalogos.Catalogo;

public class Localidad extends Catalogo{
    //ATRIBUTOS UNICOS DE LOCALIDA + CATALOGO
    private String cve_loc;
    private int idMunicipio;
    
    //CONSTRUCTOR VACIO
    public Localidad() {
        super(0, "");
    }

    //CONSTRUCTOR
    public Localidad(int id, String descripcion, String cve_loc, int idMunicipio) {
        super(id, descripcion);
        this.cve_loc = cve_loc;
        this.idMunicipio = idMunicipio;
    }
    
    //GETTERS Y SETTERS
    public String getCve_loc() {
        return cve_loc;
    }

    public void setCve_loc(String cve_loc) {
        this.cve_loc = cve_loc;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
