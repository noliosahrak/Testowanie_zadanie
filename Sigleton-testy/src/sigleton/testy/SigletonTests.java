/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigleton.testy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author student
 */
public class SigletonTests {

    private static SingletonSimpleLazy firstInstanceForTestBreakWithThreads;
    private static SingletonSimpleLazy secondInstanceForTestBreakWithThreads;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException, InterruptedException {
        // TODO code application logic here
        SingletonSimpleEager singleton = SingletonSimpleEager.getInstance();
        System.out.println(singleton);
        SingletonSimpleEager singleton2 = SingletonSimpleEager.getInstance();
        System.out.println(singleton2);
        
        NewClass a = new NewClass("a");
        System.out.println(a);
        NewClass a2 = new NewClass("a");
        System.out.println(a2);
        
        System.out.println();
        System.out.println(SingletonSimpleLazy.instanceIsNull());
        SingletonSimpleLazy singleton3 = SingletonSimpleLazy.getInstance();
        System.out.println(SingletonSimpleLazy.instanceIsNull());
        
        SingletonSimpleLazy firstInstance = SingletonSimpleLazy.getInstance();

        // 1
        Constructor<SingletonSimpleLazy> constructor = SingletonSimpleLazy.class.getDeclaredConstructor();
        // 2
        constructor.setAccessible(true);
        // 3
        SingletonSimpleLazy secondInstance = constructor.newInstance();

        assertNotEquals(firstInstance, secondInstance);
        
        SingletonSimpleLazy firstInstanceSer = SingletonSimpleLazy.getInstance();
        SingletonSimpleLazy secondInstanceSer = null;

        try (FileOutputStream fos = new FileOutputStream("./SingletonSimpleLazy.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(firstInstanceSer);
        }

        try (FileInputStream fis = new FileInputStream("./SingletonSimpleLazy.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            secondInstanceSer = (SingletonSimpleLazy) ois.readObject();
        }

        assertNotEquals(firstInstanceSer, secondInstanceSer);
        
        SingletonSerializable firstInstanceSer2 = SingletonSerializable.getInstance();
        SingletonSerializable secondInstanceSer2 = null;

        try (FileOutputStream fos = new FileOutputStream("./SingletonSerializable.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(firstInstanceSer2);
        }

        try (FileInputStream fis = new FileInputStream("./SingletonSerializable.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            secondInstanceSer2 = (SingletonSerializable) ois.readObject();
        }

        //assertNotEquals(firstInstanceSer2, secondInstanceSer2);
        

        Runnable task1 = () -> {
            firstInstanceForTestBreakWithThreads = SingletonSimpleLazy.getInstance();
        };
        Runnable task2 = () -> {
            secondInstanceForTestBreakWithThreads = SingletonSimpleLazy.getInstance();
        };

        int testSuccess = 0;
        int testFail = 0;
        for (int i = 0; i < 100000; i++) {
            SingletonSimpleLazy.instance = null;
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(task1);
            service.submit(task2);
            service.shutdown();
            service.awaitTermination(1, TimeUnit.SECONDS);

            if (firstInstanceForTestBreakWithThreads != null && secondInstanceForTestBreakWithThreads != null && firstInstanceForTestBreakWithThreads.equals(secondInstanceForTestBreakWithThreads)) {
                testSuccess++;
            } else {
                testFail++;
            }
        }

        System.out.println(String.format("testSuccess: %d, testFail: %d", testSuccess, testFail));
            }   
}
