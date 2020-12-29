package Cargos.Factory;

import Cargos.PeoplesCargo;
import Persons.Person;

import java.util.ArrayList;

/**
 * Concrete implementation of interface PeopleArgs, used by CargoFactory to store parameters for PeoplesCargo.
 *
 * @see Cargos.Factory.CargoArgsFor
 * @see Cargos.CargoFactory
 * @see PeoplesCargo
 */
public class PeopleArgs implements CargoArgsFor<PeoplesCargo> {
    private ArrayList<Person> personArrayList;

    public PeopleArgs(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }
}
