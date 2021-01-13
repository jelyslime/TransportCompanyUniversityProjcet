package Persons;

import Cargos.Cargo;
import Cargos.CargoFactory;
import Cargos.Factory.MaterialArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Unit tests for Employee
 *
 * @see Employee
 */
@RunWith(JUnit4.class)
public class ClientTest {

    private final String EXPECTED_NAME = "NAME";
    private final BigDecimal EXPECTED_BIG_DECIMAL = new BigDecimal("3.23");
    @Mock
    private Cargo cargo;

    /**
     * This test checks if all argument constructor works as expected.
     */
    @Test
    public void allArgsConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        Client client = new Client(EXPECTED_NAME, EXPECTED_BIG_DECIMAL, cargo);

        //assert
        assertEquals(EXPECTED_NAME, client.getName());
        assertEquals(EXPECTED_BIG_DECIMAL, client.getBudget());
        assertEquals(cargo, client.getCargo());
    }

    /**
     * This test checks if no arguments constructor works as expected.
     */
    @Test
    public void noArgsConstructor_CreateInstance() {
        //arrange
        cargo = CargoFactory.getInstance().createCargo(new MaterialArgs(0));

        //act
        Client client = new Client();

        //assert
        assertEquals("", client.getName());
        assertEquals(new BigDecimal("0.0"), client.getBudget());
        assertEquals(cargo, client.getCargo());
    }

    /**
     * This test checks if setCargo works as expected.
     */
    @Test
    public void setCargo_ModifyCargoProp_ArgumentsValid() {
        //arrange
        cargo = CargoFactory.getInstance().createCargo(new MaterialArgs(3));
        Client client = new Client();

        //act
        client.setCargo(cargo);

        //assert
        assertEquals(cargo, client.getCargo());
    }

    /**
     * This test checks if setBudget works as expected.
     */
    @Test
    public void setBudget_ModifyBudgetProp_ArgumentsValid() {
        //arrange
        Client client = new Client();

        //act
        client.setName(EXPECTED_NAME);

        //assert
        assertEquals(EXPECTED_NAME, client.getName());
    }

    /**
     * This test checks if setName works as expected.
     */
    @Test
    public void setName_ModifyNameProp_ArgumentsValid() {
        //arrange
        Client client = new Client();

        //act
        client.setBudget(EXPECTED_BIG_DECIMAL);

        //assert
        assertEquals(EXPECTED_BIG_DECIMAL, client.getBudget());
    }

    /**
     * This test checks if equals works as expected.
     */
    @Test
    public void equals_True_SameObjects() {
        //arrange
        Client client = new Client();
        Client client2 = new Client();

        //act & assert
        assertEquals(client, client2);
    }

    /**
     * This test checks if hashCode works as expected.
     */
    @Test
    public void hashCode_sameInt_SameObjects() {
        //arrange
        Client client = new Client();
        Client client2 = new Client();

        //act & assert
        assertEquals(client.hashCode(), client2.hashCode());
    }

    /**
     * This test check if toString method works as expected.
     * If the method works, it should at least write "name ="
     * plus the value of the name
     */
    @Test
    public void toString_OutputAtLeastVehicle() {
        //arrange
        Client client = new Client();

        //act
        String toString = client.toString();

        //assert
        assertTrue(toString.contains("name=" + client.getName()));
    }

}
