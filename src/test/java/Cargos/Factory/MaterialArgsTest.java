package Cargos.Factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for MaterialArgs
 *
 * @see MaterialArgs
 */
@RunWith(JUnit4.class)
public class MaterialArgsTest {

    /**
     * Test checks if getWeight works as expected
     */
    @Test
    public void getWeight_ReturnPropWeight() {
        //arrange
        double EXPECTED_WEIGHT = 4.0;
        MaterialArgs peopleArgs = new MaterialArgs(EXPECTED_WEIGHT);

        //act & assert
        assertEquals(EXPECTED_WEIGHT, peopleArgs.getWeight());
    }

    /**
     * Test checks if setWeight works as expected
     */
    @Test
    public void setWeight_ModifyPropWeight() {
        //arrange
        double EXPECTED_WEIGHT = 4.0;
        MaterialArgs peopleArgs = new MaterialArgs(2.0);

        //act
        peopleArgs.setWeight(EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT, peopleArgs.getWeight());
    }
}
