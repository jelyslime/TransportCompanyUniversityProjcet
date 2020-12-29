package Cargos;

import Cargos.Factory.CargoArgsFor;
import Cargos.Factory.MaterialArgs;
import Cargos.Factory.PeopleArgs;

public class CargoFactory {
    private static CargoFactory cargoFactory = null;

    private CargoFactory() {

    }

    public static CargoFactory getInstance() {
        if (cargoFactory == null) {
            cargoFactory = new CargoFactory();
        }
        return cargoFactory;
    }


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
