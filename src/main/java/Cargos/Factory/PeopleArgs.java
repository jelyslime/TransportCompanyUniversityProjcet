package Cargos.Factory;

import Cargos.PeoplesCargo;
import Persons.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Concrete implementation of interface PeopleArgs, used by CargoFactory to store parameters for PeoplesCargo.
 *
 * @see Cargos.Factory.CargoArgsFor
 * @see Cargos.CargoFactory
 * @see PeoplesCargo
 */
public class PeopleArgs implements CargoArgsFor<PeoplesCargo> {
    private List<Person> personArrayList; //persons that have to be transported

    public PeopleArgs(ArrayList<Person> personArrayList) {
        if (Objects.isNull(personArrayList)) {
            this.personArrayList = new ArrayList<>();
        }
        this.personArrayList = personArrayList
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public PeopleArgs() {
        this.personArrayList = new ArrayList<>();
    }

    public List<Person> getPersonArrayList() {
        return personArrayList;
    }

    /**
     * Auto-generated setter
     * @param list list of persons that have to be transported.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setPersonArrayList(List<Person> list) {
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException("Argument is null");
        }

        this.personArrayList = list
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
