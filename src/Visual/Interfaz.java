package Visual;

import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Controlador.ControladorPrincipal;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Interfaz extends JFrame{

	private static JFrame frame;
	private JPanel tutorial;
	private ControladorPrincipal ControladorPrincipal;
	private static JPanel juego;
	private static Rectangle tamanioVentana;
	
	public Interfaz(ControladorPrincipal controlador) {
		this.ControladorPrincipal = controlador;
	}
	
	public void iniciar() {
		frame = new JFrame("Nonograma-Menu");
		this.tamanioVentana = ControladorPrincipal.tamanioVentanaPrincipal();
		setSize(tamanioVentana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
	}
	
	
	public void setTitle(String titulo) {
		frame.setTitle(titulo);
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
