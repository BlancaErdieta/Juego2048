package Pantalla;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Principal.PanelJuego;

/**
 * @author Blanca Erdieta
 */

public interface Pantalla {
	
	public void inicializarPantalla(PanelJuego panel);
	public void pintarPantalla(Graphics g);
	public void ejecutarFrame();
	
	//Listeners
	public void pulsarTecla(KeyEvent e);
}
