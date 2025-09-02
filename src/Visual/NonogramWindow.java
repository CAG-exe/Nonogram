package Visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.Controlador;
import Negocio.Nonograma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class NonogramWindow extends JPanel {

	private static JButton[][] casillas;
	private int tamanio = 5;
	private JPanel panelPrincipal;
	private JPanel panelNonograma;
	private NonogramGrilla NonogramaGrilla;
	private JButton comprobarButton;
	private JButton volverButton;
	private JButton pista;
	private JButton solucionBoton;
	private boolean pistaUsada = false;
	private JButton volverButton2;



	public NonogramWindow(int tamanio) {
		this.tamanio = tamanio;
		initialize(tamanio);
		Controlador.InstanciarNonograma(tamanio);
		NonogramaGrilla = new NonogramGrilla(tamanio, panelNonograma);
	}
	
	private void reproducirSonidoVictoria() {
		try {
			InputStream sonido = Class.class.getResourceAsStream("/media/sound_victory.wav");
		    if (sonido == null) {
		        System.out.println("No se pudo encontrar el archivo");
		        return;
		    }
		    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonido);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}
		catch (Exception e) {
		    System.out.println(e);
		}	
	}
	private void reproducirSonidoDerrota() {
		try {
			InputStream sonido = Class.class.getResourceAsStream("/media/sound_lost1.wav");
		    if (sonido == null) {
		        System.out.println("No se pudo encontrar el archivo");
		        return;
		    }
		    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonido);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}
		catch (Exception e) {
		    System.out.println(e);
		}	
	}


	private void initialize(int tamanio) {

		setLayout(new BorderLayout());
		JLabel MensajeFinal=new JLabel("");
		MensajeFinal.setText("FELICIDADES GANASTE");
		MensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeFinal.setBounds(404, 430, 106, 39);
		
		JLabel MensajeDerrota=new JLabel("");
		MensajeDerrota.setText("FELICIDADES PERDISTE");
		MensajeDerrota.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeDerrota.setBounds(424, 410, 196, 39);
		
		JPanel panel = new JPanel();
		this.panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(new Color(137, 108, 108));
		panelPrincipal.add(MensajeFinal);
		MensajeFinal.setVisible(false);
		panelPrincipal.add(MensajeDerrota);
		MensajeDerrota.setVisible(false);
		
		
		
		//-------------------BOTON COMPROBAR-------------------
		comprobarButton = new JButton("Comprobar");
		comprobarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pistaUsada = true;
				reproducirSonidoDerrota();
				MensajeDerrota.setVisible(true);
				comprobarButton.setVisible(false);
				if(Controlador.verificarIgualdad()) {
					MensajeFinal.setVisible(true);
					comprobarButton.setVisible(false);
					reproducirSonidoVictoria();
				}
			}
		});
		panel.add(comprobarButton);
		
		
		
		//------------BOTON VOLVER-------------------------
		volverButton = new JButton("Volver al Menú");
		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz.volverAlMenu();
			}
		});
		panel.add(volverButton);
		
		//------------BOTON VOLVER EN EL JUEGO-------------------------
		volverButton2 = new JButton("Volver al Menú");
		volverButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(
					null,
					"¿Estás seguro de que quieres volver? ¡Perderás el progreso actual!",
					"",
					JOptionPane.YES_NO_OPTION
				);

				if (opcion == JOptionPane.YES_OPTION) {
					Interfaz.volverAlMenu();
				}
				// Si selecciona NO, no hace nada y continúa en el juego
			}
		});
		panel.add(volverButton2);
		
		
		//----------------BOTON DE PISTA-------------------------
		pista = new JButton("PISTA");
		pista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cantidadPista = Controlador.cantidadPista();
				if ( cantidadPista >= 1) {
					int[] pista = Controlador.pedirPista();
					if (pista.length > 1) {
						darPista(pista);
						renombrar();
						usable(cantidadPista);
						}
					}
				}
				
			private void usable(int cantidadPista) {
				if(cantidadPista==1){
				pista.setText("PISTA USADAS");
				pista.setEnabled(false);
				}
			}

			private void renombrar() {
				int pistas=Controlador.cantidadPista();
				pista.setText("PISTA ("+pistas+")");
				
			}

			private void darPista(int[] pista) {
				if(pista.length ==2) {
					casillas[pista[0]][pista[1]].setBackground(Color.BLACK);}
			}
		});
		
		panel.add(pista);
		
		
		
		/////-------------------------BOTON DE SOLUCION-----------------------
		solucionBoton = new JButton("Ver solución");
		solucionBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean[][] matriz = new Boolean[5][5];
				Solucion ventanaSolucion = new Solucion(matriz,tamanio,NonogramaGrilla.obtenerPanelTasksVerticales(), NonogramaGrilla.obtenerPanelTasksHorizontales());
				ventanaSolucion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				ventanaSolucion.setVisible(true);
			}
		});
		panel.add(solucionBoton);
		solucionBoton.setVisible(false);
		
		
		
		JPanel panelNanograma = new JPanel(new GridBagLayout());
		this.panelNonograma = panelNanograma;
		cambioDeTmanioBounds(tamanio);
		panel.add(panelNanograma);
		panelNanograma.setLayout(new GridLayout(5, 5, 0, 0));
		panelNanograma.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
	}

	private void cambioDeTmanioBounds(int tamanio) {
		if(tamanio==5) {
			this.panelNonograma.setBounds(180, 100, 250, 250);
			comprobarButton.setBounds(450, 410, 150, 39);
			volverButton2.setBounds(30, 410, 150, 39);
			pista.setBounds(240, 410, 150, 39);
			solucionBoton.setBounds(240, 460, 150, 39);
		}
		else if(tamanio==10) {
			this.panelNonograma.setBounds(120, 70, 350, 350);
			comprobarButton.setBounds(430, 460, 150, 39);
			volverButton2.setBounds(20, 460, 150, 39);
			pista.setBounds(225, 460, 150, 39);
			solucionBoton.setBounds(225, 510, 150, 39);
		}
		else if(tamanio==15) {
			this.panelNonograma.setBounds(140, 80, 500, 500);
			comprobarButton.setBounds(620, 610, 150, 39);
			volverButton2.setBounds(40, 610, 150, 39);
			pista.setBounds(325, 610, 150, 39);
			solucionBoton.setBounds(325, 660, 150, 39);
		}
		else {
			this.panelNonograma.setBounds(140, 80, 550, 550);
			comprobarButton.setBounds(650, 660, 150, 39);
			volverButton2.setBounds(40, 660, 150, 39);
			pista.setBounds(335, 660, 150, 39);
			solucionBoton.setBounds(335, 710, 150, 39);
			
		}
	}
	

	public static void sendInfo(int row, int col) {
		Controlador.marcarCasilla(row, col);
	}


	public static void darCasillas(JButton[][] casillas2) {
		casillas = casillas2;
		
	}
	

}
