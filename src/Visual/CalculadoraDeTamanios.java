package Visual;

import java.awt.Dimension;
import java.awt.Rectangle;

public class CalculadoraDeTamanios {
	public int tamanio;
	private Rectangle TamanioDeVentanaDeJuego;
	private Rectangle TamanioDeGrillaDelJuego;
	private Dimension[] TamaniosDePanelesDeLaGrilla;
	private Rectangle dimencionesDeBotonComprobar;
	private Rectangle dimencionesDeBotonVolver;
	private Rectangle dimencionesDeBotonPista;
	private Rectangle dimencionesDeBotonSolucion;
	
	
	public CalculadoraDeTamanios(int tamanio) {
		this.tamanio = tamanio;
		calcularTamanios();
	}

	private void calcularTamanios() {
		TamaniosDePanelesDeLaGrilla = new Dimension[3];
		switch (tamanio) {
			case 5:
				TamanioDeVentanaDeJuego = new Rectangle(600, 200,626, 600);
				TamanioDeGrillaDelJuego = new Rectangle(180, 100,250, 250);
				TamaniosDePanelesDeLaGrilla[0] = new Dimension(200, 50);
				TamaniosDePanelesDeLaGrilla[1] = new Dimension(50, 200);
				TamaniosDePanelesDeLaGrilla[2] = new Dimension(200, 200);
				dimencionesDeBotonComprobar = new Rectangle(450, 410, 150, 39);
				dimencionesDeBotonVolver = new Rectangle(30, 410, 150, 39);
				dimencionesDeBotonPista = new Rectangle(240, 410, 150, 39);
				dimencionesDeBotonSolucion = new Rectangle(240, 460, 150, 39);
				break;
			case 10:
				TamanioDeVentanaDeJuego = new Rectangle(600, 200,626, 600);
				TamanioDeGrillaDelJuego = new Rectangle(120, 70, 350, 350);
				TamaniosDePanelesDeLaGrilla[0] = new  Dimension(280, 70);
				TamaniosDePanelesDeLaGrilla[1] = new Dimension(70, 280);
				TamaniosDePanelesDeLaGrilla[2] = new Dimension(280, 280);
				dimencionesDeBotonComprobar = new Rectangle(430, 460, 150, 39);
				dimencionesDeBotonVolver = new Rectangle(20, 460, 150, 39);
				dimencionesDeBotonPista = new Rectangle(225, 460, 150, 39);
				dimencionesDeBotonSolucion = new Rectangle(225, 510, 150, 39);
				break;
			case 15:
				TamanioDeVentanaDeJuego = new Rectangle(530, 130, 826, 800);
				TamanioDeGrillaDelJuego = new Rectangle(140, 80, 500, 500);
				TamaniosDePanelesDeLaGrilla[0] = new  Dimension(420, 90);
				TamaniosDePanelesDeLaGrilla[1] = new Dimension(90, 420);
				TamaniosDePanelesDeLaGrilla[2] = new Dimension(420, 420);
				dimencionesDeBotonComprobar = new Rectangle(620, 610, 150, 39);
				dimencionesDeBotonVolver = new Rectangle(40, 610, 150, 39);
				dimencionesDeBotonPista = new Rectangle(325, 610, 150, 39);
				dimencionesDeBotonSolucion = new Rectangle(325, 660, 150, 39);
				break;
			case 20:
				TamanioDeVentanaDeJuego = new Rectangle(530, 130, 826, 800);
				TamanioDeGrillaDelJuego = new Rectangle(140, 80, 550, 550);
				TamaniosDePanelesDeLaGrilla[0] = new  Dimension(420, 130);
				TamaniosDePanelesDeLaGrilla[1] = new Dimension(130, 420);
				TamaniosDePanelesDeLaGrilla[2] = new Dimension(420, 420);
				dimencionesDeBotonComprobar = new Rectangle(650, 660, 150, 39);
				dimencionesDeBotonVolver = new Rectangle(40, 660, 150, 39);
				dimencionesDeBotonPista = new Rectangle(335, 660, 150, 39);
				dimencionesDeBotonSolucion = new Rectangle(335, 710, 150, 39);
				break;
		}
		
	}

	public Rectangle obtenerTamanioDeVentanaDeJuego() {
		return TamanioDeVentanaDeJuego;
	}

	public Rectangle obtenerTamanioDeGrilla() {
		return TamanioDeGrillaDelJuego;
	}

	public Rectangle obtenerDimensionDeBotonComprobar() {
		return dimencionesDeBotonComprobar;
	}
	
	public Rectangle obtenerDimensionDeBotonVolver() {
		return dimencionesDeBotonVolver;
	}
	
	public Rectangle obtenerDimensionDeBotonPista() {
		return dimencionesDeBotonPista;
	}
	
	public Rectangle obtenerDimensionDeBotonSolucion() {
		return dimencionesDeBotonSolucion;
	}
	
	public Dimension[] obtenerTamaniosDeLosPanalesDeLaGrilla() {
		return TamaniosDePanelesDeLaGrilla;
	}
	
	
	
}
