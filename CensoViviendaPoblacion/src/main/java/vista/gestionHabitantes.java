package vista;

import controlador.HabitanteControlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Usuario;
import javax.swing.JOptionPane;
import modelo.Habitante;

public class gestionHabitantes extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final HabitanteControlador controlador;
    
    public gestionHabitantes(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        this.controlador = new HabitanteControlador();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHabitantesTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        lblPaterno = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaterno = new javax.swing.JTextPane();
        lblMaterno = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMaterno = new javax.swing.JTextPane();
        dateNacimiento = new javax.swing.JFormattedTextField();
        lblFechaNaciiento = new javax.swing.JLabel();
        cboGenero = new javax.swing.JComboBox<>();
        lblGenero = new javax.swing.JLabel();
        cboEstadoCivil = new javax.swing.JComboBox<>();
        lblEstadoCivil = new javax.swing.JLabel();
        lblNivelEducacion = new javax.swing.JLabel();
        cboNivelEducacion = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblCodigoHabitante = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCodigoHabitante = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHabitantesTitulo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblHabitantesTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHabitantesTitulo.setText("GESTIÓN DE HABITANTES");

        lblNombre.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txtNombre);

        lblPaterno.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblPaterno.setText("Paterno:");

        txtPaterno.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(txtPaterno);

        lblMaterno.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblMaterno.setText("Materno:");

        txtMaterno.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(txtMaterno);

        dateNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        lblFechaNaciiento.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblFechaNaciiento.setText("Fecha Nacimiento");

        cboGenero.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar género", "H", "M" }));

        lblGenero.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblGenero.setText("Genero:");

        cboEstadoCivil.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar estado civil", "Soltero (a)", "Casado (a)", "Divorciado (a)", "Viudo (a)" }));

        lblEstadoCivil.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblEstadoCivil.setText("Estado Civil:");

        lblNivelEducacion.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblNivelEducacion.setText("Nivel de Educación");

        cboNivelEducacion.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboNivelEducacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Nivel Educacion", "Básica", "Media Superior", "Superior" }));

        jButton1.setText("ACTUALIZAR");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");

        lblCodigoHabitante.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblCodigoHabitante.setText("Código Habitante:");

        txtCodigoHabitante.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(txtCodigoHabitante);

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
            .addComponent(lblHabitantesTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lblMaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblPaterno)
                                    .addComponent(lblCodigoHabitante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(lblFechaNaciiento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblGenero)
                                .addComponent(lblEstadoCivil)
                                .addComponent(lblNivelEducacion))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboNivelEducacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboEstadoCivil, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHabitantesTitulo)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoHabitante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNaciiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNivelEducacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivelEducacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        dateNacimiento.setText("");

        // Restablecer ComboBoxes a la primera opción ("Seleccionar...")
        cboGenero.setSelectedIndex(0);
        cboEstadoCivil.setSelectedIndex(0);
        cboNivelEducacion.setSelectedIndex(0);

        txtNombre.requestFocus();
    }
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Habitante recolectarDatos(){
        String nombre = txtNombre.getText().trim();
        String paterno = txtPaterno.getText().trim();
        String materno = txtMaterno.getText().trim();
        String txtNacimiento = dateNacimiento.getText();
        
        //Convertir fecha de nacimiento
        Date fecha_nac = null;
        try {
            fecha_nac = dateFormat.parse(txtNacimiento);
        } catch (ParseException e) {
            System.err.println("Error: " + e);
        }
        
        // ComboBoxes (asumiendo que cboGenero, cboEstadoCivil, cboNivelEducacion existen)
        String genero = cboGenero.getSelectedItem().toString();
        String estadoCivil = cboEstadoCivil.getSelectedItem().toString();
        String nivelEducacion = cboNivelEducacion.getSelectedItem().toString();

        // 2. CREAR EL OBJETO MODELO
        Habitante nuevoHabitante = new Habitante();
        nuevoHabitante.setNombre(nombre);
        nuevoHabitante.setPaterno(paterno);
        nuevoHabitante.setMaterno(materno);
        nuevoHabitante.setFechaNacimiento(fecha_nac);
        nuevoHabitante.setGenero(genero);
        nuevoHabitante.setEstadoCivil(estadoCivil);
        nuevoHabitante.setNivelEducacion(nivelEducacion);
        
        return nuevoHabitante;
    }
    
    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Habitante nuevoHabitante = recolectarDatos(); // Recoge los datos de la UI

        try {
            boolean exito = controlador.registrarHabitante(nuevoHabitante);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Habitante registrado correctamente.");
                limpiarCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboEstadoCivil;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JComboBox<String> cboNivelEducacion;
    private javax.swing.JFormattedTextField dateNacimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCodigoHabitante;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFechaNaciiento;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblHabitantesTitulo;
    private javax.swing.JLabel lblMaterno;
    private javax.swing.JLabel lblNivelEducacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPaterno;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JTextPane txtCodigoHabitante;
    private javax.swing.JTextPane txtMaterno;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextPane txtPaterno;
    // End of variables declaration//GEN-END:variables
}
