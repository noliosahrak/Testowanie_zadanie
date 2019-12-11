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
public abstract class OknoDekorator implements Okno{
    protected Okno dekorowaneOkno;
    
    public OknoDekorator(Okno dekorowaneOkno) {
        this.dekorowaneOkno = dekorowaneOkno;
    }
}
