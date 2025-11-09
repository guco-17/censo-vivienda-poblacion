package vista.graficas;

import controlador.DashboardControlador;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class GraficoDistribucionEdad extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    
    public GraficoDistribucionEdad() {
        initComponents();
        this.controlador = new DashboardControlador();
        setLayout(new BorderLayout());
        cargarGrafico();
    }
    
    private void cargarGrafico() {
        Map<String, Double> datos = controlador.obtenerDistribucionPorEdad();
        
        PieDataset dataset = crearDataset(datos);

        JFreeChart chart = ChartFactory.createPieChart(
            "Distribución de la Población por Grupos de Edad", // Título
            dataset,
            true,  // Leyenda
            true,  // Tooltips
            false  // URLs
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        
        plot.setLabelGenerator(null);

        chart.setBackgroundPaint(Color.white);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        this.removeAll();
        this.add(chartPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    
    private PieDataset crearDataset(Map<String, Double> datos) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            dataset.setValue(entry.getKey() + " (" + entry.getValue() + "%)", entry.getValue());
        }
        return dataset;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
