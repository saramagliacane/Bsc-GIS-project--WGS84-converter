/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package attributi;

public class GaussBoaga extends CoordinateCart{

    public GaussBoaga(double x, double y, double quota) {
        super(x,y, quota);
    }
    @Override
    public String descrizione() {return "\nCoordinate GaussBoaga:";}

    @Override
    public String toString() {
        return Utilities.tronc(N,3) + " N | "+ Utilities.tronc(E,3) + "E | " + Utilities.tronc(quota,3) + " m di quota";
    }
    
    /**
     * Main di test
     * @param args
     */
    public static void main(String args[]) {
        
        GaussBoaga temp = new GaussBoaga (5066854.358, 5066854.358, 5066854.358);
        System.out.print(temp);
       
    }
}