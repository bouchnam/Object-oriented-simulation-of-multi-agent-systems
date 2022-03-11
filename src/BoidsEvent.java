public class BoidsEvent extends Event {
    private Boids boids;
    public EventManager manager;
    int limitex;
    int limitey;

    public BoidsEvent(long date, Boids boids, EventManager manager, int limitex, int limitey) {
        super(date);
        this.boids = boids;
        this. manager = manager;
        this.limitex = limitex;
        this.limitey = limitey;
    }

    public void execute() {
        boids.updatePos();
        manager.addEvent(new BoidsEvent(this.getDate()+1, boids,manager, limitex, limitey));
    }

}
