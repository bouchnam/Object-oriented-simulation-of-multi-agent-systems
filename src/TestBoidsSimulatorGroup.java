import java.awt.Point;
import gui.*;
import java.awt.Color;

/**
* Cette classe permet de tester la classe BoidsSimulator.
*/
public class TestBoidsSimulatorGroup {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(1000, 1000, Color.RED);
        Boids[] listeBoids = new Boids[3];
        Boid[] boids1 = new Boid[100];
        Boid[] boids2 = new Boid[100];
        Boid[] boids3 = new Boid[100];


        for (int i=0;i<100;i++) {
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
		    boids3[i] = new Boid(position, vitesse, acceleration);
		}

        for (int i=0;i<100;i++) {
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
		    boids1[i] = new Boid(position, vitesse, acceleration);
		}
        
        for (int i=0;i<100;i++) {
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
            boids2[i] = new Boid(position, vitesse, acceleration);
        }


      Boids B1 = new Boids(boids1);
      Boids B2 = new Boids(boids2);
      Boids B3 = new Boids(boids3);



      listeBoids[0] = B1;
      listeBoids[1] = B2;
      listeBoids[2] = B3;



      EventManager manager = new EventManager();
      BoidsSimulatorGroup Simulation = new BoidsSimulatorGroup(listeBoids,gui,manager);
      gui.setSimulable(Simulation);
      Simulation.draw();
    }
}
