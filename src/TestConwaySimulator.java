import gui.*;
import java.awt.Point;
import java.awt.Color;

/**
* Cette classe permet de tester la classe ConwaySimulator.
*/
public class TestConwaySimulator {
    public static void main(String[] args) {
        Cellule[][] Cellules= new Cellule[50][50];

        for (int i=0;i<50;i++) {
            for (int j=0;j<50;j++) {
                Cellules[i][j] = new Cellule(new Point(10*i,10*j),(int)(Math.random()*2));
            }
        }

        Cellules[20][3] = new Cellule(new Point(10*20,10*3),1);
        Cellules[21][3] = new Cellule(new Point(10*21,10*3),1);
        Cellules[20][4] = new Cellule(new Point(10*20,10*4),1);
        Cellules[22][4] = new Cellule(new Point(10*22,10*4),1);
        Cellules[23][6] = new Cellule(new Point(10*23,10*6),1);
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        EventManager manager = new EventManager();
        Conway conway = new Conway(Cellules,500,500);
        ConwaySimulator Simulation = new ConwaySimulator(conway,gui,manager);
        gui.setSimulable(Simulation);
        Simulation.draw();
    }
}
