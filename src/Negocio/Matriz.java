package Negocio;

import java.util.List;
import java.util.Random;

public class Matriz {
	
	public Boolean[][] matriz;
	
	public Matriz(int tamanio) {
		if (tamanio <= 0) {
			throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor a 0");
		}
		matriz = new Boolean[tamanio][tamanio];
		LLenarDeCeros();
	}
	
	private void LLenarDeCeros() {
		for (int fila = 0; fila < matriz.length; fila++) {
		    for (int columna = 0; columna < matriz[0].length; columna++) {
		    	matriz[fila][columna]= false;
		    }
		}
	}

	public void marcarCasilla(int fila, int columna) {
		Boolean valor = matriz[fila][columna];
		if(valor) {
			MarcarCasilla(fila,columna);
		}
		DesmarcarCasilla(fila,columna);
	}
	
	
	// las casillas desmarcadas en la matriz se muestran con un "0":Claudio
	private void DesmarcarCasilla(int fila, int columna) {
		matriz[fila][columna]=false;
	}
	
	// las casillas Rellenas en la matriz se muestran con un "0":Claudio
	private void MarcarCasilla(int fila,int columna){
		matriz[fila][columna]= true;
	}
	
	// las marca con exis en la matriz se muestran con un "2":Claudio
//	
//	private void MarcarConEquis(int fila, int columna) {
//		matriz[fila][columna]=2;
//	}
	

	public void generarMatrizSolucion() {
		double random;
		for(int fila = 0; fila<longitud(); fila++) {
			for (int columna = 0; columna<longitud(); columna++) {
				random = Math.random();
				if(random >0.5) {
					matriz[fila][columna] = true;
				}
			}
			
		}
	}
	
	public void generarSolucionPredefinida() {
		
	}
	
	public int longitud() {
		return matriz.length;
	}
	
    //necesita se testeada
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matriz other = (Matriz) obj;
		boolean sonIguales = true;
		for (int fila = 0; fila < longitud(); fila++) {
		    for (int columna = 0; columna < matriz[0].length; columna++) {
		    	sonIguales &= other.consultarMatriz(fila, columna) == (consultarMatriz(fila, columna));
		    }
		    
		}
		return sonIguales;
	}

	public int consultarTamanio() {
		return matriz.length;
	}

	public boolean consultarMatriz(int i, int f) {
		try{
			return matriz[i][f];
		} catch (Exception e) {
			throw new IllegalArgumentException("Los parametros son invalidos.");
		}
	}
	

}
