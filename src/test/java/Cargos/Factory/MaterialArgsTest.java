package Cargos.Factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class MaterialArgsTest {
    @Test
    public void getWeight_ReturnPropWeight() {
        //arrange
        double EXPECTED_WEIGHT = 4.0;
        MaterialArgs peopleArgs = new MaterialArgs(EXPECTED_WEIGHT);

        //act & assert
        assertEquals(EXPECTED_WEIGHT, peopleArgs.getWeight());
    }

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
