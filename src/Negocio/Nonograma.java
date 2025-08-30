package Negocio;

import java.util.List;

public class Nonograma {
	
	private Matriz matrizSolucion;
	private Matriz matrizJuego;
	private Task tasksSolucion; 
	private Task tasksMatrizDelJugador;
	private int tamanio = 5; 
	
	public Nonograma(int size) {
		matrizJuego =new Matriz(size);
		matrizSolucion =new Matriz(size); 
	}

	//le pide a la clase matriz que marque la matriz juego
	public void marcarCasilla(int fila, int columna) {
		matrizJuego.marcarCasilla(fila, columna);
	}

	// le pide a la clase matriz que genere una solucion
	public void generarMatrizSolucion(){
		matrizSolucion.generarMatrizSolucion();
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

	public void generarMatrizSolucionPredefinida() {
		matrizSolucion.generarSolucionPredefinida();
		
	}

}

