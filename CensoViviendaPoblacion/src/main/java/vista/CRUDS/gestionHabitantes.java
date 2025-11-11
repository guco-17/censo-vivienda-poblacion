package vista.CRUDS;

import controlador.HabitanteControlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Usuario;
import javax.swing.JOptionPane;
import modelo.ActividadEconomica;
import modelo.DAO.ActividadEconomicaDAO;
import modelo.DAO.ViviendaDAO;
import modelo.Habitante;
import modelo.Vivienda;
import vista.Inicio;
import static utils.CierreSeguro.cerrarAplicacion;

public class gestionHabitantes extends javax.swing.JFrame {
    //AUXILIARES DE MAPEO
    private ArrayList<Vivienda> listaViviendas;
    private ArrayList<ActividadEconomica> listaActividades;
    //VARIABLES DE INSTANCIA
    private final Usuario usuarioSesion;
    private final HabitanteControlador controlador;
    private ViviendaDAO viviendaDAO = new ViviendaDAO();
    private int idViviendaSeleccionada = -1;
    private ActividadEconomicaDAO actividadDAO = new ActividadEconomicaDAO();
    
    private final ArrayList<ActividadEconomica> actividadesDelHabitante = new ArrayList<>();
    private int idActividadSeleccionada = -1;
    
