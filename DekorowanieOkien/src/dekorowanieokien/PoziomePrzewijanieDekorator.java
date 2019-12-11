/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorowanieokien;

/**
 *
 * @author student
 */
public class PoziomePrzewijanieDekorator extends OknoDekorator{
    
    public PoziomePrzewijanieDekorator(Okno dekorowaneOkno) {
        super(dekorowaneOkno);
    }
    
    @Override
    public void rysuj() {
        rysujPoziomyPasekPrzewijania();
        dekorowaneOkno.rysuj();
    }

    private void rysujPoziomyPasekPrzewijania() {
        //rysuj poziomy pasek przewijania
    }
    
    @Override
    public String pobierzOpis() {
        return dekorowaneOkno.pobierzOpis() + ", z poziomym paskiem przewijania";
    }
}
