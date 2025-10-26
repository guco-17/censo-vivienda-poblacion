package modelo;

import modelo.Catalogos.Catalogo;

public class ActividadEconomica extends Catalogo{
    /*
        Las clases TipoVivienda y ActividadEconomica se quedan "vacías", pero esto es intencional y representa la mejor
        práctica de la POO.
        Al extender Catalogo, ellas automáticamente tienen id y descripcion, eliminando la necesidad de reescribir ese
        código en cada una de las cuatro clases de catálogo.
    */
    
    //CONSTRUCTOR VACÍO
    public ActividadEconomica() {
        super(0, "");
    }
    
    //CONSTRUCTOR
    public ActividadEconomica(int id, String descripcion) {
        super(id, descripcion);
    }
}
