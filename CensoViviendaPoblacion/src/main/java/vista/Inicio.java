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

        menuBar = new javax.swing.JMenuBar();
        menuUsuarios = new javax.swing.JMenu();
        usuariosGestionar = new javax.swing.JMenuItem();
        menuVivienda = new javax.swing.JMenu();
        menuItemGestionarVivienda = new javax.swing.JMenuItem();
        menuPoblacion = new javax.swing.JMenu();
        menuItemGestionHabitantes = new javax.swing.JMenuItem();

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

        menuVivienda.setText("Vivienda");

        menuItemGestionarVivienda.setText("Gestionar Viviendas");
        menuItemGestionarVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionarViviendaActionPerformed(evt);
            }
        });
        menuVivienda.add(menuItemGestionarVivienda);

        menuBar.add(menuVivienda);

        menuPoblacion.setText("Población");

        menuItemGestionHabitantes.setText("Gestionar Habitantes");
        menuItemGestionHabitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionHabitantesActionPerformed(evt);
            }
        });
        menuPoblacion.add(menuItemGestionHabitantes);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemGestionHabitantes;
    private javax.swing.JMenuItem menuItemGestionarVivienda;
    private javax.swing.JMenu menuPoblacion;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuVivienda;
    private javax.swing.JMenuItem usuariosGestionar;
    // End of variables declaration//GEN-END:variables
}
