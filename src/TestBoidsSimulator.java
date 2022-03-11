import java.awt.Point;
import gui.*;
import java.awt.Color;

/**
* Cette classe permet de tester la classe BoidsSimulator.
*/
public class TestBoidsSimulator {
    public static void main(String[] args) {
        Boid[] boids = new Boid[500];

        GUISimulator gui = new GUISimulator(1000, 1000, Color.RED);

        for (int i=0;i<500;i++) {
			int x = (int)(Math.random() * gui.getWidth());
			int y = (int)(Math.random() * gui.getHeight());
            Vector position = new Vector(2);
            Vector vitesse = new Vector(2);
            Vector acceleration = new Vector(2);
            position.getVect()[0] = x;
            position.getVect()[1] = y;
            vitesse.getVect()[0] = Math.random() * 15 - 8;
            vitesse.getVect()[1] = Math.random() * 15 - 8;
            acceleration.getVect()[0] = 0;
            acceleration.getVect()[1] = 0;
		    boids[i] = new Boid(position, vitesse, acceleration);
		}


      Boids B = new Boids(boids);
      EventManager manager = new EventManager();
      BoidsSimulator Simulation = new BoidsSimulator(B,gui,manager);
      gui.setSimulable(Simulation);
      Simulation.draw();
    }
}
