// controllare prima di convertire il punto se ha coordinate WGS84

package oggetti;


import attributi.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Sara
 */
public class Punto {
    private String nome;
    private HashMap<String, Attributi> attributi= new HashMap<String,Attributi>();
    private int id;
    private static int counter = 0;
    
    public Punto( Attributi coord ) {   
        this.id = counter;
        attributi.put(coord.getClass().getSimpleName(), coord);
        counter++;
     }
     public Punto( String nome, Attributi coord ) { 
        this.id = counter;
        this.nome = nome;
        attributi.put(coord.getClass().getSimpleName(), coord);
        counter++;
     }
    
    public Set<String> getKeys() {
	return attributi.keySet();
	}
    public Attributi getAttributo (String key) {
	if (attributi.containsKey(key)) return attributi.get(key);
        return null;
    }
    
    public void setAttributo( Attributi coord ) {    
        String key = coord.getClass().getSimpleName();
        if (attributi.containsKey(key)) return;
        attributi.put(key, coord);
    }
    
    public String mostra (){ 
        String longs = "";
        Iterator <String> i = attributi.keySet().iterator();
        while (i.hasNext()) 
		{
			String label = i.next();
			Attributi val = attributi.get(label);
                        longs += val.descrizione() + " " + val;
                       
		}
        return ("Nome punto: " +nome + "\n" +longs);
        
    }
    
    public String getNome (){ 
               return this.nome;
    }
    public static Punto Lanaro = new Punto("Lanaro",new WGS84 (45, 44, 49.27350, 13, 46, 55.62078, 589.377));
    public static Punto Trecam = new Punto("3cam", new WGS84 (45, 38, 5.30010, 13, 48, 59.79464, 317.163));
    public static Punto Franco = new Punto("Franco", new WGS84 (45, 40, 55.34769, 13, 50, 10.56380, 452.412));
    public static Punto Bercis = new Punto("Bercis", new WGS84 (45, 44, 51.20396, 13, 39, 53.19392, 244.504));
    public static Punto Cares = new Punto("Cares", new WGS84 (45, 35, 35.21889, 13, 49, 45.06422, 205.139));
    public static Punto Ermada = new Punto("Ermada",new WGS84 (45, 47, 40.96079, 13, 37, 34.64112, 367.605));
    public static Punto Sleon = new Punto("Sleon",new WGS84 (45, 45, 53.51495, 13, 43, 20.49039, 446.276));
    public static Punto Duino = new Punto("Duino",new WGS84 (45, 47, 14.67811, 13, 35, 32.46407, 61.580));
    

}
