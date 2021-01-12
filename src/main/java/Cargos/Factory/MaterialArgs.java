package Cargos.Factory;

import Cargos.MaterialCargo;

/**
 * Concrete implementation of interface CargoArgsFor, used by CargoFactory to store parameters for MaterialCargo.
 *
 * @see Cargos.Factory.CargoArgsFor
 * @see Cargos.CargoFactory
 * @see MaterialCargo
 */
public class MaterialArgs implements CargoArgsFor<MaterialCargo> {
    private double weight; //weight of the cargo.

    public MaterialArgs(double weight) {
        this.weight = weight;
    }

    public MaterialArgs() {
        weight = 0;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Auto-generated setter
     * @param weight weight of the cargo
     * @throws IllegalArgumentException when argument is null.
     */
    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Value is negative.");
        }
        this.weight = weight;
    }
}
