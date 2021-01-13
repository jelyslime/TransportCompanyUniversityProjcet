package Cargos;

import Persons.Person;
import utility.TRANSPORT_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class represent humans as a value that haves to be transported.
 * <p></p>
 * Inherited from abstract class Cargo.
 *
 * @see Cargo
 */
public class PeoplesCargo extends Cargo {
    private List<Person> persons; //persons to be transported

    /**
     * Protected no args constructor
     */
    protected PeoplesCargo() {
        super(TRANSPORT_TYPE.PASSENGER);
        this.persons = new ArrayList<>();
    }

    /**
     * public constructor
     * <p>
     * Using factory is recommended.
     *
     * @param persons persons to be added
     */
    public PeoplesCargo(List<Person> persons) {
        super(TRANSPORT_TYPE.PASSENGER);
        if (Objects.isNull(persons)) {
            this.persons = new ArrayList<>();
        }
        this.persons = persons
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * public all args constructor
     * <p>
     * Using factory is recommended.
     *
     * @param type    type of the transport
     * @param persons persons to be added
     */
    public PeoplesCargo(TRANSPORT_TYPE type, List<Person> persons) {
        super(type);
        if (Objects.isNull(persons)) {
            this.persons = new ArrayList<>();
        }
        this.persons = persons
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Person> getPersons() {
        return persons;
    }

    /**
     * Auto generated setter.
     *
     * @param persons persons to be transported.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setPersons(List<Person> persons) {
        if (Objects.isNull(persons)) {
            throw new IllegalArgumentException("Argument is null");
        }
        this.persons = persons
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Method gets the number of people that have to be transported.
     *
     * @return number of people.
     */
    protected int getNumberOfPeoples() {
        return getPersons().size();
    }

    /**
     * Auto-generated equals
     *
     * @param o object to check for equality with this.
     * @return true if objects are equal, false if objects are not equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PeoplesCargo that = (PeoplesCargo) o;
        return Objects.equals(persons, that.persons);
    }

    /**
     * Auto-generated hashCode
     *
     * @return hash of this object
     */
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
