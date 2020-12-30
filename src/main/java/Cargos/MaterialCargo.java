package Cargos;

import utility.TRANSPORT_TYPE;

import java.util.Objects;

/**
 * Class represent cargos who are not any known form of live.
 * Inherited from abstract class Cargo.
 * Cargo dimensions are ignored.
 *
 * @see Cargo
 */
public class MaterialCargo extends Cargo {
    private double CargoWeight;

    protected MaterialCargo() {
        super(TRANSPORT_TYPE.PRODUCT);
        this.CargoWeight = 0;
    }

    protected MaterialCargo(double cargoWeight) {
        super(TRANSPORT_TYPE.PRODUCT);
        CargoWeight = cargoWeight;
    }

    protected MaterialCargo(TRANSPORT_TYPE type, double cargoWeight) {
        super(type);
        CargoWeight = cargoWeight;
    }

    public double getCargoWeight() {
        return CargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        CargoWeight = cargoWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaterialCargo cargo = (MaterialCargo) o;
        return Double.compare(cargo.CargoWeight, CargoWeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), CargoWeight);
    }

    @Override
    public String toString() {
        return "MaterialCargo{" +
                "CargoWeight=" + CargoWeight +
                ", type=" + getType() +
                '}';
    }

    /**
     * Implemented method from CargoNecessaryInformation.
     *
     * @return total weight of cargo.
     */
    @Override
    public double getNecessaryInformation() {
        return getCargoWeight();
    }


}
