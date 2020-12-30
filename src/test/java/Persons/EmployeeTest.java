package Persons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.CATEGORY;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Unit tests for Employee
 *
 * @see Employee
 */
@RunWith(JUnit4.class)
public class EmployeeTest {

    private String EXPECTED_NAME = "NAME";
    private BigDecimal EXPECTED_SALARY = new BigDecimal("123.32");
    private CATEGORY EXPECTED_CATEGORY = CATEGORY.B;

    /**
     * This test checks if all argument constructor works as expected.
     */
    @Test
    public void allArgsConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        Employee employee = new Employee(EXPECTED_NAME, EXPECTED_SALARY, EXPECTED_CATEGORY);

        //assert
        assertEquals(EXPECTED_NAME, employee.getName());
        assertEquals(EXPECTED_SALARY, employee.getSalary());
        assertEquals(EXPECTED_CATEGORY, employee.getCategory());
    }

    /**
     * This test checks if no arguments constructor works as expected.
     */
    @Test
    public void noArgsConstructor_CreateInstance() {
        //arrange & act
        Employee employee = new Employee();

        //assert
        assertEquals("", employee.getName());
        assertEquals(new BigDecimal("0.0"), employee.getSalary());
        assertEquals(CATEGORY.B, employee.getCategory());
    }

    /**
     * This test checks if setCategory works as expected.
     */
    @Test
    public void setCategory_ModifyCategoryProp_ArgumentsValid() {
        //arrange
        Employee employee = new Employee();

        //act
        employee.setCategory(CATEGORY.C);

        //assert
        assertEquals(CATEGORY.C, employee.getCategory());
    }

    /**
     * This test checks if setName works as expected.
     */
    @Test
    public void setName_ModifyNameProp_ArgumentsValid() {
        //arrange
        Employee employee = new Employee();

        //act
        employee.setName(EXPECTED_NAME);

        //assert
        assertEquals(EXPECTED_NAME, employee.getName());
    }

    /**
     * This test checks if setSalary works as expected.
     */
    @Test
    public void setSalary_ModifySalaryProp_ArgumentsValid() {
        //arrange
        Employee employee = new Employee();

        //act
        employee.setSalary(EXPECTED_SALARY);

        //assert
        assertEquals(EXPECTED_SALARY, employee.getSalary());
    }

    /**
     * This test checks if equals works as expected.
     */
    @Test
    public void equals_True_SameObjects() {
        //arrange
        Employee employee = new Employee();
        Employee employee2 = new Employee();

        //act & assert
        assertTrue(employee.equals(employee2));
    }

    /**
     * This test checks if hashCode works as expected.
     */
    @Test
    public void hashCode_sameInt_SameObjects() {
        //arrange
        Employee employee = new Employee();
        Employee employee2 = new Employee();

        //act & assert
        assertTrue(employee.hashCode() == employee2.hashCode());
    }

    /**
     * This test check if toString method works as expected.
     * If the method works, it should at least write "name ="
     * plus the value of the name
     */
    @Test
    public void toString_OutputAtLeastVehicle() {
        //arrange
        Employee employee = new Employee();

        //act
        String toString = employee.toString();

        //assert
        assertTrue(toString.contains("name=" + employee.getName()));
    }
}
