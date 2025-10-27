package utils;

import javax.swing.*;
import java.awt.event.*;
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
                    Inicio.cerrarAplicacion(usuarioSesion);
                }
            }
        });
    }
}
