package Vehicles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class implements singleton design pattern.
 * <p>
 * Class purpose is to simulate automatic id generation via an atomic integer
 * </p>
 */
public class VechiclesIdCounterSingleton {
    private static VechiclesIdCounterSingleton singleton = null;

    public final AtomicInteger counter;

    private VechiclesIdCounterSingleton() {
        counter = new AtomicInteger();
    }

    public static VechiclesIdCounterSingleton getInstance() {
        if (singleton == null) {
            singleton = new VechiclesIdCounterSingleton();
        }
        return singleton;
    }
}
