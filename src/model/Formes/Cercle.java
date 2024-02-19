package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

public class Cercle extends Forme{
	
	private float rayon; 
	
	public Cercle(Color color,List<Coord> pts) {
		super(color,pts);
	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
	}
	
}
