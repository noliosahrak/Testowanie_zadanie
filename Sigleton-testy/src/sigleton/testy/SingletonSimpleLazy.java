/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigleton.testy;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class SingletonSimpleLazy implements Serializable{
    static SingletonSimpleLazy instance;
    
    private SingletonSimpleLazy() {
    }
 
    public synchronized static SingletonSimpleLazy getInstance() {
        if(instance == null){
            instance = new SingletonSimpleLazy();
        }
        return instance;
    }
    
    public static boolean instanceIsNull() {
        if(instance == null){
            return true;
        }
        return false;
    }
}
