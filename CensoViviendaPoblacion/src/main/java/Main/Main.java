package Main;

import modelo.Usuario;
import vista.Login;

public class Main {
    private static Usuario usuarioActual = null;
    
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Login().setVisible(true);
        }
    });
    }
}
