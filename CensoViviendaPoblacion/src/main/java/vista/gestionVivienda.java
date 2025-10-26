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
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblViviendasTitulo.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        lblViviendasTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViviendasTitulo.setText("GESTIÓN DE VIVIENDAS");

        lblCodigoVivienda.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblCodigoVivienda.setText("CodigoVivienda:");

        jScrollPane1.setViewportView(txtCodigoVivienda);

        jScrollPane2.setViewportView(txtCalle);

        lblCalle.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblCalle.setText("Calle:");

        lblNumeroExterior.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblNumeroExterior.setText("Número Exterior:");

        jScrollPane3.setViewportView(txtNumeroExterior);

        lblColonia.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblColonia.setText("Colonia:");

        jScrollPane4.setViewportView(txtColonia);

        cboAgua.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboAgua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));

        lblAgua.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblAgua.setText("Tiene Agua?");

        lblCuartos.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblCuartos.setText("Cantidad de cuartos:");

        jScrollPane5.setViewportView(txtCuartos);

        cboLuz.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboLuz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));

        lblLuz.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblLuz.setText("Tiene Luz?");

        cboGas.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboGas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Si", "No" }));

        lblGas.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblGas.setText("Tiene Gas?");

        cboTipoVivienda.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboTipoVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoViviendaActionPerformed(evt);
            }
        });

        lblTipoVivienda.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblTipoVivienda.setText("Tipo de vivienda:");

        cboLocalidad.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        cboLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocalidadActionPerformed(evt);
            }
        });

        lblLocalidad.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblLocalidad.setText("Localidad:");

        btnRegistrar.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLocalidad, 0, 158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblTipoVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoVivienda, 0, 158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lblGas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGas, 0, 158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCuartos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblNumeroExterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCodigoVivienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(lblCalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblLuz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblColonia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblAgua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLuz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboAgua, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                .addGap(157, 157, 157))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(97, 97, 97))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
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
            boolean exito = controlador.actualizarVivienda(nuevaVivienda);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Vivienda actualizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
 
            } else {
                JOptionPane.showMessageDialog(this, "La vivienda no fue actualizada. Intente de nuevo.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la vivienda: \n" + e.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int codigoAEliminar = parseIntSafely(txtCodigoVivienda.getText());
        
        if (codigoAEliminar <= 0) {
            JOptionPane.showMessageDialog(this, 
                    "Debe ingresar el Código de la Vivienda a eliminar.", 
                    "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar la Vivienda con Código: " + codigoAEliminar + "?\n"
          + "ADVERTENCIA: Si esta vivienda tiene habitantes registrados, la operación fallará.", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // 3. LLAMADA AL CONTROLADOR
            try {
                // Se llama al controlador, que a su vez llama al DAO (usando codigoVivienda en el WHERE)
                boolean exito = controlador.eliminarVivienda(codigoAEliminar);

                if (exito) {
                    JOptionPane.showMessageDialog(this, 
                            "Vivienda con Código " + codigoAEliminar + " eliminada con éxito.", 
                            "Éxito", JOptionPane.INFORMATION_MESSAGE); 
                } else {
                    JOptionPane.showMessageDialog(this, 
                            "La vivienda con ese código no fue encontrada o no se pudo eliminar (revisa si tiene habitantes).", 
                            "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                        "Error al intentar eliminar la vivienda: \n" + e.getMessage(), 
                        "Error Crítico", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
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
