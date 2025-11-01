package vista;

import controlador.DashboardControlador;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoServiciosBasicos extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    private final String municipioFiltro;
    
    public GraficoServiciosBasicos(String municipioSeleccionado) {
        initComponents();
        this.controlador = new DashboardControlador();
        
        this.municipioFiltro = (municipioSeleccionado != null && municipioSeleccionado.equals("Todos")) ? null : municipioSeleccionado;
        
        setLayout(new BorderLayout());
        cargarGrafico();
    }
    
    private void cargarGrafico(){
        Map<String, Integer> datos = controlador.obtenerserviciosBasicosMunicipio(municipioFiltro);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String categoria = "Viviendas con servicios";

        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            String etiqueta = entry.getKey();
            int valor = entry.getValue();
            if (!etiqueta.equals("Total Viviendas")) {
                dataset.addValue(valor, etiqueta, categoria);
            }
        }

        String titulo = "Servicios Básicos por Vivienda " + 
                        (municipioFiltro != null ? "en " + municipioFiltro : "(Todo el Estado)");
        
        JFreeChart chart = ChartFactory.createBarChart(
            titulo,
            "Tipo de Servicio",
            "Cantidad de Viviendas",
            dataset,       // Datos
            PlotOrientation.VERTICAL,
            true,          // Mostrar leyenda
            true,          // Generar tooltips
            false          // Generar URLs
        );

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
