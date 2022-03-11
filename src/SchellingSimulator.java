import gui.*;
import java.awt.Color;
import java.util.*;

public class SchellingSimulator extends ConwaySimulator implements Simulable {
      int seuil;

      public SchellingSimulator(Schelling conway,GUISimulator gui,EventManager manager){
          super(conway,gui,manager);
      }

      @Override
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
          Cellule liste[][] = conway.getCellules();
          int width = conway.getWidth();
          int height = conway.getHeight();
            for (int i=0;i<height;i++) {
                for (int j=0;j<width;j++) {
                    int etat =liste[i][j].getEtat();
                    gui.addGraphicalElement(new Rectangle(liste[i][j].getCarre().x,liste[i][j].getCarre().y, Color.BLACK, Color.decode(colors.get(etat)), 10));
                }
            }
      }
}
