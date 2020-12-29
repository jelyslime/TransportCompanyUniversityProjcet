package Cargos;

import utility.TRANSPORT_TYPE;

/**
 * Abstract class Cargo is on top of Cargos hierarchy.
 * Class implements CargoNecessaryInformation
 * <p>
 *
 * </p>
 * When using different types of cargos, it's preferable to use class Cargo when possible, for better code flexibility.
 *
 * @see Cargos.CargoNecessaryInformation
 */
public abstract class Cargo implements CargoNecessaryInformation {
    TRANSPORT_TYPE type;

    public Cargo(TRANSPORT_TYPE type) {
        this.type = type;
    }


    public TRANSPORT_TYPE getType() {
        return type;
    }

    /**
     * Implemented method from CargoNecessaryInformation.
     *
     * @return Type of the goods that are for transporting.
     * @see TRANSPORT_TYPE
     */
    @Override
    public TRANSPORT_TYPE getCargoType() {
        return getType();
    }
}
