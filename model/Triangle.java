package ProjetPatron.model;

import java.awt.Color;
import java.util.*;

public class Triangle extends Forme{
	
	private float hypothenus;
	private float adjacent;
	private float opposee;
	
	public Triangle(Color color, List<Coord> points) {
		super(color,points);
	}

	public float getHypothenus() {
		return hypothenus;
	}

	public void setHypothenus(int hypothenus) {
		this.hypothenus = hypothenus;
	}

	public float getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(int adjacent) {
		this.adjacent = adjacent;
	}

	public float getOpposee() {
		return opposee;
	}

	public void setOpposee(int opposee) {
		this.opposee = opposee;
	}
	
	
}
