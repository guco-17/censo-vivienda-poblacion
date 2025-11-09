package vista.graficas;

import controlador.DashboardControlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoGenero extends javax.swing.JPanel {
    private final DashboardControlador controlador;
    
    public GraficoGenero() {
        initComponents();
        this.controlador = new DashboardControlador();
        setLayout(new BorderLayout());
        cargarGrafico();
    }
    
    private void cargarGrafico() {
        Map<String, Integer> datos = controlador.obtenerDistribucionPorGenero();

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            String claveGenero = entry.getKey();
            int conteo = entry.getValue();

            if (claveGenero != null) {
                String claveEstandarizada = claveGenero.trim().toUpperCase();

                if ("H".equals(claveEstandarizada)) {
                    dataset.setValue("Masculino", conteo);
                } else if ("M".equals(claveEstandarizada)) {
                    dataset.setValue("Femenino", conteo);
                }
            }
        }

        JFreeChart chart = ChartFactory.createPieChart(
            "Distribución de Población por Género", // Título del gráfico
            dataset,                                // Datos
            true,                                   // Mostrar leyenda
            true,                                   // Tooltips (etiquetas al pasar el ratón)
            false                                   // URLs (no necesario)
        );

        //Personalización
        chart.setBackgroundPaint(Color.white);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Masculino", new Color(54, 162, 235)); // Azul
        plot.setSectionPaint("Femenino", new Color(255, 105, 180)); // Rosa

        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        removeAll();
        add(chartPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
