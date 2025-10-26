package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.DAO.LocalidadDAO;
import modelo.DAO.TipoViviendaDAO;
import modelo.Localidad;
import modelo.TipoVivienda;
import modelo.Usuario;
import controlador.ViviendaControlador;
import modelo.Vivienda;

public class gestionVivienda extends javax.swing.JFrame {
    //AUXILIARES DE MAPEO
    private ArrayList<Localidad> listaLocalidades;
    private ArrayList<TipoVivienda> listaTiposVivienda;
    //VARIABLES DE INSTANCIA
    private LocalidadDAO localidadDAO = new LocalidadDAO();
    private int idLocalidadSeleccionada = -1;
    private int idMunicipioSeleccionado = -1;
    private TipoViviendaDAO tipoViviendaDAO = new TipoViviendaDAO();
    private int idTipoViviendaSeleccionado = -1;
     private final ViviendaControlador controlador = new ViviendaControlador();
    private final Usuario usuarioSesion;
    
    //CONSTRUCTOR
    public gestionVivienda(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        cargarLocalidades();
        cargarTiposVivienda();
    }
    
    private int parseIntSafely(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return -1; // -1 indica campo vacío.
        }
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return 0; // 0 o cualquier valor inválido.
        }
    }

    private void cargarLocalidades() {
        try {
            cboLocalidad.removeAllItems();
            cboLocalidad.addItem("Seleccione una Localidad");

            listaLocalidades = localidadDAO.obtenerTodos();

            for (Localidad l : listaLocalidades) {
                cboLocalidad.addItem(l.toString());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar localidades: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarTiposVivienda() {
        try {
            cboTipoVivienda.removeAllItems();
            cboTipoVivienda.addItem("Seleccione Tipo");

            listaTiposVivienda = tipoViviendaDAO.obtenerTodos();
            for (TipoVivienda tv : listaTiposVivienda) {
                cboTipoVivienda.addItem(tv.toString()); 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar Tipos de Vivienda.", "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblViviendasTitulo = new javax.swing.JLabel();
        lblCodigoVivienda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigoVivienda = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCalle = new javax.swing.JTextPane();
        lblCalle = new javax.swing.JLabel();
        lblNumeroExterior = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNumeroExterior = new javax.swing.JTextPane();
        lblColonia = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtColonia = new javax.swing.JTextPane();
        cboAgua = new javax.swing.JComboBox<>();
        lblAgua = new javax.swing.JLabel();
        lblCuartos = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCuartos = new javax.swing.JTextPane();
        cboLuz = new javax.swing.JComboBox<>();
        lblLuz = new javax.swing.JLabel();
        cboGas = new javax.swing.JComboBox<>();
        lblGas = new javax.swing.JLabel();
        cboTipoVivienda = new javax.swing.JComboBox<>();
        lblTipoVivienda = new javax.swing.JLabel();
        cboLocalidad = new javax.swing.JComboBox<>();
        lblLocalidad = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblViviendasTitulo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblViviendasTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViviendasTitulo.setText("GESTIÓN DE VIVIENDAS");

        lblCodigoVivienda.setText("CodigoVivienda:");

        jScrollPane1.setViewportView(txtCodigoVivienda);

        jScrollPane2.setViewportView(txtCalle);

        lblCalle.setText("Calle:");

        lblNumeroExterior.setText("Número Exterior:");

        jScrollPane3.setViewportView(txtNumeroExterior);

        lblColonia.setText("Colonia:");

        jScrollPane4.setViewportView(txtColonia);

        cboAgua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));

        lblAgua.setText("Tiene Agua?");

        lblCuartos.setText("Cantidad de cuartos:");

        jScrollPane5.setViewportView(txtCuartos);

        cboLuz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));

        lblLuz.setText("Tiene Luz?");

        cboGas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));

        lblGas.setText("Tiene Gas?");

        cboTipoVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoViviendaActionPerformed(evt);
            }
        });

        lblTipoVivienda.setText("Tipo de vivienda:");

        cboLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocalidadActionPerformed(evt);
            }
        });

        lblLocalidad.setText("Localidad:");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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
            .addComponent(lblViviendasTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblLocalidad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTipoVivienda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboTipoVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblGas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboGas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCuartos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNumeroExterior)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCodigoVivienda)
                                .addComponent(lblCalle))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblLuz)
                                .addComponent(lblColonia)
                                .addComponent(lblAgua))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboLuz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboAgua, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblViviendasTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigoVivienda)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroExterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColonia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuartos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLuz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLuz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoVivienda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalidad))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed

    private void cboTipoViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoViviendaActionPerformed
        String descripcionSeleccionada = (String) cboTipoVivienda.getSelectedItem();
        
        if (descripcionSeleccionada != null && !descripcionSeleccionada.equals("Seleccione Tipo")) {
            for (TipoVivienda tv : listaTiposVivienda) {
                if (tv.toString().equals(descripcionSeleccionada)) {
                    this.idTipoViviendaSeleccionado = tv.getId();
                    return;
                }
            }
        }
        this.idTipoViviendaSeleccionado = -1;
    }//GEN-LAST:event_cboTipoViviendaActionPerformed

    private void cboLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocalidadActionPerformed
        String descripcionSeleccionada = (String) cboLocalidad.getSelectedItem();
        
        if (descripcionSeleccionada != null && !descripcionSeleccionada.equals("Seleccione una Localidad")) {
            for (Localidad l : listaLocalidades) {
                if (l.toString().equals(descripcionSeleccionada)) {
                    this.idLocalidadSeleccionada = l.getId();
                    this.idMunicipioSeleccionado = l.getIdMunicipio();
                    return;
                }
            }
        }
        this.idLocalidadSeleccionada = -1;
        this.idMunicipioSeleccionado = -1;
    }//GEN-LAST:event_cboLocalidadActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Vivienda nuevaVivienda = new Vivienda();
        
        int codigoVivienda = parseIntSafely(txtCodigoVivienda.getText());
        int cuartos = parseIntSafely(txtCuartos.getText());
        int numeroExterior = parseIntSafely(txtNumeroExterior.getText());
        String tieneAgua = (String) cboAgua.getSelectedItem();
        String tieneLuz = (String) cboLuz.getSelectedItem();
        String tieneGas = (String) cboGas.getSelectedItem();
        
        if (codigoVivienda <= 0 || cuartos <= 0 || numeroExterior <= 0) {
            JOptionPane.showMessageDialog(this, "Asegúrese de que todos los campos numéricos (Código, Cuartos, Número Exterior) contengan valores enteros válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (this.idLocalidadSeleccionada == -1 || this.idMunicipioSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Localidad y un Tipo de Vivienda válidos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.idTipoViviendaSeleccionado == -1) {
             JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Vivienda válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
        try {
            nuevaVivienda.setCodigoVivienda(codigoVivienda);
            nuevaVivienda.setCalle(txtCalle.getText());
            nuevaVivienda.setNumeroExterior(numeroExterior);
            nuevaVivienda.setColonia(txtColonia.getText());
            nuevaVivienda.setCuartos(cuartos);
            nuevaVivienda.setTieneAgua(tieneAgua);
            nuevaVivienda.setTieneLuz(tieneLuz);
            nuevaVivienda.setTieneGas(tieneGas);

            // ** CLAVES FORÁNEAS ** (Obtenidas de los ActionListeners de los ComboBoxes)
            nuevaVivienda.setIdLocalidad(this.idLocalidadSeleccionada); 
            nuevaVivienda.setIdTipoVivienda(this.idTipoViviendaSeleccionado);
            nuevaVivienda.setIdMunicipio(this.idMunicipioSeleccionado);

        } catch (Exception e) {
            // Este catch solo ocurriría si hubiera un error grave en la asignación,
            // la validación se hace principalmente en el Controller.
            JOptionPane.showMessageDialog(this, "Error de formato de datos. Verifique campos numéricos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            boolean exito = controlador.registrarVivienda(nuevaVivienda);

            if (exito) {
                // El objeto nuevaVivienda ahora contiene la ID autogenerada por la BD (nuevaVivienda.getIdVivienda())
                JOptionPane.showMessageDialog(this, "Vivienda registrada con éxito. ID asignada: " + nuevaVivienda.getIdVivienda(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Lógica para limpiar la interfaz o pasar a la siguiente vista
                // ...
            } else {
                JOptionPane.showMessageDialog(this, "La vivienda no fue registrada. Intente de nuevo.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            // Captura las excepciones de validación (Controller) o SQL (DAO)
            JOptionPane.showMessageDialog(this, "Error al registrar la vivienda: \n" + e.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboAgua;
    private javax.swing.JComboBox<String> cboGas;
    private javax.swing.JComboBox<String> cboLocalidad;
    private javax.swing.JComboBox<String> cboLuz;
    private javax.swing.JComboBox<String> cboTipoVivienda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblAgua;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCodigoVivienda;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblCuartos;
    private javax.swing.JLabel lblGas;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblLuz;
    private javax.swing.JLabel lblNumeroExterior;
    private javax.swing.JLabel lblTipoVivienda;
    private javax.swing.JLabel lblViviendasTitulo;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JTextPane txtCalle;
    private javax.swing.JTextPane txtCodigoVivienda;
    private javax.swing.JTextPane txtColonia;
    private javax.swing.JTextPane txtCuartos;
    private javax.swing.JTextPane txtNumeroExterior;
    // End of variables declaration//GEN-END:variables
}
