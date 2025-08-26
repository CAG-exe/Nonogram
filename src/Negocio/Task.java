package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Task {

	private List<String> tareas; //Junta ambas task, la primera mitad es en horizontal, la segunda mitad es en vertical
	private List<String> tasksHorizontal;
	private List<String> tasksVertical;
	private int tamanio;
	
	public Task(Matriz mat,int tamanio) {
		tareas = new ArrayList<String>(); 
		tasksHorizontal = new ArrayList<String>(); 
		tasksVertical = new ArrayList<String>(); 
		generarTasks(mat,tamanio);
	}
	
	public List<String> generarTasks(Matriz mat, int tamanio){
		if (mat == null) {
			throw new IllegalArgumentException("La matriz no puede ser null");
		}
		this.tamanio = tamanio;
		if (tamanio <= 0) {
			throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor a 0");
		}
		
		tasksHorizontal.addAll(generarTasksFila(mat, tamanio, true));
		tareas.addAll(tasksHorizontal);  // Horizontal
		 
		tasksVertical.addAll(generarTasksFila(mat, tamanio, false)); // Vertical
		tareas.addAll(tasksVertical);
		
		return tareas;
	}
	
	private List<String> generarTasksFila(Matriz mat, int tamanio, boolean esHorizontal){
		ArrayList<String> tasks = new ArrayList<String>();
		
		for(int i = 0; i<tamanio; i++) {
			
			String tarea = "";
			int contador = 0;
			
			for(int f = 0 ; f<tamanio; f++) {
				
				boolean valor;
				if (esHorizontal) {
	                   valor = mat.consultarMatriz(i, f); // Fila i, Columna j
	               } else {
	                   valor = mat.consultarMatriz(f, i); // Columna i, Fila j
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
	
	public List<String> obtenerTasksHorizontales(){
		return this.tasksHorizontal;
	}
	
	public List<String> obtenerTasksVerticales(){
		return this.tasksVertical;
	}
	
	public List<String> obtenerTodosLosTasks(){
		return tareas;
	}
}
