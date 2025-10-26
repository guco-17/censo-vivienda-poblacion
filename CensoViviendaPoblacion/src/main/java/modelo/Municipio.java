package modelo;

import modelo.Catalogos.Catalogo;

public class Municipio extends Catalogo{
    //ATRIBUTOS UNICOS DE MUNICIPIO + CATALOGO
    private String cve_mun;
    
    //CONSTRUCTOR VACIO
    public Municipio() {
        super(0, "");
    }

    //CONSTRUCTOR
    public Municipio(String cve_mun, int id, String descripcion) {
        super(id, descripcion);
        this.cve_mun = cve_mun;
    }
    
    //GETTERS Y SETTERS
    public String getCve_mun() {
        return cve_mun;
    }

    public void setCve_mun(String cve_mun) {
        this.cve_mun = cve_mun;
    }
}
