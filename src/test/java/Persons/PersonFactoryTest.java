package Persons;

import Cargos.Cargo;
import Persons.Factory.ClientArgs;
import Persons.Factory.EmployeeArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import utility.CATEGORY;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Unit tests for PersonFactory
 *
 * @see PersonFactory
 */
@RunWith(JUnit4.class)
public class PersonFactoryTest {

    @Mock
    private Cargo cargo;

    @Mock
    private BigDecimal bigDecimal;

    @Mock
    private CATEGORY category;

    private EmployeeArgs employeeArgs;

    /**
     * This test checks if singleton returns same instance of object
     */
    @Test
    public void getInstance_returnObject_SameInstance() {
        //assert
        assertEquals(PersonFactory.getInstance(), PersonFactory.getInstance());
    }

    /**
     * This test checks if created person is from expected type
     * <p>
     * </p>
     * Person type varies from parameter calls.
     */
    @Test
    public void createPerson_Client_ClientArgs() {
        //arrange
        ClientArgs clientArgs = new ClientArgs("", bigDecimal, cargo);

        //act
        Client client = PersonFactory.getInstance().createPerson(clientArgs);

        //assert
        assertNotNull(client);
    }

    /**
     * This test checks if created person is from expected type
     * <p>
     * </p>
     * Person type varies from parameter calls.
     */
    @Test
    public void createPerson_Employee_EmployeeArgs() {
        //arrange
        employeeArgs = new EmployeeArgs("", bigDecimal, category);

        //act
        Employee employee = PersonFactory.getInstance().createPerson(employeeArgs);

        //assert
        assertNotNull(employee);
    }

    /**
     * This test check if factory will throw an exception
     * <p></p>
     * Exception is thrown when an call is made with unsupported parameters.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createCargo_ThrowIllegalArgumentException_NotSupportedArgs() {
        PersonFactory.getInstance().createPerson(employeeArgs);
    }
}
