package Cargos;

import utility.TRANSPORT_TYPE;

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
