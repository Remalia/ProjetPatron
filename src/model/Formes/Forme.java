package ProjetPatron.src.model.Formes;

import java.awt.Color;
import java.util.*;

public class Forme {
	
	private Color color;
	private List<Coord> points;
	
	protected Forme(Color color,List<Coord> points) {
		this.color = color;
		this.points = points;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Coord> getPoints() {
		return points;
	}

	public void setPoints(List<Coord> points) {
		this.points = points;
	}
		
}
