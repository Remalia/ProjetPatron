package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

/***
 * Permet la création et la gestion de rectangle
 */
public class Rectangle extends Forme{

	private float longeur;
	private float largeur;

	/***
	 * Constructeur de rectangle
	 * @param color la couleur du rectangle
	 * @param pts la liste des 4 points de coordonées de rectangle
	 */
	public Rectangle(Color color,List<Coord> pts) {
		super(color,pts);
		calcLongeurLargeur();
	}

	/***
	 * Permet de calculer la longeur et la largeur du rectangle et de l'assigner
	 */
	public void calcLongeurLargeur(){
		//TODO calculer en fonction des pts
	}

	/***
	 * Permet de récupérer la longeur du rectangle
	 * @return la longeur du rectangle
	 */
	public float getLongeur() {
		return longeur;
	}

	/***
	 * Permet de récupérer la largeur du rectangle
	 * @return la largeur du rectangle
	 */
	public float getLargeur() {
		return largeur;
	}


	/***
	 * Permet de changer la position d'un point mais aussi de réassigner son proche pour garder la forme de rectangle
	 * @param point le point en question
	 * @param x sa nouvelle position x
	 * @param y sa nouvelle position y
	 */
	@Override
	public void changePoint(Coord point, float x, float y) {
		//TODO si on change un point changer celui non aligné en plus
	}
}
