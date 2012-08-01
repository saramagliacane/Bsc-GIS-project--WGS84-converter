package attributi;

/**
 * Classe astratta che eredita da Attributi, ha fields privati N, E, quota e metodi set/get
 * @author Sara
 */
public abstract class CoordinateCart implements Attributi {
    protected double N, E, quota;
    public abstract String descrizione();

    @Override
       public String toString() {
        return N  + " N |  "+ E  + " E | " + quota + " m di quota";
    }
    /**
     * Costruttore di CoordinateCart
     * @param x
     * @param y
     * @param quota
     */
    public CoordinateCart(double x, double y, double quota) {
        this.N = x;
        this.E = y;
        this.quota = quota;
    }
    public void setN(double N){
        this.N= N;
    }
    public void setE(double E){
        this.E=E;
    }
    public void setQuota(double quota ){
        this.quota=quota;
    }
    
    public double getN(){
        return N;
    }
    public double getE(){
        return E;
    }
    public double getQuota(){
        return quota;
    }
}
