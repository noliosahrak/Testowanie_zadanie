/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie;

/**
 *
 * @author student
 */
public class Zadanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = " Raz dwa     trzy    ghj ";
        int wynik = liczenie(s);
        System.out.println(wynik);
    }
    
    public static int liczenie(String s) {
        int ls = 1; //licznik słów
        char poprzedni = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && poprzedni != ' ') {
                ls++;
            }
            poprzedni = c;
        }
        if (s.charAt(s.length() - 1) == ' ') ls--;
        return ls;
    }
}
