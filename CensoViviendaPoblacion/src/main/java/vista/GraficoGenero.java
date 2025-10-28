package vista;

import controlador.DashboardControlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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
            String etiqueta = entry.getKey().equals("M") ? "Masculino" : 
                              entry.getKey().equals("F") ? "Femenino" : "Otro";
            dataset.setValue(etiqueta, entry.getValue());
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
        
        // 4. CREAR EL PANEL DE JFreeChart PARA INTEGRARLO EN SWING
        ChartPanel chartPanel = new ChartPanel(chart);
        
        // 5. AÑADIR EL PANEL DEL GRÁFICO AL JPanel
        add(chartPanel, BorderLayout.CENTER);
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
