package Visual;

import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPrincipal;
import Negocio.Nonograma;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class NonogramWindow extends JPanel {

	private static JButton[][] casillas;
	private JPanel panelPrincipal;
	private JPanel panelNonograma;
	public NonogramGrilla NonogramaGrilla;
	public JButton comprobarButton;
	public JButton volverButton;
	public static JButton pista;
	public JButton solucionBoton;
	public JButton volverButton2;
	private static ControladorPrincipal controladorPrincipal;
	private Clip currentClip;
    private JLabel tiempo;



	public NonogramWindow(Nonograma modelo, ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		initialize();
		NonogramaGrilla = new NonogramGrilla(modelo, panelNonograma, controladorPrincipal);
	}

	
	public void reproducirSonidoVictoria() {
		try {
			InputStream sonido = Class.class.getResourceAsStream("/media/sound_victory.wav");
		    if (sonido == null) {
		        System.out.println("No se pudo encontrar el archivo");
		        return;
		    }
		    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonido);
			currentClip = AudioSystem.getClip();
			currentClip.open(audioInputStream);
			currentClip.start();
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
			currentClip = AudioSystem.getClip();
			currentClip.open(audioInputStream);
			currentClip.start();
		}
		catch (Exception e) {
		    System.out.println(e);
		}	
	}
	public void detenerSonido() {
		if (currentClip != null && currentClip.isRunning()) {
			currentClip.stop();
			currentClip.close();
			currentClip = null;
		}
	}


	private void initialize() {

		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		this.panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBackground(new Color(137, 108, 108));
		
		//-------------------TIEMPO-------------------
		
		tiempo = new JLabel("00:00");
		tiempo.setFont(new Font("Tahoma", Font.BOLD, 19));
		tiempo.setForeground(new Color(0, 0, 0));
		panel.add(tiempo);
		
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
				detenerSonido();
				controladorPrincipal.mostrarDialogoDeConfirmacionDeSalida();
			}
		});
		panel.add(volverButton2);
		
		
		//----------------BOTON DE PISTA-------------------------
		int cantidadPistasInicial = controladorPrincipal.obtenerCantidadPistasDisponibles();
		pista = new JButton("PISTA (" + cantidadPistasInicial + ")");
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
		
	}

	private void cambioDeTamanioBounds() {
		this.panelNonograma.setBounds(controladorPrincipal.obtenerTamanioDeGrillaDelJuego());
		comprobarButton.setBounds(controladorPrincipal.obtenerDimensionDeBotonComprobar());
		volverButton2.setBounds(controladorPrincipal.obtenerDimensionDeBotonVolver());
		pista.setBounds(controladorPrincipal.obtenerDimensionDeBotonPista());
		solucionBoton.setBounds(controladorPrincipal.obtenerDimensionDeBotonSolucion());
		tiempo.setBounds(controladorPrincipal.obtenerDimensionDeTimer());
	}
	
	public void actualizarTemporizador(String tiempoFormateado) {
		if (tiempo != null) {
			tiempo.setText(tiempoFormateado);
		}
	}

	public static void sendInfoDesmarcarCasilla(int row, int col) {
		ControladorPrincipal.desmarcarCasilla(row, col);
	}
	
	
	public static void sendInfoMarcarCasilla(int row, int col) {
		ControladorPrincipal.marcarCasilla(row, col);
	}


	public static void darCasillas(JButton[][] casillas2) {
		casillas = casillas2;
		
	}

	public void mostrarMensajeDeVictoria(Rectangle posicionYTamaño, String Mensaje, String nombreJugador) {
		JLabel MensajeFinal=new JLabel("");
		MensajeFinal.setText("¡" + nombreJugador.toUpperCase() + " GANASTE!");
		MensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeFinal.setBounds(posicionYTamaño);
		panelPrincipal.add(MensajeFinal);
		MensajeFinal.setVisible(true);
	}
	
	public void mostrarMensajeDeDerrota(Rectangle posicionYTamaño, String Mensaje, String nombreJugador) {
		JLabel MensajeFinal=new JLabel("");
		MensajeFinal.setText(nombreJugador.toUpperCase() + " PERDISTE");
		MensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		MensajeFinal.setBounds(posicionYTamaño);
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
