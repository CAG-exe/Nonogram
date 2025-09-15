package Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Negocio.Nonograma;
import Visual.CalculadoraDeTamanios;
import Visual.Interfaz;
import Visual.Menu;
import Visual.NonogramWindow;
import Visual.Solucion;
import Visual.TablaBotones;
import Visual.Tutorial;

public class ControladorPrincipal {
	private static Nonograma gameModel;
	private Interfaz interfaz;
	private Menu menuPanel;
	private Tutorial tutorialPanel;
	private NonogramWindow juegoVentana;
	private CalculadoraDeTamanios calculadoraDeTamanios;
	private boolean solucionComprobada = false;
	private Timer tiempo;
	private int tiempoTranscurrido = 0; // tiempo en segundos
	private String nombreJugador;

	public void setModeloYVista(Interfaz interfaz, Nonograma game){
		this.interfaz = interfaz;
		this.gameModel = game;
	}
	
	public void iniciar() {
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);
		interfaz.iniciar();
		mostrarMenu();
	}
	
	public static void InstanciarNonograma(int tamanio) {
		gameModel.inicarNonogramaSegunTamanio(tamanio);
		gameModel.generarMatrizSolucion();
	}
	
	public static boolean verificarRespuestaCorrecta() {
		return gameModel.comprobarSolucionDelJugador();
	}
	
	public static void marcarCasilla(int row, int col) {
		gameModel.marcarCasilla(row, col);
	}
	
	public static void desmarcarCasilla(int row, int col) {
		gameModel.desmarcarCasilla(row, col);
	}
	
	public static int[] pedirPista() {
		return gameModel.DarPista();
		}

	public static void cantidadPista() {
		int cantidadPistas=gameModel.getPista();
		 if (cantidadPistas >= 1 && juegoAndando()==true) {
			 int[] pista = gameModel.DarPista();
			 if(pista.length > 1) {
				usable(cantidadPistas);
				darPista(pista);
			 }
		 }
		 if(cantidadPistas-1==0) {
			NonogramWindow.invalidarBotonPista();
			NonogramWindow.renombrarBotonPista("PISTAS USADAS");
		 }
	}


	private static void darPista(int[] pista) {
		if(pista.length==2)
			NonogramWindow.ModificarCasillaConPista(pista);
	}

	private static void usable(int cantidadPistas) {
		if(cantidadPistas>=1){
			NonogramWindow.renombrarBotonPista("PISTA ("+(cantidadPistas-1)+")");
		}
	}
	public int obtenerCantidadPistasDisponibles() {
		return gameModel.getPista();
	}

	public ImageIcon obtenerImageicon() {
		return gameModel.ImageIcon();
	}


	public void mostrarMenu() {
		this.menuPanel = new Menu(this);
		Interfaz.cambiarDePanel(menuPanel);
		interfaz.setTamanioDeVentanaPrincipalPorDefecto();
		interfaz.setTitle("Nonograma-Menu");
		interfaz.favIcon(obtenerImageicon().getImage());
		solucionComprobada = false;
	}
	
	public void mostrarTutorial() {
		this.tutorialPanel = new Tutorial(this);
		interfaz.cambiarDePanel(tutorialPanel);
		interfaz.setTamanioDeVentanaPrincipalPorDefecto();
		interfaz.setTitle("Nonograma-Tutorial");
	}
	
	public void mostrarJuego(int tamanio, String nombreJugador) {
		this.nombreJugador = nombreJugador;
		gameModel.inicarNonogramaSegunTamanio(tamanio);
		calculadoraDeTamanios = new CalculadoraDeTamanios(tamanio);
		this.juegoVentana =  new NonogramWindow(gameModel,this);
		interfaz.setSize(calculadoraDeTamanios.obtenerTamanioDeVentanaDeJuego());
		interfaz.cambiarDePanel(juegoVentana);
		iniciarTemporizador();
	}
	
	private void iniciarTemporizador() {
		tiempoTranscurrido = 0;
		tiempo = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tiempoTranscurrido++;
				if (juegoVentana != null) {
					juegoVentana.actualizarTemporizador(formatearTiempo(tiempoTranscurrido));
				}
			}
		});
		tiempo.start();
	}
	
	private void detenerTemporizador() {
		if (tiempo != null) {
			tiempo.stop();
		}
	}
	
	private String formatearTiempo(int segundos) {
		int minutos = segundos / 60;
		int segs = segundos % 60;
		return String.format("%02d:%02d", minutos, segs);
	}
	

	public ImageIcon obtenerEjemploTutorial() {
		return gameModel.obtenerImagenTutorial();
	}

	public Rectangle obtenerTamanioDeGrillaDelJuego() {
		return calculadoraDeTamanios.obtenerTamanioDeGrilla();
	}

	public Rectangle obtenerDimensionDeBotonComprobar() {
		return calculadoraDeTamanios.obtenerDimensionDeBotonComprobar();
	}
	
	public Rectangle obtenerDimensionDeBotonVolver() {
		return calculadoraDeTamanios.obtenerDimensionDeBotonVolver();
	}
	
	public Rectangle obtenerDimensionDeBotonPista() {
		return calculadoraDeTamanios.obtenerDimensionDeBotonPista();
	}
	
	public Rectangle obtenerDimensionDeBotonSolucion() {
		return calculadoraDeTamanios.obtenerDimensionDeBotonSolucion();
	}
	
	public Rectangle obtenerDimensionDeTimer() {
		return calculadoraDeTamanios.obtenerDimensionDeTimer();
	}
	
	public Dimension[] obtenerTamaniosDeLosPanelesDeLaGrilla() {
		return calculadoraDeTamanios.obtenerTamaniosDeLosPanalesDeLaGrilla();
	}

	public void comprobarResultadoDelJugador() {
		juegoVentana.comprobarButton.setVisible(false);
		solucionComprobada = true;
		if(verificarRespuestaCorrecta()) {
			juegoVentana.reproducirSonidoVictoria();
			juegoVentana.mostrarMensajeDeVictoria(calculadoraDeTamanios.obtenerDimencionesDelMensajeFinal(), "Ganaste", nombreJugador);
			detenerTemporizador();
		} else {
			juegoVentana.reproducirSonidoDerrota();
			juegoVentana.mostrarMensajeDeDerrota(calculadoraDeTamanios.obtenerDimencionesDelMensajeFinal(), "Perdiste", nombreJugador);
			juegoVentana.solucionBoton.setVisible(true);
			detenerTemporizador();
		}
		mostrarDialogoDeVolverAJugar();
	}
	private void mostrarDialogoDeVolverAJugar() {
		int opcion = JOptionPane.showConfirmDialog(
			null,
			"¿Quieres volver a jugar?",
			"",
			JOptionPane.YES_NO_OPTION
		);
		
		if (opcion == JOptionPane.YES_OPTION) {
			solucionComprobada = false;
			gameModel.terminarJuego();
			int tamanio = gameModel.obtenerTamanio();
			mostrarJuego(tamanio, nombreJugador);
		}
	}
	
	public void mostrarVentanaDeSolucion() {
		interfaz.mostrarVentanaSolucion(gameModel.getMatrizSolucion(),gameModel.obtenerTamanio(),juegoVentana.NonogramaGrilla.obtenerPanelTasksVerticales(), juegoVentana.NonogramaGrilla.obtenerPanelTasksHorizontales());
	}
	

	public void mostrarDialogoDeConfirmacionDeSalida() {
		if (solucionComprobada) {
			mostrarMenu();
		}
		else {
		int opcion = JOptionPane.showConfirmDialog(
				null,
				"¿Estás seguro de que quieres volver? ¡Perderás el progreso actual!",
				"",
				JOptionPane.YES_NO_OPTION
			);

			if (opcion == JOptionPane.YES_OPTION) {
				mostrarMenu();
				detenerTemporizador();
			}
		}
	}
	
	
	public void actualizarEstadoDeLaCasilla(MouseEvent e, int fila, int columna) {
		if (NonogramWindow.botonesGrillaHabilitados()) { 
        	if(e.getButton() == MouseEvent.BUTTON1) {//Click izquierdo
                if (!TablaBotones.esCasillaSeleccionada(fila, columna)) {
                    marcarCasilla(fila,columna);
                    TablaBotones.marcarLaCasillaVisual(fila, columna);
                } else if (TablaBotones.esCasillaSeleccionada(fila, columna)) {
                	desmarcarCasilla(fila,columna);
                	TablaBotones.desmarcarLaCasillaVisual(fila, columna);
                }
        	} 
        	 else if (e.getButton() == MouseEvent.BUTTON3) { //Click derecho
                 if (TablaBotones.esCasillaTachada(fila, columna)) {
                 	desmarcarCasilla(fila,columna);
                 	TablaBotones.desmarcarLaCasillaVisual(fila, columna);
                 } else {
                 	desmarcarCasilla(fila,columna);
                 	TablaBotones.tacharLaCasillaVisual(fila, columna);
                 }
           }
        }
	}
	
	public static boolean juegoAndando() {
		return gameModel.isJuegoAndando();
	}
	
	public List<String> obtenerListaDeTasksHorizontalesDelNonograma(){
		return gameModel.obtenerTasksHorizontales();
	}
	
	public List<String> obtenerListaDeTasksVerticalesDelNonograma(){
		return gameModel.obtenerTasksVerticales();
	}
	
	public void terminarJuego(){
		gameModel.terminarJuego();
	}
	
}
