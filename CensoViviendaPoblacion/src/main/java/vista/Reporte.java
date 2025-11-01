package vista;

import controlador.DashboardControlador;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Municipio;
import modelo.Usuario;

public class Reporte extends javax.swing.JFrame {
     private final Usuario usuarioSesion;
    private final DashboardControlador controlador;
    
    private final String[] COLUMNAS_REPORTE = {
        "Código Vivienda", "Municipio", "Colonia", "Calle", "Habitantes", "Nombres Detallados", "Act. Económicas"
    };

    public Reporte(Usuario usuarioAutenticado) {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.usuarioSesion = usuarioAutenticado;
        this.controlador = new DashboardControlador();
        cargarMunicipios();
        cargarGraficoNivelEducativo(null);
        inicializarTabla();
        ajustarAnchoColumnas();
        cargarDatosTabla(null);
        cargarKPIs(null);
        cargarGraficoTipoVivienda(null);
        cargarGraficaServiciosBasicos(null);
        cargarGraficoTop5Poblacion();
        cargarGraficoDistribucionEdad();
    }
    
    private void cargarKPIs(String municipioSeleccionado){
        //DENSIDAD DE POBLACIÓN
        double promedioHabitanteVivienda = controlador.promedioHabitantesPorVivienda(municipioSeleccionado);
        String HabitanteViviendaFormateado = String.format("%.2f", promedioHabitanteVivienda);
        lblPromedioHabitanteVivienda1.setText(String.valueOf(HabitanteViviendaFormateado)); 
        
        //PORCENTAJE DE VIVIENDAS CON SERVICIOS BÁSICOS COMPLETOS
        double porcentaje = controlador.obtenerPorcentajeViviendasConServiciosCompletos(municipioSeleccionado);
        String porcentajeFormateado = String.format("%.2f %%", porcentaje);
        statPorcentajeServiciosBasicos.setText(String.valueOf(porcentajeFormateado));
        
        //TOTAL DE POBLACIÓN
        int totalHabitantes = controlador.obtenerPoblacionTotal();
        poblacionTotalKPI.setText(String.valueOf(totalHabitantes));
        
        //TOTAL DE POBLACIÓN POR MUNICIPIO
        int totalHabitantesMunicipio = controlador.obtenerPoblacionMunicipio(municipioSeleccionado);
        poblacionMunicipioKPI.setText(String.valueOf(totalHabitantesMunicipio));
    }
    
    private void cargarGraficoNivelEducativo(String municipioSeleccionado) {
        nivelEducativoPanel.removeAll(); 

        GraficoNivelEducativo graficoNivelEducativo = new GraficoNivelEducativo(municipioSeleccionado); 

        graficoNivelEducativo.setSize(nivelEducativoPanel.getSize());
        nivelEducativoPanel.add(graficoNivelEducativo, BorderLayout.CENTER); 

        nivelEducativoPanel.revalidate();
        nivelEducativoPanel.repaint();
    }
    
