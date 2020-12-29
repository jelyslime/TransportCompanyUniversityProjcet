package Cargos.Factory;

import Persons.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for PeopleArgs.
 *
 * @see PeopleArgs
 */
@RunWith(JUnit4.class)
public class PeopleArgsTest {

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

}
