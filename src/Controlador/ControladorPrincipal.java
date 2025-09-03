package Controlador;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Negocio.CalculadoraDeTamanios;
import Negocio.Nonograma;
import Visual.Interfaz;
import Visual.Menu;
import Visual.NonogramWindow;
import Visual.Tutorial;

public class ControladorPrincipal {
	private static  Nonograma gameModel;
	private Interfaz interfaz;
	private Menu menuPanel;
	private Tutorial tutorialPanel;
	private NonogramWindow juegoVentana;
	private CalculadoraDeTamanios calculadoraDeTamanios;
	private boolean solucionComprobada = false;
	
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
		return gameModel.verificarIgualdad();
	}
	
	public static void marcarCasilla(int row, int col) {
		gameModel.marcarCasilla(row, col);
	}
	
	public static int[] pedirPista() {

		return gameModel.DarPista();
		}

	public static int cantidadPista() {
		return gameModel.getPista();
	}


	public ImageIcon obtenerImageicon() {
		return gameModel.ImageIcon();
	}

	public Rectangle tamanioVentanaPrincipal() {
		return gameModel.tamanioVentanaPrincipalModelo();
	}

	public void mostrarMenu() {
		this.menuPanel = new Menu(this);
		interfaz.cambiarDePanel(menuPanel);
		interfaz.setSize(gameModel.tamanioVentanaPrincipalModelo());
		interfaz.setTitle("Nonograma-Menu");
		solucionComprobada = false;
	}
	
	public void mostrarTutorial() {
		this.tutorialPanel = new Tutorial(this);
		interfaz.cambiarDePanel(tutorialPanel);
		interfaz.setSize(gameModel.tamanioVentanaPrincipalModelo());
		interfaz.setTitle("Nonograma-Tutorial");
	}
	
	public void mostrarJuego(int tamanio) {
		gameModel.inicarNonogramaSegunTamanio(tamanio);
		this.calculadoraDeTamanios = gameModel.obtenerCalculadoraDeTamanios();
		interfaz.setSize(gameModel.calcularTamañoDeVentanaDeJuego());
		this.juegoVentana =  new NonogramWindow(tamanio,this);
		interfaz.cambiarDePanel(juegoVentana);
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
	
	public Dimension[] obtenerTamaniosDeLosPanelesDeLaGrilla() {
		return calculadoraDeTamanios.obtenerTamaniosDeLosPanalesDeLaGrilla();
	}

	public void comprobarResultadoDelJugador() {
		juegoVentana.comprobarButton.setVisible(false);
		solucionComprobada = true;
		if(verificarRespuestaCorrecta()) {
			juegoVentana.reproducirSonidoVictoria();
			juegoVentana.mostrarMensajeDeVictoria(new Rectangle(), "Ganaste");
		} else {
			juegoVentana.reproducirSonidoDerrota();
			juegoVentana.mostrarMensajeDeDerrota(new Rectangle(), "Perdiste");
		}
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
			}
		}
	}
	
}
