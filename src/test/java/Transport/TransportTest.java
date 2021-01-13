package Transport;

import Cargos.Cargo;
import Cargos.CargoFactory;
import Cargos.Factory.MaterialArgs;
import Persons.Client;
import Persons.Employee;
import Persons.Factory.ClientArgs;
import Persons.Factory.EmployeeArgs;
import Persons.PersonFactory;
import Vehicles.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import utility.CATEGORY;
import utility.FeeCalculation.GenericFeeCalculator;

import java.math.BigDecimal;
import java.util.Date;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class TransportTest {
    private final double destination = 0.0;
    private final boolean isPayed = false;
    @Spy
    private Transport transport;
    @Mock
    private Date dateOfBegin;
    @Mock
    private Date dateOfEnd;
    @Mock
    private Cargo cargo2;
    @Mock
    private Client client;
    private Cargo cargo;
    @Mock
    private BigDecimal priceForTransport;

    @Mock
    private Employee employee;

    @Mock
    private Vehicle vehicle;

    @Mock
    private Vehicle vehicle1;

    @Before
    public void init() {
        cargo = CargoFactory.getInstance().createCargo(new MaterialArgs(500));
        doReturn(cargo).when(client).getCargo();
        //doReturn(priceForTransport).when(genericFeeCalculator).calculateFee(cargo);
        //doReturn(priceForTransport).when(transport).calculateTransportPrice();
        transport = new Transport
                .TransportBuilder()
                .withDateOfBegin(dateOfBegin)
                .withDateOfEnd(dateOfEnd)
                .withDestination(destination)
                .withClient(client)
                .isPayed(isPayed)
                .withVehicle(vehicle)
                .withDriver(employee)
                .build();

    }

    /**
     * This test checks if TransportBuilder inner class method will set same instance as constructor will.
     * If it does, builder works as expected.
     *
     * @see Transport.TransportBuilder
     */
    @Test
    public void build_WithoutCargoAndPrice_BuilderWorks() {
        //arrange & act
        Transport transport1 = new Transport(dateOfBegin, dateOfEnd, destination, client, isPayed, employee, vehicle);

        //assert
        assertEquals(transport1, transport);
    }

    /**
     * This test checks if TransportBuilder inner class method will set same instance as constructor will.
     * If it does, builder works as expected.
     *
     * @see Transport.TransportBuilder
     */
    @Test
    public void build_allParameters_BuilderWorks() {
        //arrange
        Transport transport1 = new Transport(dateOfBegin, dateOfEnd, destination, client, isPayed, employee, vehicle);

        //act
        transport = new Transport
                .TransportBuilder()
                .withDateOfBegin(dateOfBegin)
                .withDateOfEnd(dateOfEnd)
                .withDestination(destination)
                .withClient(client)
                .withCargo(cargo)
                .withPriceForTransport(GenericFeeCalculator.getInstance()
                        .calculateFee(cargo)
                        .multiply(BigDecimal.valueOf(destination)))
                .isPayed(isPayed)
                .withVehicle(vehicle)
                .withDriver(employee)
                .build();

        //assert
        assertEquals(transport1, transport);
    }

    /**
     * This test checks if setDateOfBegin works as expected.
     */
    @Test
    public void setDateOfBegin_ModifyDateOfBeginProp_ArgumentsAreValid() {
        //arrange
        Date date = new Date();

        //act
        transport.setDateOfBegin(date);

        //assert
        assertEquals(date, transport.getDateOfBegin());
    }

    /**
     * This test checks if setDateOfEnd works as expected.
     */
    @Test
    public void setDateOfEnd_ModifyDateOfBeginProp_ArgumentsAreValid() {
        //arrange
        Date date = new Date();

        //act
        transport.setDateOfEnd(date);

        //assert
        assertEquals(date, transport.getDateOfEnd());
    }

    /**
     * This test checks if setClient works as expected.
     */
    @Test
    public void setClient_ModifyClientProp_ArgumentsAreValid() {
        //arrange
        Client client = PersonFactory.getInstance().createPerson(new ClientArgs("name", priceForTransport, cargo));


        //act
        transport.setClient(client);

        //assert
        assertEquals(client, transport.getClient());
    }

    /**
     * This test checks if setDriver works as expected.
     */
    @Test
    public void setDriver_ModifyDriverProp_ArgumentsAreValid() {
        //arrange
        Employee employee = PersonFactory.getInstance().createPerson(new EmployeeArgs("name", priceForTransport, CATEGORY.C));


        //act
        transport.setDriver(employee);

        //assert
        assertEquals(employee, transport.getDriver());
    }

    /**
     * This test checks if setDestination works as expected.
     */
    @Test
    public void setDestination_ModifyDestinationProp_ArgumentsAreValid() {
        //arrange
        double expected = 5.32;


        //act
        transport.setDestination(expected);

        //assert
        assertEquals(expected, transport.getDestination());
    }

    /**
     * This test checks if setCargoToBeTransported works as expected.
     */
    @Test
    public void setCargoToBeTransported_ModifyCargoProp_ArgumentsAreValid() {
        //arrange & act
        transport.setCargoToBeTransported(cargo2);

        //assert
        assertEquals(cargo2, transport.getCargoToBeTransported());
    }


    /**
     * This test checks if setPayed works as expected.
     */
    @Test
    public void setPayed_ModifyIsPayedProp_ArgumentsAreValid() {
        //arrange & act
        transport.setPayed(true);

        //assert
        assertTrue(transport.isPayed());
    }

    /**
     * This test checks if setPayed works as expected.
     */
    @Test
    public void setVehicle_ModifyVehicleProp_ArgumentsAreValid() {
        //arrange & act
        transport.setVehicle(vehicle1);

        //assert
        assertEquals(vehicle1, transport.getVehicle());
    }

    /**
     * This test checks if setPriceForTransport works as expected.
     */
    @Test
    public void setPriceForTransport_ModifyPriceForTransportProp_ArgumentsAreValid() {
        //arrange & act
        transport.setPriceForTransport(new BigDecimal("3.2"));

        //assert
        assertEquals(new BigDecimal("3.2"), transport.getPriceForTransport());
    }

    /**
     * This test checks if hashCode works as expected.
     */
    @Test
    public void hashCode_SameHash_ObjectAreSame() {
        //arrange
        Transport transport1 = new Transport(dateOfBegin, dateOfEnd, destination, client, isPayed, employee, vehicle);

        //assert & act
        assertEquals(transport.hashCode(), transport1.hashCode());
    }

    /**
     * This test checks if hashCode works as expected.
     */
    @Test
    public void hashCode_differentHash_ObjectAreDifferent() {
        //arrange
        Transport transport1 = new Transport(dateOfBegin, dateOfEnd, destination, client, isPayed, employee, vehicle1);

        //assert & act
        assertFalse(transport.hashCode() == transport1.hashCode());
    }

    /**
     * This test check if toString method works as expected.
     * If the method works, it should at least write "dateOfBegin ="
     * plus the value of the date
     */
    @Test
    public void toString_OutputAtLeastDateOfBEGIN() {
        //arrange & act
        String toString = transport.toString();

        //assert
        assertTrue(toString.contains("dateOfBegin=" + transport.getDateOfBegin()));
    }
}
