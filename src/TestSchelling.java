import gui.*;
import java.awt.Point;
import java.awt.Color;

public class TestSchelling{
    public static void main(String[] args) {
        Cellule[][]  Cellules= new Cellule[50][50];
        for (int i=0;i<50;i++) {
            for (int j=0;j<50;j++) {
                Cellules[i][j] = new Cellule(new Point(10*i,10*j),(int)(Math.random()*8));
            }
        }
        Cellules[3][20] = new Cellule(new Point(10*3,10*20),2);
        Cellules[3][21] = new Cellule(new Point(10*3,10*21),2);
        Cellules[4][20] = new Cellule(new Point(10*4,10*20),2);
        Cellules[4][22] = new Cellule(new Point(10*4,10*22),2);
        Cellules[6][23] = new Cellule(new Point(10*6,10*23),2);
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        EventManager manager = new EventManager();
        Schelling conway = new Schelling(Cellules,500,500,5);
        SchellingSimulator Simulation = new SchellingSimulator(conway,gui,manager);
        gui.setSimulable(Simulation);
        Simulation.draw();
    }
}
