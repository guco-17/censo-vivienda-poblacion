package vista;

import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.ConexionDB;
import controlador.DashboardControlador;
import java.awt.BorderLayout;

public class Inicio extends javax.swing.JFrame {
    private Usuario usuarioActual;
    private final DashboardControlador dashboardControlador;
    
    public Inicio(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioActual = usuarioAutenticado;
        this.dashboardControlador = new DashboardControlador();
        this.setTitle("Censo Estatal Coahuila 2025 - Bienvenido: " + usuarioAutenticado.getNombreUsuario());
        gestionarPermisos();
        cargarKPIs();
        cargarGraficoHombresMujeres();
        cargarGraficoDashboard();
    }
    
    public static void cerrarAplicacion(Usuario usuario) {
        try {
            if (usuario != null) {
                System.out.println("Cerrando sesión del usuario: " + usuario.getNombreUsuario());
                usuario = null;
            }

            if (ConexionDB.getInstance() != null) {
                ConexionDB.getInstance().closeConnection();
                System.out.println("Conexión a base de datos cerrada correctamente.");
            }
            

            JOptionPane.showMessageDialog(null,
                "Sesión cerrada y recursos liberados correctamente.\nSaliendo del sistema...",
                "Cierre seguro",
                JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al cerrar la aplicación: " + e.getMessage(),
                "Error de cierre",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void gestionarPermisos() {
        String rol = usuarioActual.getRol();
        
        if (!"admin".equals(rol.toLowerCase().trim())) {
            menuBar.setVisible(false);
        }
    }
    
    private void cargarKPIs() {
        try {
            // KPI 1: Población Total
            int totalHabitantes = dashboardControlador.obtenerPoblacionTotal();
            poblacionTotalKPI.setText(String.valueOf(totalHabitantes));
            
            // KPI 2: Total de Viviendas
            int totalVivienda = dashboardControlador.obtenerViviendas();
            viviendaServicios.setText(String.valueOf(totalVivienda)); 
            
            // KPI 2: Población Económicamente Activa (PEA)
            int pea = dashboardControlador.obtenerPoblacionActivaEconomica();
            poblacionActivaEconomicaKPI.setText(String.valueOf(pea)); 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Error al cargar los datos del Dashboard: " + e.getMessage(), 
                    "Error de Conexión", 
                    JOptionPane.ERROR_MESSAGE);
            // Mostrar errores en los KPIs
            poblacionTotalKPI.setText("N/A");
            poblacionActivaEconomicaKPI.setText("N/A");
            viviendaServicios.setText("N/A");
        }
    }
    
    private void cargarGraficoHombresMujeres() {
        //GRAFICO HOMBRES Y MUJERES
        // Limpiar panel
        panelGraficoGenero.removeAll(); 

        // instancia del gráfico
        GraficoGenero graficoHmbresMujeres = new GraficoGenero(); 

        //Configurar el tamaño y añadir al contenedor
        graficoHmbresMujeres.setSize(panelGraficoGenero.getSize());
        panelGraficoGenero.add(graficoHmbresMujeres);

        //Repintar el panel contenedor
        panelGraficoGenero.revalidate();
        panelGraficoGenero.repaint();
    }
    
    private void cargarGraficoDashboard() {
        graficoActEconom.removeAll(); 

        GraficoActividadEconomica graficoActividad = new GraficoActividadEconomica(); 

        graficoActividad.setSize(graficoActEconom.getSize());
        graficoActEconom.add(graficoActividad, BorderLayout.CENTER); 

        graficoActEconom.revalidate();
        graficoActEconom.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblViviendasServicios = new javax.swing.JLabel();
        viviendaServicios = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblPoblacionTotal = new javax.swing.JLabel();
        poblacionTotalKPI = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblPobEconomAct = new javax.swing.JLabel();
        poblacionActivaEconomicaKPI = new javax.swing.JLabel();
        panelGraficoGenero = new javax.swing.JPanel();
        graficoActEconom = new javax.swing.JPanel();
        btnHabitantesVivienda = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuUsuarios = new javax.swing.JMenu();
        usuariosGestionar = new javax.swing.JMenuItem();
        menuCatalogos = new javax.swing.JMenu();
        menuItemTipoViviendaCRUD = new javax.swing.JMenuItem();
        menuItemActividadesEconomicas = new javax.swing.JMenuItem();
        menuMunicipios = new javax.swing.JMenuItem();
        menuItemLocalidades = new javax.swing.JMenuItem();
        menuVivienda = new javax.swing.JMenu();
        menuItemGestionarVivienda = new javax.swing.JMenuItem();
        menuItemTablaViviendas = new javax.swing.JMenuItem();
        menuPoblacion = new javax.swing.JMenu();
        menuItemGestionHabitantes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CENSO COAHUILA 2025");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DASHBOARD");

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jLabel3.setText("Versión 1.0");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 100));

