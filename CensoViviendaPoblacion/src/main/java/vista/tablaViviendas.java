package vista;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.Vivienda;
import controlador.ViviendaControlador;
import javax.swing.JOptionPane;

public class tablaViviendas extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final ViviendaControlador controlador;
    
    public tablaViviendas(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        this.controlador = new ViviendaControlador();
        cargarTablaViviendas();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        utils.CierreSeguro.habilitarCierreSeguro(this, usuarioSesion);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarTablaViviendas() {
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);

        modelo.addColumn("Código");
        modelo.addColumn("Calle");
        modelo.addColumn("Colonia");
        modelo.addColumn("Cuartos");
        modelo.addColumn("Agua");
        modelo.addColumn("Luz");
        modelo.addColumn("Gas");
        modelo.addColumn("Localidad");
        modelo.addColumn("Municipio");
        modelo.addColumn("Tipo Vivienda");

        try {
            ArrayList<Vivienda> viviendas = controlador.obtenerTodasLasViviendasConRelaciones();

            for (Vivienda v : viviendas) {
                modelo.addRow(new Object[]{
                    v.getCodigoVivienda(),
                    v.getCalle(),
                    v.getColonia(),
                    v.getCuartos(),
                    v.getTieneAgua(),
                    v.getTieneLuz(),
                    v.getTieneGas(),
                    v.getNombreLocalidad(),
                    v.getNombreMunicipio(),
                    v.getDescripcionTipoVivienda()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla de viviendas: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    // End of variables declaration//GEN-END:variables
}
