package Vehicles;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import utility.CATEGORY;
import utility.TRANSPORT_TYPE;

import java.math.BigDecimal;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

/**
 * This class is a unit test class for Vehicle
 *
 * @see Vehicles.Vehicle
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class VehiclesTest {

    private static Vehicle vehicle;

    /**
     * Method to initialise parameters to test instance
     */
    @BeforeClass
    public static void init() {
        vehicle = new Vehicle.VehiclesBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vehiclesType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();
    }

    /**
     * This test checks if withCategory of VehicleBuilder inner class method will set category to Vehicle instance.
     *
     * @see Vehicle.VehiclesBuilder
     */
    @Test
    public void withCategory_SetVehicleCategory_BuilderWorks() {
        //assert
        assertEquals(CATEGORY.C, vehicle.getCategoryRequired());
    }

    /**
     * This test checks if withMaximumCapacity of VehicleBuilder inner class method will set the max capacity value to Vehicle instance.
     *
     * @see Vehicle.VehiclesBuilder
     */
    @Test
    public void withMaximumCapacity_SetVehicleMaxCapacity_BuilderWorks() {
        //assert
        assertEquals(5.0, vehicle.getMaximumCapacity());
    }

    /**
     * This test checks if withPricePerKm of VehicleBuilder inner class method will set the correct price per km value to Vehicle instance.
     *
     * @see Vehicle.VehiclesBuilder
     */
    @Test
    public void withPricePerKm_SetVehiclePricePerKm_BuilderWorks() {
        //assert
        assertEquals(new BigDecimal("3.23"), vehicle.getPricePerKm());
    }

    /**
     * This test checks if vehicleType of VehicleBuilder inner class method will set the correct vehicle type to Vehicle instance.
     *
     * @see Vehicle.VehiclesBuilder
     */
    @Test
    public void vehicleType_SetVehicleType_BuilderWorks() {
        //assert
        assertEquals(VEHICLE_TYPE.BANICHARKA, vehicle.getVehicleType());
    }

    /**
     * This test checks if transportType of VehicleBuilder inner class method will set the correct transport type to Vehicle instance.
     *
     * @see Vehicle.VehiclesBuilder
     */
    @Test
    public void transportType_SetVehicleTransportType_BuilderWorks() {
        //assert
        assertEquals(TRANSPORT_TYPE.PASSENGER, vehicle.getTransportType());
    }


    /**
     * This test checks if equals method will return false when comparing two different objects
     */
    @Test
    public void equals_False_ObjectsAreDifferent() {
        //arrange & act
        Vehicle vehicle3 = new Vehicle.VehiclesBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vehiclesType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();

        //assert
        assertNotEquals(vehicle3, vehicle);

    }

    /**
     * This test checks if hashCode method will return different hashes when different same object
     */
    @Test
    public void hashCode_False_ObjectsAreDifferent() {
        //arrange & act
        Vehicle vehicle3 = new Vehicle.VehiclesBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vehiclesType(VEHICLE_TYPE.BANICHARKA)
                .withCategory(CATEGORY.C)
                .withMaximumCapacity(5)
                .withPricePerKm(new BigDecimal("3.23"))
                .build();

        //assert
        assertFalse(vehicle.hashCode() == vehicle3.hashCode());
    }

    /**
     * This test checks if hashCode method will return same hashes when hashing same object
     */
    @Test
    public void hashCode_True_ObjectsAreSame() {
        //assert
        assertEquals(vehicle.hashCode(), vehicle.hashCode());
    }


    /**
     * This test checks if the value of Id will auto-increase upon creation of new object
     */
    @Test
    public void vehicleId_IncreaseAtNewInstantiation_ObjectCreated() {
        //arrange & act
        Vehicle vehicle4 = new Vehicle.VehiclesBuilder()
                .transportType(TRANSPORT_TYPE.PASSENGER)
                .vehiclesType(VEHICLE_TYPE.BANICHARKA)
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
