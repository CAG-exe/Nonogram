package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Matriz {
	
public Boolean[][] matriz;
	
	public Matriz(int tamanio) {
		if (tamanio <= 0) {
			throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor a 0");
		}
		matriz = new Boolean[tamanio][tamanio];
		LLenarDeFalse();
	}
	
	private void LLenarDeFalse() {
		for (int fila = 0; fila < matriz.length; fila++) {
		    for (int columna = 0; columna < matriz[0].length; columna++) {
		    	matriz[fila][columna]= false;
		    }
		}
	}

	public void desmarcarCasilla(int fila, int columna) {
		matriz[fila][columna]=false;
	}

	public void marcarCasilla(int fila,int columna){
		matriz[fila][columna]= true;
	}

	public void generarMatrizSolucion() {
		double random;
		for(int fila = 0; fila<longitud(); fila++) {
			for (int columna = 0; columna<longitud(); columna++) {
				random = Math.random();
				if(random >0.5) {
					matriz[fila][columna] = true;
				} else {
					matriz[fila][columna] = false;
				}
			}
			
		}
	}
	
	public void generarSolucionPredefinida() {
		LLenarDeFalse();
		matriz[0][0]=true;
	}
	
	public int longitud() {
		return matriz.length;
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

	public List<Integer> conseguirMarcada(int fila) {
		ArrayList<Integer> columnasMarcadas= new ArrayList<Integer>();
		for(int col=0;col<matriz.length;col++) {
			if(matriz[fila][col]==true) {
				columnasMarcadas.add(col);
			}
		}
		return columnasMarcadas;
	}

	public int conserguirNoMarcadaDe(List<Integer> columnaSolucion, int fila) {
		columnaSolucion = (ArrayList<Integer>) columnaSolucion;
		for(Integer columna : columnaSolucion) {
			if(matriz[fila][columna]==false) {
				matriz[fila][columna] = true;
				return columna;
			}
		}
		return -1;
	}



	
}