    private void cargarGraficoTipoVivienda(String municipioSeleccionado) {
        panellHabitantesTipoVivienda.removeAll(); 

        // Asegúrate de que este es el nombre que le diste a tu JPanel
        GraficoHabitantesTipoVivienda grafico = new GraficoHabitantesTipoVivienda(municipioSeleccionado); 

        grafico.setSize(panellHabitantesTipoVivienda.getSize());
        panellHabitantesTipoVivienda.add(grafico, BorderLayout.CENTER); 

        panellHabitantesTipoVivienda.revalidate();
        panellHabitantesTipoVivienda.repaint();
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
    
    private void cargarGraficaServiciosBasicos(String municipioSeleccionado){
        panelGraficaServiciosBasicos.removeAll(); 

        // Asegúrate de que este es el nombre que le diste a tu JPanel
        GraficoServiciosBasicos grafico = new GraficoServiciosBasicos(municipioSeleccionado); 

        grafico.setSize(panellHabitantesTipoVivienda.getSize());
        panelGraficaServiciosBasicos.add(grafico, BorderLayout.CENTER); 

        panelGraficaServiciosBasicos.revalidate();
        panelGraficaServiciosBasicos.repaint();
    }
    
    private void cargarGraficoTop5Poblacion() {
        if (panelTop5MunicipiosPoblados != null) { 
            panelTop5MunicipiosPoblados.removeAll(); 
            GraficoTop5MunicipiosPoblados grafico = new GraficoTop5MunicipiosPoblados();
            grafico.setSize(panelTop5MunicipiosPoblados.getSize());
            panelTop5MunicipiosPoblados.add(grafico, BorderLayout.CENTER); 
            panelTop5MunicipiosPoblados.revalidate();
            panelTop5MunicipiosPoblados.repaint();
        }
    }
    
    private void cargarGraficoDistribucionEdad() {
    if (panelDistribuciónEdades != null) { 
        panelDistribuciónEdades.removeAll(); 
        GraficoDistribucionEdad grafico = new GraficoDistribucionEdad();
        grafico.setSize(panelDistribuciónEdades.getSize());
        panelDistribuciónEdades.add(grafico, BorderLayout.CENTER); 
        panelDistribuciónEdades.revalidate();
        panelDistribuciónEdades.repaint();
    }
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
                nuevaFila[6] = fila.get("actividadesEconomicas");

                modelo.addRow(nuevaFila);
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPromedioHabitantesVivienda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPromedioHabitanteVivienda = new javax.swing.JLabel();
        panelFiltros = new javax.swing.JPanel();
        cboFiltro = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        panelPromedioHabitantesVivienda1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPromedioHabitanteVivienda1 = new javax.swing.JLabel();
        nivelEducativoPanel = new javax.swing.JPanel();
        panellHabitantesTipoVivienda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        panelGraficaServiciosBasicos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblPorcentajeServicios = new javax.swing.JLabel();
        lblPorcentajeServicios1 = new javax.swing.JLabel();
        statPorcentajeServiciosBasicos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblPoblacionTotal = new javax.swing.JLabel();
        poblacionTotalKPI = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblPoblacionMunicipio = new javax.swing.JLabel();
        poblacionMunicipioKPI = new javax.swing.JLabel();
        panelTop5MunicipiosPoblados = new javax.swing.JPanel();
        panelDistribuciónEdades = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        panelPromedioHabitantesVivienda.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROMEDIO DE HABITANTES POR VIVIENDA");

        lblPromedioHabitanteVivienda.setFont(new java.awt.Font("Gadugi", 0, 36)); // NOI18N
        lblPromedioHabitanteVivienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPromedioHabitanteVivienda.setText("0.0");

        javax.swing.GroupLayout panelPromedioHabitantesViviendaLayout = new javax.swing.GroupLayout(panelPromedioHabitantesVivienda);
        panelPromedioHabitantesVivienda.setLayout(panelPromedioHabitantesViviendaLayout);
        panelPromedioHabitantesViviendaLayout.setHorizontalGroup(
            panelPromedioHabitantesViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromedioHabitantesViviendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPromedioHabitantesViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
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
        lblTitulo.setText("HABITANTES Y VIVIENDAS.");

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

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        panelPromedioHabitantesVivienda1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DENSIDAD DE POBLACIÓN (Habitantes por Vivienda).");

        lblPromedioHabitanteVivienda1.setFont(new java.awt.Font("Gadugi", 0, 48)); // NOI18N
        lblPromedioHabitanteVivienda1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPromedioHabitanteVivienda1.setText("0.0");

        javax.swing.GroupLayout panelPromedioHabitantesVivienda1Layout = new javax.swing.GroupLayout(panelPromedioHabitantesVivienda1);
        panelPromedioHabitantesVivienda1.setLayout(panelPromedioHabitantesVivienda1Layout);
        panelPromedioHabitantesVivienda1Layout.setHorizontalGroup(
            panelPromedioHabitantesVivienda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromedioHabitantesVivienda1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPromedioHabitantesVivienda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addComponent(lblPromedioHabitanteVivienda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPromedioHabitantesVivienda1Layout.setVerticalGroup(
            panelPromedioHabitantesVivienda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromedioHabitantesVivienda1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPromedioHabitanteVivienda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        nivelEducativoPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout nivelEducativoPanelLayout = new javax.swing.GroupLayout(nivelEducativoPanel);
        nivelEducativoPanel.setLayout(nivelEducativoPanelLayout);
        nivelEducativoPanelLayout.setHorizontalGroup(
            nivelEducativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        nivelEducativoPanelLayout.setVerticalGroup(
            nivelEducativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        panellHabitantesTipoVivienda.setBackground(new java.awt.Color(255, 255, 255));
        panellHabitantesTipoVivienda.setPreferredSize(new java.awt.Dimension(410, 0));

        javax.swing.GroupLayout panellHabitantesTipoViviendaLayout = new javax.swing.GroupLayout(panellHabitantesTipoVivienda);
        panellHabitantesTipoVivienda.setLayout(panellHabitantesTipoViviendaLayout);
        panellHabitantesTipoViviendaLayout.setHorizontalGroup(
            panellHabitantesTipoViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        panellHabitantesTipoViviendaLayout.setVerticalGroup(
            panellHabitantesTipoViviendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
        jScrollPane2.setViewportView(tablaResultados);

        panelGraficaServiciosBasicos.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelGraficaServiciosBasicosLayout = new javax.swing.GroupLayout(panelGraficaServiciosBasicos);
        panelGraficaServiciosBasicos.setLayout(panelGraficaServiciosBasicosLayout);
        panelGraficaServiciosBasicosLayout.setHorizontalGroup(
            panelGraficaServiciosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        panelGraficaServiciosBasicosLayout.setVerticalGroup(
            panelGraficaServiciosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblPorcentajeServicios.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        lblPorcentajeServicios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentajeServicios.setText("PORCENTAJE DE");

        lblPorcentajeServicios1.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        lblPorcentajeServicios1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentajeServicios1.setText("SERVICIOS BÁSICOS");

        statPorcentajeServiciosBasicos.setFont(new java.awt.Font("Gadugi", 0, 48)); // NOI18N
        statPorcentajeServiciosBasicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statPorcentajeServiciosBasicos.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPorcentajeServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statPorcentajeServiciosBasicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblPorcentajeServicios1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPorcentajeServicios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statPorcentajeServiciosBasicos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(239, Short.MAX_VALUE)
                    .addComponent(lblPorcentajeServicios1)
                    .addGap(16, 16, 16)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 125));

        lblPoblacionTotal.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblPoblacionTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoblacionTotal.setText("Población total");

        poblacionTotalKPI.setFont(new java.awt.Font("Gadugi", 0, 48)); // NOI18N
        poblacionTotalKPI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poblacionTotalKPI.setText("0000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoblacionTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(poblacionTotalKPI, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poblacionTotalKPI, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoblacionTotal)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 125));

        lblPoblacionMunicipio.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblPoblacionMunicipio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoblacionMunicipio.setText("Población Total del Municipio");

        poblacionMunicipioKPI.setFont(new java.awt.Font("Gadugi", 0, 48)); // NOI18N
        poblacionMunicipioKPI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poblacionMunicipioKPI.setText("0000");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoblacionMunicipio, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(poblacionMunicipioKPI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poblacionMunicipioKPI, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoblacionMunicipio)
                .addContainerGap())
        );

        panelTop5MunicipiosPoblados.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelTop5MunicipiosPobladosLayout = new javax.swing.GroupLayout(panelTop5MunicipiosPoblados);
        panelTop5MunicipiosPoblados.setLayout(panelTop5MunicipiosPobladosLayout);
        panelTop5MunicipiosPobladosLayout.setHorizontalGroup(
            panelTop5MunicipiosPobladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelTop5MunicipiosPobladosLayout.setVerticalGroup(
            panelTop5MunicipiosPobladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelDistribuciónEdades.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelDistribuciónEdadesLayout = new javax.swing.GroupLayout(panelDistribuciónEdades);
        panelDistribuciónEdades.setLayout(panelDistribuciónEdadesLayout);
        panelDistribuciónEdadesLayout.setHorizontalGroup(
            panelDistribuciónEdadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDistribuciónEdadesLayout.setVerticalGroup(
            panelDistribuciónEdadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panellHabitantesTipoVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                            .addComponent(panelPromedioHabitantesVivienda1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nivelEducativoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(panelGraficaServiciosBasicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTop5MunicipiosPoblados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDistribuciónEdades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelPromedioHabitantesVivienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nivelEducativoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panellHabitantesTipoVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(panelGraficaServiciosBasicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTop5MunicipiosPoblados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDistribuciónEdades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panelPrincipal);

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
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed

    private void cboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String municipioSeleccionado = (String) cboFiltro.getSelectedItem();
        cargarDatosTabla(municipioSeleccionado);
        cargarKPIs(municipioSeleccionado);
        cargarGraficoNivelEducativo(municipioSeleccionado);
        cargarGraficoTipoVivienda(municipioSeleccionado);
        cargarGraficaServiciosBasicos(municipioSeleccionado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPoblacionMunicipio;
    private javax.swing.JLabel lblPoblacionTotal;
    private javax.swing.JLabel lblPorcentajeServicios;
    private javax.swing.JLabel lblPorcentajeServicios1;
    private javax.swing.JLabel lblPromedioHabitanteVivienda;
    private javax.swing.JLabel lblPromedioHabitanteVivienda1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JPanel nivelEducativoPanel;
    private javax.swing.JPanel panelDistribuciónEdades;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelGraficaServiciosBasicos;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelPromedioHabitantesVivienda;
    private javax.swing.JPanel panelPromedioHabitantesVivienda1;
    private javax.swing.JPanel panelTop5MunicipiosPoblados;
    private javax.swing.JPanel panellHabitantesTipoVivienda;
    private javax.swing.JLabel poblacionMunicipioKPI;
    private javax.swing.JLabel poblacionTotalKPI;
    private javax.swing.JLabel statPorcentajeServiciosBasicos;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
