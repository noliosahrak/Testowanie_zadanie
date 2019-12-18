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
public class SingletonReflection {
    private static SingletonReflection instance;
 
    private SingletonReflection() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }
    }
 
    public static SingletonReflection getInstance() {
        if (instance == null) {
            instance = new SingletonReflection();
        }
        return instance;
    }
}
