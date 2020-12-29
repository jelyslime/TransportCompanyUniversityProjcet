package Cargos;

import Cargos.Factory.CargoArgsFor;
import Cargos.Factory.MaterialArgs;
import Cargos.Factory.PeopleArgs;

/**
 * Factory for creating cargos.
 * To use properly see:
 *
 * @see CargoArgsFor
 */
public class CargoFactory {
    private static CargoFactory cargoFactory = null;

    private CargoFactory() {

    }

    /**
     * Method to adopt singleton design pattern.
     *
     * @return Single instance of factory
     */
    public static CargoFactory getInstance() {
        if (cargoFactory == null) {
            cargoFactory = new CargoFactory();
        }
        return cargoFactory;
    }

    /**
     * Factory method to create instances of cargo.
     * Method checks supported implementations of CargoArgsFor and create
     * concrete object
     *
     * @param args implementation of CargoArgsFor interface for the current instance desired to be created.
     * @param <T>  extends Cargo abstract class.
     * @return instance of Cargo
     * @throws IllegalArgumentException Throws when no mach of argument list is found
     * @see CargoArgsFor
     * @see Cargo
     */
    public <T extends Cargo> T createCargo(CargoArgsFor<T> args) {

        if (args instanceof PeopleArgs) {
            return (T) new PeoplesCargo(((PeopleArgs) args).getPersonArrayList());
        }
        if (args instanceof MaterialArgs) {
            return (T) new MaterialCargo(((MaterialArgs) args).getWeight());
        } else {
            throw new IllegalArgumentException("Argument type not supported.");
        }
    }
}
