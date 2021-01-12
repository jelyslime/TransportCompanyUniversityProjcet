package Persons;

import utility.CATEGORY;

import java.math.BigDecimal;
import java.util.Objects;
/**
 * Mutable class. A {@code Employee} consists of logical information for
 * employees working in the company.
 * <p>
 * It contains information for the salary of the employee and driving license category.
 * </p>
 *
 * <p>
 * Class haves an factory which is recommended for creating instances of {@code Employee}.
 * </p>
 *
 * @author Vladislav Zlatanov
 */
public class Employee extends Person {
    private BigDecimal salary;
    private CATEGORY category;

    /**
     * Protected all args constructor.
     *
     * @param name name of employee
     * @param salary employee salary
     * @param category category of driving license
     */
    protected Employee(String name, BigDecimal salary, CATEGORY category) {
        super(name);
        this.salary = salary;
        this.category = category;
    }

    /**
     * Protected no args constructor.
     */
    protected Employee() {
        super();
        this.salary = new BigDecimal("0.0");
        this.category = CATEGORY.B;
    }

    /**
     * Auto generated getter
     * @return employee salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * setter
     *
     * @param salary sets salary of employee
     *               @throws IllegalArgumentException when argument is null.
     */
    public void setSalary(BigDecimal salary) {
        if (Objects.isNull(salary)) {
            throw new IllegalArgumentException("Argument is null");
        }
        this.salary = salary;
    }

    /**
     * getter
     * @return driving license category of employee.
     */
    public CATEGORY getCategory() {
        return category;
    }

    /**
     *
     * @param category driving license category
     *                 @throws IllegalArgumentException when argument is null.
     */
    public void setCategory(CATEGORY category) {
        if (Objects.isNull(category)) {
            throw new IllegalArgumentException("Argument is null");
        }
        this.category = category;
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
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary) &&
                category == employee.category;
    }

    /**
     * Auto-generated hashCode
     *
     * @return hash of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, category);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                "salary=" + salary +
                ", category=" + category +
                '}';
    }
}
