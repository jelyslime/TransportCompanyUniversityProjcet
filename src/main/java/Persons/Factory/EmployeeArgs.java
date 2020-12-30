package Persons.Factory;

import Persons.Employee;
import utility.CATEGORY;

import java.math.BigDecimal;

/**
 * Concrete implementation of interface PersonArgsFor, used by PersonFactory to store parameters for Employee.
 *
 * @see PersonArgsFor
 * @see Persons.PersonFactory
 * @see Employee
 */
public class EmployeeArgs implements PersonArgsFor<Employee> {
    private String name;
    private BigDecimal salary;
    private CATEGORY category;

    public EmployeeArgs(String name, BigDecimal salary, CATEGORY category) {
        this.name = name;
        this.salary = salary;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public CATEGORY getCategory() {
        return category;
    }

}
