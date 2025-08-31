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

import Controlador.Controlador;
import Negocio.Nonograma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NanogramWindow extends JPanel {

	private static JButton[][] casillas;
	private int tamanio = 5;
	private JPanel panelPrincipal;
	private JPanel panelNanograma;
	private NanogramGrilla NanogramaGrilla;
	private JButton comprobarButton;
	private JButton volverButton;
	private JButton pista;



	public NanogramWindow(int tamanio) {
		this.tamanio = tamanio;
		initialize(tamanio);
		Controlador.InstanciarNonograma(tamanio);
		NanogramaGrilla = new NanogramGrilla(tamanio, panelNanograma);
	}


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
				if(Controlador.verificarIgualdad()) {
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
		
		pista = new JButton("PISTA");
		pista.setBounds(600, 600, 150, 39);
		pista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] pista = Controlador.pedirPista();
				if(pista.length>1)
					darPista(pista);
			}

			private void darPista(int[] pista) {
				if(pista.length ==2) {
					casillas[pista[0]][pista[1]].setBackground(Color.BLACK);}
			}
		});
		panel.add(pista);
		
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
		Controlador.marcarCasilla(row, col);
	}


	public static void darCasillas(JButton[][] casillas2) {
		casillas = casillas2;
		
	}
	

}
