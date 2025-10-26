package modelo.DAO;

import modelo.ConexionDB;
import modelo.Vivienda;
import java.sql.*;
import java.util.ArrayList;

public class ViviendaDAO {
    private Connection conn = ConexionDB.getInstance().getConnection();

    public ViviendaDAO() {
        this.conn = ConexionDB.getInstance().getConnection();
    }
    
    private Vivienda mapearVivienda(ResultSet rs) throws SQLException {
        Vivienda v = new Vivienda();
        v.setIdVivienda(rs.getInt("idVivienda"));
        v.setCodigoVivienda(rs.getInt("codigoVivienda"));
        v.setCalle(rs.getString("calle"));
        v.setNumeroExterior(rs.getInt("numeroExterior"));
        v.setColonia(rs.getString("colonia"));
        v.setCuartos(rs.getInt("cuartos"));
        v.setTieneAgua(rs.getString("tieneAgua"));
        v.setTieneAgua(rs.getString("tieneLuz"));
        v.setTieneAgua(rs.getString("tieneGas"));  
        v.setIdLocalidad(rs.getInt("idLocalidad"));
        v.setIdTipoVivienda(rs.getInt("idTipoVivienda"));
        
        return v;
    }
    
    public boolean agregar(Vivienda vivienda){
        // Se incluyen todos los campos excepto idVivienda (autoincremental) y idMunicipio (redundante, se deriva de Localidad)
        String sql = "INSERT INTO Vivienda (codigoVivienda, calle, numeroExterior, colonia, cuartos, tieneAgua, tieneLuz, tieneGas, idLocalidad, idMunicipio, idTipoVivienda) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, vivienda.getCodigoVivienda());
            ps.setString(2, vivienda.getCalle());
            ps.setInt(3, vivienda.getNumeroExterior());
            ps.setString(4, vivienda.getColonia());
            ps.setInt(5, vivienda.getCuartos());
            ps.setString(6, vivienda.getTieneAgua());
            ps.setString(7, vivienda.getTieneLuz());
            ps.setString(8, vivienda.getTieneGas());
            ps.setInt(9, vivienda.getIdLocalidad());
            ps.setInt(10, vivienda.getIdMunicipio());
            ps.setInt(11, vivienda.getIdTipoVivienda());
            
            int filasAfectadas = ps.executeUpdate();
            
            // Obtener el ID generado (CRUCIAL para el posterior registro de Habitantes)
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        vivienda.setIdVivienda(rs.getInt(1));
                    }
                }
            }
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar vivienda: " + e.getMessage());
        }
        return false;
    }
    
    public Vivienda obtenerPorId(int id){
        Vivienda vivienda = null;
        String sql = "SELECT idVivienda, codigoVivienda, calle, numeroExterior, colonia, cuartos, tieneAgua, tieneLuz, tieneGas, idLocalidad, idTipoVivienda " +
                     "FROM Vivienda WHERE idVivienda = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vivienda = mapearVivienda(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener vivienda por ID: " + e.getMessage());
        }
        return vivienda;
    }
    
    public ArrayList<Vivienda> obtenerTodos(){
        ArrayList<Vivienda> viviendas = new ArrayList<>();
        String sql = "SELECT idVivienda, codigoVivienda, calle, numeroExterior, colonia, cuartos, tieneAgua, tieneLuz, tieneGas, idLocalidad, idMunicipio, idTipoVivienda FROM Vivienda";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                viviendas.add(mapearVivienda(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la lista de viviendas: " + e.getMessage());
        }
        return viviendas;
    }
    
    public boolean actualizar(Vivienda vivienda) throws Exception {
        String sql = "UPDATE Vivienda SET calle=?, numeroExterior=?, colonia=?, cuartos=?, tieneAgua=?, tieneLuz=?, tieneGas=?, idLocalidad=?, idMunicipio=?, idTipoVivienda=? WHERE codigoVivienda=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vivienda.getCalle());
            ps.setInt(2, vivienda.getNumeroExterior());
            ps.setString(3, vivienda.getColonia());
            ps.setInt(4, vivienda.getCuartos());
            ps.setString(5, vivienda.getTieneAgua());
            ps.setString(6, vivienda.getTieneLuz());
            ps.setString(7, vivienda.getTieneGas());
            ps.setInt(8, vivienda.getIdLocalidad());
            ps.setInt(9, vivienda.getIdMunicipio());
            ps.setInt(10, vivienda.getIdTipoVivienda());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new Exception("Error al actualizar vivienda: " + e.getMessage(), e);
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM Vivienda WHERE idVivienda = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.print("Error al eliminar vivienda (Asegúrese de que no tenga habitantes asociados): " + e.getMessage());
        }
        return false;
    }
    
    public int obtenerIdPorCodigo(int codigoVivienda) throws Exception {
        String sql = "SELECT idVivienda FROM Vivienda WHERE codigoVivienda = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigoVivienda);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idVivienda");
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar el ID de vivienda por código.", e);
        }
        return -1; // Retorna -1 si no se encuentra
    }
}
