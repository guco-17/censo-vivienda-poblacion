package vista;

import controlador.UsuarioControlador;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class gestionUsuarios extends javax.swing.JFrame {
    private final UsuarioControlador usuarioControlador;
    private final Usuario usuarioSesion;
    
    public gestionUsuarios(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioControlador = new UsuarioControlador();
        this.usuarioSesion = usuarioAutenticado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuariosTitulo = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblRolUsuario = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        cboRolUsuario = new javax.swing.JComboBox<>();
        btnCrearUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsuariosTitulo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblUsuariosTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuariosTitulo.setText("USUARIOS");

        txtNombreUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        lblNombreUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblNombreUsuario.setText("Nombre de usuario:");

        lblPassword.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblPassword.setText("Contraseña:");

        lblRolUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblRolUsuario.setText("Rol de usuario:");

        txtPassword.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        cboRolUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar rol", "admin", "client" }));

        btnCrearUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btnCrearUsuario.setText("CREAR");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btnEliminarUsuario.setText("ELIMINAR");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

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
            .addComponent(lblUsuariosTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRolUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword)
                            .addComponent(lblNombreUsuario))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword)
                    .addComponent(txtNombreUsuario)
                    .addComponent(cboRolUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblUsuariosTitulo)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String password = txtPassword.getText().trim(); 
        String rol = cboRolUsuario.getSelectedItem().toString();
        
        if (nombreUsuario.isEmpty() || password.isEmpty() || rol.equals("seleccionar rol")) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setRol(rol);
        
        try {
            boolean exito = usuarioControlador.crearUsuario(nuevoUsuario);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Usuario '" + nombreUsuario + "' creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } else {
                 JOptionPane.showMessageDialog(this, "La operación no afectó ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al Crear Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        String nombreUsuario = txtNombreUsuario.getText().trim();
        
        
        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar el campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Usuario user = new Usuario();
        user.setNombreUsuario(nombreUsuario);
        
        try {
            boolean exito = usuarioControlador.eliminarUsuario(user);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Usuario '" + nombreUsuario + "' eliminado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } else {
                 JOptionPane.showMessageDialog(this, "La operación no afectó ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al Crear Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JComboBox<String> cboRolUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRolUsuario;
    private javax.swing.JLabel lblUsuariosTitulo;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
