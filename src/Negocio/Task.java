package Negocio;

import java.util.ArrayList;
import java.util.List;


public class Task {

	private List<String> tareasTotales; //Junta ambas task, la primera mitad es en horizontal, la segunda mitad es en vertical
	private List<String> tasksHorizontal;
	private List<String> tasksVertical;
	
	public Task(Matriz mat,int tamanio) {
		tareasTotales = new ArrayList<String>(); 
		tasksHorizontal = new ArrayList<String>(); 
		tasksVertical = new ArrayList<String>(); 
		generarTasks(mat,tamanio);
	}
	
	
	private List<String> generarTasks(Matriz mat, int tamanio){
		if (mat == null) {
			throw new IllegalArgumentException("La matriz no puede ser null");
		}
		if (tamanio <= 0) {
			throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor a 0");
		}
		
		tasksHorizontal.addAll(generarTasksFila(mat, tamanio, true));
		tareasTotales.addAll(tasksHorizontal);  // Horizontal
		 
		tasksVertical.addAll(generarTasksFila(mat, tamanio, false)); // Vertical
		tareasTotales.addAll(tasksVertical);
		
		return tareasTotales;
	}
	

	private List<String> generarTasksFila(Matriz mat, int tamanio, boolean esHorizontal) {
	    List<String> tasks = new ArrayList<>();
	    
	    for (int fila = 0; fila < tamanio; fila++) {
	        String tarea = construirTareaParaFila(mat, tamanio, fila, esHorizontal);
	        tasks.add(tarea);
	    }
	    
	    return tasks;
	}
	
	private String construirTareaParaFila(Matriz mat, int tamanio, int fila, boolean esHorizontal) {
	    List<Integer> secuenciasNegras = new ArrayList<>();
	    int contadorActual = 0;
	    
	    for (int columna = 0; columna < tamanio; columna++) {
	        boolean esNegro = esHorizontal(mat, esHorizontal, fila, columna);
	        
	        if (esNegro) {
	            contadorActual++;
	        } 
	        else {
	            if (contadorActual > 0) {
	                secuenciasNegras.add(contadorActual);
	                contadorActual = 0;
	            }
	        }
	    }
	    
	    // Agregar la última secuencia si existe
	    if (contadorActual > 0) {
	        secuenciasNegras.add(contadorActual);
	    }
	    
	    return formatearSecuencias(secuenciasNegras);
	}
	
	private String formatearSecuencias(List<Integer> secuencias) {
	    if (secuencias.isEmpty()) {
	        return "0";
	    }
	    
	    StringBuilder resultado = new StringBuilder();
	    for (int i = 0; i < secuencias.size(); i++) {
	        if (i > 0) {
	            resultado.append(" ");
	        }
	        resultado.append(secuencias.get(i));
	    }
	    
	    return resultado.toString();
	}
	

	private boolean esHorizontal(Matriz mat, boolean esHorizontal, int fila, int columna) {
		boolean valor;
		if (esHorizontal) {
		       valor = mat.consultarMatriz(fila, columna);
		   } else {
		       valor = mat.consultarMatriz(columna, fila);
		   }
		return valor;
	}
	
	// Muestra los valores e las pistas para mostrar a la izquierda
	public String[] getPistasFilas() {
	    return tasksHorizontal.toArray(new String[0]);
	}

	// Obtiene los valores de las pistas para mostrar arriba 
	public String[] getPistasColumnas() {
	    return tasksVertical.toArray(new String[0]);
	}

	
	public boolean comprobarIgualdad(Task otroTask) {
		return otroTask.tareasTotales.equals(tareasTotales);
	}
	
	public List<String> obtenerTasksHorizontales(){
		return this.tasksHorizontal;
	}
	
	public List<String> obtenerTasksVerticales(){
		return this.tasksVertical;
	}
	
	public List<String> obtenerTodosLosTasks(){
		return tareasTotales;
	}
	
}
