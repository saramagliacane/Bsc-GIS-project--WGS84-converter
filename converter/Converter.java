package converter;

import oggetti.*;
import attributi.WGS84;



public final class Converter {
	
        private Converter() {
		
	}
	
	public static Punto convert(Punto p, Ellissoide from, Ellissoide to) {
		MolodenskijConverter m = new MolodenskijConverter(from, to);
		return m.convert(p);
	}
	
	public static Punto convert(Punto p, Ellissoide from) {
		GaussConverter g = new GaussConverter(from);
		return g.convert(p);
	}
        
        public static Punto convert (Punto p) {
            MolodenskijConverter m = new MolodenskijConverter(Ellissoide.WGS84, Ellissoide.ED50);
            GaussConverter g = new GaussConverter (Ellissoide.ED50);
            return g.convert(m.convert(p));
            
            
        }
          public static Punto convert (Punto p, double precisione) {
            MolodenskijConverter m = new MolodenskijConverter(Ellissoide.WGS84, Ellissoide.ED50);
            GaussConverter g = new GaussConverter (Ellissoide.ED50);
            g.setPrecisione(precisione);
            return g.convert(m.convert(p));
            
        }
         
          public static void main (String args[]){
            Punto p = new Punto(new WGS84(45,44,49.27350,13,46,55.62078,589.377));
            p = convert(p);
            System.out.print(p.mostra());
            
        }
}
