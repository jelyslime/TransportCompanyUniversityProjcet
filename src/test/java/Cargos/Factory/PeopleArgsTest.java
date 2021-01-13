package Cargos.Factory;

import Persons.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Unit tests for PeopleArgs.
 *
 * @see PeopleArgs
 */
@RunWith(JUnit4.class)
public class PeopleArgsTest {

    @Test
    public void allArgsConstructor_CreateEmptyList_ArgumentIsNull() {
        //arrange & act
        PeopleArgs peopleArgs = new PeopleArgs(null);

        //assert
        assertEquals(new ArrayList<Person>(), peopleArgs.getPersonArrayList());
    }

    @Test
    public void noArgsConstructor_CreateInstance() {
        PeopleArgs peopleArgs = new PeopleArgs();

        //assert
        assertNotNull(peopleArgs);
    }

    /**
     * Test checks if getPersonArrayList works as expected
     */
    @Test
    public void getPersonArrayList_ReturnPropList() {
        //arrange
        ArrayList<Person> EXPECTED_LIST = new ArrayList<>();
        PeopleArgs peopleArgs = new PeopleArgs(EXPECTED_LIST);

        //act & assert
        assertEquals(EXPECTED_LIST, peopleArgs.getPersonArrayList());
    }

    /**
     * Test checks if setPersonArrayList works as expected
     */
    @Test
    public void setPersonArrayList_ModifyPropList() {
        //arrange
        ArrayList<Person> EXPECTED_LIST = new ArrayList<>();
        PeopleArgs peopleArgs = new PeopleArgs(new ArrayList<>());

        //act
        peopleArgs.setPersonArrayList(EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST, peopleArgs.getPersonArrayList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPersonArrayList_ThrowsIllegalArgumentException() {
        //arrange
        PeopleArgs peopleArgs = new PeopleArgs(new ArrayList<>());

        //act
        peopleArgs.setPersonArrayList(null);

    }

}
