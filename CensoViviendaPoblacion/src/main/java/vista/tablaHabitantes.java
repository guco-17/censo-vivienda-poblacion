package vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Habitante;
import modelo.Usuario;
import controlador.HabitanteControlador;
import javax.swing.table.DefaultTableModel;
import modelo.ActividadEconomica;

public class tablaHabitantes extends javax.swing.JFrame {
    private final Usuario usuarioSesion;
    private final HabitanteControlador controlador;
    
    public tablaHabitantes(Usuario usuarioAutenticado) {
        initComponents();
        this.usuarioSesion = usuarioAutenticado;
        this.controlador = new HabitanteControlador();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarTablaHabitantes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String convertirActividadesAString(ArrayList<ActividadEconomica> actividades) {
        if (actividades == null || actividades.isEmpty()) {
            return "N/A";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < actividades.size(); i++) {
            sb.append(actividades.get(i).getDescripcion());
            if (i < actividades.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    private void cargarTablaHabitantes() {
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo); 

        // Definir las columnas
        modelo.addColumn("Código");
        modelo.addColumn("Nombre Completo");
        modelo.addColumn("F. Nacimiento");
        modelo.addColumn("Género");
        modelo.addColumn("Est. Civil");
        modelo.addColumn("Nivel Educ.");
        modelo.addColumn("Vivienda (Calle y Código)");
        modelo.addColumn("Localidad");
        modelo.addColumn("Municipio");
        modelo.addColumn("Actividades Económicas");

        try {
            ArrayList<Habitante> habitantes = controlador.obtenerTodosLosHabitantesConRelaciones();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (Habitante h : habitantes) {
                String nombreCompleto = h.getNombre() + " " + h.getPaterno() + 
                                        (h.getMaterno() != null && !h.getMaterno().isEmpty() ? " " + h.getMaterno() : "");

                String fechaNacimiento = (h.getFechaNacimiento() != null) ? sdf.format(h.getFechaNacimiento()) : "";

                String actividadesStr = convertirActividadesAString(h.getActividadesEconomicas());
                modelo.addRow(new Object[]{
                    h.getCodigoHabitante(),
                    nombreCompleto,
                    fechaNacimiento,
                    h.getGenero(),
                    h.getEstadoCivil(),
                    h.getNivelEducacion(),
                    h.getCalleVivienda(),
                    h.getNombreLocalidad(),
                    h.getNombreMunicipio() ,
                    actividadesStr
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla de habitantes: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInicioActionPerformed
        Inicio inicio = new Inicio(this.usuarioSesion);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemInicio;
    // End of variables declaration//GEN-END:variables
}
