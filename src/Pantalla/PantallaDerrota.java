package Pantalla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Principal.PanelJuego;
/**
 * @author Blanca Erdieta 
 */
public class PantallaDerrota implements Pantalla{
	
	/** PANEL DE JUEGO **/
	PanelJuego panelJuego;
	/** TEXTO INICIO **/
	Color colorLetra = Color.WHITE;
	Font fuente = new Font("", Font.BOLD, 60);
	String puntuacion;
	
	public PantallaDerrota(PanelJuego panelJuego, String puntuacion) {
		this.puntuacion = puntuacion;
		inicializarPantalla(panelJuego);
	}

	@Override
	public void inicializarPantalla(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
		
	}

	@Override
	public void pintarPantalla(Graphics g) {
		g.setColor(new Color(92, 140, 189));
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		g.setFont(fuente);
		g.setColor(colorLetra);
		g.drawString("NO HAY MÁS MOVIMIENTOS", panelJuego.getWidth() / 2-50, panelJuego.getHeight() / 2 - 10);
		g.setFont(new Font("", Font.BOLD, 20));
		g.setColor(colorLetra);
		g.drawString(puntuacion, 110,panelJuego.getHeight()-150);
		
	
		
	}

	@Override
	public void ejecutarFrame() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void pulsarTecla(KeyEvent e) {
		panelJuego.setPantallaEjecucion(new PantallaInicio(panelJuego));;
		
		
		
	}


}
