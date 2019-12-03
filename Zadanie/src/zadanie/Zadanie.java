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
        char domyslnySeparator = ' ';
        
        while (zmiennaSterujaca) {
            System.out.println();
            System.out.println("Co chcesz zrobić?");
            System.out.println("1 - Przelicz słowa w pliku tekstowym");
            System.out.println("2 - Przelicz słowa w tekscie wpisanym z konsoli");
            System.out.println("3 - Ustaw separator");
            System.out.println("4 - Pomoc");
            System.out.println("0 - Wyjście");
            
            wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    System.out.println("Podaj ścieżkę do pliku");
                    String sciezka = sc.next();
                    ArrayList<String> tekst = wcztajTekst(sciezka);
                    System.out.println("W tym pliku jest "+liczenieZListy(tekst,domyslnySeparator)+" słów");
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Wpisz tekst:");
                    s = sc.nextLine();
                    System.out.println("W tej linii jest "+liczenie(s,domyslnySeparator)+" słów");
                    break;
                case 3:
                    System.out.println("Jaki znak ma być nowym separatorem? ");
                    domyslnySeparator = sc.next().charAt(0);
                    System.out.println("Nowy separtor to "+domyslnySeparator);
                    break;
                case 4:
                    System.out.println("Tu umieścić pomoc");
                    break;
                case 0:
                    zmiennaSterujaca = false;       //działa
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

    private static ArrayList<String> wcztajTekst(String sciezka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
