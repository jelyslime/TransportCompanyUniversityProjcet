package Vechicles;


import Vehicles.VechiclesIdCounterSingleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static junit.framework.TestCase.*;

/**
 * This class is a unit test for VechiclesIdCounterSingleton
 * @see VechiclesIdCounterSingleton
 */
@RunWith(JUnit4.class)
public class VechiclesIdCounterSingletonTest {

    /**
     * This test checks if singleton returns same instance of object
     */
    @Test
    public void getInstance_returnObject_SameInstance(){
        //assert
        assertEquals(VechiclesIdCounterSingleton.getInstance(),VechiclesIdCounterSingleton.getInstance());
    }
}
