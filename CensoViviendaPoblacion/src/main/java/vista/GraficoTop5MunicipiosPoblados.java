package vista;

import controlador.DashboardControlador;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoTop5MunicipiosPoblados extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    
    public GraficoTop5MunicipiosPoblados() {
        initComponents();
        this.controlador = new DashboardControlador();
        setLayout(new BorderLayout());
        cargarGrafico();
    }
    
    private void cargarGrafico() {
        Map<String, Integer> datos = controlador.obtenerTop5MunicipiosMasPoblados();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String serie = "Población"; 

        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            dataset.addValue(entry.getValue(), serie, entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "TOP 5 Municipios Más Poblados", // Título
            "Municipio",                     // Etiqueta del eje X
            "Cantidad de Habitantes",        // Etiqueta del eje Y
            dataset,
            PlotOrientation.VERTICAL,
            true,                            // Leyenda (Series)
            true,                            // Tooltips
            false                            // URLs
        );
        
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        
        Color colorAzul = new Color(102,102,255);
        
        renderer.setSeriesPaint(0, colorAzul);

        chart.setBackgroundPaint(Color.white);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.removeAll();
        this.add(chartPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
