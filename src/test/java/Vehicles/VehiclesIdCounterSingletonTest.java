package Vehicles;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

/**
 * This class is a unit test for VehiclesIdCounterSingleton
 *
 * @see VehiclesIdCounterSingleton
 */
@RunWith(JUnit4.class)
public class VehiclesIdCounterSingletonTest {

    /**
     * This test checks if singleton returns same instance of object
     */
    @Test
    public void getInstance_returnObject_SameInstance() {
        //assert
        assertEquals(VehiclesIdCounterSingleton.getInstance(), VehiclesIdCounterSingleton.getInstance());
    }
}
