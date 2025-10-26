package modelo.DAO;

import java.sql.Connection;
import modelo.ActividadEconomica;

public class ActividadEconomicaDAO extends CatalogoDAO<ActividadEconomica>{
    public ActividadEconomicaDAO(Connection conn, String nombreTabla, Class<ActividadEconomica> tipoClase) {
        super(conn, nombreTabla, tipoClase);
    }
    
}
