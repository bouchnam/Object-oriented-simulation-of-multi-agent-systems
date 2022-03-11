import java.awt.Point;
import gui.*;
import java.awt.Color;

/**
* Cette classe permet de tester la classe BallsSimulator.
*/
public class TestBallsSimulator {
    public static void main(String[] args) throws InterruptedException{
        Point[] Balls = new Point[20];

        for (int i=0;i<20;i++) {
			int x = (int)(Math.random() * 500);
			int y = (int)(Math.random() * 500);
		    Balls[i] = new Point(x,y);
		}

      GUISimulator gui = new GUISimulator(500, 500, Color.RED);
      EventManager manger = new EventManager();
      Balls lesballes = new Balls(Balls);
      BallsSimulator Simulation = new BallsSimulator(lesballes,gui,manger);
      gui.setSimulable(Simulation);
      Simulation.draw();
    }
}
