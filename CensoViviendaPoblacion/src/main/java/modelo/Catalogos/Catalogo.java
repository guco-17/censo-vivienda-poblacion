package modelo.Catalogos;

public abstract class Catalogo {
    //ATRIBUTOS DEL CATÁLOGO (COMNUNES PARA CADA CLASE QUE LA EXTIENDA)
    protected int id;
    protected String descripcion;

    //CONSTRUCTOR
    public Catalogo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }    
}
