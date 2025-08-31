package Visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Negocio.Nonograma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NanogramWindow extends JPanel {

	private JButton[][] casillas;
	private int tamanio = 5;
	private JPanel panelPrincipal;
	private JPanel panelNanograma;
	private JButton comprobarButton;
	private JButton volverButton;
	private static Nonograma Game;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame juegoNonograma = new JFrame("Nonograma");
//					NanogramWindow window = new NanogramWindow(5);
//					juegoNonograma.add(window);
//					juegoNonograma.setBounds(100, 100, 626, 600);
//					juegoNonograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					juegoNonograma.setLocationRelativeTo(null);
//					juegoNonograma.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NanogramWindow(int tamanio) {
		this.tamanio = tamanio;
		initialize(tamanio);
		Game = new Nonograma(tamanio);
		Game.generarMatrizSolucionPredefinida();
		NanogramGrilla nanogramaGrilla = new NanogramGrilla(tamanio, panelNanograma);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int tamanio) {

		setLayout(new BorderLayout());
		JLabel MensajeFinal=new JLabel("");
		MensajeFinal.setText("Hola");
		MensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeFinal.setBounds(404, 430, 106, 39);
		
		JPanel panel = new JPanel();
		this.panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(new Color(137, 108, 108));
		panelPrincipal.add(MensajeFinal);
		MensajeFinal.setVisible(false);
		comprobarButton = new JButton("Comprobar");
		comprobarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.verificarIgualdad()) {
					MensajeFinal.setVisible(true);
					comprobarButton.setVisible(false);
				}
			}
		});
		panel.add(comprobarButton);
		
		volverButton = new JButton("Volver al Menú");
		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz.volverAlMenu();
			}
		});
		panel.add(volverButton);
		
		JPanel panelNanograma = new JPanel(new GridBagLayout());
		this.panelNanograma = panelNanograma;
		cambioDeTmanioBounds(tamanio);
		panel.add(panelNanograma);
		panelNanograma.setLayout(new GridLayout(5, 5, 0, 0));
		panelNanograma.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
	}

	private void cambioDeTmanioBounds(int tamanio) {
		if(tamanio==5) {
			this.panelNanograma.setBounds(180, 100, 250, 250);
			comprobarButton.setBounds(354, 410, 106, 39);
			volverButton.setBounds(90, 410, 150, 39);
		}
		else if(tamanio==10) {
			this.panelNanograma.setBounds(120, 70, 350, 350);
			comprobarButton.setBounds(374, 430, 106, 39);
			volverButton.setBounds(90, 430, 150, 39);
		}
		else if(tamanio==15) {
			this.panelNanograma.setBounds(140, 80, 500, 500);
			comprobarButton.setBounds(504, 610, 106, 39);
			volverButton.setBounds(180, 610, 150, 39);
		}
		else {
			this.panelNanograma.setBounds(140, 80, 550, 550);
			comprobarButton.setBounds(474, 660, 106, 39);
			volverButton.setBounds(170, 660, 150, 39);
			
		}
	}

	public static void sendInfo(int row, int col) {
		Game.marcarCasilla(row, col);
	}
	

}
