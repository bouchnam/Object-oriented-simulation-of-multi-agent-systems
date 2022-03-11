import gui.*;
import java.awt.Color;
import java.awt.Point;

/**
* Cette classe réalise l'interface Simulable.
*/
public class BallsSimulator implements Simulable {
	private Balls balls;
	private GUISimulator gui;
	public EventManager manager;

	public BallsSimulator(Balls balls, GUISimulator gui, EventManager manager) {
		this.balls = balls;
		this.gui = gui;
		this.manager = manager;
		manager.addEvent(new BallsEvent(1, balls, manager, gui.getPanelWidth(), gui.getPanelHeight()));
	}

	/** Translate, affiche et dessine les balles. */
	@Override
	public void next() {
		manager.next();
		gui.reset();
		draw();
	}

	/** Réinitialise les balles et les dessine. */
	@Override
	public void restart() {
		manager.restart();
		manager.addEvent(new BallsEvent(1, balls, manager, gui.getPanelWidth(), gui.getPanelHeight()));
		balls.reInit();
		gui.reset();
		draw();
	}

	/** Dessine les balles. */
	public void draw() {
	gui.addGraphicalElement(new Rectangle(gui.getPanelWidth()/2, gui.getPanelHeight()/2, Color.black, Color.blue, gui.getPanelWidth(), gui.getPanelHeight()));
		Point liste[] = balls.getBalls();
		for (Point balle : liste ) {
			gui.addGraphicalElement(new Oval(balle.x, balle.y, Color.WHITE, Color.WHITE, 10));
		}
	}
}
