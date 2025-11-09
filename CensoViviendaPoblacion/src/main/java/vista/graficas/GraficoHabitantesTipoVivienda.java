package vista.graficas;

import controlador.DashboardControlador;
import java.awt.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


public class GraficoHabitantesTipoVivienda extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    private final String filtroMunicipio;
    
    public GraficoHabitantesTipoVivienda(String municipio) {
        initComponents();
        this.filtroMunicipio = municipio;
        this.controlador = new DashboardControlador();
        cargarGrafico();
    }
    
    private final Color[] colores = {
        new Color(54, 162, 235),  // Azul
        new Color(255, 99, 132),  // Rosa
        new Color(255, 206, 86),  // Amarillo
        new Color(75, 192, 192),  // Verde agua
        new Color(153, 102, 255), // Morado
        new Color(255, 159, 64),  // Naranja
        new Color(199, 199, 199), // Gris
        new Color(83, 109, 254),  // Azul Claro
        new Color(255, 87, 34),   // Rojo
        new Color(0, 150, 136)    // Verde Oscuro
    };
    
    private void cargarGrafico(){
        Map<String, Integer> datos = controlador.obtenerHabitantesPorTipoVivienda(filtroMunicipio);

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            String tipoVivienda = entry.getKey();
            int totalHabitantes = entry.getValue();
            
            String etiqueta = tipoVivienda + " (" + totalHabitantes + ")";
            dataset.setValue(etiqueta, totalHabitantes);
        }
        
        if (dataset.getItemCount() == 0) {
            return;
        }

        JFreeChart chart = ChartFactory.createPieChart(
            "Habitantes por Tipo de Vivienda",
            dataset,
            false,
            false,
            false
        );

        chart.setBackgroundPaint(Color.white);
        PiePlot plot = (PiePlot) chart.getPlot();
        
        int colorIndex = 0;
        for (String key : datos.keySet()) {
            String datasetKey = key + " (" + datos.get(key) + ")";
            plot.setSectionPaint(datasetKey, colores[colorIndex % colores.length]);
            colorIndex++;
        }

        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        
        plot.setCircular(true); 
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(false);

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
