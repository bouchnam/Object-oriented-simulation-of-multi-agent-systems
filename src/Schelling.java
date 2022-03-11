import java.util.*;

public class Schelling extends Conway {
    LinkedList<Cellule> points = new LinkedList<Cellule>();
    int seuil;

    public Schelling(Cellule[][] lescellules, int width, int height, int seuil) {
        super(lescellules,width,height);
        this.seuil = seuil;

        for (int i=0;i<height/10;i++){
            for (int j=0;j<width/10;j++){
                if(lescellules[i][j].getEtat()==0){
                    points.add(lescellules[i][j]);
                }
            }
        }
    }

  /** On calcule les nombres des couleurs differentes autour de la Cellule i,j */
  public int compteur_different_col(int etat, int i, int j) {
      int var1 = this.width;
      int var2 = this.height;
      int compteur_different_col = 0;

      for(int t = -1;t<2;t++) {
          for(int k = -1;k<2;k++) {
              if ((k!=0 || t!=0)) {
                int indice_x = modulo(this.lescellules_traite[i][j].getCarre().x/10+t,var1);
                int indice_y = modulo(this.lescellules_traite[i][j].getCarre().y/10+k,var2);
                    if (this.lescellules_traite[indice_x][indice_y].getEtat()!=etat && this.lescellules_traite[indice_x][indice_y].getEtat() !=0 ) {
                        compteur_different_col+=1;
                    }
                }
            }
        }
        return compteur_different_col;
    }

    void update_cellules_traites() {
        for (int i=0;i<height;i++ ){
            for (int j=0;j<width;j++ ) {
                this.lescellules_traite[i][j] = new Cellule(this.lescellules[i][j].getCarre(),this.lescellules[i][j].getEtat());
            }
        }
    }

    int modulo(int nombre,int mod) {
        int modulation = nombre %mod;
        if (modulation == -1){
            modulation += mod;
        }
        return modulation;
    }

    void demanagement(LinkedList<Cellule> demenagee, int i, int j, int etat) {
        this.lescellules[i][j].setEtat(0);
        points.add(lescellules[i][j]);
        int random = (int)(Math.random()*(this.points.size()-1));
        //on récupére une cellule vacante aléatoire
        Cellule nouveau_habi = this.points.remove(random);
        int indice_nv_x = nouveau_habi.getCarre().x/10;
        int indice_nv_y = nouveau_habi.getCarre().y/10;
        this.lescellules[indice_nv_x][indice_nv_y].setEtat(etat);
        demenagee.add(lescellules[indice_nv_x][indice_nv_y]);
    }

    @Override
    public void next_conway(){
        int var1 = this.width;
        int var2 = this.height;
        LinkedList<Cellule> demenagee = new LinkedList<Cellule>();
        for (int i=0;i<height;i++ ){
            for (int j=0;j<width;j++ ) {
                int etat = this.lescellules_traite[i][j].getEtat();
                if (etat !=0 && !demenagee.contains(this.lescellules[i][j])){
                    int compteur_different_col = compteur_different_col(etat,i,j);
                    if (compteur_different_col > seuil-1){
                        demanagement(demenagee,i,j,etat);
                    }
                }
            }
        }
        update_cellules_traites();
    }
}
