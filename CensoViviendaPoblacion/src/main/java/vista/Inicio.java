package vista;

import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.ConexionDB;

public class Inicio extends javax.swing.JFrame {
    private Usuario usuarioActual;
    
    public Inicio(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioActual = usuarioAutenticado;
        this.setTitle("Censo Estatal Coahuila 2025 - Bienvenido: " + usuarioAutenticado.getNombreUsuario());
        gestionarPermisos();
    }
    
    public static void cerrarAplicacion(Usuario usuario) {
        try {
            if (usuario != null) {
                System.out.println("Cerrando sesión del usuario: " + usuario.getNombreUsuario());
                usuario = null; // Elimina referencia a usuario en memoria
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
        // Ejemplo de lógica para deshabilitar o habilitar menús
        String rol = usuarioActual.getRol();
        
        if (!"admin".equals(rol.toLowerCase().trim())) {
            
        }
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
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 440, Short.MAX_VALUE))
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
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JMenuItem usuariosGestionar;
    // End of variables declaration//GEN-END:variables
}
