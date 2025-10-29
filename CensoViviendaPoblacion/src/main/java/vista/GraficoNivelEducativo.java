package vista;

import controlador.DashboardControlador;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraficoNivelEducativo extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    
    public GraficoNivelEducativo() {
        initComponents();
        this.controlador = new DashboardControlador();
        cargarGrafico();
    }
    
    private void cargarGrafico() {
        Map<String, Map<String, Integer>> datos = controlador.obtenerNivelEducativoPorMunicipio();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Map<String, Integer>> nivelEntry : datos.entrySet()) {
            String nivelEducacion = nivelEntry.getKey();
            Map<String, Integer> conteosPorMunicipio = nivelEntry.getValue();

            for (Map.Entry<String, Integer> municipioEntry : conteosPorMunicipio.entrySet()) {
                String municipio = municipioEntry.getKey();
                int conteo = municipioEntry.getValue();

                dataset.addValue(conteo, nivelEducacion, municipio);
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Capital Humano: Nivel Educativo por Municipio",
            "Municipio",
            "No. de Habitantes",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.WHITE);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)); // 30 grados

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        Color[] colores = {
            new Color(255, 162, 235),   // Azul
            new Color(255, 0, 0),   // Rosa
            new Color(255, 206, 86),   // Amarillo
            new Color(75, 192, 192),   // Verde agua
            new Color(153, 102, 255)   // Morado
        };

        for (int i = 0; i < dataset.getRowCount(); i++) {
            renderer.setSeriesPaint(i, colores[i % colores.length]);
        }

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
