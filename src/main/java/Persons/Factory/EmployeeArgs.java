package Persons.Factory;

import Persons.Employee;
import utility.CATEGORY;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Concrete implementation of interface PersonArgsFor, used by PersonFactory to store parameters for Employee.
 *
 * @see PersonArgsFor
 * @see Persons.PersonFactory
 * @see Employee
 */
public class EmployeeArgs implements PersonArgsFor<Employee> {
    private final String name;
    private final BigDecimal salary;
    private final CATEGORY category;

    public EmployeeArgs(String name, BigDecimal salary, CATEGORY category) {
        if (Objects.isNull(name)) {
            this.name = "";
        } else {
            this.name = name;
        }

        if (Objects.isNull(salary)) {
            this.salary = BigDecimal.ZERO;
        } else {
            this.salary = salary;
        }

        if (Objects.isNull(category)) {
            this.category = CATEGORY.B;
        } else {
            this.category = category;
        }
    }

    public EmployeeArgs() {
        name = "";
        salary = BigDecimal.ZERO;
        category = CATEGORY.B;
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
