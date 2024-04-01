package ProjetPatron.src.model.Formes;

import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.Formes.FormeVue;
import ProjetPatron.src.vue.Formes.FormeVueFactory;

import java.awt.Color;
import java.util.*;

/***
 * Classe abstraite de forme permettant une gestion hiérarchique de forme
 */
public abstract class Forme implements FormeVueFactory {
	
	private Color color;
	private List<Coord> points;
	private final int id;
	private final boolean locked;
	private FormeVue fv = null;

	/***
	 * Constructeur Abstrait permettant de créer une forme
	 * @param color la couleur qu'aura la forme
	 * @param points les points de liaison de la forme
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 */
	protected Forme(Color color,List<Coord> points,boolean locked) {
		this.color = color;
		this.points = points;
		this.locked = locked;
		this.id = MainModel.getNextIdForme();
	}

	/***
	 * Constructeur Abstrait permettant de créer une forme
	 * @param color la couleur qu'aura la forme
	 * @param points les points de liaison de la forme
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 * @param id l'id de la forme nouvellement créer
	 */
	protected Forme(Color color,List<Coord> points,boolean locked,int id) {
		this.color = color;
		this.points = points;
		this.locked = locked;
		this.id = id;
		MainModel.setNbForme(MainModel.getNbForme()+1);
	}

	/***
	 * Permet de returner l'id de la forme
	 * @return l'id
	 */
	public int getId() {
		return id;
	}

	/***
	 * Permet de savoir si la forme est déplaçable
	 * @return Vrai si elle est déplaçable, Faux sinon
	 */
	public boolean isLocked() {
		return locked;
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
	public void changePoint(Coord point, int x, int y){
		int temp = this.points.indexOf(point);
		if(temp != -1){
			Coord pointList = this.points.get(temp);
			pointList.setX(x);
			pointList.setY(y);
		}
	}

	/***
	 * Permet de récupérer le centre de la forme
	 * @return le centre de la forme
	 */
	public Coord getCenter(){
		int cumulX = 0;
		int cumulY = 0;
		for (Coord c: this.points){
			cumulX += c.getX();
			cumulY += c.getY();
		}
		return new Coord(cumulX/points.size(),cumulY/points.size());
	}

	/***
	 * Permet de récupérer la largeur de la forme
	 * @return la largeur de la forme
	 */
	public int getWidth(){
		int x1 = points.get(0).getX();
		int x2 = points.get(1).getX();
		if (x1 > x2){
			return x1 - x2;
		}else{
			return x2 - x1;
		}
	}

	/***
	 * Permet de récupérer la hauteur de la forme
	 * @return la hauteur de la forme
	 */
	public int getHeight(){
		int y1 = points.get(0).getY();
		int y2 = points.get(1).getY();
		if (y1 > y2){
			return y1 - y2;
		}else{
			return y2 - y1;
		}
	}
  
  public abstract float getAire();

	/***
	 * Permet de récupérer le point le plus à gauche de la forme
	 * @return le point le plus à gauche
	 */
	public int getMostLeftCoord(){
		return Math.min(points.get(0).getX(),points.get(1).getX());
	}

	/***
	 * Permet de récupérer le point le plus en haut de la forme
	 * @return le point le plus en haut
	 */
	public int getMostUpCoord(){
		return Math.min(points.get(0).getY(),points.get(1).getY());
	}

	/***
	 * Permet de récupérer le point le plus à droite de la forme
	 * @return le point le plus à droite
	 */
	public int getMostRightCoord(){
		return Math.max(points.get(0).getX(),points.get(1).getX());
	}

	/***
	 * Permet de récupérer le point le plus en bas de la forme
	 * @return le point le plus en bas
	 */
	public int getMostDownCoord(){
		return Math.max(points.get(0).getY(),points.get(1).getY());
	}

	/***
	 * Permet de récupérer la coordonnée x du point
	 * @return la coordonnée x du point
	 */
	public int[] getPointX(){
		int[] xs = new int[points.size()];
		for (int i = 0; i < points.size(); i++) {
			xs[i] = points.get(i).getX();
		}
		return xs;
	}


	/***
	 * Permet de récupérer la coordonnée y du point
	 * @return la coordonnée y du point
	 */
	public int[] getPointY(){
		int[] ys = new int[points.size()];
		for (int i = 0; i < points.size(); i++) {
			ys[i] = points.get(i).getY();
		}
		return ys;
	}

	/***
	 * Permet de récupérer le chemin de l'image de la forme
	 * @return le chemin de l'image de la forme
	 */
	public abstract String getPathImg();

	/***
	 * Permet de récupérer la forme
	 * @return la forme
	 */
	public FormeVue getFv() {
		return fv;
	}

	/***
	 * Permet de changer la forme
	 * @param fv la nouvelle forme
	 */
	public void setFv(FormeVue fv) {
		this.fv = fv;
	}

	public String writeForme(){
		return "  f-";
	}
}
