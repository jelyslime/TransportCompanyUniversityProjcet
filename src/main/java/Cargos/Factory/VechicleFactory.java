package Cargos.Factory;

import Cargos.Cargo;
import Cargos.MaterialCargo;
import Cargos.PeoplesCargo;

public class VechicleFactory {
    private static VechicleFactory vechicleFactory = null;

    private VechicleFactory() {

    }

    public static VechicleFactory getInstance() {
        if (vechicleFactory == null) {
            vechicleFactory = new VechicleFactory();
        }
        return vechicleFactory;
    }


    public <T extends Cargo> T createVechicle(VehicleArgsFor<T> args) {

        if (args instanceof PeopleArgs) {
            return (T) new PeoplesCargo(((PeopleArgs) args).getPersonArrayList());
        }
        if (args instanceof MaterialArgs) {
            return (T) new MaterialCargo(((MaterialArgs) args).getWeight());
        } else {
            throw new IllegalArgumentException("No valid factory for this argument list.");
        }
    }
}
