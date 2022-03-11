import java.util.*;

/** Cette classe fournit l'implémentation d'un Boid.
 *	Un Boid est caractérisé par sa position, sa vitesse et son accélération.
 */
public class Boid {
	/** Position du boid. */
	private Vector position;
	/** Vitesse du boid. */
	private Vector vitesse;
	/** Accélération du boid. */
	private Vector acceleration;
	/** Vitesse maximale du boid. */
    	private int vitMax = 20;

	public Boid(Vector position, Vector vitesse, Vector acceleration) {
		this.position = position;
		this.vitesse = vitesse;
		this.acceleration = acceleration;
	}

	/** Calcule la nouvelle posiiton du boid à partir de son accélération et sa vitesse. */
	public void updatePosition() {
		vitesse = vitesse.add(acceleration);
		vitesse.limit(vitMax);
		position = position.add(vitesse);
		acceleration.getVect()[0] = 0;
		acceleration.getVect()[1] = 0;
	}

    public Vector getPos(){
		return this.position;
	}

	public Vector getVit(){
		return this.vitesse;
	}

	public Vector getAcc() {
		return this.acceleration;
	}

	/** Limite la position du boid dans la fenêtre de simulation. */
	public void borders(int limX, int limY){
		if (position.getVect()[0] > limX){
			position.getVect()[0] = 0;
		}
		else if (position.getVect()[0] < 0){
			position.getVect()[0] = limX - 30;
		}
		if (position.getVect()[1] > limY){
			position.getVect()[1] = 0;
		}
		else if (position.getVect()[1] < 0){
		    position.getVect()[1] = limY - 30;
		}
	}

	/** Applique la règle de cohésion au boid. */
    public void cohesion(Boid[] boids) {
 	   Vector newPos= new Vector(2);
 	   int sum = 0;

 	   for (int i = 0; i < boids.length; i++){
 		   double dist = this.position.dist(boids[i].position);
 		   if (dist < 40 && dist > 0){
               newPos= newPos.add(boids[i].position);
 			   sum++;
 		   }
 	   }

 	   if (sum != 0){
 		   newPos.divScal(sum);
 		   Vector vitesse_voulue =  newPos.minus(position);
 		   acceleration = acceleration.add(vitesse_voulue);
 	   }
    }

	/**  Applique la règle de sépération au boid. */
    public void separation(Boid[] boids) {
		Vector newVit = new Vector(2);
		int sum = 0;

		for (int i = 0; i < boids.length; i++) {
 		   	double dist = this.position.dist(boids[i].position);
 		   	if (dist < 20 && dist > 0) {
				Vector difference_pos = position.minus(boids[i].position);
				newVit = newVit.add(difference_pos);
				sum++;
			}
		}

		if (sum != 0) {
			newVit.multScal(0.5);
			acceleration = acceleration.add(newVit);
 		}
    }

	/** Applique la règle d'alignement au boid. */
    public void alignement(Boid[] boids) {
        Vector newVit = new Vector(2);
        int sum = 0;

        for (int i = 0; i < boids.length; i++) {
            double dist = this.position.dist(boids[i].position);
            if (dist < 40 && dist > 0) {
                newVit.add(boids[i].vitesse);
                sum++;
            }
        }

        if (sum != 0) {
            newVit.divScal(sum);
            Vector acceleration_voulue = newVit.minus(vitesse);
            acceleration_voulue.divScal(8);
            acceleration = acceleration.add(acceleration_voulue);
        }
    }
}
