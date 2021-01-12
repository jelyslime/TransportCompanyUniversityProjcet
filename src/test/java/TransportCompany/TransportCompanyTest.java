package TransportCompany;

import Cargos.Cargo;
import Persons.Client;
import Persons.Employee;
import Transport.Transport;
import Vehicles.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import utility.CATEGORY;
import utility.FeeCalculation.GenericFeeCalculator;
import utility.TRANSPORT_TYPE;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransportCompanyTest {


    private String companyName = "";


    @Mock
    Cargo cargo;

    @Mock
    private List<Vehicle> vehicles;

    @Mock
    private List<Employee> employeeList;

    @Mock
    private Map<Transport, Client> transports;

    @Mock
    private BigDecimal earnings;

    @Mock
    private List<Client> clientsList;

    CATEGORY category;

    @Mock
    Vehicle vehicle;

    @Mock
    Employee employee;

    @Mock
    Client client;

    @Mock
    Employee employee1;

    @Mock
    Client client1;

    @Mock
    Transport transport;

    @Mock
    BigDecimal bigDecimal;

    @Mock
    Date begin;
    @Mock
    Date end;

    @Spy
    @InjectMocks
    private TransportCompany transportCompany;


    @Before
    public void setUp() {
        transportCompany.setCompanyName("");
        //transportCompany = spy(new TransportCompany(companyName,vehicles,employeeList,transports,earnings,clientsList));

    }

    @Test
    public void allArgsConstructor_CreateInstance() {
        //arrange & act
        TransportCompany company = new TransportCompany(companyName, vehicles, employeeList,
                transports, earnings, clientsList);


        //assert
        assertTrue(Objects.nonNull(company));
    }

    @Test
    public void noArgsConstructor_CreateInstance() {
        //arrange & act
        TransportCompany company1 = new TransportCompany();

        //assert
        assertTrue(Objects.nonNull(company1));
    }

    @Test
    public void delete_ClearAllData() {
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        transportCompany.setVehicles(vehicles);

        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportClientHashMap.put(transport, client);
        transportCompany.setTransportsAsMap(transportClientHashMap);

        List<Client> clients = new ArrayList<>();
        clients.add(client);
        transportCompany.setClients(clients);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        transportCompany.setEmployees(employees);

        BigDecimal bigDecimal = BigDecimal.TEN;
        transportCompany.setEarnings(bigDecimal);

        transportCompany.setCompanyName("name");

        //arrange
        transportCompany.delete();

        //assert
        assertEquals("", transportCompany.getCompanyName());
        assertEquals(0, transportCompany.getTransports().size());
        assertEquals(0, transportCompany.getClients().size());
        assertEquals(BigDecimal.ZERO, transportCompany.getEarnings());
        assertEquals(0, transportCompany.getVehicles().size());
        assertEquals(0, transportCompany.getEmployees().size());
    }

    @Test
    public void deleteVehicle_True_VehicleIsRemoved() {
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        transportCompany.setVehicles(vehicles);

        //act
        boolean result = transportCompany.deleteVehicle(vehicle);

        //assert
        assertTrue(result);
    }

    @Test
    public void deleteVehicle_False_VehicleWasNotInList() {
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        transportCompany.setVehicles(vehicles);

        //act
        boolean result = transportCompany.deleteVehicle(vehicle);

        //assert
        assertFalse(result);
    }

    @Test
    public void deleteClient_True_ClientIsRemoved() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        transportCompany.setClients(clients);

        //act
        boolean result = transportCompany.deleteClient(client);

        //arrange
        assertTrue(result);
    }

    @Test
    public void deleteClient_False_ClientWasNotInList() {
        //arrange
        List<Client> clients = new ArrayList<>();
        transportCompany.setClients(clients);

        //act
        boolean result = transportCompany.deleteClient(client);

        //arrange
        assertFalse(result);
    }

    @Test
    public void deleteEmployee_True_EmployeeIsRemoved() {
        //arrange
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        transportCompany.setEmployees(employees);

        //act
        boolean result = transportCompany.deleteEmployee(employee);

        //arrange
        assertTrue(result);
    }

    @Test
    public void deleteEmployee_False_EmployeeWasNotInList() {
        //arrange
        List<Employee> employees = new ArrayList<>();
        transportCompany.setEmployees(employees);

        //act
        boolean result = transportCompany.deleteEmployee(employee);

        //arrange
        assertFalse(result);
    }

    @Test
    public void deleteTransport_True_TransportIsRemoved() {
        //arrange
        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportClientHashMap.put(transport, client);
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.deleteTransport(transport);

        //arrange
        assertTrue(result);
    }

    @Test
    public void deleteTransport_False_TransportWasNotInList() {
        //arrange
        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.deleteTransport(transport);

        //arrange
        assertFalse(result);
    }

    @Test
    public void changeName_True_NameIsChanged() {
        //arrange&act
        boolean result = transportCompany.changeName("new name");

        assertTrue(result);
    }

    @Test
    public void changeName_False_NewNameIsLikeOldName() {
        //arrange&act
        boolean result = transportCompany.changeName("");

        assertFalse(result);
    }

    @Test
    public void decreaseEarnings_True_resultIsMoreThenZero() {
        //arrange
        BigDecimal bigDecimal = BigDecimal.TEN;
        transportCompany.setEarnings(bigDecimal);

        //act
        boolean result = transportCompany.decreaseEarnings(BigDecimal.ONE);

        //assert
        assertTrue(result);
    }

    @Test
    public void decreaseEarnings_False_resultIsLessThenZero() {
        //arrange
        BigDecimal bigDecimal = BigDecimal.ZERO;
        transportCompany.setEarnings(bigDecimal);

        //act
        boolean result = transportCompany.decreaseEarnings(BigDecimal.ONE);

        //assert
        assertFalse(result);
    }

    @Test
    public void addTransport_True_TransportIsAdded() {
        //arrange
        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.addTransport(transport);

        //arrange
        assertTrue(result);
    }

    @Test
    public void addTransport_False_TransportWasInsideMap() {
        //arrange
        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportClientHashMap.put(transport, client);
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.addTransport(transport);

        //arrange
        assertFalse(result);
    }

    @Test
    public void addVehicle_True_VehicleIsAdded() {
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        transportCompany.setVehicles(vehicles);

        //act
        boolean result = transportCompany.addVehicle(vehicle);

        //assert
        assertTrue(result);
    }

    @Test
    public void addVehicle_False_VehicleWasWasInsideList() {
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        transportCompany.setVehicles(vehicles);

        //act
        boolean result = transportCompany.addVehicle(vehicle);

        //assert
        assertFalse(result);
    }

    @Test
    public void addEmployee_True_EmployeeIsAdded() {
        //arrange
        List<Employee> employees = new ArrayList<>();
        transportCompany.setEmployees(employees);

        //act
        boolean result = transportCompany.addEmployee(employee);

        //arrange
        assertTrue(result);
    }

    @Test
    public void addEmployee_False_EmployeeWasInList() {
        //arrange
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        transportCompany.setEmployees(employees);

        //act
        boolean result = transportCompany.addEmployee(employee);

        //arrange
        assertFalse(result);
    }

    @Test
    public void addClient_True_ClientIsAdded() {
        //arrange
        List<Client> clients = new ArrayList<>();
        transportCompany.setClients(clients);

        //act
        boolean result = transportCompany.addClient(client);

        //arrange
        assertTrue(result);
    }

    @Test
    public void addClient_False_ClientWasInList() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        transportCompany.setClients(clients);

        //act
        boolean result = transportCompany.addClient(client);

        //arrange
        assertFalse(result);
    }

    @Test
    public void increaseEarnings_IncreaseEarnings() {
        //arrange
        BigDecimal bigDecimal = BigDecimal.ZERO;
        transportCompany.setEarnings(bigDecimal);

        //act
        transportCompany.increaseEarnings(BigDecimal.TEN);

        //assert
        assertEquals(BigDecimal.TEN, transportCompany.getEarnings());
    }

    @Test(expected = IllegalArgumentException.class)
    public void increaseEarnings_ThrowIllegalArgument_ArgumentIsNull() {
        //act
        transportCompany.increaseEarnings(null);
    }

    @Test
    public void isClientInObligation_True_ClientIsInObligation() {
        //arrange
        when(transport.isPayed()).thenReturn(false);

        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportClientHashMap.put(transport, client);
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.isClientInObligation(client);

        assertTrue(result);
    }

    @Test
    public void isClientInObligation_False_ClientIsInObligation() {
        //arrange
        when(transport.isPayed()).thenReturn(true);

        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportClientHashMap.put(transport, client);
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.isClientInObligation(client);

        assertFalse(result);
    }

    @Test
    public void isClientInObligation_False_DifferentClient() {
        //arrange
        Map<Transport, Client> transportClientHashMap = new HashMap<>();
        transportClientHashMap.put(transport, client);
        transportCompany.setTransportsAsMap(transportClientHashMap);

        //act
        boolean result = transportCompany.isClientInObligation(client1);

        assertFalse(result);
    }

    @Test
    public void assignTransport_False_NoAvailableVehicles() {
        //arrange

        doReturn(cargo).when(client).getCargo();
        doReturn(null).when(transportCompany).availableVehicle(cargo,begin,end);
        //act
        boolean result = transportCompany
                .assignTransport(begin, end, client, false, 33);

        assertFalse(result);
    }

    @Test
    public void assignTransport_False_NoAvailableEmployees() {
        //arrange
        doReturn(cargo).when(client).getCargo();
        doReturn(vehicle).when(transportCompany).availableVehicle(cargo,begin,end);
        doReturn(category).when(vehicle).getCategoryRequired();
        doReturn(null)
                .when(transportCompany)
                .availableEmployee(category,begin,end);
        //act
        boolean result = transportCompany
                .assignTransport(begin, end, client, false, 33);

        assertFalse(result);
    }

    @Test
    public void assignTransport_True_TransportIsAdded() {
        //arrange
        doReturn(cargo).when(client).getCargo();
        doReturn(vehicle).when(transportCompany).availableVehicle(cargo,begin,end);
        doReturn(category).when(vehicle).getCategoryRequired();
        doReturn(employee)
                .when(transportCompany)
                .availableEmployee(category,begin,end);
        doReturn(transport)
                .when(transportCompany)
                .createNewTransport(employee,vehicle,client,33,cargo,begin,end);
        //act
        boolean result = transportCompany
                .assignTransport(begin, end, client, false, 33);

        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assignTransport_ThrowIllegalArgument_NullArgument() {

        transportCompany.assignTransport(null, end, client, false, 33);
    }

    @Test
    public void createNewTransport_CreatesTransport(){
       //arrange
        doReturn(cargo).when(client).getCargo();
        doReturn(TRANSPORT_TYPE.PASSENGER).when(cargo).getCargoType();

        Transport expected = new Transport.TransportBuilder()
                .withDriver(employee)
                .withVehicle(vehicle)
                .withClient(client)
                .withDestination(33)
                .withCargo(client.getCargo())
                .withDateOfBegin(begin)
                .withDateOfEnd(end)
                .build();

        //act
        Transport actual = transportCompany
                .createNewTransport(employee,vehicle,client,33,cargo,begin,end);

        assertEquals(expected,actual);
    }

    @Test
    public void addToEarningsIfEmployeePaysTransport_AddToEarnings_ClientHavesEnoughMoney(){
        doReturn(BigDecimal.ONE).when(transport).getPriceForTransport();
        doReturn(BigDecimal.TEN).when(client).getBudget();
        doReturn(BigDecimal.ONE).when(transportCompany).getEarnings();

        //act
        transportCompany.addToEarningsIfEmployeePaysTransport(transport,client,true);

        //assert
        verify(transportCompany,times(1))
                .increaseEarnings(transport.getPriceForTransport());
        verify(client,times(1)).setBudget(BigDecimal.TEN.subtract(transport.getPriceForTransport()));
        verify(client,times(2)).getBudget();
        verify(transport,times(1)).setPayed(true);
    }

    @Test
    public void addToEarningsIfEmployeePaysTransport_DoesNotAddToEarnings_ClientHavesEnoughMoney(){
        doReturn(BigDecimal.TEN).when(transport).getPriceForTransport();
        doReturn(BigDecimal.ONE).when(client).getBudget();
        doReturn(BigDecimal.ONE).when(transportCompany).getEarnings();

        //act
        transportCompany.addToEarningsIfEmployeePaysTransport(transport,client,true);

        //assert
        verify(transportCompany,times(0))
                .increaseEarnings(transport.getPriceForTransport());
        verify(client,times(1)).getBudget();
        verify(transport,times(1)).setPayed(false);
    }

    @Test
    public void addToEarningsIfEmployeePaysTransport_DoesNotAddToEarnings_ClientDoesNotPay(){
        doReturn(BigDecimal.TEN).when(transport).getPriceForTransport();
        doReturn(BigDecimal.ONE).when(client).getBudget();
        doReturn(BigDecimal.ONE).when(transportCompany).getEarnings();

        //act
        transportCompany.addToEarningsIfEmployeePaysTransport(transport,client,false);

        //assert
        verify(transport,times(1)).setPayed(false);
    }

    @Test
    public void availableEmployee_null_IfNoEmployeeFind(){
        //arrange
        doReturn(employeeList)
                .when(transportCompany)
                .employeesThatCanDriveSpecificVehicle(category);
        doReturn(employeeList)
                .when(transportCompany)
                .employeesAvailableAtPeriod(employeeList,begin,end);

        //act

        Employee employee = transportCompany.availableEmployee(category,begin,end);

        assertTrue(Objects.isNull(employee));
    }

    @Test
    public void availableEmployee_Employee_EmployeeFound(){
        //arrange
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        doReturn(employees)
                .when(transportCompany)
                .employeesThatCanDriveSpecificVehicle(category);
        doReturn(employees)
                .when(transportCompany)
                .employeesAvailableAtPeriod(employeeList,begin,end);

        //act

        Employee actual = transportCompany.availableEmployee(category,begin,end);

        assertEquals(employee,actual);
    }

    @Test
    public void availableVehicle_null_IfNoEmployeeFind(){
        //arrange
        doReturn(vehicles)
                .when(transportCompany)
                .getVehiclesThatMeetsRequest(cargo);
        doReturn(vehicles)
                .when(transportCompany)
                .vehiclesThatAreAvailableOnPeriod(vehicles,begin,end);

        //act

        Vehicle vehicle = transportCompany.availableVehicle(cargo,begin,end);

        assertTrue(Objects.isNull(vehicle));
    }

    @Test
    public void availableVehicle_Vehicle_VehicleFound(){
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        doReturn(vehicles)
                .when(transportCompany)
                .getVehiclesThatMeetsRequest(cargo);
        doReturn(vehicles)
                .when(transportCompany)
                .vehiclesThatAreAvailableOnPeriod(vehicles,begin,end);

        //act

        Vehicle refactor = transportCompany.availableVehicle(cargo,begin,end);

        assertEquals(vehicle,refactor);
    }

    @Test
    public void employeesAvailableAtPeriod_ListOfEmployeesWhoAreAvalible() throws ParseException {
        //arrange
        doReturn(employee1).when(transport).getDriver();

        Date beforeNotDummy = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date after = new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime();
        ArrayList<Transport> transports = new ArrayList<>();
        transports.add(transport);
        doReturn(beforeNotDummy).when(transport).getDateOfBegin();
        doReturn(after).when(transport).getDateOfEnd();
        doReturn(transports).when(transportCompany).getTransports();
        doReturn(employee1).when(transport).getDriver();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        //act
        List<Employee> actual = transportCompany.employeesAvailableAtPeriod(employees,new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime(),
                new GregorianCalendar(2014, Calendar.FEBRUARY, 14).getTime());

        //assert
        assertEquals(employees,actual);
    }

    @Test
    public void employeesThatCanDriveSpecificVehicle_ListOfEmployeeWhoHaveNeededCategory(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        doReturn(CATEGORY.D).when(employee).getCategory();
        doReturn(employees).when(transportCompany).getEmployees();

        List<Employee> actual = transportCompany.employeesThatCanDriveSpecificVehicle(CATEGORY.D);

        assertEquals(employees,actual);
    }

    @Test
    public void employeesThatCanDriveSpecificVehicle_EmptyList_NoEmployeeFound(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        doReturn(CATEGORY.D).when(employee).getCategory();
        doReturn(employees).when(transportCompany).getEmployees();

        List<Employee> actual = transportCompany.employeesThatCanDriveSpecificVehicle(CATEGORY.C);

        assertTrue(actual.isEmpty());
    }
}
