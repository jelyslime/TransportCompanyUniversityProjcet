package utility.FeeCalculation;

import Cargos.CargoNecessaryInformation;

import java.math.BigDecimal;

public interface FeeCalculator {
    BigDecimal calculateFee(CargoNecessaryInformation necessaryInformation);
}
