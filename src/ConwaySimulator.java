import gui.*;
import java.awt.Color;

/**
* Cette classe réalise l'interface Simulable pour le jeu de la vie de Conway.
*/
public class ConwaySimulator implements Simulable {
    protected Conway conway;
    protected GUISimulator gui;
    public EventManager manager;

    public ConwaySimulator(Conway conway,GUISimulator gui, EventManager manager){
        this.conway = conway;
        this.gui = gui;
        this.manager = manager;
      	 manager.addEvent(new ConwayEvent(0,conway,manager));
    }

    /** Réinitialise les cellules et les dessine. */
    @Override
    public void restart() {
    	manager.restart();
    	 manager.addEvent(new ConwayEvent(0,conway,manager));
        conway.reInit();
        gui.reset();
        draw();
    }

    /** Passe de l'étape t à l'étape t+1. */
    @Override
    public void next() {
        manager.next();
        gui.reset();
        draw();
    }

    /** Dessine les cellules. */
    public void draw() {
        Cellule liste[][] = conway.getCellules();
        int width = conway.getWidth();
        int height = conway.getHeight();

            for (int i=0;i<height;i++ ){
                for (int j=0;j<width;j++ ) {
                    if (liste[i][j].getEtat() == 0) {
                        gui.addGraphicalElement(new Rectangle( liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.WHITE, 10));
                    } else if (liste[i][j].getEtat() == 1) {
                        gui.addGraphicalElement(new Rectangle( liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.BLUE, 10));
                    }
                }
            }
        }
}
