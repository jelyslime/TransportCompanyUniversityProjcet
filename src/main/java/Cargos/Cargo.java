package Cargos;

import utility.TRANSPORT_TYPE;

public abstract class Cargo implements CargoNecessaryInformation {
    TRANSPORT_TYPE type;

    public Cargo(TRANSPORT_TYPE type) {
        this.type = type;
    }


    public TRANSPORT_TYPE getType() {
        return type;
    }


    @Override
    public TRANSPORT_TYPE getCargoType() {
        return getType();
    }
}
