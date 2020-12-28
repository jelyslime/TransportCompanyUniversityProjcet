package Cargos;

public class MaterialCargo extends Cargo{
    private double CargoWeight;

    public MaterialCargo(double cargoWeight) {
        CargoWeight = cargoWeight;
    }

    public double getCargoWeight() {
        return CargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        CargoWeight = cargoWeight;
    }

    @Override
    public double getNecessaryInformation() {
        return getCargoWeight();
    }
}
