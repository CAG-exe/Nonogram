package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Task {
	

	private List<String> tareasTotales; //Junta ambas task, la primera mitad es en horizontal, la segunda mitad es en vertical
	private List<String> tasksHorizontal;
	private List<String> tasksVertical;
	private int tamanio;
	
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
		this.tamanio = tamanio;
		if (tamanio <= 0) {
			throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor a 0");
		}
		
		tasksHorizontal.addAll(generarTasksFila(mat, tamanio, true));
		tareasTotales.addAll(tasksHorizontal);  // Horizontal
		 
		tasksVertical.addAll(generarTasksFila(mat, tamanio, false)); // Vertical
		tareasTotales.addAll(tasksVertical);
		
		return tareasTotales;
	}
	
	private List<String> generarTasksFila(Matriz mat, int tamanio, boolean esHorizontal){
		ArrayList<String> tasks = new ArrayList<String>();
		
		for(int fila = 0; fila<tamanio; fila++) {
			
			String tarea = "";
			int contador = 0;
			
			for(int columna = 0 ; columna<tamanio; columna++) {
				
				boolean valor;
				if (esHorizontal) {
	                   valor = mat.consultarMatriz(fila, columna);
	               } else {
	                   valor = mat.consultarMatriz(columna, fila);
	               }
				
				if(valor) { // Si es true (negro) entonces suma el contador.
					contador++;
				}else {
					if (contador > 0) { //Cuando llega a una casilla blanca entonces suma a la task acumulado.
		                if (tarea.length() > 0) tarea+= " ";
		                tarea+= contador;
		            }
					contador = 0;
				}	
			}
			
			if (contador > 0) { //Guarda la ultima acumulacion.
                if (tarea.length() > 0) tarea+= " ";
                tarea+= contador;
            } else {
            	if (tarea.length() == 0)
                tarea+= contador;
            }
			tasks.add(tarea); //Añade el String al task. 
		}
		return tasks;
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
