import java.awt.Point;

/**
 * Cette classe fournit l'implémentation d'une cellule.
 * Une cellule est caractérisée par son état.
 */
public class Cellule {
    private Point carre;
    private int etat;

    public Cellule(Point carre, int etat) {
        this.carre = carre;
        this.etat = etat;
    }

    public Point getCarre() {
        return this.carre;
    }

    public int getEtat() {
        return this.etat;
    }

    public void setCarre(Point point) {
        this.carre = point;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
