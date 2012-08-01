package attributi;

/**
 * Classe che estende CoordinateEllis
 * @author Sara
 */
public class WGS84 extends CoordinateEllis {
    public String descrizione() {return "\nCoordinate WGS84:";}

    @Override
       public String toString() {
        return super.toString();
    }
    
    /**
     * Costruttore semplice per dati in decimale
     * @param toLatitude
     * @param toLongitude
     * @param toAltitude
     */
    public WGS84(double toLatitude, double toLongitude, double toAltitude) {
        super(toLatitude,  toLongitude, toAltitude);
    }
    
    /**
     * Costruttore che accetta come parametri i dati in gradi, min, sec
     * e li converte in decimali
     * @param latGr
     * @param latMin
     * @param latSec
     * @param lonGr
     * @param lonMin
     * @param lonSec
     * @param toAltitude
     */
     public WGS84(double latGr, double latMin, double latSec, double lonGr, 
             double lonMin, double lonSec, double toAltitude) {
         
        super(latGr+ latMin/60+ latSec/3600,  lonGr+ lonMin/60 + lonSec/3600, toAltitude);
    }
   }
