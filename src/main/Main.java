package main;

import javax.swing.UIManager;

import Controlador.ControladorPrincipal;
import Negocio.Nonograma;
import Visual.Interfaz;

public class Main {
	public static void main(String[] args) {
        // Configura el Look and Feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
  
        
        Nonograma gameModel = new Nonograma();
        ControladorPrincipal ControladorPrincipal = new ControladorPrincipal();
        Interfaz interfazPrincipal = new Interfaz(ControladorPrincipal);
        ControladorPrincipal.setModeloYVista(interfazPrincipal, gameModel);
        ControladorPrincipal.iniciar();
	}
	

}

