package Controlador;

import javax.swing.UIManager;

import Negocio.Nonograma;
import Visual.Interfaz;

public class Controlador {
	private static Nonograma game;
	
	public static void main(String[] args) {	
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		 } catch(Exception e){
	            System.out.println(e);
	        }
		Interfaz interfaz=new Interfaz();
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);
		
		}
	
	public static void InstanciarNonograma(int tamanio) {
		game=new Nonograma(tamanio);
		game.generarMatrizSolucionPredefinida();
	}
	
	public static boolean verificarIgualdad() {
		return game.verificarIgualdad();
	}
	
	public static void marcarCasilla(int row, int col) {
		game.marcarCasilla(row, col);
	}
	
	public static int[] pedirPista() {
		return game.DarPista();
		}
	}
