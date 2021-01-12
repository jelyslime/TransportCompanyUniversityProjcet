package utility.FeeCalculation;

import Cargos.CargoNecessaryInformation;

import java.math.BigDecimal;

/**
 * Interface for fee calculation.
 */
public interface FeeCalculator {
    BigDecimal calculateFee(CargoNecessaryInformation necessaryInformation);
}
