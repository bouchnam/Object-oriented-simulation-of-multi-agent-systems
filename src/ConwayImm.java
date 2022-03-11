/**
 * Cette classe fournit l'implémentation du jeu de l'immigration.
 */

public class ConwayImm extends Conway {

    public ConwayImm(Cellule[][] lescellules,int width,int height){
        super(lescellules,width,height);
    }

    /** Calcule l'état des cellules à l'étape t+1. */
    @Override
    public void next_conway() {
        int var1 = this.width;
        int var2 = this.height;
        for (int i=0; i<height; i++ ) {
            for (int j=0; j<width; j++ ) {
                int compteur_vivant = 0;
                int etat = this.lescellules_traite[i][j].getEtat();
                for(int t = -1; t<2; t++){
                    for(int k = -1; k<2; k++){
                        if ((k!=0 || t!=0)) {
                            int indice_x =(this.lescellules_traite[i][j].getCarre().x/10+t+var1)%var1;
                            int indice_y =(this.lescellules_traite[i][j].getCarre().y/10+k+var2)%var2;
                            if (this.lescellules_traite[indice_x][indice_y].getEtat()==(etat+1)%4) {
                                compteur_vivant+=1;
                            }
                        }
                    }
                }
                if (compteur_vivant > 2) {
                    this.lescellules[i][j].setEtat((etat+1)%4);
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
