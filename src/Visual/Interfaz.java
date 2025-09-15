package Visual;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Rectangle;

import Controlador.ControladorPrincipal;
import Negocio.Nonograma;

import javax.swing.JDialog;

public class Interfaz extends JFrame{

	private static JFrame frame;
	private JPanel tutorial;
	private ControladorPrincipal ControladorPrincipal;
	private static JPanel juego;
	private static Rectangle tamanioVentana;
	
	public Interfaz(ControladorPrincipal controlador, Nonograma modelo) {
		this.ControladorPrincipal = controlador;
	}
	
	public void iniciar() {
		frame = new JFrame("Nonograma-Menu");
		setTamanioDeVentanaPrincipalPorDefecto();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
	}
	
	
	public void setTitle(String titulo) {
		frame.setTitle(titulo);
	}
	
	public void setTamanioDeVentanaPrincipalPorDefecto() {
		setSize(new Rectangle(560, 200,800, 640));
	}
	
	public void mostrarVentanaSolucion(Boolean[][] matriz, int tamanio, JPanel panelTasksVerticales, JPanel panelTasksHorizontales) {
		Solucion ventanaSolucion = new Solucion(matriz,tamanio,panelTasksVerticales, panelTasksHorizontales);
		ventanaSolucion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventanaSolucion.setVisible(true);
	}
	
	public static void cambiarDePanel(JPanel panel) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
	}

	public void setSize(Rectangle Rectangle) {
		frame.setBounds(Rectangle);
	}

	public void favIcon(Image image) {
		frame.setIconImage(image);
	}
}
