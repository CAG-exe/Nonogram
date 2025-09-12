package Negocio;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.ImageIcon;

import Visual.CalculadoraDeTamanios;

public class Nonograma {
	
	private Matriz matrizSolucion;
	private Matriz matrizJuego;
	private Task tasksSolucion; 
	private Task tasksMatrizDelJugador;
	private int tamanio;
	private int pista;
	private CalculadoraDeTamanios CalculadoraDeTamanios;
	private boolean JuegoAndando;
	
	public Nonograma() {
	}
	
	public void inicarNonogramaSegunTamanio(int tamanio) {
		this.tamanio = tamanio;
		this.pista = setPista(tamanio);
		matrizJuego = new Matriz(tamanio);
		matrizSolucion = new Matriz(tamanio);
		generarMatrizSolucion();
		CalculadoraDeTamanios = new CalculadoraDeTamanios(tamanio);
		pista=setPista(tamanio);
		JuegoAndando=true;
	}
	

	//le pide a la clase matriz que marque la matriz juego
	public void marcarCasilla(int fila, int columna) {
		matrizJuego.marcarCasilla(fila, columna);
	}
	
	public void desmarcarCasilla(int fila, int columna) {
		matrizJuego.desmarcarCasilla(fila, columna);
	}

	// le pide a la clase matriz que genere una solucion
	public void generarMatrizSolucion(){
		boolean matrizNoSatisfactoria = true;
		while(matrizNoSatisfactoria){
			matrizSolucion.generarMatrizSolucion();
			tasksSolucion = new Task(matrizSolucion, tamanio);
			boolean tiene_algun_lleno_o_cero = false;
			for(String task : tasksSolucion.obtenerTodosLosTasks()) {
				if(task.contains(""+ tamanio) || task.contains("0")) {
					tiene_algun_lleno_o_cero |= true;
				} else {
					tiene_algun_lleno_o_cero |= false;
				}
			}
			if(!tiene_algun_lleno_o_cero) {
				matrizNoSatisfactoria = false;
			}
			
		}
	}

	public Task TaksDeMatrizSolucion() {
		if(tasksSolucion.equals(null)) {
			tasksSolucion = new Task(matrizSolucion,tamanio);
		}
		return tasksSolucion;
	}
	
	public boolean comprobarSolucionDelJugador() {
		Task tasksMatrizDelJugador = new Task(matrizJuego,5);
		return tasksSolucion.comprobarIgualdad(tasksMatrizDelJugador);
	}
	
	// le pide a la clase matriz que verifique la igualdad de matrices
	public boolean verificarIgualdad() {
			return matrizSolucion.equals(getMatrizJuego());	
	}

	private Matriz getMatrizJuego() {
		return matrizJuego;
	}
	
	public Boolean[][] getMatrizSolucion() {
		return matrizSolucion.matriz;
	}

	public void generarMatrizSolucionPredefinida() {
		matrizSolucion.generarSolucionPredefinida();
	}
	
	public int[] DarPista() {
		int buscarCasilla=20;
		while(buscarCasilla>1) {
			int fila = generarNumeroEntreFilas();
			HashSet<Integer> filasVisitadas=new HashSet<Integer>();
			if(!filasVisitadas.contains(fila)) {
				ArrayList<Integer> columnaSolucion = (ArrayList<Integer>) matrizSolucion.conseguirMarcada(fila);
				int columnaEncontrada = matrizJuego.conserguirNoMarcadaDe(columnaSolucion,fila);
				if(columnaEncontrada != -1) {
					restaPista();
					return new int[]{fila,columnaEncontrada};
				}
				filasVisitadas.add(fila);
				}
			buscarCasilla--;
			}
		return new int[] {-1};
	}
	
	private void restaPista() {
		pista=pista-1;
	}

	private int generarNumeroEntreFilas() {
		return (int)(Math.random()*matrizJuego.longitud());
	}

	private int setPista(int size) {
		if(size==5)
			return 3;
		else if(size==10)
			return 5;
		else if(size == 15)
			return 7;
		else 
			return 10;
	}

	public int getPista() {
		return pista;
	}
	

	public ImageIcon ImageIcon() {
		return new ImageIcon(getClass().getResource("/media/icon.png"));
	}
	
	
	public Rectangle tamanioVentanaPrincipalModelo() {
		return new Rectangle(560, 200,800, 640);
	}

	public javax.swing.ImageIcon obtenerImagenTutorial() {
		return new ImageIcon(getClass().getResource("/media/ayuda.png"));
	}

	public Rectangle calcularTamañoDeVentanaDeJuego() {
		return CalculadoraDeTamanios.obtenerTamanioDeVentanaDeJuego();
	}

	public CalculadoraDeTamanios obtenerCalculadoraDeTamanios() {
		return CalculadoraDeTamanios;
	}
	
	public void terminarJuego() {
		JuegoAndando=false;
	}

	public boolean isJuegoAndando() {
		return JuegoAndando;
	}
	
	public List<String> obtenerTasksHorizontales(){
		return tasksSolucion.obtenerTasksHorizontales();
	}

	public List<String> obtenerTasksVerticales(){
		return tasksSolucion.obtenerTasksVerticales();
	}
	
	public int obtenerTamanio() {
		return tamanio;
	}
}
