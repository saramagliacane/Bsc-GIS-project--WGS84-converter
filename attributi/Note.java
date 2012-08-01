package attributi;

/**
 * Classe di attributi generale
 * @author Sara
 */
public class Note implements Attributi {
    private String note;
    
    public String descrizione (){ return "\nNote:";}
    public String toString(){ return note;}; 
    
    public Note (String note){ this.note= note;};
}