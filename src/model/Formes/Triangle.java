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

	/***
	 * Permet de récupérer le chemin de l'image du triangle
	 * @return le chemin de l'image du triangle
	 */
	/***
	 * Constructeur de triangle
	 * @param color La couleur du triangle
	 * @param points Les coordonées des points du triangle
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 * @param id l'id de la forme
	 */
	public Triangle(Color color,List<Coord> points,boolean locked,int id) {
		super(color,points,locked,id);
	}

	@Override
	public String getPathImg() {
		return "assets/images/jeu/triangle.png";
	}

	@Override
	public String writeForme() {
		String ligneDesc = " ";
		ligneDesc += "("+this.getPoints().get(0).getX()+"/"+this.getPoints().get(0).getY()+") | ";
		ligneDesc += "("+this.getPoints().get(1).getX()+"/"+this.getPoints().get(1).getY()+") | ";
		ligneDesc += "("+this.getPoints().get(2).getX()+"/"+this.getPoints().get(2).getY()+") | ";
		ligneDesc += this.isLocked() ? "T\n" : "F\n";
		return super.writeForme()+"triangle-"+this.getId()+":"+ligneDesc;
	}

	/***
	 * Permet de créer le triangle
	 * @return le triangle
	 */
	@Override
	public FormeVue createFormeVue() {
		if(this.getFv() == null)
			this.setFv(new TriangleVue(this));
		return this.getFv();
	}
	@Override
	public float getAire(){
		return (float) (this.getWidth() * this.getHeight()) /2 ;
	}

}