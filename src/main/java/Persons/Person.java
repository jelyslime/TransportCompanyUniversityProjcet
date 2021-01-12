package Persons;

import java.util.Objects;

/**
 * Mutable class. A {@code Person} consists of logical information for
 * an person
 * <p>
 * It contains information for the person's name.
 *
 * @author Vladislav Zlatanov
 */
public abstract class Person {
    private String name; //name of the persons

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    /**
     * auto-generated setter.
     *
     * @param name name of the person
     * @throws IllegalArgumentException when argument is null.
     */
    public void setName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.name = name;
    }

    /**
     * Compare this {@code Person} with the specified {@code Object } for equality.
     *
     * @param o {@code Object} to which this {@code Person} is to be compared.
     * @return {@code true} if the specified {@code Object} is a {@code Person}
     * which values are equal to {@code Person}'s
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
