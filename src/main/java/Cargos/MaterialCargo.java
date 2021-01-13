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
    private double CargoWeight; //weight of cargo

    /**
     * Protected no args constructor
     */
    protected MaterialCargo() {
        super(TRANSPORT_TYPE.PRODUCT);
        this.CargoWeight = 0;
    }

    /**
     * public constructor
     * <p>
     * Using factory is recommended.
     *
     * @param cargoWeight weight of the cargo
     */
    protected MaterialCargo(double cargoWeight) {
        super(TRANSPORT_TYPE.PRODUCT);
        CargoWeight = cargoWeight;
    }

    /**
     * public all args constructor.
     * <p>
     * Using factory is recommended.
     *
     * @param type        type of the transport.
     * @param cargoWeight weight of the cargo.
     */
    protected MaterialCargo(TRANSPORT_TYPE type, double cargoWeight) {
        super(type);
        CargoWeight = cargoWeight;
    }

    /**
     * Auto-generated getter.
     *
     * @return weight of cargo.
     */
    public double getCargoWeight() {
        return CargoWeight;
    }

    /**
     * Auto-generated setter
     *
     * @param cargoWeight weight of the cargo to be set.
     * @throws IllegalArgumentException when argument is null.
     */
    public void setCargoWeight(double cargoWeight) {
        if (cargoWeight < 0) {
            throw new IllegalArgumentException("Value is negative.");
        }
        CargoWeight = cargoWeight;
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
        MaterialCargo cargo = (MaterialCargo) o;
        return Double.compare(cargo.CargoWeight, CargoWeight) == 0;
    }

    /**
     * Auto-generated hashCode
     *
     * @return hash of this object
     */
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
