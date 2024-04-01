package ProjetPatron.src.model.Formes;

import ProjetPatron.src.vue.Formes.CercleVue;
import ProjetPatron.src.vue.Formes.FormeVue;

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
	 * Permet de récupérer le chemin de l'image du cercle
	 * @return le chemin de l'image du cercle
	 */
	@Override
	public String getPathImg() {
		return "assets/images/jeu/cercle.png";
	}

	@Override
	public String writeForme() {
		String ligneDesc = " ";
		ligneDesc += "("+this.getPoints().get(0).getX()+"/"+this.getPoints().get(0).getY()+") |";
		ligneDesc += "("+this.getPoints().get(1).getX()+"/"+this.getPoints().get(1).getY()+") | ";
		ligneDesc += this.isLocked() ? "T\n" : "F\n";
		return super.writeForme()+"cercle-"+this.getId()+":"+ligneDesc;
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

	/***
	 * Permet de set le rayon du cercle
	 */
	public void setRayon(){
		//TODO set le rayon depuis le centre vers le points autre
	}


	/***
	 * Permet de créer le cercle
	 * @return le cercle
	 */
	@Override
	public FormeVue createFormeVue() {
		if(this.getFv() == null)
			this.setFv(new CercleVue(this));
		return this.getFv();
	}

	@Override

	public float getAire(){
		return (float) (Math.PI * (Math.pow(((double) this.getWidth() /2),2)));
	}
}
