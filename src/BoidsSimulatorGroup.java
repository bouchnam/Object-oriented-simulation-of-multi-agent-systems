import gui.*;
import java.awt.Color;
import java.awt.Point;
import static java.lang.Math.*;
import java.util.*;

public class BoidsSimulatorGroup implements Simulable{
    private Boids[] boids;
    private GUISimulator gui;
    public EventManager manager;

    public BoidsSimulatorGroup(Boids[] boids, GUISimulator gui,EventManager manager) {
        this.boids = boids;
        this.gui = gui;
        this.manager = manager;
        int i = 1;

        for(Boids b : boids) {
            manager.addEvent(new BoidsGroupEvent(i*manager.getCurrentDate(), b,manager, gui.getPanelWidth(), gui.getPanelHeight()));
            i += 3;
        }
    }

    @Override
	public void next() {
        manager.next();
        int i =1;
        for(Boids b : boids) {
            manager.addEvent(new BoidsGroupEvent(i*manager.getCurrentDate(), b,manager, gui.getPanelWidth(), gui.getPanelHeight()));
            b.borders(gui.getWidth(), gui.getHeight());
            i += 3;
         }
         gui.reset();
         draw();
	}


    @Override
    public void restart() {
    	manager.restart();
        int i = 1;
        for(Boids b : boids){
            manager.addEvent(new BoidsGroupEvent(i*manager.getCurrentDate(), b,manager, gui.getPanelWidth(), gui.getPanelHeight()));
            b.reInit();
            i += 3;
        }
        gui.reset();
        draw();
    }

    public void draw() {
        HashMap<Integer, String> colors = new HashMap<Integer, String>();
        colors.put(0,"#FFFFFF");//white
        colors.put(1,"#00FFFF");//CYAN
        colors.put(2,"#FFFF00");//YELLOW
        colors.put(3,"#FF00FF");//PINK
        colors.put(4,"#0000FF");//BLEU
        colors.put(5,"#008000");//GREEN
        colors.put(6,"#FF0000");//RED
        colors.put(7,"#000000");//BLACK
        int i = 0;
        for(Boids b1 : boids) {
            Boid[] b = b1.getBoids();
            for (Boid currentBoid : b ) {
                gui.addGraphicalElement(new Oval((int)currentBoid.getPos().getVect()[0], (int)currentBoid.getPos().getVect()[1], Color.decode(colors.get(i)), Color.decode(colors.get(i)), 4+2*i));
            }
            i += 1;
        }
    }
}
