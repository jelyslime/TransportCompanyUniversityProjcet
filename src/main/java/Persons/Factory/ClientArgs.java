package Persons.Factory;

import Cargos.Cargo;
import Persons.Client;

import java.math.BigDecimal;

/**
 * Concrete implementation of interface PersonArgsFor, used by PersonFactory to store parameters for Client.
 *
 * @see PersonArgsFor
 * @see Persons.PersonFactory
 * @see Client
 */
public class ClientArgs implements PersonArgsFor<Client> {
    private String name;
    private BigDecimal budget;
    private Cargo cargo;

    public ClientArgs(String name, BigDecimal budget, Cargo cargo) {
        this.name = name;
        this.budget = budget;
        this.cargo = cargo;
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
