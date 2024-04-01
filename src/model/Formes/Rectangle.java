package ProjetPatron.src.model.Formes;

import ProjetPatron.src.vue.Formes.CercleVue;
import ProjetPatron.src.vue.Formes.FormeVue;
import ProjetPatron.src.vue.Formes.RectangleVue;

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
	 * @param pts la liste des 2 points de coordonées de rectangle
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 */
	public Rectangle(Color color,List<Coord> pts, boolean locked) {
		super(color,pts,locked);
		calcLongeurLargeur();
	}

	/***
	 * Permet de récupérer le chemin de l'image du rectangle
	 * @return le chemin de l'image du rectangle
	 */
	@Override
	public String getPathImg() {
		return "assets/images/jeu/rectangle.png";
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
	 * Permet de créer le rectangle
	 * @return le rectangle
	 */
	@Override
	public FormeVue createFormeVue() {
		if(this.getFv() == null)
			this.setFv(new RectangleVue(this));
		return this.getFv();
	}

}
