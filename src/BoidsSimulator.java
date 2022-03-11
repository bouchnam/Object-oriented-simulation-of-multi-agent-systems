import gui.*;
import java.awt.Color;
import java.awt.Point;

public class BoidsSimulator implements Simulable{
    private Boids boids;
    private GUISimulator gui;
    public EventManager manager;

    public BoidsSimulator(Boids boids, GUISimulator gui,EventManager manager) {
		this.boids = boids;
		this.gui = gui;
		this.manager = manager;
		manager.addEvent(new BoidsEvent(1, boids,manager, gui.getWidth(), gui.getHeight()));
	}

    /** Passe de l'étape t à l'étape t+1. */
    @Override
	public void next() {
        manager.next();
        boids.borders(gui.getWidth(), gui.getHeight());
        gui.reset();
        draw();
	}

    /** Réinitialise les boids. */
    @Override
    public void restart() {
    	manager.restart();
    	manager.addEvent(new BoidsEvent(1, boids, manager, gui.getWidth(), gui.getHeight()));
        boids.reInit();
        gui.reset();
        draw();
    }

    /** Dessine les boids. */
    public void draw() {
        Boid[] b = boids.getBoids();
        for (Boid currentBoid : b ) {
            gui.addGraphicalElement(new Oval((int)currentBoid.getPos().getVect()[0], (int)currentBoid.getPos().getVect()[1], Color.WHITE, Color.WHITE, 5));
        }
    }

}
