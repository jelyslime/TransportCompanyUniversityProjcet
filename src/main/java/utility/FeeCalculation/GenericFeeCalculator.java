package utility.FeeCalculation;

import Cargos.CargoNecessaryInformation;
import utility.TRANSPORT_TYPE;

import java.math.BigDecimal;

public class GenericFeeCalculator implements FeeCalculator{
    private static GenericFeeCalculator genericFeeCalculator = null;

    private GenericFeeCalculator() {

    }

    /**
     * Method to adopt singleton design pattern.
     *
     * @return Single instance of calculator
     */
    public static GenericFeeCalculator getInstance() {
        if (genericFeeCalculator == null) {
            genericFeeCalculator = new GenericFeeCalculator();
        }
        return genericFeeCalculator;
    }

    /**
     * Method calculates fee per km for transporting certain cargo.
     *
     * @param necessaryInformation an instance of CargoNecessaryInformation.
     * @see CargoNecessaryInformation
     * @return Cost to transport cargo per km
     */
    @Override
    public BigDecimal calculateFee(CargoNecessaryInformation necessaryInformation) {
        BigDecimal costByCategory = evaluateExpenseBasedOnCategory(necessaryInformation.getCargoType());
        BigDecimal costToBeReturned = BigDecimal.valueOf(necessaryInformation.getNecessaryInformation());
        return costToBeReturned
                .multiply(costByCategory)
                .divide(new BigDecimal(2.0));
    }

    /**
     *
     * @param transport_type Type of the cargo.
     * @return multiplayer for calculateFee method for further calculations.
     * @see TRANSPORT_TYPE
     */
    protected BigDecimal evaluateExpenseBasedOnCategory(TRANSPORT_TYPE transport_type){
       if (transport_type.equals(TRANSPORT_TYPE.PRODUCT)){
           return new BigDecimal("1.5");
       } else if(transport_type.equals(TRANSPORT_TYPE.PASSENGER)){
           return new BigDecimal("2.0");
       }else {
           return new BigDecimal("1.0");
       }
    }
}
