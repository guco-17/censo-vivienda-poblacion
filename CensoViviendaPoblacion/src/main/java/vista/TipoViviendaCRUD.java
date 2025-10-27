package vista;

import modelo.Usuario;
import controlador.TipoViviendaControlador;
import modelo.TipoVivienda;
import java.util.ArrayList; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoViviendaCRUD extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final TipoViviendaControlador controlador = new TipoViviendaControlador();
    private ArrayList<TipoVivienda> listaTiposVivienda;
    private int idTipoViviendaSeleccionado = -1;
    
    public TipoViviendaCRUD(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        cargarTablaTiposVivienda();
    }
    
    private void cargarTablaTiposVivienda() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCIÓN");

        try {
            // 3. Obtener la lista de tipos de vivienda del controlador
            this.listaTiposVivienda = controlador.obtenerTodos();

            // 4. Llenar el modelo con los datos
            for (TipoVivienda tv : listaTiposVivienda) {
                modelo.addRow(new Object[]{
                    tv.getId(),
                    tv.getDescripcion()
                });
            }

            // 5. Asignar el modelo a la JTable
            jTable1.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al cargar la tabla de Tipos de Vivienda: " + e.getMessage(), 
                "Error de Carga", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLtITULO = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblDescripcion1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        menuInicio2 = new javax.swing.JMenu();
        menuItemInicio2 = new javax.swing.JMenuItem();

        utils.CierreSeguro.habilitarCierreSeguro(this, usuarioSesion);

        LBLtITULO.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        LBLtITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLtITULO.setText("TIPOS DE VIVIENDA");

        lblDescripcion.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción:");

        jScrollPane1.setViewportView(txtDescripcion);

        jTable1.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
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
        jScrollPane2.setViewportView(jTable1);

        lblDescripcion1.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblDescripcion1.setText("IdTipoVivienda:");

        jScrollPane3.setViewportView(jTextPane2);

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

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LBLtITULO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblDescripcion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblDescripcion1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLtITULO)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblDescripcion1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblDescripcion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemInicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicio2ActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicio2ActionPerformed

    private void limpiarCampos() {
        jTextPane2.setText(""); // Limpiar ID
        txtDescripcion.setText(""); // Limpiar Descripción
    }
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String descripcion = txtDescripcion.getText().trim();
        TipoVivienda nuevoTipo = new TipoVivienda();
        nuevoTipo.setDescripcion(descripcion);
        
        try {
            boolean exito = controlador.registrarTipoVivienda(nuevoTipo);

            if (exito) {
                JOptionPane.showMessageDialog(this, 
                    "Tipo de Vivienda registrado exitosamente.", 
                    "Registro Exitoso", 
                    JOptionPane.INFORMATION_MESSAGE);

                limpiarCampos();
                cargarTablaTiposVivienda();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se pudo registrar el Tipo de Vivienda.", 
                    "Error de Registro", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                e.getMessage(), 
                "Error de Validación/BD", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int idActualizar;
        String nuevaDescripcion;
        
        try {
            String idText = jTextPane2.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Debe ingresar el IdTipoVivienda a actualizar en el campo ID.", 
                    "Error de Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            idActualizar = Integer.parseInt(idText);
            
            if (idActualizar <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "El ID debe ser un número entero positivo.", 
                    "Error de Formato", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "El ID debe ser un número entero válido.", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        nuevaDescripcion = txtDescripcion.getText().trim();
        if (nuevaDescripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "La descripción no puede estar vacía.", 
                "Error de Validación", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        TipoVivienda tipoViviendaActualizar = new TipoVivienda();
        tipoViviendaActualizar.setId(idActualizar); 
        tipoViviendaActualizar.setDescripcion(nuevaDescripcion);
        
        try {
            boolean exito = controlador.actualizarTipoVivienda(tipoViviendaActualizar);

            if (exito) {
                JOptionPane.showMessageDialog(this, 
                    "Tipo de Vivienda ID: " + idActualizar + " actualizado exitosamente.", 
                    "Actualización Exitosa", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                limpiarCampos();
                cargarTablaTiposVivienda();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se pudo actualizar el Tipo de Vivienda. Verifique que el ID exista.", 
                    "Error de Actualización", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al actualizar: " + e.getMessage(), 
                "Error de BD/Validación", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idEliminar;
        
        try {
            String idText = jTextPane2.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Debe ingresar el IdTipoVivienda a eliminar en el campo ID.", 
                    "Error de Validación", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            idEliminar = Integer.parseInt(idText);
            
            if (idEliminar <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "El ID debe ser un número entero positivo.", 
                    "Error de Formato", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "El ID debe ser un número entero válido.", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar el Tipo de Vivienda con ID: " + idEliminar + "?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                boolean exito = controlador.eliminarTipoVivienda(idEliminar);
                
                if (exito) {
                    JOptionPane.showMessageDialog(this, 
                        "Tipo de Vivienda ID: " + idEliminar + " eliminado exitosamente.", 
                        "Eliminación Exitosa", 
                        JOptionPane.INFORMATION_MESSAGE);
                    
                    limpiarCampos();
                    cargarTablaTiposVivienda();
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "No se pudo eliminar el Tipo de Vivienda. Verifique que el ID exista.", 
                        "Error de Eliminación", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Error al eliminar: " + e.getMessage(), 
                    "Error de BD", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLtITULO;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescripcion1;
    private javax.swing.JMenu menuInicio2;
    private javax.swing.JMenuItem menuItemInicio2;
    private javax.swing.JTextPane txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
