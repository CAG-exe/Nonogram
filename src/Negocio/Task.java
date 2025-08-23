package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Task {

	List<String> tareas;
	
	public Task() {
		tareas = new ArrayList<String>(); //Junta ambas task, la primera mitad es en horizontal, la segunda mitad es en vertical.
	}
	
	public List<String> generarTasks(Matriz mat){
		int tamanio = mat.consultarTamanio();
		
		 tareas.addAll(generarTasksFila(mat, tamanio, true));  // Horizontal
	     tareas.addAll(generarTasksFila(mat, tamanio, false)); // Vertical
		
		return tareas;
	}
	
	public List<String> generarTasksFila(Matriz mat, int tamanio, boolean esHorizontal){
		ArrayList<String> tasks = new ArrayList<String>();
		
		for(int i = 0; i<tamanio; i++) {
			
			String tarea = "";
			int contador = 0;
			
			for(int f = 0 ; f<tamanio; f++) {
				
				int valor;
				if (esHorizontal) {
	                   valor = mat.consultarMatriz(i, f); // Fila i, Columna j
	               } else {
	                   valor = mat.consultarMatriz(f, i); // Columna i, Fila j
	               }
				
				if(valor == 1) { // Si es 1 (negro) entonces suma el contador.
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
            }
			tasks.add(tarea); //Añade el String al task. 
		}
		return tasks;
		
	}
}
