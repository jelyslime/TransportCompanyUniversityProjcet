package Persons;

import Cargos.Cargo;
import Cargos.CargoFactory;
import Cargos.Factory.MaterialArgs;

import java.math.BigDecimal;
import java.util.Objects;

public class Client extends Person {
    private BigDecimal budget;
    private Cargo cargo;

    protected Client(String name, BigDecimal budget, Cargo cargo) {
        super(name);
        this.budget = budget;
        this.cargo = cargo;
    }

    protected Client() {
        super();
        budget = new BigDecimal("0.0");
        cargo = CargoFactory.getInstance().createCargo(new MaterialArgs(0));
    }


    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(budget, client.budget) &&
                Objects.equals(cargo, client.cargo);
    }

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
