/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class Zadanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = " Raz/dwa";                          //2
        int wynik = liczenie(s,'/');
        System.out.println(wynik);
        
        ArrayList<String> lista = new ArrayList();
        lista.add(s);                                   //2+2+5+7=16
        lista.add("Kra kra /kra/");
        lista.add(" Cos/takiego/niby/cos/tam   /");
        lista.add("sdgji/df/wefn/ef/e  /   er/r/");
        System.out.println(liczenieZListy(lista,'/'));
        
        boolean zmiennaSterujaca = true;
        int wybor;
        Scanner sc = new Scanner(System.in);
        
        while (zmiennaSterujaca) {
            System.out.println();
            System.out.println("Co chcesz zrobić?");
            System.out.println("1 - Przelicz słowa w pliku tekstowym");
            System.out.println("2 - Wpisz tekst");
            System.out.println("3 - Ustaw separator");
            System.out.println("4 - Pomoc");
            System.out.println("0 - Wyjście");
            wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    zmiennaSterujaca = false;
            }
        }
    }
    
    public static int liczenie(String s, char separator) {
        int ls = 0; //licznik słów
        char poprzedni = separator;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != separator && poprzedni == separator) {
                ls++;
            }
            poprzedni = c;
        }
        return ls;
    }
    
    public static int liczenieZListy(ArrayList<String> lista, char separator) {
        int ls = 0;
        for (String s : lista) {
            ls += liczenie(s,separator);
        }
        return ls;
    }
}
