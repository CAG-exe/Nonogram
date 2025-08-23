package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Task {

	List<String> tareas;
	
	public Task() {
		List<String> tareas = new ArrayList<String>();
	}
	
	public List<String> generarTasks(Matriz mat){
		int tamanio = mat.consultarTamanio();
		
		 tareas.addAll(generarTasksFila(mat, tamanio, true));  // Horizontal
	     tareas.addAll(generarTasksFila(mat, tamanio, false)); // Vertical
		
		return tareas;
	}
	
	public List<String> generarTasksFila(Matriz mat, int tamanio, boolean esHorizontal){
		ArrayList<String> tasksHorizontal = new ArrayList<String>();
		
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
				
				if(valor == 1) {
					contador++;
				}else {
					if(contador >0 )
						tarea += " " + contador;
					contador = 0;
				}	
			}
			
			if (contador > 0) {
                if (tarea.length() > 0) tarea+= " ";
                tarea+= contador;
            }
			tasksHorizontal.add(tarea);
		}
		return tasksHorizontal;
		
	}
}
