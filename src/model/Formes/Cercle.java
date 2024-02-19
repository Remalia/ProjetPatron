package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

import static java.lang.Math.abs;

public class Cercle extends Forme{

	/***
	 * Permet de créer un cercle
	 * @param color la couleur du cercle
	 * @param pts les deux points du cercles (centre/rayon)
	 */
	public Cercle(Color color,List<Coord> pts) {
		super(color,pts);
	}

	/***
	 * Permet de récupérer le rayon du cercle
	 * @return la taille du rayon du cercle
	 */
	public float getRayon() {
		float distX = abs(this.getPoints().get(0).getX()-this.getPoints().get(1).getX());
		float distY = abs(this.getPoints().get(0).getY()-this.getPoints().get(1).getY());
		return distY+distX;
	}
}
