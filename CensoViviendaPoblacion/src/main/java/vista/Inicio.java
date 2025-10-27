package vista;

import modelo.Usuario;

public class Inicio extends javax.swing.JFrame {
    private Usuario usuarioActual;
    
    public Inicio(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioActual = usuarioAutenticado;
        this.setTitle("Censo Estatal Coahuila 2025 - Bienvenido: " + usuarioAutenticado.getNombreUsuario());
        gestionarPermisos();
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
            .addGap(0, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
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
