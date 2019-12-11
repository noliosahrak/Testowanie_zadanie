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
public class ZielonaCzcionkaDekorator extends DekoratorNapisu{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public ZielonaCzcionkaDekorator(Napis dekorowanyNapis) {
        super(dekorowanyNapis);
    }
    
    @Override
    public void wypisz() {
        System.out.println(dekorowanyNapis.pobierzNapis());
    }

    @Override
    public String pobierzNapis() {
        return ANSI_GREEN + dekorowanyNapis.pobierzNapis()+ ANSI_RESET;
    }
}
