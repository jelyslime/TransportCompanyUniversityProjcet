package Vechicles;

import utility.TRANSPORT_TYPE;
import Vehicles.VEHICLE_TYPE;
import Vehicles.Vehicle;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import utility.CATEGORY;

import java.math.BigDecimal;

import static junit.framework.TestCase.*;

/**
 * This class is a unit test class for Vehicle
 *
 * @see Vehicles.Vehicle
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class VechicleTest {

    private static Vehicle vehicle;

    /**
     * Method to initialise parameters to test instance
     *
     *
     *
     */
    @BeforeClass
    public static void init() {
        vehicle = new Vehicle
                .VechicleBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vechicleType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();
    }

    /**
     * This test checks if withCategory of VechicleBuilder inner class method will set category to Vehicle instance.
     *
     * @see Vehicles.Vehicle.VechicleBuilder
     *
     */
    @Test
    public void withCategory_SetVehicleCategory_BuilderWorks() {
        //assert
        assertEquals(CATEGORY.C, vehicle.getCategoryRequired());
    }

    /**
     * This test checks if withMaximumCapacity of VechicleBuilder inner class method will set the max capacity value to Vehicle instance.
     *
     * @see Vehicles.Vehicle.VechicleBuilder
     *
     */
    @Test
    public void withMaximumCapacity_SetVehicleMaxCapacity_BuilderWorks() {
        //assert
        assertEquals(5.0, vehicle.getMaximumCapacity());
    }

    /**
     * This test checks if withPricePerKm of VechicleBuilder inner class method will set the correct price per km value to Vehicle instance.
     *
     * @see Vehicles.Vehicle.VechicleBuilder
     *
     */
    @Test
    public void withPricePerKm_SetVehiclePricePerKm_BuilderWorks() {
        //assert
        assertEquals(new BigDecimal("3.23"), vehicle.getPricePerKm());
    }

    /**
     * This test checks if vechicleType of VechicleBuilder inner class method will set the correct vechicle type to Vehicle instance.
     *
     * @see Vehicles.Vehicle.VechicleBuilder
     *
     */
    @Test
    public void vechicleType_SetVehicleType_BuilderWorks() {
        //assert
        assertEquals(VEHICLE_TYPE.BANICHARKA, vehicle.getVehicleType());
    }

    /**
     * This test checks if transportType of VechicleBuilder inner class method will set the correct transport type to Vehicle instance.
     *
     * @see Vehicles.Vehicle.VechicleBuilder
     *
     */
    @Test
    public void transportType_SetVehicleTransportType_BuilderWorks() {
        //assert
        assertEquals(TRANSPORT_TYPE.PASSENGER, vehicle.getTransportType());
    }


    /**
     * This test checks if equals method will return false when comparing two different objects
     *
     */
    @Test
    public void equals_False_ObjectsAreDifferent() {
        //arrange & act
        Vehicle vehicle3 = new Vehicle
                .VechicleBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vechicleType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();

        //assert
        assertFalse(vehicle3.equals(vehicle));

    }

    /**
     * This test checks if hashCode method will return different hashes when different same object
     *
     */
    @Test
    public void hashCode_False_ObjectsAreDifferent() {
        //arrange & act
        Vehicle vehicle3 = new Vehicle
                .VechicleBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vechicleType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();

        //assert
        assertFalse(vehicle.hashCode() == vehicle3.hashCode());
    }

    /**
     * This test checks if hashCode method will return same hashes when hashing same object
     *
     */
    @Test
    public void hashCode_True_ObjectsAreSame() {
        //assert
        assertEquals(vehicle.hashCode(), vehicle.hashCode());
    }


    /**
     * This test checks if the value of Id will auto-increase upon creation of new object
     *
     */
    @Test
    public void vehicleId_IncreaseAtNewInstantions_ObjectCreated() {
        //arrange & act
        Vehicle vehicle4 = new Vehicle
                .VechicleBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vechicleType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();

        //assert
        assertEquals(4, vehicle4.getVehicleId());
    }

    /**
     * This test check if toString method works as expected.
     * If the method works, it should at least write "vehicleId ="
     * plus the value of the id
     */
    @Test
    public void toString_OutputAtLeastVehicle() {
        //arrange & act
        String toString = vehicle.toString();

        assertTrue(toString.contains("vehicleId=" + vehicle.getVehicleId()));
    }

}
