package Cargos.Factory;

import Cargos.MaterialCargo;

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
