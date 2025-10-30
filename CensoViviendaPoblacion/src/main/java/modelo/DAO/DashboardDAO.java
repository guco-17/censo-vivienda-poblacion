package modelo.DAO;

import java.sql.*;
import java.util.*;
import modelo.ConexionDB;

public class DashboardDAO {
    private Connection conn = ConexionDB.getInstance().getConnection();
    
    public DashboardDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    //KPI POBLACIÓN TOTAL
    public int contarTotalHabitantes() {
        int total = 0;
        String sql = "SELECT COUNT(idHabitante) AS total FROM Habitante"; 
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar el total de habitantes: " + e.getMessage());
        }
        return total;
    }
    
    //KPI POBLACIÓN ACTIVA ECONÓMICAMENTE
    public int contarPoblacionEconomicamenteActiva() {
        int total = 0;
        String sql = "SELECT COUNT(idHabitante) AS total FROM Habitante_Actividad";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar la PEA: " + e.getMessage());
        }
        return total;
    }
    
    //KPI VIVIENDAS CON SERVICIOS BÁSICOS.
    public int contarTotalViviendas() {
        int total = 0;
        String sql = "SELECT COUNT(idVivienda) AS total FROM Vivienda";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar total de viviendas: " + e.getMessage());
        }
        return total;
    }
    
    // CONTAR HABITANTES POR GÉNERO GRÁFICA KPI
    public Map<String, Integer> contarHabitantesPorGenero() {
        Map<String, Integer> resultados = new HashMap<>();
        String sql = "SELECT genero, COUNT(idHabitante) AS conteo FROM Habitante GROUP BY genero";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resultados.put(rs.getString("genero"), rs.getInt("conteo"));
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar habitantes por género: " + e.getMessage());
        }
        return resultados;
    }
    
    //GRÁFICA DE EDUCACIÓN POR MUNICIPIO.
    public Map<String, Map<String, Integer>> obtenerNivelEducativoPorMunicipio() {
        Map<String, Map<String, Integer>> resultados = new HashMap<>();

        String sql = "SELECT h.nivelEducacion, m.descripcion AS nombreMunicipio, COUNT(h.idHabitante) AS conteo FROM Habitante h JOIN Vivienda v ON h.idVivienda = v.idVivienda JOIN Municipio m ON v.idMunicipio = m.idMunicipio WHERE h.nivelEducacion IS NOT NULL AND h.nivelEducacion <> '' GROUP BY h.nivelEducacion, m.descripcion ORDER BY m.descripcion, h.nivelEducacion"; 

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nivel = rs.getString("nivelEducacion");
                String municipio = rs.getString("nombreMunicipio");
                int conteo = rs.getInt("conteo");

                resultados.putIfAbsent(nivel, new HashMap<>());

                resultados.get(nivel).put(municipio, conteo);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener nivel educativo por municipio: " + e.getMessage());
        }
        return resultados;
    }
    
    //GRÁFICO TOP 5 ACTIVIDADES ECONÓMICAS
    public Map<String, Integer> obtenerTop5ActividadesEconomicas() {
        Map<String, Integer> resultados = new LinkedHashMap<>();
        
        String sql = "SELECT TOP 5 ae.descripcion AS nombreActividad, COUNT(ha.idHabitante) AS conteo FROM Habitante_Actividad ha JOIN ActividadEconomica ae ON ha.idActividadEconomica = ae.idActividadEconomica GROUP BY ae.descripcion ORDER BY conteo DESC;";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombreActividad = rs.getString("nombreActividad");
                int conteo = rs.getInt("conteo");
                resultados.put(nombreActividad, conteo);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el Top 5 de actividades económicas: " + e.getMessage());
        }
        return resultados;
    }
    
    //TABLA HABITANTES POR VIVIENDA
    public List<Map<String, Object>> obtenerHabitantesPorVivienda(String nombreMunicipio) {
        List<Map<String, Object>> resultados = new ArrayList<>();

        String sql = "SELECT " +
                     "    V.codigoVivienda, " +
                     "    M.descripcion AS nombreMunicipio, " +
                     "    V.colonia, " +
                     "    V.calle, " +
                     "    V.numeroExterior, " +
                     "    COUNT(H.idHabitante) AS totalHabitantes, " +
                     "    STRING_AGG(H.nombre + ' ' + H.paterno + ' ' + COALESCE(H.materno, ''), '; ') AS nombresDetallados " +
                     "FROM " +
                     "    Vivienda V " +
                     "JOIN " +
                     "    Habitante H ON V.idVivienda = H.idVivienda " +
                     "JOIN " +
                     "    Municipio M ON V.idMunicipio = M.idMunicipio " +
                     "WHERE " +
                     "    (? IS NULL OR ? = 'Todos' OR M.descripcion = ?) " +
                     "GROUP BY " +
                     "    V.idVivienda, V.codigoVivienda, V.calle, V.numeroExterior, V.colonia, M.descripcion " +
                     "ORDER BY " +
                     "    V.codigoVivienda";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            // Manejo del parámetro de filtro
            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> fila = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        fila.put(metaData.getColumnLabel(i), rs.getObject(i));
                    }
                    resultados.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el reporte de Habitantes por Vivienda: " + e.getMessage());
        }
        return resultados;
    }
    
    //PROMEDIO DE HABITANTES POR VIVIENDA
    public double promedioHabitantesPorVivienda(){
        double promedio = 0;
        String sql = "SELECT CAST(COUNT(H.idHabitante) AS DECIMAL(10, 2)) / CAST(COUNT(DISTINCT V.idVivienda) AS DECIMAL(10, 2)) AS promedio FROM Vivienda V INNER JOIN Habitante H ON V.idVivienda = H.idVivienda;";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                promedio = rs.getInt("promedio");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar total de viviendas: " + e.getMessage());
        }
        return promedio;
    }
}
