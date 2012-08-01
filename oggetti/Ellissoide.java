package oggetti;

import attributi.*;

public final class Ellissoide {
	
	private double semimajor;
	private double e2;
	private double flattening;
	private double semiminor;
        private Orientamento o;
        private String id = null;
        	
	
	public Ellissoide (double semimajor, double e2, Orientamento o) {
		this.semimajor = semimajor;
		this.e2 = e2;
		this.semiminor = Math.sqrt(Math.pow(semimajor,2) - e2 * Math.pow(semimajor,2));
		this.flattening = (semimajor - semiminor) / semimajor;
                this.o = o;
         }
	public Ellissoide (String id, double semimajor, double e2, Orientamento o) {
                this.id = id;
                this.semimajor = semimajor;
		this.e2 = e2;
		this.semiminor = Math.sqrt(Math.pow(semimajor,2) - e2 * Math.pow(semimajor,2));
		this.flattening = (semimajor - semiminor) / semimajor;
                this.o = o;
        }
	
	public double CurvationRatio(CoordinateEllis p_ellis) {
		return semimajor * (1 - e2) / Math.sqrt(Math.pow(1 - e2 * Math.pow(Math.sin(Math.toRadians(p_ellis.getLat())),2),3));
	}
	
	public double GrandNormal (CoordinateEllis p_ellis) {
		return semimajor / Math.sqrt(1 - e2 * Math.pow(Math.sin(Math.toRadians(p_ellis.getLat())),2));
	}
	
	public static final Ellissoide WGS84 = new Ellissoide("WGS84", 6378137,0.00669437999, new Orientamento(0,0,0));
	public static final Ellissoide ED50 = new Ellissoide("ED50",6378388,0.00672267002,new Orientamento(-87,-98,-121));
	public static final Ellissoide ITA40 = new Ellissoide("ITA40", 378388,0.00672267002, new Orientamento(-104.1,-49.1,-9.9,-11.68,0.971,-2.917,0.714));


	public double getSemimajor() {
		return semimajor;
	}

	public double getE2() {
		return e2;
	}

	public double getFlattening() {
		return flattening;
	}

	public double getSemiminor() {
		return semiminor;
	}
	
        public double getTranslation_xy() {
		return o.getTranslation_xy();
	}

	public double getTranslation_yz() {
		return o.getTranslation_yz();
	}

	public double getTranslation_xz() {
		return o.getTranslation_xz();
	}

	public double getRotation_x() {
		return o.getRotation_x();
	}

	public double getRotation_y() {
		return o.getRotation_y();
	}

	public double getRotation_z() {
		return o.getRotation_z();
	}

	public double getRefactor() {
		return o.getRefactor();
	}
	public String getId() {
		return this.id;
	}
}
