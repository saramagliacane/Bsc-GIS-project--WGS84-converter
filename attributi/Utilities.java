package attributi;

/**
 * Classe di utilities che contiene il metodo statico tronca
 * @author Sara
 */
public class Utilities {
    
    /**
     * Metodo statico che tronca i double a n cifre significative
     * @param x il double da troncare
     * @param n a quante cifre troncare
     * @return il double troncato
     */
    public static double tronc (double x, int n){
        double t = Math.pow(10, n);
        double temp = Math.floor(t*x);
        return temp /t;
    
    }
    /**
     * Main di test
    */
    public static void main (String args[]){
        double a = 5066854.358999999;
        double b = tronc(a, 5);
        System.out.print(a + " "+ b );
    
    }
   
}
