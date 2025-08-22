package Negocio;

public class Matriz {
	
	private int[][] matriz;
	
	public Matriz() {
		matriz = new int[5][5];
		LLenarDeCeros();
	}
	
	private void LLenarDeCeros() {
		for (int fila = 0; fila < matriz.length; fila++) {
		    for (int columna = 0; columna < matriz[0].length; columna++) {
		    	matriz[fila][columna]=0;
		    }
		}
	}

	public void marcarCasilla(int fila, int columna) {
		int valorC = matriz[fila][columna];
		if(valorC==2) {
			DesmarcarCasilla(fila,columna);
		}
		else if(valorC==1){
			MarcarConExis(fila,columna);
		}
		RellenarConNegroCasilla(fila,columna);
	}
	
	
	// las casillas desmarcadas en la matriz se muestran con un "0":Claudio
	private void DesmarcarCasilla(int fila, int columna) {
		matriz[fila][columna]=0;
	}
	
	// las casillas Rellenas en la matriz se muestran con un "0":Claudio
	private void RellenarConNegroCasilla(int fila,int columna){
		matriz[fila][columna]=1;
	}
	
	// las marca con exis en la matriz se muestran con un "2":Claudio
	
	private void MarcarConExis(int fila, int columna) {
		matriz[fila][columna]=2;
	}
	

	public void generarMatrizSolucion() {
		
		
	}
	
	public void generarSolucionPredefinida() {
		
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
		for (int fila = 0; fila < matriz.length; fila++) {
		    for (int columna = 0; columna < matriz[0].length; columna++) {
		    	if(other.matriz[fila][columna] == 2) {
		    		sonIguales =sonIguales && (matriz[fila][columna] == 0);
		    }
		    	else{
		    		sonIguales =sonIguales && (matriz[fila][columna] == other.matriz[fila][columna]);
		    		}
		    	}
		}
		return sonIguales;
	}

}
