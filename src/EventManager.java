import java.util.*;

/** Cette classe fournit l'implémentation du gestionnaire d'évènements. */
public class EventManager{

    private long currentDate;
    private ArrayList<Event> events;

    public EventManager(){
        this.events = new ArrayList<Event>();
        this.currentDate = 0;
    }

    /** Ajoute un évènement au gestionnaire d'évènements. */
    public void addEvent(Event e){
        this.events.add(e);
    }

    /** Exècute dans l'ordre les évènements non encore exécutés. */
    public void next(){
        this.currentDate += 1;
        for (int i = 0;i < events.size(); i++){
            if (events.get(i).getDate() <= this.currentDate){
                events.get(i).execute();
                events.remove(i);
            }
        }
    }

    /** Retourne true si tous les évènements ont été exécutés. */
    public boolean isFinished(){
        return events.isEmpty();
    }

    /** Réinitialise le gestionnaire d'évènements. */
    public void restart(){
        this.events.clear();
        this.currentDate = 0;
    }

    public long getCurrentDate(){
    	return currentDate;
    }
}
