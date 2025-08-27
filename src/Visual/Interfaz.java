package Visual;

import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Interfaz extends JFrame{

	private static JFrame frame;
	private static JPanel menu;
	private JPanel tutorial;
	private static JPanel juego;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Nonograma-Menu");
        frame.setBounds(100,100,800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        // Creá una instancia del panel del menú
        Menu menu = new Menu(); // Asumiendo que PanelMenu hereda de JPane
        menu.ComoJugarButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frame.getContentPane().removeAll();
        		frame.getContentPane().add(tutorial, BorderLayout.CENTER);
        		frame.revalidate();
        		frame.repaint();
        	}
        });
    
        this.menu = menu;
        JPanel tuto = new Tutorial();
        this.tutorial= tuto;

        // Agregá el panel del menú al ContentPane de la Interfaz
        // Usa BorderLayout.CENTER para que el panel ocupe todo el espacio disponible
        frame.getContentPane().add(this.menu, BorderLayout.CENTER);

        // Hace que la ventana sea visible
        frame.setVisible(true);
	}

	public static void volverAlMenu() {
		try {
			frame.getContentPane().removeAll();
			frame.getContentPane().add(menu, BorderLayout.CENTER);
			frame.revalidate();
			frame.repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void abrirJuego(int tamanio) {
		try {
			juego = new NanogramWindow(tamanio);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(juego, BorderLayout.CENTER);
			frame.revalidate();
			frame.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
