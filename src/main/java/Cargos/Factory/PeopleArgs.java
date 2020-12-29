package Cargos.Factory;

import Cargos.PeoplesCargo;
import Persons.Person;

import java.util.ArrayList;

public class PeopleArgs implements VehicleArgsFor<PeoplesCargo> {
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
