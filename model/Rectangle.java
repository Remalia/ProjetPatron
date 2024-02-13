package ProjetPatron.model;

import java.awt.Color;
import java.util.*;

public class Rectangle extends Forme{

	private float longeur;
	private float largeur;
	
	public Rectangle(Color color,List<Coord> pts,int longeur,int largeur) {
		super(color,pts);
		this.largeur = largeur;
		this.longeur = longeur;
	}

	public float getLongeur() {
		return longeur;
	}

	public void setLongeur(int longeur) {
		this.longeur = longeur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	
}
