package converter;

import oggetti.*;
import attributi.CoordinateEllis;
import attributi.GaussBoaga;
import attributi.UTM;




public class GaussConverter {

	private class Espressione implements Function {
		
		private double e2;
		private double a;

		public Espressione(double a, double e2) {
			this.e2 = e2;
			this.a = a;
		}
		
		@Override
		public double evaluate(double val) {
			return (a * (1 - e2))/Math.sqrt(Math.pow(1 - e2 * Math.pow(Math.sin(val),2),3));
		}
		
	}
	
	private Espressione integrale;
	private double a;
	private double e2;
        private String from_id;
        private final double contraction_ratio = 0.9996;
        private final double fake_origin_x = 0;
        private final double fake_origin_y = 500000;
        private double precisione = 10000;
               
     
	public GaussConverter(Ellissoide from) {
		this.a = from.getSemimajor();
		this.e2 = from.getE2();
                this.from_id = from.getId();
               
	}
	
       
        
	public Punto convert(Punto p) {
		
		integrale = new Espressione(a,e2);
		double fuse_length = 6 * Math.PI / 180;
		
                 CoordinateEllis p_ellis = (CoordinateEllis) p.getAttributo(from_id);
                if (p_ellis != null) { 
                
		int fuse;
		if (Math.toRadians(p_ellis.getLon()) > Math.PI)
			fuse = (int) ((Math.toRadians(p_ellis.getLon()) - Math.PI) / fuse_length);
		else
			fuse = (int) ((Math.PI + Math.toRadians(p_ellis.getLon())) / fuse_length);
		                
                double deltalength = (fuse - 30) * fuse_length + fuse_length / 2;
		
		double latitude = Math.toRadians(p_ellis.getLat());
		double longitude = Math.toRadians(p_ellis.getLon()) - deltalength;
		
		double sinLatitude = Math.sin(latitude);
		double cosLatitude = Math.cos(latitude);
		double tanLatitude = Math.tan(latitude);
		
		double tempVar1 = Math.sqrt(1 - e2 * Math.pow(sinLatitude, 2));
		double tempVar2 = Math.pow(e2/Math.sqrt(1 - e2), 2);
		
		double valoreIntegrale = Integrale.calcola(integrale, 0, Math.toRadians(p_ellis.getLat()), precisione);
		
		double x =  valoreIntegrale + 
					(double) 1/2 * a*sinLatitude*cosLatitude / tempVar1 * Math.pow(longitude,2) +
					(double) 1/24 * a*sinLatitude*Math.pow(cosLatitude, 3) / tempVar1 * (
							5 - Math.pow(tanLatitude,2) + 9*tempVar2*Math.pow(cosLatitude,2) + 
							4 * Math.pow(tempVar2, 2)* Math.pow(cosLatitude,4) 
					) * Math.pow(longitude,4) +
					(double)1/720 * a*sinLatitude*Math.pow(cosLatitude, 5)/ tempVar1 * (
							61 - 58*Math.pow(tanLatitude,2) + Math.pow(tanLatitude, 4) + 270 * tempVar2 * Math.pow(cosLatitude, 2) -
							330 * tempVar2 * Math.pow(cosLatitude, 2) * Math.pow(tanLatitude,2)
					) * Math.pow(longitude, 6);
		
		double y = 	a * cosLatitude / tempVar1 * longitude + 
					(double)1/6 * a * Math.pow(cosLatitude, 3) / tempVar1 * (
							1 - Math.pow(tanLatitude,2) + tempVar2 * Math.pow(cosLatitude, 2)
					) * Math.pow(longitude, 3) +
					(double)1/120 * a*Math.pow(cosLatitude,5)/tempVar1 * (
							5 - 18 * Math.pow(tanLatitude, 2) + Math.pow(tanLatitude, 4) + 14 * tempVar2 * Math.pow(cosLatitude, 2) -
							58 * tempVar2 * Math.pow(cosLatitude, 2) * Math.pow(tanLatitude, 2)
					) * Math.pow(longitude, 5);
               
                x = x * contraction_ratio + fake_origin_x;
		y = y * contraction_ratio + fake_origin_y;
		
		p.setAttributo(new UTM (x, y, p_ellis.getQuota()));
                
                if (fuse == 31) p.setAttributo(new GaussBoaga(x, y+1000000, p_ellis.getQuota()));
                else if (fuse == 32 ) p.setAttributo(new GaussBoaga(x, y+2020000, p_ellis.getQuota()));
                
                }
		return p;
                
	}
        
        public void setPrecisione (double precisione)  {this.precisione = precisione;}
        public double getPrecisione ()  { return this.precisione;}
        
        public static void main(String args[]) {
            Punto p = Converter.convert(Punto.Ermada);
            System.out.print(p.mostra());
                    
        }
	
}
