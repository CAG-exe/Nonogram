package Negocio;


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

	public boolean estaMarcada(int casillaAprueba, int tamanio) {
		int[] filaYCol=convertirDeIntAFilaColumna(casillaAprueba,tamanio);
		return matriz[filaYCol[0]][filaYCol[1]];
	}

	public static int[] convertirDeIntAFilaColumna(int casillaAprueba, int tamanio) {
		int[] convetirCasilla= new int[2];
		convetirCasilla[0] = casillaAprueba/tamanio;
		convetirCasilla[1] = casillaAprueba%tamanio;
		return convetirCasilla;
	}

	
}
