package Cargos;

import Persons.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.TRANSPORT_TYPE;

import java.util.ArrayList;

import static junit.framework.Assert.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for PeoplesCargo
 *
 * @see PeoplesCargo
 */
@RunWith(JUnit4.class)
public class PeoplesCargoTest {
    private final ArrayList<Person> EXPECTED_LIST = new ArrayList<>();
    private final TRANSPORT_TYPE EXPECTED_TYPE = TRANSPORT_TYPE.PASSENGER;

    /**
     * This test checks if all argument constructor works as expected.
     */
    @Test
    public void allArgsConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST, cargo.getPersons());
        assertEquals(EXPECTED_TYPE, cargo.getCargoType());
    }

    /**
     * This test checks if constructor only with double value works as expected.
     */
    @Test
    public void oneParamConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST, cargo.getPersons());
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

    /**
     * This test checks if no arguments constructor works as expected.
     */
    @Test
    public void noArgsConstructor_CreateInstance() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo();

        //assert
        assertEquals(0.0, cargo.getNecessaryInformation());
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

    /**
     * This test checks if setPersons works as expected.
     */
    @Test
    public void setPersons_ModifyPersonList() {
        //arrange
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_LIST);
        ArrayList<Person> newExpectedWeight = new ArrayList<>();

        //act
        cargo.setPersons(newExpectedWeight);

        //assert
        assertEquals(newExpectedWeight, cargo.getPersons());
    }

    /**
     * This test checks if implemented method getNecessaryInformation works as expected.
     */
    @Test
    public void getNecessaryInformation_returnPersonListSize() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST.size(), (int) cargo.getNecessaryInformation());
    }

    /**
     * This test checks if implemented method getType works as expected.
     */
    @Test
    public void getType_returnType() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

    @Test
    public void equals_True_ObjectsAreEqual(){
        //arrange
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);
        PeoplesCargo cargo1 = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //act
        boolean result = cargo.equals(cargo1);

        //assert
        assertTrue(result);
    }

    @Test
    public void equals_False_ObjectsAreNotEqual(){
        //arrange
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);
        PeoplesCargo cargo1 = new PeoplesCargo(TRANSPORT_TYPE.PRODUCT, EXPECTED_LIST);

        //act
        boolean result = cargo.equals(cargo1);

        //assert
        assertFalse(result);
    }

    @Test
    public void hashCode_SameHash_EqualObjects(){
        //arrange
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);
        PeoplesCargo cargo1 = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(cargo.hashCode(),cargo1.hashCode());
    }

    @Test
    public void hashCode_DifferentHash_DifferentObjects(){
        //arrange
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);
        PeoplesCargo cargo1 = new PeoplesCargo(TRANSPORT_TYPE.PRODUCT, EXPECTED_LIST);

        //assert
        assertNotSame(cargo.hashCode(),cargo1.hashCode());
    }
}
