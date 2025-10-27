package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.LocalidadDAO;
import modelo.DAO.MunicipioDAO;
import modelo.Localidad;
import modelo.Municipio;
import modelo.Usuario;

public class LocalidadesCRUD extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final MunicipioDAO municipioDAO = new MunicipioDAO();
    private ArrayList<Municipio> listaMunicipios;
    private final LocalidadDAO localidadDAO = new LocalidadDAO();
    private ArrayList<Localidad> listaLocalidades;
    private int idMunicipioSeleccionado = -1;
    
    public LocalidadesCRUD(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        cargarTablaMunicipios();
        cargarTablaLocalidades();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLtITULO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMunicipios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLocalidades = new javax.swing.JTable();
        lblLocalidades = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtIdLocalidad = new javax.swing.JTextPane();
        lblCveLoc = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCveLoc = new javax.swing.JTextPane();
        lblCveLoc1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        lblCveLoc2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtIdMunicipio = new javax.swing.JTextPane();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        menuInicio2 = new javax.swing.JMenu();
        menuItemInicio2 = new javax.swing.JMenuItem();

        utils.CierreSeguro.habilitarCierreSeguro(this, usuarioSesion);

        LBLtITULO.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        LBLtITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLtITULO.setText("LOCALIDADES DE COAHUILA");

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MUNICIPIOS DISPONIBLES");

        tablaMunicipios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaMunicipios);

        tablaLocalidades.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaLocalidades);

        lblLocalidades.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        lblLocalidades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLocalidades.setText("LOCALIDADES");

        lblLocalidad.setText("idLocalidad:");

        jScrollPane3.setViewportView(txtIdLocalidad);

        lblCveLoc.setText("Clave de localidad:");

        jScrollPane4.setViewportView(txtCveLoc);

        lblCveLoc1.setText("Descripción:");

        jScrollPane5.setViewportView(txtDescripcion);

        lblCveLoc2.setText("idMunicipio:");

        jScrollPane6.setViewportView(txtIdMunicipio);

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
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(lblLocalidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblLocalidad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCveLoc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCveLoc1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCveLoc2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLtITULO)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblLocalidades))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblLocalidad))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCveLoc)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCveLoc1)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCveLoc2)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos() {
        txtIdLocalidad.setText("");
        txtCveLoc.setText("");
        txtDescripcion.setText("");
        txtIdMunicipio.setText("");
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
            tablaMunicipios.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al cargar la tabla: " + e.getMessage(),
                "Error de Carga",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarTablaLocalidades() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("CLAVE LOC");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("ID MUNICIPIO");

        try {
            // Se utiliza obtenerTodos() para cargar todas las localidades.
            this.listaLocalidades = localidadDAO.obtenerTodos();
            
            for (Localidad l : listaLocalidades) {
                modelo.addRow(new Object[]{
                    l.getId(),
                    l.getCve_loc(),
                    l.getDescripcion(),
                    l.getIdMunicipio()
                });
            }
            tablaLocalidades.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al cargar la tabla de Localidades: " + e.getMessage(),
                "Error de Carga",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void menuItemInicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicio2ActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicio2ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String cveLoc = txtCveLoc.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String idMunicipioStr = txtIdMunicipio.getText().trim();

        // Validaciones
        if (cveLoc.isEmpty() || descripcion.isEmpty() || idMunicipioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos (Clave Loc, Descripción, Id Municipio) son obligatorios para el registro.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idMunicipio = Integer.parseInt(idMunicipioStr);

            Localidad nuevaLocalidad = new Localidad();
            nuevaLocalidad.setCve_loc(cveLoc);
            nuevaLocalidad.setDescripcion(descripcion);
            nuevaLocalidad.setIdMunicipio(idMunicipio); // idMunicipio lo pone el usuario

            if (localidadDAO.agregar(nuevaLocalidad)) {
                JOptionPane.showMessageDialog(this, "Localidad registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarTablaLocalidades(); // Refrescar tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar la localidad. Verifique si el idMunicipio existe.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de Municipio debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String idLocalidadStr = txtIdLocalidad.getText().trim();
        String cveLoc = txtCveLoc.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String idMunicipioStr = txtIdMunicipio.getText().trim();

        // Validaciones
        if (idLocalidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una localidad de la tabla para actualizar.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cveLoc.isEmpty() || descripcion.isEmpty() || idMunicipioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios para la actualización.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idLocalidad = Integer.parseInt(idLocalidadStr); // ID Localidad (obligatorio)
            int idMunicipio = Integer.parseInt(idMunicipioStr);

            // Crear objeto Localidad
            Localidad localidadAActualizar = new Localidad();
            localidadAActualizar.setId(idLocalidad); // Usar el idLocalidad para actualizar
            localidadAActualizar.setCve_loc(cveLoc);
            localidadAActualizar.setDescripcion(descripcion);
            localidadAActualizar.setIdMunicipio(idMunicipio);

            // Actualizar
            if (localidadDAO.actualizar(localidadAActualizar)) {
                JOptionPane.showMessageDialog(this, "Localidad actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarTablaLocalidades(); // Refrescar tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la localidad. Verifique los datos o si el ID de Localidad y Municipio existen.", "Error de Actualización", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos de ID deben ser números enteros válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idLocalidadStr = txtIdLocalidad.getText().trim();

        if (idLocalidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una localidad de la tabla para eliminar.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idLocalidad = Integer.parseInt(idLocalidadStr);

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar la Localidad con ID: " + idLocalidad + "?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                if (localidadDAO.eliminar(idLocalidad)) {
                    JOptionPane.showMessageDialog(this, "Localidad eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    cargarTablaLocalidades();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la localidad. Verifique si el ID existe y no tiene registros relacionados.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de Localidad debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLtITULO;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCveLoc;
    private javax.swing.JLabel lblCveLoc1;
    private javax.swing.JLabel lblCveLoc2;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblLocalidades;
    private javax.swing.JMenu menuInicio2;
    private javax.swing.JMenuItem menuItemInicio2;
    private javax.swing.JTable tablaLocalidades;
    private javax.swing.JTable tablaMunicipios;
    private javax.swing.JTextPane txtCveLoc;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtIdLocalidad;
    private javax.swing.JTextPane txtIdMunicipio;
    // End of variables declaration//GEN-END:variables
}
