package attributi;

/**
 * Classe che estende UTM per salvare le coordinate UTM originali
 * @author Sara
 */
public class UTMo extends UTM{
       public UTMo(double x, double y, double quota) {
            super(x,y, quota);
        }
        
        public String descrizione() {return "\nCoordinate UTM originali:";}

}
