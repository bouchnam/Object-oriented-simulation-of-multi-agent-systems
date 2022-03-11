import gui.*;
import java.awt.Color;

/**
* Cette classe réalise l'interface Simulable pour le jeu de l'immigration.
*/
public class ConwayImmSimulator extends ConwaySimulator implements Simulable {
    public ConwayImmSimulator(Conway conway,GUISimulator gui,EventManager manager){
        super(conway,gui,manager);
    }

    @Override
    public void draw() {
        Cellule[][] liste = conway.getCellules();
        int width = conway.getWidth();
        int height = conway.getHeight();
        for (int i=0;i<height;i++ ){
            for (int j=0;j<width;j++ ) {
                if (liste[i][j].getEtat() == 0) {
                    gui.addGraphicalElement(new Rectangle( liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.WHITE, 10));
                } else if (liste[i][j].getEtat() == 1) {
                    gui.addGraphicalElement(new Rectangle( liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.LIGHT_GRAY, 10));
                } else if (liste[i][j].getEtat() == 2) {
                    gui.addGraphicalElement(new Rectangle( liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.DARK_GRAY, 10));
                } else if (liste[i][j].getEtat() == 3) {
                    gui.addGraphicalElement(new Rectangle( liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.BLACK, 10));
                }
            }
        }
    }
}
