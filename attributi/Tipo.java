package attributi;

/**
 * Classe esempio che implementa Attributi.
 * Salva il tipo di terreno.
 * @author Sara
 */
public class Tipo implements Attributi {
    private String tipo;
    
    public String descrizione (){ return "\nTipo di punto:";}
    public String toString(){ return tipo;}; 
    
    public Tipo (String tipo){ this.tipo= tipo;};
    public Tipo (){ this.tipo = "Sconosciuto";};
}