    public gestionHabitantes(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        this.controlador = new HabitanteControlador();
        cargarViviendas();
        cargarActividades();
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
        cboVivienda = new javax.swing.JComboBox<>();
        lblNivelEducacion1 = new javax.swing.JLabel();
        lblNivelEducacion2 = new javax.swing.JLabel();
        cboActividad = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblCodigoHabitante.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblCodigoHabitante.setText("Código Habitante:");

        txtCodigoHabitante.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(txtCodigoHabitante);

        cboVivienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboViviendaActionPerformed(evt);
            }
        });

        lblNivelEducacion1.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblNivelEducacion1.setText("Seleccionar Vivienda:");

        lblNivelEducacion2.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        lblNivelEducacion2.setText("Seleccionar Actividad:");

        cboActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActividadActionPerformed(evt);
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

        menuSalir.setText("Cerrar Aplicación");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuSalir.add(jMenuItem3);

        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblCodigoHabitante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lblPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(lblEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(lblNivelEducacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(lblNivelEducacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(lblFechaNaciiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(lblMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNivelEducacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(dateNacimiento)
                            .addComponent(cboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboNivelEducacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboVivienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboActividad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(115, 115, 115))
            .addComponent(lblHabitantesTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivelEducacion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivelEducacion2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtCodigoHabitante.setText("");
        dateNacimiento.setText("");

        cboGenero.setSelectedIndex(0);
        cboEstadoCivil.setSelectedIndex(0);
        cboNivelEducacion.setSelectedIndex(0);
        cboVivienda.setSelectedIndex(0);
        cboActividad.setSelectedIndex(0);

        this.actividadesDelHabitante.clear();

        txtNombre.requestFocus();
    }
    
    private void cargarViviendas() {
        try {
            // Asumiendo que cboVivienda es el JComboBox
            cboVivienda.removeAllItems(); 
            cboVivienda.addItem("Seleccione una Vivienda (Código / Calle)");

            // Obtener la lista de viviendas. Usamos el código de negocio y la calle.
            listaViviendas = viviendaDAO.obtenerTodos();

            for (Vivienda v : listaViviendas) {
                // Muestra el código de vivienda y la calle para que el usuario identifique
                String item = v.getCodigoVivienda() + " - " + v.getCalle() + " " + v.getColonia() + " " + " #" + v.getNumeroExterior();
                cboVivienda.addItem(item);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar viviendas: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarActividades() {
        try {
            cboActividad.removeAllItems();
            cboActividad.addItem("Seleccionar Actividad (Añadir)");

            // Obtener todas las actividades económicas
            listaActividades = actividadDAO.obtenerTodos();

            for (ActividadEconomica ae : listaActividades) {
                cboActividad.addItem(ae.getDescripcion());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar actividades: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Habitante recolectarDatos(){
        int codigoHabitante = Integer.parseInt(txtCodigoHabitante.getText());
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
        
        // ComboBoxes (validación mínima)
        if (cboGenero.getSelectedIndex() == 0 || cboEstadoCivil.getSelectedIndex() == 0 || cboNivelEducacion.getSelectedIndex() == 0 || this.idViviendaSeleccionada <= 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una opción válida para Género, Estado Civil, Nivel de Educación y Vivienda.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        // CORRECCIÓN CLAVE: Validación de actividades
        if (this.actividadesDelHabitante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una actividad económica.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        // ComboBoxes (asumiendo que cboGenero, cboEstadoCivil, cboNivelEducacion existen)
        String genero = cboGenero.getSelectedItem().toString();
        String estadoCivil = cboEstadoCivil.getSelectedItem().toString();
        String nivelEducacion = cboNivelEducacion.getSelectedItem().toString();

        // 2. CREAR EL OBJETO MODELO
        Habitante nuevoHabitante = new Habitante();
        nuevoHabitante.setCodigoHabitante(codigoHabitante);
        nuevoHabitante.setNombre(nombre);
        nuevoHabitante.setPaterno(paterno);
        nuevoHabitante.setMaterno(materno);
        nuevoHabitante.setFechaNacimiento(fecha_nac);
        nuevoHabitante.setGenero(genero);
        nuevoHabitante.setEstadoCivil(estadoCivil);
        nuevoHabitante.setNivelEducacion(nivelEducacion);
        nuevoHabitante.setIdVivienda(this.idViviendaSeleccionada);
        nuevoHabitante.setActividadesEconomicas(this.actividadesDelHabitante);
        
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

    private void cboViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboViviendaActionPerformed
        int indice = cboVivienda.getSelectedIndex();
    
        if (indice > 0) {
            Vivienda viviendaSeleccionada = listaViviendas.get(indice - 1);
            this.idViviendaSeleccionada = viviendaSeleccionada.getIdVivienda();
        } else {
            this.idViviendaSeleccionada = -1;
        }
    }//GEN-LAST:event_cboViviendaActionPerformed

    private void cboActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActividadActionPerformed
        int indice = cboActividad.getSelectedIndex();
        
        // Si hay una actividad seleccionada (índice > 0, ya que 0 es "Seleccionar...")
        if (indice > 0 && listaActividades != null && indice <= listaActividades.size()) {
            ActividadEconomica actividadSeleccionada = listaActividades.get(indice - 1); // -1 para obtener el objeto correcto de la lista de mapeo
            
            // 1. Verificar si ya se añadió para evitar duplicados
            if (!actividadesDelHabitante.contains(actividadSeleccionada)) {
                this.actividadesDelHabitante.add(actividadSeleccionada);
                
                JOptionPane.showMessageDialog(this, 
                        "Actividad '" + actividadSeleccionada.getDescripcion() + "' añadida.\nTotal de actividades seleccionadas: " + actividadesDelHabitante.size(), 
                        "Actividad Añadida", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Esta actividad ya fue seleccionada.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
            }
            
            // Opcional: limpiar la selección del combo después de añadir
            cboActividad.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cboActividadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Habitante habitanteActualizado = recolectarDatos(); 
        if (habitanteActualizado == null) {
            return;
        }

        try {
            if (controlador.actualizarHabitante(habitanteActualizado)) {
                JOptionPane.showMessageDialog(this, "Habitante actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el habitante.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage(), "Error BD/Lógica", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       String codigoHabitanteStr = txtCodigoHabitante.getText().trim();
    
        if (codigoHabitanteStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un habitante ingresando su código.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Conversión segura de String a Int
            int codigoHabitante = Integer.parseInt(codigoHabitanteStr);

            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de eliminar al habitante con código " + codigoHabitante + "?", 
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                if (controlador.eliminarHabitante(codigoHabitante)) {
                    JOptionPane.showMessageDialog(this, "Habitante eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el habitante.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Código de Habitante debe ser un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Error BD/Lógica", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        cerrarAplicacion(usuarioSesion);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboActividad;
    private javax.swing.JComboBox<String> cboEstadoCivil;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JComboBox<String> cboNivelEducacion;
    private javax.swing.JComboBox<String> cboVivienda;
    private javax.swing.JFormattedTextField dateNacimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
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
    private javax.swing.JLabel lblNivelEducacion1;
    private javax.swing.JLabel lblNivelEducacion2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPaterno;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JTextPane txtCodigoHabitante;
    private javax.swing.JTextPane txtMaterno;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextPane txtPaterno;
    // End of variables declaration//GEN-END:variables
}
