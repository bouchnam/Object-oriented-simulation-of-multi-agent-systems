/** Cette classe fournit la decription d'un évènement. */
public abstract class Event{
        private long date;

        public Event(long date){
            this.date = date;
        }

        public long getDate(){
            return this.date;
        }

        /** Exécute l'event. */
        public abstract void execute();

}
