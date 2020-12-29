package Cargos;

import Persons.Person;
import utility.TRANSPORT_TYPE;

import java.util.ArrayList;

public class PeoplesCargo extends Cargo {
    private ArrayList<Person> persons;

    public PeoplesCargo() {
        super(TRANSPORT_TYPE.PASSENGER);
        this.persons = new ArrayList<>();
    }

    public PeoplesCargo(ArrayList<Person> persons) {
        super(TRANSPORT_TYPE.PASSENGER);
        this.persons = persons;
    }

    public PeoplesCargo(TRANSPORT_TYPE type, ArrayList<Person> persons) {
        super(type);
        this.persons = persons;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    protected int getNumberOfPeoples() {
        return getPersons().size();
    }

    @Override
    public double getNecessaryInformation() {
        return getNumberOfPeoples();
    }
}
