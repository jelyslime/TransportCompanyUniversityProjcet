package Cargos;

import Persons.Person;
import utility.TRANSPORT_TYPE;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class represent humans as a value that haves to be transported.
 * <p></p>
 * Inherited from abstract class Cargo.
 *
 * @see Cargo
 */
public class PeoplesCargo extends Cargo {
    private ArrayList<Person> persons;

    protected PeoplesCargo() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PeoplesCargo that = (PeoplesCargo) o;
        return Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), persons);
    }

    @Override
    public String toString() {
        return "PeoplesCargo{" +
                "persons=" + persons +
                '}';
    }

    /**
     * Implemented method from CargoNecessaryInformation.
     *
     * @return total number of persons to be transported.
     */
    @Override
    public double getNecessaryInformation() {
        return getNumberOfPeoples();
    }
}
