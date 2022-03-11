/** Cette classe implémente un ensemble de boids. */
public class Boids {
	private Boid[] Boids;
    	private Boid[] InitialBoids;
	private Boid[] temporaryBoids;

	public Boids(int n) {
		this.InitialBoids = new Boid[n];
		this.Boids = new Boid[n];
	}

    public Boids(Boid[] Boids){
		this.Boids = Boids;
		this.temporaryBoids = Boids;
        this.InitialBoids = new Boid[Boids.length];
		for (int i=0 ; i < Boids.length; i++ ) {
			this.InitialBoids[i] = new Boid(Boids[i].getPos(), Boids[i].getVit(), Boids[i].getAcc());
		}

	}

    public Boid[] getBoids(){
		return this.Boids;
	}

	/** Applique les règles à l'ensemble des boids. */
	public void updatePos(){
		for (int i = 0; i < Boids.length; i++){
			Boids[i].cohesion(Boids);
			Boids[i].alignement(Boids);
			Boids[i].separation(Boids);
			Boids[i].updatePosition();
		}
	}

	/** limite la position des boids dans la fenêtre de simulation. */
	public void borders(int limX, int limY){
		for (int i = 0; i < Boids.length; i++){
			Boids[i].borders(limX, limY);
		}
	}

	/** Réinitialise les boids dans leurs états initials. */
    public void reInit(){
		for (int i=0; i<Boids.length; i++ ) {
			this.Boids[i] = new Boid(InitialBoids[i].getPos(), InitialBoids[i].getVit(), InitialBoids[i].getAcc());
		}
	}

}
