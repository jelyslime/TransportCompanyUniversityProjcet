package Cargos;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.TRANSPORT_TYPE;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for MaterialCargo
 *
 * @see MaterialCargo
 */
@RunWith(JUnit4.class)
public class MaterialCargoTest {

    private final double EXPECTED_WEIGHT = 4;
    private final TRANSPORT_TYPE EXPECTED_TYPE = TRANSPORT_TYPE.PRODUCT;

    /**
     * This test checks if all argument constructor works as expected.
     */
    @Test
    public void allArgsConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_TYPE, EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT, cargo.getCargoWeight());
        assertEquals(EXPECTED_TYPE, cargo.getCargoType());
    }

    /**
     * This test checks if constructor only with double value works as expected.
     */
    @Test
    public void oneParamConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT, cargo.getNecessaryInformation());
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

    /**
     * This test checks if no arguments constructor works as expected.
     */
    @Test
    public void noArgsConstructor_CreateInstance() {
        //arrange & act
        MaterialCargo cargo = new MaterialCargo();

        //assert
        assertEquals(0.0, cargo.getNecessaryInformation());
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

    /**
     * This test checks if setCargoWeight works as expected.
     */
    @Test
    public void setCargoWeight_ModifyWeigh() {
        //arrange
        MaterialCargo cargo = new MaterialCargo(EXPECTED_WEIGHT);
        double newExpectedWeight = 0.0;

        //act
        cargo.setCargoWeight(newExpectedWeight);

        //assert
        assertEquals(newExpectedWeight, cargo.getNecessaryInformation());
    }

    /**
     * This test checks if implemented method getNecessaryInformation works as expected.
     */
    @Test
    public void getNecessaryInformation_returnWeight() {
        //arrange & act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_TYPE, EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT, cargo.getNecessaryInformation());
    }

    /**
     * This test checks if implemented method getType works as expected.
     */
    @Test
    public void getType_returnType() {
        //arrange & act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_TYPE, EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }
}
