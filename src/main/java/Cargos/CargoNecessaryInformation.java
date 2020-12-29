package Cargos;

import utility.TRANSPORT_TYPE;

/**
 * Interface for obtaining the required information from an cargo.
 */
public interface CargoNecessaryInformation {

    double getNecessaryInformation();

    TRANSPORT_TYPE getCargoType();
}
