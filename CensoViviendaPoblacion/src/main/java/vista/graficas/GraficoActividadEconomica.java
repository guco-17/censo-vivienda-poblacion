package vista.graficas;

import controlador.DashboardControlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoActividadEconomica extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    
    public GraficoActividadEconomica() {
        setLayout(new BorderLayout());
        this.controlador = new DashboardControlador();
        cargarGrafico();
    }
    
    private void cargarGrafico() {
        Map<String, Integer> datos = controlador.obtenerTop5ActividadesEconomicas();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String serie = "PEA";
        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            String actividad = entry.getKey();
            int conteo = entry.getValue();
            
            dataset.addValue(conteo, serie, actividad);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "Top 5 Actividades Económicas",     // Título
            "Actividad Económica",                   // Etiqueta Eje X (Valor)
            "Conteo de Habitantes",                    // Etiqueta Eje Y (Categoría)
            dataset,                                  // Datos
            PlotOrientation.VERTICAL,               // 🚨 CLAVE: Orientación Horizontal
            false,                                     // Leyenda
            true,                                     // Tooltips
            false                                     // URLs
        );

        chart.setBackgroundPaint(Color.white);
        var plot = chart.getCategoryPlot();
        var renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(66, 135, 245));
        
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.lightGray);
        
        BarRenderer rend = new BarRenderer() {
            @Override
            public Paint getItemPaint(int row, int column) {
                return new Color(66, 135, 245); // Azul uniforme
            }
        };
        rend.setBarPainter(new org.jfree.chart.renderer.category.StandardBarPainter()); // Quita brillo
        rend.setShadowVisible(false); // Sin sombra
        rend.setDrawBarOutline(false); // Sin borde
        plot.setRenderer(rend);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        removeAll();
        add(chartPanel, BorderLayout.CENTER); 
        
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
