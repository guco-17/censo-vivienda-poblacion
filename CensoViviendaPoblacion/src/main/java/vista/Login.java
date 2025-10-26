package vista;

import javax.swing.JOptionPane;
import modelo.DAO.UsuarioDAO;
import modelo.Usuario;

public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoginTitulo = new javax.swing.JLabel();
        lblLoginBienvenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombreUsuario = new javax.swing.JTextPane();
        txtPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lblLoginPregunta = new javax.swing.JLabel();
        lblLoginCuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoginTitulo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblLoginTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginTitulo.setText("CENSO ESTATAL INEGI 2025");

        lblLoginBienvenido.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        lblLoginBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginBienvenido.setText("¡BIENVENIDO!");

        txtNombreUsuario.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        txtNombreUsuario.setText("Nombre de Usuario");
        txtNombreUsuario.setToolTipText("");
        jScrollPane1.setViewportView(txtNombreUsuario);

        txtPassword.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        txtPassword.setText("Contraseña");

        jButton1.setText("Iniciar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblLoginPregunta.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        lblLoginPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginPregunta.setText("¿No tienes una cuenta?");

        lblLoginCuenta.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblLoginCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginCuenta.setText("Solicita una con un administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoginTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLoginBienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLoginPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txtPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)))
                .addGap(86, 86, 86))
            .addComponent(lblLoginCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblLoginTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLoginBienvenido)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLoginPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoginCuenta)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreUsuario = txtNombreUsuario.getText();
        String password = new String(txtPassword.getPassword());
        
        if(nombreUsuario.isEmpty() || nombreUsuario.contains("Nombre de Usuario") || password.isEmpty() || password.contains("Contraseña")){
            JOptionPane.showMessageDialog(this, "Debe ingresar usuario y contraseña.", "Error de Login", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        UsuarioDAO dao = new UsuarioDAO();
        try{
            Usuario usuarioAutenticado = dao.validarCredenciales(nombreUsuario, password);
            
            if (usuarioAutenticado != null) {
                Inicio inicio = new Inicio(usuarioAutenticado);
                inicio.setVisible(true);
                this.dispose(); // Cierra la ventana actual de Login

            } else {
                JOptionPane.showMessageDialog(this, "Credenciales inválidas. Por favor, verifique su usuario y contraseña.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error del sistema: " + e.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoginBienvenido;
    private javax.swing.JLabel lblLoginCuenta;
    private javax.swing.JLabel lblLoginPregunta;
    private javax.swing.JLabel lblLoginTitulo;
    private javax.swing.JTextPane txtNombreUsuario;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
