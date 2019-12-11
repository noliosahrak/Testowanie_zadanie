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
public class KrotkiNapis implements Napis{
    String napis;
    
    public KrotkiNapis(String napis) {
        this.napis = napis;
    }
    
    @Override
    public void wypisz() {
        System.out.println(napis);
    }

    @Override
    public String pobierzNapis() {
        return napis;
    }
    
}
