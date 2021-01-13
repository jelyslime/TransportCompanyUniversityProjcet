package Cargos;

import utility.TRANSPORT_TYPE;

import java.util.Objects;

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
    private final TRANSPORT_TYPE type; //type of the transport

    /**
     * Protected all-args constructor
     *
     * @param type type of the transport.
     */
    protected Cargo(TRANSPORT_TYPE type) {
        this.type = type;
    }


    /**
     * Auto-generated getter
     *
     * @return type of the transport
     */
    public TRANSPORT_TYPE getType() {
        return type;
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
        Cargo cargo = (Cargo) o;
        return type == cargo.type;
    }

    /**
     * Auto-generated hashCode
     *
     * @return hash of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "type=" + type +
                '}';
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
