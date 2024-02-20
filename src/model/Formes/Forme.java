package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

/***
 * Classe abstraite de forme permettant une gestion hiérarchique de forme
 */
public abstract class Forme {
	
	private Color color;
	private List<Coord> points;

	/***
	 * Constructeur Abstrait permettant de créer une forme
	 * @param color la couleur qu'aura la forme
	 * @param points les points de liaison de la forme
	 */
	protected Forme(Color color,List<Coord> points) {
		this.color = color;
		this.points = points;
	}

	/***
	 * Permet de récupérer la couleur de la forme
	 * @return la couleur de la forme
	 */
	public Color getColor() {
		return color;
	}

	/***
	 * Permet de changer la couleur de la forme
	 * @param color la nouvelle couleur
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/***
	 * Permet de récupérer les points de la forme
	 * @return la liste de points des formes
	 */
	public List<Coord> getPoints() {
		return points;
	}

	/***
	 * Change la liste de points de la forme
	 * @param points la nouvelle liste de points
	 */
	public void setPoints(List<Coord> points) {
		this.points = points;
	}

	/***
	 * Permet de changer la position du point
	 * @param point le point en question
	 * @param x sa nouvelle position x
	 * @param y sa nouvelle position y
	 */
	public void changePoint(Coord point, float x,float y){
		int temp = this.points.indexOf(point);
		if(temp != -1){
			Coord pointList = this.points.get(temp);
			pointList.setX(x);
			pointList.setY(y);
		}
	}
}
