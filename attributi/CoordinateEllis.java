package attributi;

/**
 * Classe astratta che eredita da Attributi, ha fields privati lat, lon, quota e metodi get/set
 * @author Sara
 */
public abstract class CoordinateEllis implements Attributi {
    private double lat, lon, quota; //in decimali
    private double latgr, latmin, latsec, longr, lonmin, lonsec;
    public abstract String  descrizione();

    public CoordinateEllis(double toLatitude, double toLongitude, double toAltitude) {
        lat = toLatitude;
        lon = toLongitude;
        quota = toAltitude;
        
        this.latgr = Math.floor(lat);
        this.latmin = Math.floor((lat - latgr)*60);
        this.latsec = (lat-latgr-latmin/60)*3600;
        
        this.longr = Math.floor(lon);
        this.lonmin = Math.floor((lon -longr)*60);
        this.lonsec = (lon-longr-lonmin/60)*3600;
    }
    
    public CoordinateEllis(double latgr, double latmin, double latsec, double longr, 
             double lonmin, double lonsec, double toAltitude) 
    {
        this.latgr = latgr;
        this.latmin =latmin;
        this.latsec = latsec;
        this.longr =longr;
        this.lonmin = lonmin;
        this.lonsec = lonsec;
        quota = toAltitude;        
        this.lat = latgr+ latmin/60+ latsec/3600;
        this.lon = longr+ lonmin/60 + lonsec/3600;
    }
  
     /**
      * Ritorna una stringa con i valori double di lat, lon e quota in gradi, min, sec
      * troncati a rispettivamente 5, 5, 3 cifre
      * @return
      */  
     public String toString() {
        
        int degrees = (int) lon;
	double dminutes = (lon- (double) degrees) * 60;
	int minutes = (int) dminutes;
	double seconds = (dminutes - (double) minutes) * 60;
	String longStr = String.valueOf(degrees) + "° " + String.valueOf(minutes) + "' " + String.valueOf(Utilities.tronc(seconds,5)) + "\" E";
	degrees = (int) lat;
	dminutes = (lat- (double) degrees) * 60;
	minutes = (int) dminutes;
	seconds = (dminutes - (double) minutes) * 60;
	String latStr = String.valueOf(degrees) + "° " + String.valueOf(minutes) + "' " + String.valueOf((Utilities.tronc(seconds,5))) + "\" N";
	return latStr + "| " + longStr + "| " + (Utilities.tronc(quota,3)) +" m di quota";
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public void setLon(double lon){
        this.lon = lon;
    }
    public void setQuota(double quota){
        this.quota = quota;
    }  
    public double getLat(){
        return lat;
    }
    public double getLon(){
        return lon;
    }
    public double getQuota(){
        return quota;
    }
    
    public double getLatgr(){
        return latgr;
    }
    public double getLatmin(){
        return latmin;
    }
    public double getLatsec(){
        return latsec;
    }
    public double getLongr(){
        return longr;
    }
    public double getLonmin(){
        return lonmin;
    }
    public double getLonsec(){
        return lonsec;
    }
 
    

}
