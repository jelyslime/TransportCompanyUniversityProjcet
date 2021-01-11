package Persons.Factory;

import Cargos.Cargo;
import Cargos.CargoFactory;
import Cargos.Factory.MaterialArgs;
import Persons.Client;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Concrete implementation of interface PersonArgsFor, used by PersonFactory to store parameters for Client.
 *
 * @see PersonArgsFor
 * @see Persons.PersonFactory
 * @see Client
 */
public class ClientArgs implements PersonArgsFor<Client> {
    private final String name;
    private final BigDecimal budget;
    private final Cargo cargo;

    public ClientArgs(String name, BigDecimal budget, Cargo cargo) {
        if (Objects.isNull(name)) {
            this.name = "";
        } else {
            this.name = name;
        }

        if (Objects.isNull(budget)) {
            this.budget = BigDecimal.ZERO;
        } else {
            this.budget = budget;
        }

        if (Objects.isNull(cargo)) {
            this.cargo = CargoFactory.getInstance().createCargo(new MaterialArgs());
        } else {
            this.cargo = cargo;
        }
    }

    public ClientArgs() {
        name = "";
        budget = BigDecimal.ZERO;
        cargo = CargoFactory.getInstance()
                .createCargo(new MaterialArgs());
    }

    public String getName() {
        return name;
    }


    public BigDecimal getBudget() {
        return budget;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
