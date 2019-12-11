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
public class PionowePrzewijanieDekorator extends OknoDekorator{
    
    public PionowePrzewijanieDekorator(Okno dekorowaneOkno) {
        super(dekorowaneOkno);
    }
    
    @Override
    public void rysuj() {
        rysujPionowyPasekPrzewijania();
        dekorowaneOkno.rysuj();
    }

    private void rysujPionowyPasekPrzewijania() {
        //rysuj pionowy pasek przewijania
    }
    
    @Override
    public String pobierzOpis() {
        return dekorowaneOkno.pobierzOpis() + ", z pionowym paskiem przewijania";
    }
    
}
