/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorowanienapisów;

/**
 *
 * @author student
 */
public class DekorowanieNapisów {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Napis a = new ZielonaCzcionkaDekorator(new CzerwoneTloDekorator(new KrotkiNapis("Testowy Napis")));
        
        a.wypisz();
    }
    
}
