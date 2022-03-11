/** Cette classe fournit la decription d'un vecteur. */
public class Vector{
    private double[] vector;

    public Vector(int taille){
        vector = new double[taille];
    }

    public Vector(double[] vector){
        this.vector = vector;
    }

    public double[] getVect(){
        return this.vector;
    }

    public void setVect(double[] v){
        this.vector = v;
    }

    /** Retourne la somme des deux vecteurs. */
    public Vector add(Vector v1){
        Vector v2 = new Vector(v1.vector.length);
        for (int i = 0 ; i < v1.vector.length; i++){
            v2.vector[i] = v1.vector[i] + this.vector[i];
        }
        return v2;
    }

    /** Retourne la différence des deux vecteurs. */
    public Vector minus(Vector v1){
        Vector v2 = new Vector(v1.vector.length);
        for (int i = 0 ; i < v1.vector.length; i++){
            v2.vector[i] = this.vector[i] - v1.vector[i];
        }
        return v2;
    }

    /** Divise le vecteur par le scalaire; */
    public void divScal(double scalaire){
        for (int i = 0; i < this.vector.length; i++){
            this.vector[i] = this.vector[i] / scalaire;
        }
    }

    /** Multiplie le vecteur par le scalaire. */
    public void multScal(double scalaire) {
        for (int i = 0; i < this.vector.length; i++){
            this.vector[i] = this.vector[i] * scalaire;
        }
    }

    /** Limite la norme du vecteur à la valeur max. */
    public void limit(int max) {
        double norme = norme();
        if (norme > max) {
            this.divScal(norme);
            this.multScal(max);
        }
    }

    /** Calcule la norme du vecteur. */
    public double norme(){
        double sum = 0;
        for (int i = 0; i < this.vector.length; i++){
            sum += this.vector[i] * this.vector[i];
        }
        return Math.sqrt(sum);
    }

    /** Calcule la distance entre deux vecteurs. */
    public double dist(Vector v1){
        Vector v = this.minus(v1);
        return v.norme();
    }

}
