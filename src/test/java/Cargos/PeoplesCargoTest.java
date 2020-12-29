package Cargos;

import Persons.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utility.TRANSPORT_TYPE;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class PeoplesCargoTest {
    private ArrayList<Person> EXPECTED_LIST = new ArrayList<>();
    private TRANSPORT_TYPE EXPECTED_TYPE = TRANSPORT_TYPE.PASSENGER;

    @Test
    public void allArgsConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST, cargo.getPersons());
        assertEquals(EXPECTED_TYPE, cargo.getCargoType());
    }

    @Test
    public void oneParamConstructor_CreateInstance_ValidArguments() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST, cargo.getPersons());
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

    @Test
    public void noArgsConstructor_CreateInstance() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo();

        //assert
        assertEquals(0.0, cargo.getNecessaryInformation());
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }

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

    @Test
    public void getNecessaryInformation_returnPersonListSize() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_LIST.size(), (int) cargo.getNecessaryInformation());
    }

    @Test
    public void getType_returnType() {
        //arrange & act
        PeoplesCargo cargo = new PeoplesCargo(EXPECTED_TYPE, EXPECTED_LIST);

        //assert
        assertEquals(EXPECTED_TYPE, cargo.getType());
    }
}
