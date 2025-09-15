package Negocio;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;

import javax.swing.ImageIcon;

public class Nonograma {
	
	private Matriz matrizSolucion;
	private Matriz matrizJuego;
	private Task tasksSolucion; 
	private int tamanio;
	private int pista;
	private boolean JuegoAndando;
	private HashSet<Integer> posicionesVisitadas;
	
	public Nonograma() {
	}
	
	public void inicarNonogramaSegunTamanio(int tamanio) {
		if(tamanio != 5 && tamanio != 10 && tamanio != 15 && tamanio != 20) {
			throw new IllegalArgumentException("El tamaño del nanograma es ilegal. Probar con 5, 10, 15 o 20.");
		}
		posicionesVisitadas = new HashSet<Integer>();
		this.tamanio = tamanio;
		this.pista = setPista(tamanio);
		matrizJuego = new Matriz(tamanio);
		matrizSolucion = new Matriz(tamanio);
		generarMatrizSolucion();
		pista=setPista(tamanio);
		JuegoAndando=true;
	}
	

	//le pide a la clase matriz que marque la matriz juego
	public void marcarCasilla(int fila, int columna) {
		if(fila<0 || fila >= tamanio) {
			throw new IllegalArgumentException("El valor de la fila debe ser entre 0 y " + (tamanio-1) +".");
		}
		
		if(columna<0 || columna >= tamanio) {
			throw new IllegalArgumentException("El valor de la columna debe ser entre 0 y " + (tamanio-1) +".");
		}
		matrizJuego.marcarCasilla(fila, columna);
	}
	
	public void desmarcarCasilla(int fila, int columna) {
		if(fila<0 || fila >= tamanio) {
			throw new IllegalArgumentException("El valor de la fila debe ser entre 0 y " + (tamanio-1) +".");
		}
		
		if(columna<0 || columna >= tamanio) {
			throw new IllegalArgumentException("El valor de la columna debe ser entre 0 y " + (tamanio-1) +".");
		}
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
	
	public void generarMatrizSolucionPredefinida() {
		matrizSolucion.generarSolucionPredefinida();
		tasksSolucion = new Task(matrizSolucion, tamanio);
	}

	public Task TaksDeMatrizSolucion() {
		if(tasksSolucion.equals(null)) {
			tasksSolucion = new Task(matrizSolucion,tamanio);
		}
		return tasksSolucion;
	}
	
	public boolean comprobarSolucionDelJugador() {
		Task tasksMatrizDelJugador = new Task(matrizJuego,tamanio);
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
	
	public boolean consultarValorDeLaCasillaJugador(int i, int f) {
		return matrizJuego.consultarMatriz(i, f);
	}


	public int[] DarPista() {
	    boolean buscandoPista = true;
	    int contar = 0;

	    while (buscandoPista) {
	        int casillaAprueba = BuscarCasilla();
	        int[] filaCol = procesarCasillaSiEsValida(casillaAprueba);

	        if (filaCol != null) {
	            contar++;
	            return filaCol;
	        }

	        contar++;
	        if (contar == 20)
	            buscandoPista = false;
	    }

	    return new int[] {-1};
	}
	
	private int[] procesarCasillaSiEsValida(int casillaAprueba) {
	    if (!posicionesVisitadas.contains(casillaAprueba)) {
	        if (comprobarCasillaEsFuncionan(casillaAprueba)) {
	            restaPista();
	            posicionesVisitadas.add(casillaAprueba);
	            int[] filaCol = Matriz.convertirDeIntAFilaColumna(casillaAprueba, tamanio);
	            matrizJuego.marcarCasilla(filaCol[0], filaCol[1]);
	            return filaCol;
	        }
	        posicionesVisitadas.add(casillaAprueba);
	    }
	    return null;
	}
	
	

	private boolean comprobarCasillaEsFuncionan(int casillaAprueba) {
		return matrizSolucion.estaMarcada(casillaAprueba,tamanio) && !matrizJuego.estaMarcada(casillaAprueba,tamanio)? true: false;
	}

	private int BuscarCasilla() {
		return (int)(Math.random()*Math.pow(tamanio,2));
	}
	
	private void restaPista() {
		pista=pista-1;
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

	public javax.swing.ImageIcon obtenerImagenTutorial() {
		return new ImageIcon(getClass().getResource("/media/ayuda.png"));
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
