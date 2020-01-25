package Pantalla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Principal.ControlJuego;
import Principal.PanelJuego;
import Principal.Sprite;

/**
 * @author Blanca Erdieta
 */

public class PantallaJuego implements Pantalla {
	private final static int bordeTablero = 8;
	private static final int lado = 90;

	/** SPRITES **/
	Image imagenCuadrado;
	Sprite[][] cuadrados;
	boolean movimiento;

	/** FONDO **/
	Color colorFondo = new Color(92, 140, 189);
	Color colorLetra = Color.WHITE;
	Font fuente = new Font("", Font.BOLD, 40);
	String Spuntuacion;

	/** POSICIONES **/
	int posXTablero;
	int posYTablero;
	int[] posXCeldas;
	int[] posYCeldas;
	int[] posicion;
	/** PANEL JUEGO **/
	PanelJuego panelJuego;

	/** LOGICA **/
	ControlJuego controlJuego;

	public PantallaJuego(PanelJuego panelJuego) {
		inicializarPantalla(panelJuego);
	}

	@Override
	public void inicializarPantalla(PanelJuego panel) {
		this.panelJuego = panel;
		cuadrados = new Sprite[4][4];
		controlJuego = new ControlJuego();
		movimiento = true;
		// PUNTUACION
		Spuntuacion = "Puntuacion: " + controlJuego.getPuntuacion();
		

		// POSICIONES
		posicion = new int[2];
		posXTablero = panelJuego.getWidth() - 475;
		posYTablero = panelJuego.getHeight() - 475;
		// celdas
		posXCeldas = new int[4];
		posYCeldas = new int[4];
		posXCeldas[0] = posXTablero + bordeTablero;
		posYCeldas[0] = posYTablero + bordeTablero;
		for (int i = 1; i < 4; i++) {
			posXCeldas[i] = posXCeldas[i - 1] + lado + bordeTablero;
			posYCeldas[i] = posYCeldas[i - 1] + lado + bordeTablero;

		}

		// INICIO DE JUEGO
		for (int i = 0; i < controlJuego.getTablero().length; i++) {
			for (int j = 0; j < controlJuego.getTablero().length; j++) {
				cuadrados[i][j] = new Sprite();

			}
		}
		posicion = controlJuego.nuevoCuadrado();
		Sprite aux = new Sprite(posXCeldas[posicion[0]], posYCeldas[posicion[1]], lado, 0, 0,
				controlJuego.getTablero()[posicion[0]][posicion[1]]);
		cuadrados[posicion[0]][posicion[1]] = aux;

	}

	@Override
	public void pintarPantalla(Graphics g) {
		rellenarFondo(g);
		crearTablero(g);

		for (int i = 0; i < cuadrados.length; i++) {
			for (int j = 0; j < cuadrados.length; j++) {
				cuadrados[i][j].pintarEnMundo(g);
			}

		}

	}

	private void crearTablero(Graphics g) {

		g.setColor(new Color(125, 89, 48));
		g.fillRect(posXTablero, posYTablero, 400, 400);
		// celdas
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				g.setColor(new Color(154, 112, 65));
				g.fillRect(posXCeldas[i], posYCeldas[j], lado, lado);

			}

		}
	}

	private void rellenarFondo(Graphics g) {
		g.setColor(colorFondo);
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		g.setFont(fuente);
		g.setColor(colorLetra);
		g.drawString(Spuntuacion, panelJuego.getWidth() / 2 - 50, 100);

	}

	@Override
	public void ejecutarFrame() {
		// PUNTUACION
		Spuntuacion = "Puntuacion: " + controlJuego.getPuntuacion();
		
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//comprobamos si ganamos o perdemos
		if (controlJuego.posibleMovimiento()==false) {
			panelJuego.setPantallaEjecucion(new PantallaDerrota(panelJuego,Spuntuacion));
		}
		for (int i = 0; i < controlJuego.getTablero().length; i++) {
			for (int j = 0; j < controlJuego.getTablero().length; j++) {
				if (controlJuego.getTablero()[i][j]==2048) {
					panelJuego.setPantallaEjecucion(new PantallaVictoria(panelJuego,Spuntuacion));
					
				}
			}
		}

	}

	public void moverSprite() {

		for (int i = 0; i < controlJuego.getTablero().length; i++) {
			
			for (int j = 0; j < controlJuego.getTablero().length; j++) {
				
				if (controlJuego.getTablero()[i][j] > 0) {

					cuadrados[i][j] = new Sprite(posXCeldas[i], posYCeldas[j], lado, 0, 0,
							controlJuego.getTablero()[i][j]);
				} else {
					cuadrados[i][j] = new Sprite();
				}

			}
		}

	}

	@Override
	public void pulsarTecla(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: {
			controlJuego.moverArriba();
			if (controlJuego.getMovimiento()[2]) {
				posicion = controlJuego.nuevoCuadrado();
			}
			
				
			
			break;
		}
		case KeyEvent.VK_LEFT: {
			controlJuego.moverIzquierda();
			if (controlJuego.getMovimiento()[0]) {
				posicion = controlJuego.nuevoCuadrado();
			}
			break;
		}
		case KeyEvent.VK_RIGHT: {
			controlJuego.moverDerecha();
			if (controlJuego.getMovimiento()[1]) {
				posicion = controlJuego.nuevoCuadrado();
			}
			break;
		}
		case KeyEvent.VK_DOWN: {
			controlJuego.moverAbajo();
			if (controlJuego.getMovimiento()[3]) {
				posicion = controlJuego.nuevoCuadrado();
			}
			break;
		}
		default: {
			break;
		}
		}
		
		Sprite aux = new Sprite(posXCeldas[posicion[0]], posYCeldas[posicion[1]], lado, 0, 0,
				controlJuego.getTablero()[posicion[0]][posicion[1]]);
		cuadrados[posicion[0]][posicion[1]] = aux;
		moverSprite();
		// controlJuego.depurar();
	}

}
