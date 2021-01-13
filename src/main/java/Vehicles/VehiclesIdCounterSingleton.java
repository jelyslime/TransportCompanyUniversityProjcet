package Vehicles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class implements singleton design pattern.
 * <p>
 * Class purpose is to simulate automatic id generation via an atomic integer
 * </p>
 */
public class VehiclesIdCounterSingleton {
    private static VehiclesIdCounterSingleton singleton = null;

    public final AtomicInteger counter;

    private VehiclesIdCounterSingleton() {
        counter = new AtomicInteger();
    }

    public static VehiclesIdCounterSingleton getInstance() {
        if (singleton == null) {
            singleton = new VehiclesIdCounterSingleton();
        }
        return singleton;
    }
}
