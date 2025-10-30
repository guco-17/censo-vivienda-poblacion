package vista;

import controlador.DashboardControlador;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Municipio;
import modelo.Usuario;

public class reporteHabitantesVivienda extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final DashboardControlador controlador;
    
    private final String[] COLUMNAS_REPORTE = {
        "Código Vivienda", "Municipio", "Colonia", "Calle", "Habitantes", "Nombres Detallados"
    };

    public reporteHabitantesVivienda(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        this.controlador = new DashboardControlador();
        cargarGraficoNivelEducativo();
        cargarMunicipios();
        inicializarTabla();
        ajustarAnchoColumnas();
        cargarDatosTabla(null);
        cargarKPIs();
    }
    
    private void cargarKPIs(){
        double promedioHabitanteVivienda = controlador.promedioHabitantesPorVivienda();
            lblPromedioHabitanteVivienda.setText(String.valueOf(promedioHabitanteVivienda)); 
    }
    
    private void cargarGraficoNivelEducativo() {
        nivelEducativoPanel.removeAll(); 

        GraficoActividadEconomica graficoNivelEducativo = new GraficoActividadEconomica(); 

        graficoNivelEducativo.setSize(nivelEducativoPanel.getSize());
        nivelEducativoPanel.add(graficoNivelEducativo, BorderLayout.CENTER); 

        nivelEducativoPanel.revalidate();
        nivelEducativoPanel.repaint();
    }
    
    private void cargarMunicipios() {
        cboFiltro.removeAllItems();
        cboFiltro.addItem("Todos");
        
        try {
            List<Municipio> municipios = controlador.obtenerNombresMunicipios();
            
            for (Municipio municipio : municipios) {
                cboFiltro.addItem(municipio.getDescripcion());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los municipios: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    private void inicializarTabla() {
    DefaultTableModel modelo = new DefaultTableModel(null, COLUMNAS_REPORTE) {
        // Opcional: Esto hace que las celdas no sean editables
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tablaResultados.setModel(modelo);
}
    
    private void ajustarAnchoColumnas() {
        javax.swing.table.TableColumnModel columnModel = tablaResultados.getColumnModel();
        int anchoEstandar = 100;
        int anchoNombresDetallados = 400; 

        // Columna 0: "Código Vivienda"
        columnModel.getColumn(0).setPreferredWidth(anchoEstandar);

        // Columna 1: "Municipio"
        columnModel.getColumn(1).setPreferredWidth(anchoEstandar);

        // Columna 2: "Colonia"
        columnModel.getColumn(2).setPreferredWidth(anchoEstandar);

        // Columna 3: "Calle"
        columnModel.getColumn(3).setPreferredWidth(anchoEstandar);

        // Columna 4: "Habitantes"
        columnModel.getColumn(4).setPreferredWidth(80); // Un poco más estrecha

        // Columna 5: "Nombres Detallados" - Le damos más espacio
        columnModel.getColumn(5).setPreferredWidth(anchoNombresDetallados);
    }

    public void cargarDatosTabla(String municipioSeleccionado) {
        DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
        modelo.setRowCount(0);

        try {
            String filtro = (municipioSeleccionado != null && municipioSeleccionado.equals("Todos")) 
                    ? null : municipioSeleccionado;

            List<Map<String, Object>> listaReporte = controlador.obtenerTablaHabitantesViviendas(filtro);

            if (listaReporte.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron viviendas con los criterios de búsqueda.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            for (Map<String, Object> fila : listaReporte) {
                Object[] nuevaFila = new Object[COLUMNAS_REPORTE.length];

                nuevaFila[0] = fila.get("codigoVivienda"); 
                nuevaFila[1] = fila.get("nombreMunicipio");
                nuevaFila[2] = fila.get("colonia");
                nuevaFila[3] = fila.get("calle");
                nuevaFila[4] = fila.get("totalHabitantes");
                nuevaFila[5] = fila.get("nombresDetallados");

                modelo.addRow(nuevaFila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFiltros = new javax.swing.JPanel();
        cboFiltro = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        nivelEducativoPanel = new javax.swing.JPanel();
        panelPromedioHabitantesVivienda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPromedioHabitanteVivienda = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFiltros.setBackground(new java.awt.Color(102, 102, 255));

        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFiltroActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Reporte - Habitantes por Vivienda.");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setMaximumSize(new java.awt.Dimension(72, 22));
        btnBuscar.setMinimumSize(new java.awt.Dimension(72, 22));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboFiltro)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaResultados);

        nivelEducativoPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout nivelEducativoPanelLayout = new javax.swing.GroupLayout(nivelEducativoPanel);
        nivelEducativoPanel.setLayout(nivelEducativoPanelLayout);
        nivelEducativoPanelLayout.setHorizontalGroup(
            nivelEducativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        nivelEducativoPanelLayout.setVerticalGroup(
            nivelEducativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        panelPromedioHabitantesVivienda.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROMEDIO DE HABITANTES POR VIVIENDA");

        lblPromedioHabitanteVivienda.setFont(new java.awt.Font("Gadugi", 0, 56)); // NOI18N
        lblPromedioHabitanteVivienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPromedioHabitanteVivienda.setText("0.0");

        javax.swing.GroupLayout panelPromedioHabitantesViviendaLayout = new javax.swing.GroupLayout(panelPromedioHabitantesVivienda);
        panelPromedioHabitantesVivienda.setLayout(panelPromedioHabitantesViviendaLayout);
        panelPromedioHabitantesViviendaLayout.setHorizontalGroup(
            panelPromedioHabitantesViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromedioHabitantesViviendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPromedioHabitantesViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPromedioHabitanteVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPromedioHabitantesViviendaLayout.setVerticalGroup(
            panelPromedioHabitantesViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromedioHabitantesViviendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPromedioHabitanteVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        menuInicio.setText("Inicio");

        menuItemInicio.setText("Regresar");
        menuItemInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInicioActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemInicio);

        jMenuBar1.add(menuInicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nivelEducativoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelPromedioHabitantesVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nivelEducativoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPromedioHabitantesVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String municipioSeleccionado = (String) cboFiltro.getSelectedItem();
        cargarDatosTabla(municipioSeleccionado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFiltroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPromedioHabitanteVivienda;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JPanel nivelEducativoPanel;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelPromedioHabitantesVivienda;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
