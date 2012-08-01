package attributi;

/**
 * Classe che estende Coordinate cartesiane, sovrascrivendo toString() che 
 * tronca N, E e quota a 3 cifre significative
 * @author Sara
 */
public class UTM extends CoordinateCart{

    public UTM(double x, double y, double quota) {
        super(x,y, quota);
    }
    @Override
    public String descrizione() {return "\nCoordinate UTM:";}

    @Override
    public String toString() {
        return Utilities.tronc(N,3) + " N | "+ Utilities.tronc(E,3) + "E | " + Utilities.tronc(quota,3) + " m di quota";
    }
    
    /**
     * Main di test
     * @param args
     */
    public static void main(String args[]) {
        
        UTM temp = new UTM (5066854.358, 5066854.358, 5066854.358);
        System.out.print(temp);
       
    }
}
