package Cargos;

import utility.TRANSPORT_TYPE;

public abstract class Cargo implements CargoNecessaryInformation {
    TRANSPORT_TYPE type;

    public Cargo(TRANSPORT_TYPE type) {
        this.type = type;
    }

    public Cargo() {
        this.type = TRANSPORT_TYPE.PRODUCT;
    }

    public TRANSPORT_TYPE getType() {
        return type;
    }

    public void setType(TRANSPORT_TYPE type) {
        this.type = type;
    }


    @Override
    public TRANSPORT_TYPE getCargoType() {
        return getType();
    }
}
