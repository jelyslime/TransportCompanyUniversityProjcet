package Persons;

import utility.CATEGORY;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee extends Person {
    private BigDecimal salary;
    private CATEGORY category;

    protected Employee(String name, BigDecimal salary, CATEGORY category) {
        super(name);
        this.salary = salary;
        this.category = category;
    }

    protected Employee() {
        super();
        this.salary = new BigDecimal("0.0");
        this.category = CATEGORY.B;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        if (Objects.isNull(salary)) {
            throw new IllegalArgumentException("Argument is null");
        }
        this.salary = salary;
    }

    public CATEGORY getCategory() {
        return category;
    }

    public void setCategory(CATEGORY category) {
        if (Objects.isNull(category)) {
            throw new IllegalArgumentException("Argument is null");
        }
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary) &&
                category == employee.category;
    }

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