        lblViviendasServicios.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblViviendasServicios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViviendasServicios.setText("Total de Viviendas");

        viviendaServicios.setFont(new java.awt.Font("Gadugi", 0, 36)); // NOI18N
        viviendaServicios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viviendaServicios.setText("0000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblViviendasServicios, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(viviendaServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viviendaServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblViviendasServicios)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 125));

        lblPoblacionTotal.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblPoblacionTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoblacionTotal.setText("Población total");

        poblacionTotalKPI.setFont(new java.awt.Font("Gadugi", 0, 36)); // NOI18N
        poblacionTotalKPI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poblacionTotalKPI.setText("0000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoblacionTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(poblacionTotalKPI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poblacionTotalKPI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoblacionTotal)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(250, 100));

        lblPobEconomAct.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblPobEconomAct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPobEconomAct.setText("Población economicamente activa");

        poblacionActivaEconomicaKPI.setFont(new java.awt.Font("Gadugi", 0, 36)); // NOI18N
        poblacionActivaEconomicaKPI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poblacionActivaEconomicaKPI.setText("0000");
        poblacionActivaEconomicaKPI.setPreferredSize(new java.awt.Dimension(250, 125));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPobEconomAct, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(poblacionActivaEconomicaKPI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poblacionActivaEconomicaKPI, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPobEconomAct)
                .addContainerGap())
        );

