package modelo.DAO;

import java.sql.*;
import java.util.*;
import modelo.ConexionDB;
import java.sql.Types;

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
        String sql = "SELECT COUNT(DISTINCT H.idHabitante) AS total " +
                 "FROM Habitante H " +
                 "JOIN Vivienda_Actividad VA ON H.idVivienda = VA.idVivienda";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar población activa económicamente: " + e.getMessage());
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
    public Map<String, Map<String, Integer>> obtenerNivelEducativoPorMunicipio(String nombreMunicipio) {
        Map<String, Map<String, Integer>> resultados = new HashMap<>();

        String sql = "SELECT h.nivelEducacion, m.descripcion AS nombreMunicipio, COUNT(h.idHabitante) AS conteo " +
                     "FROM Habitante h " +
                     "JOIN Vivienda v ON h.idVivienda = v.idVivienda " +
                     "JOIN Municipio m ON v.idMunicipio = m.idMunicipio " +
                     "WHERE h.nivelEducacion IS NOT NULL AND h.nivelEducacion <> '' " +
                     "AND (? IS NULL OR ? = 'Todos' OR m.descripcion = ?) " +
                     "GROUP BY h.nivelEducacion, m.descripcion " +
                     "ORDER BY m.descripcion, h.nivelEducacion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nivel = rs.getString("nivelEducacion");
                    String municipio = rs.getString("nombreMunicipio");
                    int conteo = rs.getInt("conteo");

                    resultados.putIfAbsent(nivel, new HashMap<>());
                    resultados.get(nivel).put(municipio, conteo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener nivel educativo por municipio: " + e.getMessage());
        }
        return resultados;
    }
    
    //GRÁFICO TOP 5 ACTIVIDADES ECONÓMICAS
    public Map<String, Integer> obtenerTop5ActividadesEconomicas() {
        Map<String, Integer> resultados = new LinkedHashMap<>();
        
        String sql = "SELECT TOP 5 AE.descripcion, COUNT(VA.idVivienda) AS conteo " +
                 "FROM ActividadEconomica AE " +
                 "JOIN Vivienda_Actividad VA ON AE.idActividadEconomica = VA.idActividadEconomica " +
                 "GROUP BY AE.descripcion " +
                 "ORDER BY conteo DESC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resultados.put(rs.getString("descripcion"), rs.getInt("conteo"));
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el Top 5 de actividades económicas: " + e.getMessage());
        }
        return resultados;
    }
    
    //TABLA HABITANTES POR VIVIENDA
    public List<Map<String, Object>> obtenerHabitantesPorVivienda(String nombreMunicipio) {
        List<Map<String, Object>> resultados = new ArrayList<>();

        // SQL que combina datos de vivienda, cuenta habitantes, lista nombres y lista actividades
        String sql = "SELECT " +
                     "V.codigoVivienda, " +
                     "M.descripcion AS nombreMunicipio, " +
                     "V.colonia, " +
                     "V.calle, " +
                     "COUNT(H.idHabitante) AS TotalHabitantes, " +
                     "STRING_AGG(H.nombre + ' ' + H.paterno + ISNULL(' ' + H.materno, ''), ', ') AS NombresDetallados, " +
                     "STUFF(( " +
                         "SELECT ', ' + AE.descripcion " +
                         "FROM Vivienda_Actividad VA_inner " +
                         "JOIN ActividadEconomica AE ON VA_inner.idActividadEconomica = AE.idActividadEconomica " +
                         "WHERE VA_inner.idVivienda = V.idVivienda " +
                         "FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS ActividadesEconomicas " +
                     "FROM Vivienda V " +
                     "JOIN Habitante H ON V.idVivienda = H.idVivienda " +
                     "JOIN Localidad L ON V.idLocalidad = L.idLocalidad " +
                     "JOIN Municipio M ON V.idMunicipio = M.idMunicipio " +
                     "WHERE (? IS NULL OR ? = 'Todos' OR M.descripcion = ?) " +
                     "GROUP BY V.idVivienda, V.codigoVivienda, M.descripcion, V.colonia, V.calle " +
                     "ORDER BY V.codigoVivienda";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty() && !nombreMunicipio.equals("Todos")) ? nombreMunicipio : null;

            // Establecer los parámetros para el filtro
            if (filtro == null) {
                ps.setNull(1, Types.VARCHAR);
                ps.setString(2, "Todos"); // Se usa en la comparación
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(1, filtro);
                ps.setString(2, "NoTodos"); // Para que la condición no se cumpla en la segunda parte
                ps.setString(3, filtro);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("Código Vivienda", rs.getInt("codigoVivienda"));
                    fila.put("Municipio", rs.getString("nombreMunicipio"));
                    fila.put("Colonia", rs.getString("colonia"));
                    fila.put("Calle", rs.getString("calle"));
                    fila.put("Habitantes", rs.getInt("TotalHabitantes"));
                    fila.put("Nombres Detallados", rs.getString("NombresDetallados"));
                    // Nuevo campo Act. Económicas
                    fila.put("Act. Económicas", rs.getString("ActividadesEconomicas")); 
                    resultados.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener habitantes por vivienda: " + e.getMessage());
        }
        return resultados;
    }
    
    //PROMEDIO DE HABITANTES POR VIVIENDA
    public double promedioHabitantesPorVivienda(String nombreMunicipio){
        double promedio = 0;
        String sql = "SELECT CAST(COUNT(H.idHabitante) AS DECIMAL(10, 2)) / CAST(COUNT(DISTINCT V.idVivienda) AS DECIMAL(10, 2)) AS promedio " +
                     "FROM Vivienda V " +
                     "INNER JOIN Habitante H ON V.idVivienda = H.idVivienda " +
                     "INNER JOIN Municipio M ON V.idMunicipio = M.idMunicipio " +
                     "WHERE (? IS NULL OR ? = 'Todos' OR M.descripcion = ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    promedio = rs.getDouble("promedio"); 
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el promedio de habitantes por vivienda: " + e.getMessage()); 
        }
        return promedio;
    }
    
    //CANTIDAD DE HABITANTES QUE VIVEN POR CADA TIPO DE VIVIENDA
    public Map<String, Integer> obtenerHabitantesPorTipoVivienda(String nombreMunicipio){
       Map<String, Integer> resultados = new LinkedHashMap<>(); 

        String sql = "SELECT TV.descripcion AS TipoVivienda, COUNT(H.idHabitante) AS TotalHabitantes " +
                     "FROM TipoVivienda TV " +
                     "INNER JOIN Vivienda V ON TV.idTipoVivienda = V.idTipoVivienda " +
                     "INNER JOIN Habitante H ON V.idVivienda = H.idVivienda " +
                     "INNER JOIN Municipio M ON V.idMunicipio = M.idMunicipio " +
                     "WHERE (? IS NULL OR ? = 'Todos' OR M.descripcion = ?) " +
                     "GROUP BY TV.descripcion " +
                     "ORDER BY TotalHabitantes DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String tipoVivienda = rs.getString("TipoVivienda");
                    int totalHabitantes = rs.getInt("TotalHabitantes");
                    resultados.put(tipoVivienda, totalHabitantes);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener habitantes por tipo de vivienda: " + e.getMessage());
        }
        return resultados;
    }
    
    public Map<String, Integer> serviciosBasicosMunicipio(String nombreMunicipio){
        Map<String, Integer> resultados = new LinkedHashMap<>();
        
        String sql = "SELECT " +
                     "   COUNT(V.idVivienda) AS total_viviendas, " +
                     "   SUM(CASE WHEN V.tieneAgua = 'SI' THEN 1 ELSE 0 END) AS con_agua, " +
                     "   SUM(CASE WHEN V.tieneLuz = 'SI' THEN 1 ELSE 0 END) AS con_luz, " +
                     "   SUM(CASE WHEN V.tieneGas = 'SI' THEN 1 ELSE 0 END) AS con_gas " +
                     "FROM Vivienda V " +
                     "INNER JOIN Municipio M ON V.idMunicipio = M.idMunicipio " +
                     "WHERE (? IS NULL OR ? = 'Todos' OR M.descripcion = ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    resultados.put("Total Viviendas", rs.getInt("total_viviendas"));
                    resultados.put("Viviendas con Agua", rs.getInt("con_agua"));
                    resultados.put("Viviendas con Luz", rs.getInt("con_luz"));
                    resultados.put("Viviendas con Gas", rs.getInt("con_gas"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el reporte de servicios básicos: " + e.getMessage());
        }
        return resultados;
    }
    
    public double porcentajeViviendasConServiciosCompletos(String nombreMunicipio) {
        double porcentaje = 0.0;

        String sql = "SELECT " +
                     "   COALESCE( " +
                     "       ROUND( " +
                     "           CAST(SUM(CASE WHEN V.tieneAgua = 'SI' AND V.tieneLuz = 'SI' AND V.tieneGas = 'SI' THEN 1 ELSE 0 END) AS DECIMAL(10, 2)) " +
                     "           * 100.0 / NULLIF(CAST(COUNT(V.idVivienda) AS DECIMAL(10, 2)), 0), " +
                     "           2 " +
                     "       ), 0.0) AS porcentaje_con_todos_servicios " +
                     "FROM Vivienda V " +
                     "INNER JOIN Municipio M ON V.idMunicipio = M.idMunicipio " +
                     "WHERE (? IS NULL OR ? = 'Todos' OR M.descripcion = ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    porcentaje = rs.getDouble("porcentaje_con_todos_servicios");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el porcentaje de viviendas con servicios completos: " + e.getMessage());
        }
        return porcentaje;
    }
    
    //KPI POBLACIÓN TOTAL POR MUNICIPIO
    public int contarTotalHabitantesMunicipio(String nombreMunicipio) {
        int total = 0;

        String sql = "SELECT COUNT(h.idHabitante) AS total " +
                     "FROM Habitante h " +
                     "INNER JOIN Vivienda v ON h.idVivienda = v.idVivienda " +
                     "INNER JOIN Municipio m ON v.idMunicipio = m.idMunicipio " +
                     "WHERE (? IS NULL OR ? = 'Todos' OR m.descripcion = ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            String filtro = (nombreMunicipio != null && !nombreMunicipio.isEmpty()) ? nombreMunicipio : "Todos";

            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar el total de habitantes con filtro: " + e.getMessage());
        }
        return total;
    }
    
    public Map<String, Integer> top5MunicipiosMasPoblados() {
        Map<String, Integer> resultados = new LinkedHashMap<>();

        String sql = "SELECT TOP 5 m.descripcion AS municipio, COUNT(h.idHabitante) AS poblacion " +
                     "FROM Municipio m " +
                     "JOIN Vivienda v ON m.idMunicipio = v.idMunicipio " +
                     "JOIN Habitante h ON v.idVivienda = h.idVivienda " +
                     "GROUP BY m.descripcion " +
                     "ORDER BY poblacion DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String municipio = rs.getString("municipio");
                int poblacion = rs.getInt("poblacion");
                resultados.put(municipio, poblacion);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el Top 5 de municipios más poblados: " + e.getMessage());
        }
        return resultados;
    }
    
    public Map<String, Double> distribucionPorEdad() {
        Map<String, Double> resultados = new LinkedHashMap<>();

        String sql = "SELECT " +
                     "    CASE " +
                     "        WHEN edad BETWEEN 0 AND 14 THEN '0-14 Niños/Adolescentes' " +
                     "        WHEN edad BETWEEN 15 AND 24 THEN '15-24 Jóvenes' " +
                     "        WHEN edad BETWEEN 25 AND 44 THEN '25-44 Adultos' " +
                     "        WHEN edad BETWEEN 45 AND 64 THEN '45-64 Adultos Mayores' " +
                     "        ELSE '65+ Adultos de la 3ra Edad' " +
                     "    END as grupo_edad, " +
                     "    ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Habitante), 2) as porcentaje " +
                     "FROM ( " +
                     "    SELECT DATEDIFF(YEAR, fechaNacimiento, GETDATE()) as edad " +
                     "    FROM Habitante " +
                     ") as edades " +
                     "GROUP BY " +
                     "    CASE " +
                     "        WHEN edad BETWEEN 0 AND 14 THEN '0-14 Niños/Adolescentes' " +
                     "        WHEN edad BETWEEN 15 AND 24 THEN '15-24 Jóvenes' " +
                     "        WHEN edad BETWEEN 25 AND 44 THEN '25-44 Adultos' " +
                     "        WHEN edad BETWEEN 45 AND 64 THEN '45-64 Adultos Mayores' " +
                     "        ELSE '65+ Adultos de la 3ra Edad' " +
                     "    END " +
                     "ORDER BY MIN(edad)";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String grupoEdad = rs.getString("grupo_edad");
                double porcentaje = rs.getDouble("porcentaje");
                resultados.put(grupoEdad, porcentaje);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener la distribución por edad: " + e.getMessage());
        }
        return resultados;
    }
    
}
