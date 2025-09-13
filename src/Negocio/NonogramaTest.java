package Negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonogramaTest {

	@Test(expected = IllegalArgumentException.class)
	public void IniciarNonogramaConArgumentoIlegalTest () {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(3);
	}
	
	
	@Test
	public void iniciarNonogramaConTamanio5Test() {
		Nonograma game5 = new Nonograma();
		game5.inicarNonogramaSegunTamanio(5);
	}
	
	
	
	@Test
	public void iniciarNonogramaConTamanio10Test() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(10);
	}
	
	
	@Test
	public void iniciarNonogramaConTamanio15Test() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(15);
	}
	
	@Test
	public void iniciarNonogramaConTamanio20Test() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(20);
	}
	
	@Test
	public void MarcarCasillaTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.marcarCasilla(1, 0);
		
		assertTrue(game.consultarValorDeLaCasillaJugador(1, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void MarcarCasillaFueraDeRangoTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.marcarCasilla(6, 0);
	}
	
	@Test
	public void MarcarCasillaCasoBordeTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.marcarCasilla(4, 4);
		
		assertTrue(game.consultarValorDeLaCasillaJugador(4, 4));
	}
	
	
	@Test
	public void DesmarcarCasillaTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.desmarcarCasilla(1, 0);
		
		assertFalse(game.consultarValorDeLaCasillaJugador(1, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void DesmarcarCasillaFueraDeRangoTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.desmarcarCasilla(6, 0);
	}
	
	@Test
	public void DesmarcarCasillaCasoBordeTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.desmarcarCasilla(4, 4);
		
		assertFalse(game.consultarValorDeLaCasillaJugador(4, 4));
	}
	
	
	@Test 
	public void verificarMatrizDelJugadorTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.generarMatrizSolucionPredefinida();
		game.marcarCasilla(0, 0);
		
		assertTrue(game.comprobarSolucionDelJugador());
	}
	
	
	@Test 
	public void verificarMatrizDelJugadorErradaTest() {
		Nonograma game = new Nonograma();
		game.inicarNonogramaSegunTamanio(5);
		
		game.generarMatrizSolucionPredefinida();
		game.marcarCasilla(1, 0);
		
		assertFalse(game.comprobarSolucionDelJugador());
	}
	
}
