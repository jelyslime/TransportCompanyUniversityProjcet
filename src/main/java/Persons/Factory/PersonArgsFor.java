package Persons.Factory;

import Persons.Person;

/**
 * Interface serve as an markup interface for person factory
 *
 * @param <T> interface is tied to T, the compiler can infer the rest when choosing what to build in factory.
 *
 *            <p>
 * @see Persons.PersonFactory Concreate factory that uses interface.
 * </p>
 * @see ClientArgs Excample of interface implementaiton.
 */
public interface PersonArgsFor<T extends Person> {
}
