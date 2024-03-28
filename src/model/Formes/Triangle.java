package ProjetPatron.src.model.Formes;

import ProjetPatron.src.vue.Formes.CercleVue;
import ProjetPatron.src.vue.Formes.FormeVue;
import ProjetPatron.src.vue.Formes.RectangleVue;
import ProjetPatron.src.vue.Formes.TriangleVue;

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
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 */
	public Triangle(Color color, List<Coord> points,boolean locked) {
		super(color, points,locked);
	}

	@Override
	public String getPathImg() {
		return "assets/images/jeu/triangle.png";
	}


	@Override
	public FormeVue createForme() {
		return new TriangleVue(this);
	}

}