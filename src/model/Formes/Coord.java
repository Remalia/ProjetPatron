package ProjetPatron.src.model.Formes;

/***
 * Classe permettant la gestion des coordonnées et des points afin de créer les formes
 */
public class Coord {
	
	private float x;
	private float y;

	/***
	 * Permet de créer une coordonée (un point)
	 * @param x la position x
	 * @param y la position y
	 */
	public Coord(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/***
	 * Permet de récupérer le x du point
	 * @return la position x
	 */
	public float getX() {
		return x;
	}

	/***
	 * Permet de changer la position x du point
	 * @param x la nouvelle position x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/***
	 * Permet de récupérer le y du point
	 * @return la position y
	 */
	public float getY() {
		return y;
	}

	/***
	 * Permet de changer la position y du point
	 * @param y la nouvelle position y
	 */
	public void setY(float y) {
		this.y = y;
	}

	
	
}
