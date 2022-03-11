public class BallsEvent extends Event {
    private Balls balls;
    public EventManager manager;
    private int limitex;
    private int limitey;

    public BallsEvent(long date, Balls balls, EventManager manager, int limitex, int limitey) {
        super(date);
        this.balls = balls;
        this. manager = manager;
        this.limitex = limitex;
        this.limitey = limitey;

    }

    public void execute() {
        this.balls.translater(10, 10, limitex, limitey);
        manager.addEvent(new BallsEvent(this.getDate()+1, balls, manager, limitex, limitey));
    }
}
