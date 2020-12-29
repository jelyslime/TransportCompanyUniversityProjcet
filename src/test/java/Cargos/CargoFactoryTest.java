package Cargos;

import Cargos.Factory.MaterialArgs;
import Cargos.Factory.PeopleArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Unit tests for CargoFactory
 *
 * @see CargoFactory
 */
@RunWith(JUnit4.class)
public class CargoFactoryTest {

    MaterialArgs materialArgs;
    PeopleArgs peopleArgs;

    /**
     * This test checks if singleton returns same instance of object
     */
    @Test
    public void getInstance_returnObject_SameInstance() {
        //assert
        assertEquals(CargoFactory.getInstance(), CargoFactory.getInstance());
    }

    /**
     * This test checks if created cargo is from expected type
     * <p>
     * </p>
     * Cargo type varies from parameter calls.
     */
    @Test
    public void createCargo_PersonCargo_PersonArgs() {
        //arrange
        peopleArgs = new PeopleArgs(new ArrayList<>());

        //act
        Cargo cargo = CargoFactory.getInstance().createCargo(peopleArgs);

        //assert
        assertTrue(cargo instanceof PeoplesCargo);
    }

    /**
     * This test checks if created cargo is from expected type
     * <p>
     * </p>
     * Cargo type varies from parameter calls.
     */
    @Test
    public void createCargo_MaterialCargo_MaterialArgs() {
        //arrange
        materialArgs = new MaterialArgs(0);

        //act
        Cargo cargo = CargoFactory.getInstance().createCargo(materialArgs);

        //assert
        assertTrue(cargo instanceof MaterialCargo);
    }

    /**
     * This test check if factory will throw an exception
     * <p></p>
     * Exception is thrown when an call is made with unsupported parameters.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createCargo_ThrowIllegalArgumentException_NotSupportedArgs() {
        CargoFactory.getInstance().createCargo(materialArgs);
    }
}
