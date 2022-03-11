public class ConwayEvent extends Event {
    private Balls balls;
    public EventManager manager;
    public Conway conway;

    public ConwayEvent(long date, Conway conway, EventManager manager){
        super(date);
        this. manager = manager;
        this.conway = conway;
    }

    public void execute() {
        conway.next_conway();
        manager.addEvent(new ConwayEvent(this.getDate()+1, conway,manager));
    }

}
