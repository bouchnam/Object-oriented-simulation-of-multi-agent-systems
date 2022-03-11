/**
 * Cette classe fournit l'implémentation du jeu de vie de Conway.
 */

public class Conway {
    protected Cellule[][] lescellules;
    /** Cellules dans leures états initials. */
    protected Cellule[][] lescellules_init;
    protected Cellule[][] lescellules_traite;
    protected int width;
    protected int height;

    public Conway(Cellule[][] lescellules, int width, int height) {
        super();
        this.lescellules =lescellules;
        this.width = width/10;
        this.height = height/10;
        this.lescellules_init = new Cellule[height][width];
        this.lescellules_traite = new Cellule[height][width];
        for (int i=0;i<this.height;i++ ){
            for (int j=0;j<this.width;j++ ) {
                this.lescellules_init[i][j] = new Cellule(lescellules[i][j].getCarre(),lescellules[i][j].getEtat());
                this.lescellules_traite[i][j] = new Cellule(lescellules[i][j].getCarre(),lescellules[i][j].getEtat());
            }
        }
    }

    public Cellule[][] getCellules(){
        return this.lescellules;
    }

    public void setCellules(Cellule[][] lescellules){
        this.lescellules = lescellules;
    }

    /** Réinitialise les cellules dans leures états initials. */
    public void reInit(){
        for (int i=0;i<height;i++ ){
            for (int j=0;j<width;j++ ) {
                this.lescellules[i][j] = new Cellule(lescellules_init[i][j].getCarre(),lescellules_init[i][j].getEtat());
                this.lescellules_traite[i][j] = new Cellule(lescellules_init[i][j].getCarre(),lescellules_init[i][j].getEtat());
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /** Calcule l'état des cellules à l'étape t+1. */
    public void next_conway(){
       int var1 = this.width;
       int var2 = this.height;
       for (int i=0;i<height;i++ ){
           for (int j=0;j<width;j++ ) {
               int compteur_vivant = 0;
               for(int t = -1;t<2;t++){
                   for(int k = -1;k<2;k++){
                       if ((k!=0 || t!=0)){
                           int indice_x =(this.lescellules_traite[i][j].getCarre().x/10+t+var1)%var1;
                           int indice_y =(this.lescellules_traite[i][j].getCarre().y/10+k+var2)%var2;
                           if (this.lescellules_traite[indice_x][indice_y].getEtat()==1){
                               compteur_vivant+=1;
                           }
                       }
                   }
               }
               if (this.lescellules_traite[i][j].getEtat()==0 && compteur_vivant ==3){
                   this.lescellules[i][j].setEtat(1);
               }
               else if( this.lescellules_traite[i][j].getEtat()==1 && !(compteur_vivant ==3 || compteur_vivant ==2)){
                   this.lescellules[i][j].setEtat(0);
               }
           }
       }
       for (int i=0;i<height;i++ ){
           for (int j=0;j<width;j++ ) {
               this.lescellules_traite[i][j] = new Cellule(this.lescellules[i][j].getCarre(),this.lescellules[i][j].getEtat());
           }
       }
    }
}
