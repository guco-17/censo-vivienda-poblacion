package modelo;

import modelo.Catalogos.Catalogo;

public class TipoVivienda extends Catalogo{
    //CONSTRUCTOR VACIO
    public TipoVivienda() {
        super(0, ""); // Llama al constructor de Catalogo con valores por defecto
    }
    
    //CONSTRUCTOR
    public TipoVivienda(int id, String descripcion) {
        super(id, descripcion);
    }
}
