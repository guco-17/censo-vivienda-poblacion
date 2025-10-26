package modelo;

import modelo.Catalogos.Catalogo;

public class TipoVivienda extends Catalogo{
    /*
        Las clases TipoVivienda y ActividadEconomica se quedan "vacías", pero esto es intencional y representa la mejor
        práctica de la POO.
        Al extender Catalogo, ellas automáticamente tienen id y descripcion, eliminando la necesidad de reescribir ese
        código en cada una de las cuatro clases de catálogo.
    */
    
    //CONSTRUCTOR VACIO
    public TipoVivienda() {
        super(0, ""); // Llama al constructor de Catalogo con valores por defecto
    }
    
    //CONSTRUCTOR
    public TipoVivienda(int id, String descripcion) {
        super(id, descripcion);
    }
}
