package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

import static java.lang.Math.abs;

/***
 * Permet la création et la gestion de Cercle
 */
public class Cercle extends Forme{

	/***
	 * Permet de créer un cercle
	 * @param color la couleur du cercle
	 * @param pts les deux points du cercles (centre/rayon)
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 */
	public Cercle(Color color,List<Coord> pts,boolean locked) {
		super(color,pts,locked);
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

	public void setRayon(){
		//TODO set le rayon depuis le centre vers le points autre
	}
}