        panelGraficoGenero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelGraficoGeneroLayout = new javax.swing.GroupLayout(panelGraficoGenero);
        panelGraficoGenero.setLayout(panelGraficoGeneroLayout);
        panelGraficoGeneroLayout.setHorizontalGroup(
            panelGraficoGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        panelGraficoGeneroLayout.setVerticalGroup(
            panelGraficoGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        graficoActEconom.setBackground(new java.awt.Color(255, 255, 255));
        graficoActEconom.setPreferredSize(new java.awt.Dimension(327, 307));
        graficoActEconom.setLayout(new java.awt.BorderLayout());

        btnHabitantesVivienda.setText("HABITANTES POR VIVIENDA");
        btnHabitantesVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabitantesViviendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(panelGraficoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(graficoActEconom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnHabitantesVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGraficoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(graficoActEconom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnHabitantesVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        menuUsuarios.setText("Usuarios");

        usuariosGestionar.setText("Gestionar Usuarios");
        usuariosGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosGestionarActionPerformed(evt);
            }
        });
        menuUsuarios.add(usuariosGestionar);

        menuBar.add(menuUsuarios);

        menuCatalogos.setText("Catalogos");

        menuItemTipoViviendaCRUD.setText("Tipo de Vivienda");
        menuItemTipoViviendaCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTipoViviendaCRUDActionPerformed(evt);
            }
        });
        menuCatalogos.add(menuItemTipoViviendaCRUD);

        menuItemActividadesEconomicas.setText("Actividades Economicas");
        menuItemActividadesEconomicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActividadesEconomicasActionPerformed(evt);
            }
        });
        menuCatalogos.add(menuItemActividadesEconomicas);

        menuMunicipios.setText("Municipios");
        menuMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMunicipiosActionPerformed(evt);
            }
        });
        menuCatalogos.add(menuMunicipios);

        menuItemLocalidades.setText("Localidades");
        menuItemLocalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLocalidadesActionPerformed(evt);
            }
        });
        menuCatalogos.add(menuItemLocalidades);

        menuBar.add(menuCatalogos);

        menuVivienda.setText("Vivienda");

        menuItemGestionarVivienda.setText("Gestionar Viviendas");
        menuItemGestionarVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionarViviendaActionPerformed(evt);
            }
        });
        menuVivienda.add(menuItemGestionarVivienda);

        menuItemTablaViviendas.setText("Tabla de Viviendas");
        menuItemTablaViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTablaViviendasActionPerformed(evt);
            }
        });
        menuVivienda.add(menuItemTablaViviendas);

        menuBar.add(menuVivienda);

        menuPoblacion.setText("Población");

        menuItemGestionHabitantes.setText("Gestionar Habitantes");
        menuItemGestionHabitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionHabitantesActionPerformed(evt);
            }
        });
        menuPoblacion.add(menuItemGestionHabitantes);

        jMenuItem1.setText("Tabla de Habitantes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuPoblacion.add(jMenuItem1);

        menuBar.add(menuPoblacion);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuariosGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosGestionarActionPerformed
        gestionUsuarios gestionarUsuarios = new gestionUsuarios(this.usuarioActual);
        gestionarUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_usuariosGestionarActionPerformed

    private void menuItemGestionHabitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionHabitantesActionPerformed
        gestionHabitantes gestionarHabitantes = new gestionHabitantes(this.usuarioActual);
        gestionarHabitantes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemGestionHabitantesActionPerformed

    private void menuItemGestionarViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionarViviendaActionPerformed
        gestionVivienda gestionarViviendas = new gestionVivienda(this.usuarioActual);
        gestionarViviendas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemGestionarViviendaActionPerformed

    private void menuItemTablaViviendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTablaViviendasActionPerformed
        tablaViviendas tabla = new tablaViviendas(this.usuarioActual);
        tabla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemTablaViviendasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        tablaHabitantes tabla = new tablaHabitantes(this.usuarioActual);
        tabla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuItemTipoViviendaCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTipoViviendaCRUDActionPerformed
        TipoViviendaCRUD tipoviviendacrud = new TipoViviendaCRUD(this.usuarioActual);
        tipoviviendacrud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemTipoViviendaCRUDActionPerformed

    private void menuItemActividadesEconomicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActividadesEconomicasActionPerformed
        ActividadesEconomicasCRUD actEconom = new ActividadesEconomicasCRUD(this.usuarioActual);
        actEconom.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemActividadesEconomicasActionPerformed

    private void menuMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMunicipiosActionPerformed
        MunicipioCRUD m = new MunicipioCRUD(this.usuarioActual);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuMunicipiosActionPerformed

    private void menuItemLocalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLocalidadesActionPerformed
        LocalidadesCRUD l = new LocalidadesCRUD(this.usuarioActual);
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemLocalidadesActionPerformed

    private void btnHabitantesViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabitantesViviendaActionPerformed
        reporteHabitantesVivienda reporte = new reporteHabitantesVivienda(this.usuarioActual);
        reporte.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHabitantesViviendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHabitantesVivienda;
    private javax.swing.JPanel graficoActEconom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPobEconomAct;
    private javax.swing.JLabel lblPoblacionTotal;
    private javax.swing.JLabel lblViviendasServicios;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCatalogos;
    private javax.swing.JMenuItem menuItemActividadesEconomicas;
    private javax.swing.JMenuItem menuItemGestionHabitantes;
    private javax.swing.JMenuItem menuItemGestionarVivienda;
    private javax.swing.JMenuItem menuItemLocalidades;
    private javax.swing.JMenuItem menuItemTablaViviendas;
    private javax.swing.JMenuItem menuItemTipoViviendaCRUD;
    private javax.swing.JMenuItem menuMunicipios;
    private javax.swing.JMenu menuPoblacion;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuVivienda;
    private javax.swing.JPanel panelGraficoGenero;
    private javax.swing.JLabel poblacionActivaEconomicaKPI;
    private javax.swing.JLabel poblacionTotalKPI;
    private javax.swing.JMenuItem usuariosGestionar;
    private javax.swing.JLabel viviendaServicios;
    // End of variables declaration//GEN-END:variables
}
