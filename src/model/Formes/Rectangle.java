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

	/***
	 * Constructeur de rectangle
	 * @param color la couleur du rectangle
	 * @param pts la liste des 2 points de coordonées de rectangle
	 * @param locked True --> cible deplaçable | False --> non déplaçable
	 */
	public Rectangle(Color color,List<Coord> pts, boolean locked) {
		super(color,pts,locked);
	}

	@Override
	public String writeForme() {
		String ligneDesc = " ";
		ligneDesc += "("+this.getPoints().get(0).getX()+"/"+this.getPoints().get(0).getY()+") |";
		ligneDesc += "("+this.getPoints().get(1).getX()+"/"+this.getPoints().get(1).getY()+") | ";
		ligneDesc += this.isLocked() ? "T\n" : "F\n";
		return super.writeForme()+"rectangle-"+this.getId()+":"+ligneDesc;
	}

	@Override
	public String getPathImg() {
		return "assets/images/jeu/rectangle.png";
	}

	@Override
	public FormeVue createFormeVue() {
		if(this.getFv() == null)
			this.setFv(new RectangleVue(this));
		return this.getFv();
	}

	@Override

	public float getAire(){
		return this.getWidth() * this.getHeight();
	}

}
