import static java.lang.Math.*;

public class BoidsGroupEvent extends Event {
    private Boids boids;
    public EventManager manager;
    public int limitex;
    public int limitey;

    public BoidsGroupEvent(long date, Boids boids, EventManager manager, int limitex, int limitey) {
        super(date);
        this.boids = boids;
        this. manager = manager;
        this.limitex = limitex;
        this.limitey = limitey;
    }

    public void execute() {
        boids.updatePos();
    }
}
