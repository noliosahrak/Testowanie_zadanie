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
public class DekorowanieOkien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //utwórz dekorawane okno z poziomymi i pionowymi paskami pobierania
        Okno dekorowaneOkno = new PoziomePrzewijanieDekorator(new PionowePrzewijanieDekorator(new ZwykleOkno()));
        
        //wypisz opis Okna
        System.out.println(dekorowaneOkno.pobierzOpis());
    }
    
}
