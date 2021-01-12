package Persons;

import Cargos.Cargo;
import Cargos.CargoFactory;
import Cargos.Factory.MaterialArgs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Mutable class. A {@code Client} consists of logical information for
 * client working with an transport company.
 * <p>
 * It contains information for the budget of the client and desired cargo to be transported.
 * </p>
 *
 * <p>
 * Class haves an factory which is recommended for creating instances of {@code Client}.
 * </p>
 *
 * @author Vladislav Zlatanov
 */
public class Client extends Person implements Serializable {
    private BigDecimal budget; //Client's budget
    private Cargo cargo; //Cargo to be transported

    /**
     * Protected all args constructor.
     *
     * @param name   name of the client.
     * @param budget client's budget.
     * @param cargo  cargo that client want to transport.
     */
    protected Client(String name, BigDecimal budget, Cargo cargo) {
        super(name);
        this.budget = budget;
        this.cargo = cargo;
    }

    /**
     * Protected no args constructor.
     */
    protected Client() {
        super();
        budget = new BigDecimal("0.0");
        cargo = CargoFactory.getInstance().createCargo(new MaterialArgs(0));
    }


    /**
     * auto-generated getter.
     *
     * @return client's budget.
     */
    public BigDecimal getBudget() {
        return budget;
    }

    /**
     * auto-generated setter
     *
     * @param budget budget of employee
     * @throws IllegalArgumentException when argument is null.
     */
    public void setBudget(BigDecimal budget) {
        if (Objects.isNull(budget)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.budget = budget;
    }

    /**
     * auto-generated setter
     *
     * @return cargo that client wants to transport
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * auto-generated setter
     *
     * @param cargo cargo that client wants to transport
     * @throws IllegalArgumentException when argument is null.
     */
    public void setCargo(Cargo cargo) {
        if (Objects.isNull(cargo)) {
            throw new IllegalArgumentException("Argument is null.");
        }
        this.cargo = cargo;
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
        Client client = (Client) o;
        return Objects.equals(budget, client.budget) &&
                Objects.equals(cargo, client.cargo);
    }

    /**
     * Auto-generated hashCode
     *
     * @return hash of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), budget, cargo);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + getName() + '\'' +
                "budget=" + budget +
                ", cargo=" + cargo +
                '}';
    }
}
