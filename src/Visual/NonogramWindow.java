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

import Controlador.ControladorPrincipal;
import Negocio.Nonograma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
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
	private int tamanio;
	private JPanel panelPrincipal;
	private JPanel panelNonograma;
	public NonogramGrilla NonogramaGrilla;
	public JButton comprobarButton;
	public JButton volverButton;
	public static JButton pista;
	public JButton solucionBoton;
	public JButton volverButton2;
	private static ControladorPrincipal controladorPrincipal;



	public NonogramWindow(int tamanio, ControladorPrincipal controladorPrincipal) {
		this.tamanio = tamanio;
		this.controladorPrincipal = controladorPrincipal;
		initialize();
		NonogramaGrilla = new NonogramGrilla(tamanio, panelNonograma, controladorPrincipal);
	}
	
	public void reproducirSonidoVictoria() {
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
	public void reproducirSonidoDerrota() {
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


	private void initialize() {

		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		this.panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(new Color(137, 108, 108));
		
		
		//-------------------BOTON COMPROBAR-------------------
		comprobarButton = new JButton("Comprobar");
		comprobarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.comprobarResultadoDelJugador();
				controladorPrincipal.terminarJuego();
			}
		});
		panel.add(comprobarButton);
		
		
		
		//------------BOTON VOLVER-------------------------
		volverButton = new JButton("Volver al Menú");
		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.mostrarMenu();
			}
		});
		panel.add(volverButton);
		
		//------------BOTON VOLVER EN EL JUEGO-------------------------
		volverButton2 = new JButton("Volver al Menú");
		volverButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.mostrarDialogoDeConfirmacionDeSalida();
			}
		});
		panel.add(volverButton2);
		
		
		//----------------BOTON DE PISTA-------------------------
		pista = new JButton("PISTA");
		pista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ControladorPrincipal.cantidadPista();		

			}
		});
		
		panel.add(pista);
		
		
		
		/////-------------------------BOTON DE SOLUCION-----------------------
		solucionBoton = new JButton("Ver solución");
		solucionBoton.setVisible(false);
		solucionBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorPrincipal.mostrarVentanaDeSolucion();
			}
		});
		panel.add(solucionBoton);
		
		
		
		
		JPanel panelNanograma = new JPanel(new GridBagLayout());
		this.panelNonograma = panelNanograma;
		cambioDeTamanioBounds();
		panel.add(panelNanograma);
		panelNanograma.setLayout(new GridLayout(5, 5, 0, 0));
		panelNanograma.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
	}

	private void cambioDeTamanioBounds() {
		this.panelNonograma.setBounds(controladorPrincipal.obtenerTamanioDeGrillaDelJuego());
		comprobarButton.setBounds(controladorPrincipal.obtenerDimensionDeBotonComprobar());
		volverButton2.setBounds(controladorPrincipal.obtenerDimensionDeBotonVolver());
		pista.setBounds(controladorPrincipal.obtenerDimensionDeBotonPista());
		solucionBoton.setBounds(controladorPrincipal.obtenerDimensionDeBotonSolucion());
	}
	

	public static void sendInfo(int row, int col) {
		ControladorPrincipal.marcarCasilla(row, col);
	}


	public static void darCasillas(JButton[][] casillas2) {
		casillas = casillas2;
		
	}

	public void mostrarMensajeDeVictoria(Rectangle posicionYTamaño, String Mensaje) {
		JLabel MensajeFinal=new JLabel("");
		MensajeFinal.setText("FELICIDADES GANASTE");
		MensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeFinal.setBounds(457, 410, 200, 39);
		panelPrincipal.add(MensajeFinal);
		MensajeFinal.setVisible(true);
	}
	
	public void mostrarMensajeDeDerrota(Rectangle posicionYTamaño, String Mensaje) {
		JLabel MensajeFinal=new JLabel("");
		MensajeFinal.setText("PERDISTE");
		MensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeFinal.setBounds(474, 410, 106, 39);
		panelPrincipal.add(MensajeFinal);
		MensajeFinal.setVisible(true);
	}

	public static void renombrarBotonPista(String string) {
		pista.setText(string);	
	}

	public static void ModificarCasillaConPista(int[] pista) {
		casillas[pista[0]][pista[1]].setBackground(Color.BLACK);	
	}

	public static void invalidarBotonPista() {
		pista.setEnabled(false);
		
	}
	
	public static boolean botonesGrillaHabilitados() {
		return controladorPrincipal.juegoAndando();
	}
	
}
