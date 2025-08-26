package Negocio;

import java.util.List;

public class Nonograma {
	
	private Matriz matrizSolucion;
	private Matriz matrizJuego;
	private Task Tasks; 
	
	public Nonograma() {  // constructor basico que solo crea matrzices 5x5 : Claudio
		matrizJuego = new Matriz(5);
		matrizSolucion =new Matriz(5); 
	}
	
	//Despues podemos sobrecargar el constructor para más matrices 
	
	
	//le pide a la clase matriz que marque la matriz juego
	public void marcarCasilla(int fila, int columna) {
		matrizSolucion.marcarCasilla(fila, columna);
	}
	

	// le pide a la clase matriz que genere una solucion
	public void generarMatrizSolucion(){
		matrizSolucion.generarMatrizSolucion();
	} 
	// le pide a la clase matriz que verifique la igualdad de matrices
	public boolean verificarIgualdad(int[][] matrizSolucion) {
			return matrizSolucion.equals(matrizJuego);	
	}

}

