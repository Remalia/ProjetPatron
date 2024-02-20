package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

/***
 * Classe de création d'un triangle
 */
public class Triangle extends Forme {

	/***
	 * Constructeur de triangle
	 * @param color La couleur du triangle
	 * @param points Les coordonées des points du triangle
	 */
	public Triangle(Color color, List<Coord> points) {
		super(color, points);
	}
	
}