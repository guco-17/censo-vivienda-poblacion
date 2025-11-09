package utils;

import javax.swing.*;
import java.awt.event.*;
import modelo.ConexionDB;
import modelo.Usuario;
import vista.Inicio;

public class CierreSeguro {
    public static void habilitarCierreSeguro(JFrame ventana, Usuario usuarioSesion) {
        ventana.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas cerrar la aplicación?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    cerrarAplicacion(usuarioSesion);
                }
            }
        });
    }
    
    public static void cerrarAplicacion(Usuario usuario) {
        try {
            if (usuario != null) {
                System.out.println("Cerrando sesión del usuario: " + usuario.getNombreUsuario());
                usuario = null;
            }

            if (ConexionDB.getInstance() != null) {
                ConexionDB.getInstance().closeConnection();
                System.out.println("Conexión a base de datos cerrada correctamente.");
            }
            

            JOptionPane.showMessageDialog(null,
                "Sesión cerrada y recursos liberados correctamente.\nSaliendo del sistema...",
                "Cierre seguro",
                JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al cerrar la aplicación: " + e.getMessage(),
                "Error de cierre",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
