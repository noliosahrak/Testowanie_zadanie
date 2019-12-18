/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigleton.testy;

/**
 *
 * @author student
 */
public class SingletonSimpleEager {
    private static final SingletonSimpleEager instance = new SingletonSimpleEager();
 
    private SingletonSimpleEager() {
    }
 
    public static SingletonSimpleEager getInstance() {
        return instance;
    }
    
}
