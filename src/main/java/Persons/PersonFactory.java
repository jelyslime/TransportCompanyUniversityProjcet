package Persons;

import Persons.Factory.ClientArgs;
import Persons.Factory.EmployeeArgs;
import Persons.Factory.PersonArgsFor;

/**
 * Factory for creating persons.
 * To use properly see:
 *
 * @see PersonArgsFor
 */
public class PersonFactory {
    private static PersonFactory personFactory = null;

    private PersonFactory() {

    }

    /**
     * Method to adopt singleton design pattern.
     *
     * @return Single instance of factory
     */
    public static PersonFactory getInstance() {
        if (personFactory == null) {
            personFactory = new PersonFactory();
        }
        return personFactory;
    }

    /**
     * Factory method to create instances of persons.
     * Method checks supported implementations of PersonArgsFor and create
     * concrete object
     *
     * @param args implementation of PersonArgsFor interface for the current instance desired to be created.
     * @param <T>  extends Person abstract class.
     * @return instance of Person
     * @throws IllegalArgumentException Throws when no mach of argument list is found
     * @see PersonArgsFor
     * @see Person
     */
    public <T extends Person> T createPerson(PersonArgsFor<T> args) {
        if (args instanceof ClientArgs) {
            return (T) new Client(((ClientArgs) args).getName(),
                    ((ClientArgs) args).getBudget(),
                    ((ClientArgs) args).getCargo());
        } else if (args instanceof EmployeeArgs) {
            return (T) new Employee(((EmployeeArgs) args).getName(),
                    ((EmployeeArgs) args).getSalary(),
                    ((EmployeeArgs) args).getCategory());
        } else {
            throw new IllegalArgumentException("Argument type not supported.");
        }
    }
}
