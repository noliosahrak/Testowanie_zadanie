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
public abstract class DekoratorNapisu implements Napis{
    protected Napis dekorowanyNapis;
    
    public DekoratorNapisu(Napis dekorowanyNapis) {
        this.dekorowanyNapis = dekorowanyNapis;
    }
}
