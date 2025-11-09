package vista.CRUDS;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.ActividadEconomica;
import modelo.DAO.ActividadEconomicaDAO;
import vista.Inicio;
import static utils.CierreSeguro.cerrarAplicacion;

public class ActividadesEconomicasCRUD extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final ActividadEconomicaDAO actividadDAO = new ActividadEconomicaDAO();
    private ArrayList<ActividadEconomica> listaActividades;

    public ActividadesEconomicasCRUD(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        cargarTablaActividadesEconomicas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLtITULO = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtActEconom = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        menuInicio2 = new javax.swing.JMenu();
        menuItemInicio2 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBLtITULO.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        LBLtITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLtITULO.setText("ACTIVIDADES ECONÓMICAS");

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

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jLabel1.setText("idActividadEconomica:");

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jLabel2.setText("Descripción:");

        jScrollPane2.setViewportView(txtActEconom);

        jScrollPane3.setViewportView(txtDescripcion);

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        menuInicio2.setText("Inicio");

        menuItemInicio2.setText("Regresar");
        menuItemInicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInicio2ActionPerformed(evt);
            }
        });
        menuInicio2.add(menuItemInicio2);

        jMenuBar3.add(menuInicio2);

        menuSalir.setText("Cerrar Aplicación");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuSalir.add(jMenuItem3);

        jMenuBar3.add(menuSalir);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LBLtITULO, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLtITULO)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarTablaActividadesEconomicas(){
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCIÓN");
        
        try{
            this.listaActividades = actividadDAO.obtenerTodos();
            for (ActividadEconomica ae : listaActividades) {
                modelo.addRow(new Object[]{
                    ae.getId(),
                    ae.getDescripcion()
                });
            }
            jTable1.setModel(modelo);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla: " + e.getMessage(),"Error de Carga",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void limpiarCampos() {
        txtActEconom.setText("");
        txtDescripcion.setText("");
    }
    
    private void menuItemInicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicio2ActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicio2ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String descripcion = txtDescripcion.getText().trim();
        
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ActividadEconomica nuevaActividad = new ActividadEconomica();
        nuevaActividad.setDescripcion(descripcion);

        try {
            // CAMBIO: Llamada directa al DAO
            boolean exito = actividadDAO.agregar(nuevaActividad);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Actividad Económica registrada exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarTablaActividadesEconomicas();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar la Actividad Económica.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de Base de Datos al registrar: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int idActualizar;
        String nuevaDescripcion;
        
        try {
            String idText = txtActEconom.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el ID a actualizar.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            idActualizar = Integer.parseInt(idText);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nuevaDescripcion = txtDescripcion.getText().trim();
        if (nuevaDescripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ActividadEconomica actividadActualizar = new ActividadEconomica();
        actividadActualizar.setId(idActualizar); 
        actividadActualizar.setDescripcion(nuevaDescripcion);
        
        try {
            boolean exito = actividadDAO.actualizar(actividadActualizar);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Actividad Económica ID: " + idActualizar + " actualizada exitosamente.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarTablaActividadesEconomicas();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la Actividad Económica. Verifique que el ID exista.", "Error de Actualización", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de Base de Datos al actualizar: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idEliminar;
        
        // 1. Obtener y validar el ID
        try {
            String idText = txtActEconom.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el ID a eliminar.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            idEliminar = Integer.parseInt(idText);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 2. Confirmación
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar la Actividad Económica con ID: " + idEliminar + "?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                // 3. Llamar al DAO para eliminar
                // CAMBIO: Llamada directa al DAO
                boolean exito = actividadDAO.eliminar(idEliminar);
                
                if (exito) {
                    JOptionPane.showMessageDialog(this, "Actividad Económica ID: " + idEliminar + " eliminada exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    cargarTablaActividadesEconomicas();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la Actividad Económica. Verifique que el ID exista.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                // Esto manejará si la actividad tiene dependencias (Foreign Key Constraint)
                JOptionPane.showMessageDialog(this, "Error de Base de Datos al eliminar. Verifique dependencias. Mensaje: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        cerrarAplicacion(usuarioSesion);
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLtITULO;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuInicio2;
    private javax.swing.JMenuItem menuItemInicio2;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JTextPane txtActEconom;
    private javax.swing.JTextPane txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
