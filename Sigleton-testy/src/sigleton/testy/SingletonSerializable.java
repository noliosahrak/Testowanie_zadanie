/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigleton.testy;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * @author student
 */
public class SingletonSerializable implements Serializable{
    private static SingletonSerializable instance;
 
    private SingletonSerializable() {
    }
 
    public static SingletonSerializable getInstance() {
        if (instance == null) {
            instance = new SingletonSerializable();
        }
        return instance;
    }
 
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
