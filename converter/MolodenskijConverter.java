package converter;

import oggetti.*;
import attributi.*;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MolodenskijConverter {
	
	private Ellissoide fromElipsoid;
	private Ellissoide destElipsoid;
	
	private double from_semiMajor;
	private double translation_x;
	private double translation_y;
	private double translation_z;
	private double rotation_x;
	private double rotation_y;
	private double rotation_z;
	private double scaleFactor;
	private double deltaSemiMajor;
	private double deltaFlattening;
	
	public MolodenskijConverter(Ellissoide from, Ellissoide to) {
		//data about origin elipsoid
		from_semiMajor = from.getSemimajor();
		//data about destination elipsoid
		deltaSemiMajor = from.getSemimajor() - to.getSemimajor();
		deltaFlattening = from.getFlattening() - to.getFlattening();
		rotation_x = to.getRotation_x() - from.getRotation_x();
		rotation_y = to.getRotation_y() - from.getRotation_y();
		rotation_z = to.getRotation_z() - from.getRotation_z();
		translation_x = to.getTranslation_yz() - from.getTranslation_yz();
		translation_y = to.getTranslation_xz() - from.getTranslation_xz();
		translation_z = to.getTranslation_xy() - from.getTranslation_xy();
		//scaleFactor = to.getRefactor() - to.getRefactor();
		//save Elipsoid for calculations...
		fromElipsoid = from;
		destElipsoid = to;
	}
	
	public Punto convert(Punto p)  {
                
                String from_id = fromElipsoid.getId();
                String to_id = destElipsoid.getId();
                
                CoordinateEllis p_ellis = (CoordinateEllis) p.getAttributo(from_id);
                
                if (p_ellis != null)   {       
                               
                double curvationRatio = fromElipsoid.CurvationRatio(p_ellis);
                double grandNormal = fromElipsoid.GrandNormal(p_ellis);
                double sinLongitude = Math.sin(Math.toRadians(p_ellis.getLon()));
                double cosLongitude = Math.cos(Math.toRadians(p_ellis.getLon()));
                double sinLatitude = Math.sin(Math.toRadians(p_ellis.getLat()));
                double cosLatitude = Math.cos(Math.toRadians(p_ellis.getLat()));
                double tanLatitude = Math.tan(Math.toRadians(p_ellis.getLat()));
                double altitude = p_ellis.getQuota();
                double flattening = fromElipsoid.getFlattening();

                double tempVar = curvationRatio + altitude;
                double tempVar2 = Math.pow(from_semiMajor, 2) / grandNormal + altitude;
                double tempVar6 = Math.pow(1 - flattening, 2);
                double tempVar5 = (1 - tempVar6) * grandNormal;

                double tempVar3 = (grandNormal + altitude) * cosLatitude;
                double tempVar4 = (tempVar6 * grandNormal + altitude) / (grandNormal + altitude);

                double dLatitude = sinLatitude * cosLongitude / tempVar * translation_x + sinLatitude * sinLongitude / tempVar * translation_y - cosLatitude / tempVar * translation_z + tempVar2 / tempVar * sinLongitude * rotation_x - tempVar2 / tempVar * cosLongitude * rotation_y - tempVar5 / tempVar * cosLatitude * sinLatitude * (scaleFactor + deltaSemiMajor / from_semiMajor) - (curvationRatio + tempVar6 * grandNormal) / tempVar * cosLatitude * sinLatitude * (deltaFlattening / (1 - flattening));

                double dLongitude = sinLongitude / tempVar3 * translation_x - cosLongitude / tempVar3 * translation_y - tempVar4 * tanLatitude * cosLongitude * rotation_x - tempVar4 * tanLatitude * sinLongitude * rotation_y + rotation_z;

                double dAltitude = -cosLatitude * cosLongitude * translation_x - cosLatitude * sinLongitude * translation_y - sinLatitude * translation_z + tempVar5 * sinLatitude * cosLatitude * sinLongitude * rotation_x - tempVar5 * sinLatitude * cosLatitude * cosLongitude * rotation_y - tempVar2 * scaleFactor + from_semiMajor / grandNormal * deltaSemiMajor - tempVar6 * grandNormal * Math.pow(sinLatitude, 2) * (deltaFlattening / (1 - flattening));
                               
                double toLatitude = p_ellis.getLat() + dLatitude / Math.PI * 180;
                double toLongitude = p_ellis.getLon() + dLongitude / Math.PI * 180;
                double toAltitude = p_ellis.getQuota() + dAltitude;
                
                try {
                    to_id = "attributi." + to_id;
                    Class c = Class.forName(to_id);
                    Constructor cc = c.getConstructor(double.class, double.class, double.class);
                    p.setAttributo((Attributi)cc.newInstance(toLatitude, toLongitude, toAltitude));
                } catch (Exception ex) {
                Logger.getLogger(MolodenskijConverter.class.getName()).log(Level.SEVERE, null, ex);
                 p.setAttributo(new ED50(toLatitude, toLongitude, toAltitude));
                }
		}
                return p;
	}

}
