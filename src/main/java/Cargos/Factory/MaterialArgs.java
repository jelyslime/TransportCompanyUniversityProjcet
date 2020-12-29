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
    private double weight;

    public MaterialArgs(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
