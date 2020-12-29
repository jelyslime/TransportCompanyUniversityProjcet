package Cargos;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.TRANSPORT_TYPE;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class MaterialCargoTest {

    private double EXPECTED_WEIGHT = 4;
    private TRANSPORT_TYPE EXPECTED_TYPE = TRANSPORT_TYPE.PRODUCT;

    @Test
    public void allArgsConstructor_CreateInstance_ValidArguments(){
        //arrange


        //act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_TYPE,EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT,cargo.getCargoWeight());
        assertEquals(EXPECTED_TYPE,cargo.getCargoType());
    }

    @Test
    public void oneParamConstructor_CreateInstance_ValidArguments(){
        //arrange


        //act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT,cargo.getNecessaryInformation());
        assertEquals(EXPECTED_TYPE,cargo.getType());
    }

    @Test
    public void noArgsConstructor_CreateInstance(){
        //arrange


        //act
        MaterialCargo cargo = new MaterialCargo();

        //assert
        assertEquals(0.0,cargo.getNecessaryInformation());
        assertEquals(EXPECTED_TYPE,cargo.getType());
    }

    @Test
    public void setCargoWeight_ModifyWeigh(){
        //arrange
        MaterialCargo cargo = new MaterialCargo(EXPECTED_WEIGHT);
        double newExpectedWeight = 0.0;

        //act
        cargo.setCargoWeight(newExpectedWeight);

        //assert
        assertEquals(newExpectedWeight,cargo.getNecessaryInformation());
    }

    @Test
    public void getNecessaryInformation_returnWeight(){
        //arrange & act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_TYPE,EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_WEIGHT,cargo.getNecessaryInformation());
    }

    @Test
    public void getType_returnType(){
        //arrange & act
        MaterialCargo cargo = new MaterialCargo(EXPECTED_TYPE,EXPECTED_WEIGHT);

        //assert
        assertEquals(EXPECTED_TYPE,cargo.getType());
    }
}
