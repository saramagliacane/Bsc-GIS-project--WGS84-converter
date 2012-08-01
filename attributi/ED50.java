package attributi;

/**
 * Classe che eredita da CoordinateEllis, usando il costruttore e il toString
 * @author Sara
 */
public class ED50 extends CoordinateEllis{

    public ED50(double toLatitude, double toLongitude, double toAltitude) {
        super(toLatitude,  toLongitude,  toAltitude);
    }
    
    public ED50(double latGr, double latMin, double latSec, double lonGr, 
             double lonMin, double lonSec, double toAltitude) {
         
        super(latGr+ latMin/60+ latSec/3600,  lonGr+ lonMin/60 + lonSec/3600, toAltitude);
    }
  
    public String descrizione() {return "\nCoordinate ED50 :";}

    @Override
       public String toString() {
        return super.toString();
    }
}
