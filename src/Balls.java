import java.awt.Point;

/**
 * Cette classe fournit l'implémentation d'un ensemble de balles.
 * Une balle est un point de l'espace caractérisé par son abscisse et son ordonné.
 */
public class Balls {
	private Point[] balls;
	/** Balles dans leurs états initials. */
	private Point[] init_balls;
	/** Pas de translation suivant x. */
	private int[] balls_dx;
	/** Pas de translation suivant y. */
	private int[] balls_dy;

	public Balls(Point[] balls) {
		this.balls = balls;
		int length = balls.length;
		this.init_balls = new Point[length];

        for (int i=0 ; i < length; i++ ) {
        	this.init_balls[i] = new Point(balls[i].x,balls[i].y);
        }
		balls_dx = new int[length];
		balls_dy = new int[length];
	}

	/** Initialise les pas de translation. */
	public void updatedxdy(int dx, int dy, int length) {
		for (int i=0 ; i < length; i++ ) {
			this.balls_dx[i] = dx;
			this.balls_dy[i] = dy;
		}
	}

	/** Translate les balles. */
	public void translater(int dx, int dy, int limite_x, int limite_y) {
		int length = this.balls.length;

		if (this.balls_dx[0] == 0) {
			updatedxdy(dx, dy, length);
		}

		for (int i=0 ; i < length; i++) {
			if (this.balls[i].x + balls_dx[i] > limite_x || this.balls[i].x + balls_dx[i] < 0){
				balls_dx[i] = -balls_dx[i];
			}
			if (this.balls[i].y + balls_dy[i] > limite_y || this.balls[i].y + balls_dy[i] < 0) {
				balls_dy[i] = -balls_dy[i];
			}
			this.balls[i].translate(balls_dx[i], balls_dy[i]);
		}
	}

	/** Réinitialise les balles dans leurs états initials. */
    public void reInit() {
		int length = this.balls.length;
		for ( int i=0;i<length;i++ ) {
			this.balls[i] = new Point(this.init_balls[i].x,this.init_balls[i].y);
		}
    }

	public Point[] getBalls() {
		return this.balls;
	}

    public String toString() {
    	String s = "les positions des balles : {";

    	for (Point balle : this.balls) {
    		s+=balle.toString();
    		s+="/";
    	}

    	s+="}";
    	return s;
    }
}
