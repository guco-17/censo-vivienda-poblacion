package modelo.DAO;

import modelo.ConexionDB;
import modelo.Habitante;
import java.sql.*;
import java.util.ArrayList;
import modelo.ActividadEconomica;
import modelo.DAO.ActividadHabitanteDAO;

public class HabitanteDAO{
    private Connection conn = ConexionDB.getInstance().getConnection();
    
    public HabitanteDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    private Habitante mapearHabitante(ResultSet rs) throws SQLException {
        Habitante h = new Habitante();

        // Mapeo de campos de la tabla Habitante (h.*)
        h.setIdHabitante(rs.getInt("idHabitante"));
        h.setCodigoHabitante(rs.getInt("codigoHabitante"));
        h.setNombre(rs.getString("nombre"));
        h.setPaterno(rs.getString("paterno"));
        h.setMaterno(rs.getString("materno"));
        h.setFechaNacimiento(rs.getDate("fechaNacimiento"));
        h.setGenero(rs.getString("genero"));
        h.setEstadoCivil(rs.getString("estadoCivil"));
        h.setNivelEducacion(rs.getString("nivelEducacion"));
        h.setIdVivienda(rs.getInt("idVivienda"));

        return h;
    }
    
    private boolean eliminarActividadesHabitante(int idHabitante) throws SQLException {
        String sql = "DELETE FROM Habitante_Actividad WHERE idHabitante = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHabitante);
            ps.executeUpdate();
            return true; 
        }
    }
    
    public ActividadEconomica mapearActividadEconomica(ResultSet rs) throws SQLException {
        ActividadEconomica a = new ActividadEconomica();

        // 1. Mapear el ID
        a.setId(rs.getInt("idActividadEconomica"));

        // 2. 💥 CORRECCIÓN: Leer el valor de la columna "descripcion"
        a.setDescripcion(rs.getString("descripcion")); 

        return a;
    }
    
    public boolean agregar(Habitante habitante){
        String sql = "INSERT INTO Habitante (codigoHabitante, nombre, paterno, materno, fechaNacimiento, genero, estadoCivil, nivelEducacion, idVivienda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, habitante.getCodigoHabitante());
            ps.setString(2, habitante.getNombre());
            ps.setString(3, habitante.getPaterno());
            ps.setString(4, habitante.getMaterno());
            ps.setDate(5, new java.sql.Date(habitante.getFechaNacimiento().getTime())); 
            ps.setString(6, habitante.getGenero());
            ps.setString(7, habitante.getEstadoCivil());
            ps.setString(8, habitante.getNivelEducacion());
            ps.setInt(9, habitante.getIdVivienda());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        habitante.setIdHabitante(rs.getInt(1));
                    }
                }
            }
            return filasAfectadas > 0;
        } catch (SQLException e){
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar(Habitante habitante){
        String sql = "UPDATE Habitante SET nombre=?, paterno=?, materno=?, fechaNacimiento=?, genero=?, estadoCivil=?, nivelEducacion=?, idVivienda = ? WHERE codigoHabitante=?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, habitante.getNombre());
            ps.setString(2, habitante.getPaterno());
            ps.setString(3, habitante.getMaterno());
            ps.setDate(4, new java.sql.Date(habitante.getFechaNacimiento().getTime()));
            ps.setString(5, habitante.getGenero());
            ps.setString(6, habitante.getEstadoCivil());
            ps.setString(7, habitante.getNivelEducacion());
            ps.setInt(8, habitante.getIdVivienda());
            ps.setInt(9, habitante.getCodigoHabitante());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM Habitante WHERE codigoHabitante = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Habitante> obtenerTodos(){
        ArrayList<Habitante> habitantes = new ArrayList<>();
        String sql = "SELECT idHabitante, nombre, paterno, materno, fechaNacimiento, genero, estadoCivil, nivelEducacion FROM Habitante";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Habitante h = new Habitante();
                h.setIdHabitante(rs.getInt("idHabitante"));
                h.setNombre(rs.getString("nombre"));
                h.setPaterno(rs.getString("paterno"));
                h.setMaterno(rs.getString("materno"));
                h.setFechaNacimiento(rs.getDate("fechaNacimiento")); // Mapear a Date
                h.setGenero(rs.getString("genero"));
                h.setEstadoCivil(rs.getString("estadoCivil"));
                h.setNivelEducacion(rs.getString("nivelEducacion"));
                habitantes.add(h);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
        }
        return habitantes;
    }
    
    public ArrayList<ActividadEconomica> obtenerActividadesPorHabitante(int idHabitante) throws Exception {
        ArrayList<ActividadEconomica> lista = new ArrayList<>();
        
        // Consulta: JOIN de la tabla M:N (Habitante_Actividad) con la tabla descriptiva (ActividadEconomica)
        String sql = "SELECT ae.idActividadEconomica, ae.descripcion " +
                     "FROM Habitante_Actividad ha " +
                     "JOIN ActividadEconomica ae ON ha.idActividadEconomica = ae.idActividadEconomica " +
                     "WHERE ha.idHabitante = ?";
                     
        // Reutiliza el mapeo de ActividadEconomica del DAO existente (ActividadEconomicaDAO)
        ActividadEconomicaDAO actividadDAO = new ActividadEconomicaDAO(); 

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHabitante);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Usar mapeo auxiliar para ActividadEconomica
                    ActividadEconomica a = actividadDAO.mapearActividadEconomica(rs); 
                    lista.add(a);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener actividades del habitante: " + e.getMessage(), e);
        }
        return lista;
    }
    
    public ArrayList<Habitante> obtenerTodosConRelaciones() throws Exception {
        ArrayList<Habitante> lista = new ArrayList<>();

        String sql = "SELECT h.*, " +
                     "v.calle AS calleVivienda, v.codigoVivienda AS codigoVivienda, " +
                     "l.descripcion AS nombreLocalidad, " +
                     "m.descripcion AS nombreMunicipio " +
                     "FROM Habitante h " +
                     "JOIN Vivienda v ON h.idVivienda = v.idVivienda " +
                     "JOIN Localidad l ON v.idLocalidad = l.idLocalidad " +
                     "JOIN Municipio m ON v.idMunicipio = m.idMunicipio";
        ActividadHabitanteDAO habActDAO = new ActividadHabitanteDAO();
                
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Habitante h = mapearHabitante(rs); 

                h.setCalleVivienda(rs.getString("calleVivienda") + " # " + rs.getInt("codigoVivienda"));
                h.setCodigoVivienda(rs.getInt("codigoVivienda"));
                h.setNombreLocalidad(rs.getString("nombreLocalidad"));
                h.setNombreMunicipio(rs.getString("nombreMunicipio"));
                ArrayList<ActividadEconomica> actividades = habActDAO.obtenerActividadesPorHabitante(h.getIdHabitante());
                h.setActividadesEconomicas(actividades);
                
            
                lista.add(h);
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener todos los habitantes con relaciones: " + e.getMessage(), e);
        }
        return lista;
    }
}
