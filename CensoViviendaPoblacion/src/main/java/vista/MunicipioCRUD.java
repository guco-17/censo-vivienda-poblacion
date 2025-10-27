package vista;

import modelo.Usuario;
import modelo.Municipio;
import modelo.DAO.MunicipioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MunicipioCRUD extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final MunicipioDAO municipioDAO = new MunicipioDAO();
    private ArrayList<Municipio> listaMunicipios;
    
    public MunicipioCRUD(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        cargarTablaMunicipios();
    }
    
    private void cargarTablaMunicipios() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("CLAVE");
        modelo.addColumn("DESCRIPCIÓN");

        try {
            this.listaMunicipios = municipioDAO.obtenerTodos();
            for (Municipio m : listaMunicipios) {
                modelo.addRow(new Object[]{
                    m.getId(),
                    m.getCve_mun(),
                    m.getDescripcion()
                });
            }
            jTable1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al cargar la tabla: " + e.getMessage(),
                "Error de Carga",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiarCampos() {
        txtIdMunicipio.setText("");
        txtCveMun.setText("");
        txtDescripcion.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLtITULO = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblIdMunicipio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIdMunicipio = new javax.swing.JTextPane();
        lblIdMunicipio1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCveMun = new javax.swing.JTextPane();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        menuInicio2 = new javax.swing.JMenu();
        menuItemInicio2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBLtITULO.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        LBLtITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLtITULO.setText("Municipios de Coahuila");

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

        lblIdMunicipio.setText("idMunicipio:");

        jScrollPane2.setViewportView(txtIdMunicipio);

        lblIdMunicipio1.setText("clave de municipio:");

        jScrollPane3.setViewportView(txtCveMun);

        lblDescripcion.setText("Descripcion:");

        jScrollPane4.setViewportView(txtDescripcion);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdMunicipio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblIdMunicipio1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLtITULO)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdMunicipio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdMunicipio1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemInicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicio2ActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicio2ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String cveMun = txtCveMun.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        
        if (cveMun.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La Clave y la Descripción son obligatorias.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Municipio nuevoMunicipio = new Municipio();
        nuevoMunicipio.setCve_mun(cveMun);
        nuevoMunicipio.setDescripcion(descripcion);

        try {
            boolean exito = municipioDAO.agregar(nuevoMunicipio);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Municipio registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarTablaMunicipios();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar el Municipio.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de Base de Datos al registrar: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(MunicipioCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int idActualizar;
        String cveMun = txtCveMun.getText().trim();
        String nuevaDescripcion = txtDescripcion.getText().trim();
        
        try {
            String idText = txtIdMunicipio.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar o seleccionar el ID a actualizar.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            idActualizar = Integer.parseInt(idText);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cveMun.isEmpty() || nuevaDescripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La Clave y la Descripción no pueden estar vacías.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Municipio municipioActualizar = new Municipio();
        municipioActualizar.setId(idActualizar); 
        municipioActualizar.setCve_mun(cveMun);
        municipioActualizar.setDescripcion(nuevaDescripcion);
        
        try {
            boolean exito = municipioDAO.actualizar(municipioActualizar);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Municipio ID: " + idActualizar + " actualizado exitosamente.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarTablaMunicipios();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el Municipio. Verifique que el ID exista.", "Error de Actualización", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de Base de Datos al actualizar: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(MunicipioCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idEliminar;
        
        // 1. Obtener y validar el ID
        try {
            String idText = txtIdMunicipio.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar o seleccionar el ID a eliminar.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            idEliminar = Integer.parseInt(idText);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 2. Confirmación
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar el Municipio con ID: " + idEliminar + "?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                // 3. Llamar al DAO para eliminar
                boolean exito = municipioDAO.eliminar(idEliminar);
                
                if (exito) {
                    JOptionPane.showMessageDialog(this, "Municipio ID: " + idEliminar + " eliminado exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    cargarTablaMunicipios();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el Municipio. Verifique que el ID exista.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                // Maneja si la clave foránea impide la eliminación (e.g., Viviendas en este municipio)
                JOptionPane.showMessageDialog(this, "Error de Base de Datos al eliminar. Verifique dependencias (ej. Localidades). Mensaje: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(MunicipioCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblIdMunicipio;
    private javax.swing.JLabel lblIdMunicipio1;
    private javax.swing.JMenu menuInicio2;
    private javax.swing.JMenuItem menuItemInicio2;
    private javax.swing.JTextPane txtCveMun;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtIdMunicipio;
    // End of variables declaration//GEN-END:variables
}
