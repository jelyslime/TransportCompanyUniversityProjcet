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
import utility.TRANSPORT_TYPE;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.*;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransportCompanyTest {


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
    Employee employee2;

    @Mock
    Client client1;

    @Mock
    Transport transport;

    @Mock
    Transport transport1;

    @Mock
    Transport transport2;

    @Mock
    Date begin;
    @Mock
    Date end;

    @Mock
    Vehicle vehicle1;


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
        String companyName = "";
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
        doReturn(null).when(transportCompany).availableVehicle(cargo, begin, end);
        //act
        boolean result = transportCompany
                .assignTransport(begin, end, client, false, 33);

        assertFalse(result);
    }

    @Test
    public void assignTransport_False_NoAvailableEmployees() {
        //arrange
        doReturn(cargo).when(client).getCargo();
        doReturn(vehicle).when(transportCompany).availableVehicle(cargo, begin, end);
        doReturn(category).when(vehicle).getCategoryRequired();
        doReturn(null)
                .when(transportCompany)
                .availableEmployee(category, begin, end);
        //act
        boolean result = transportCompany
                .assignTransport(begin, end, client, false, 33);

        assertFalse(result);
    }

    @Test
    public void assignTransport_True_TransportIsAdded() {
        //arrange
        doReturn(cargo).when(client).getCargo();
        doReturn(vehicle).when(transportCompany).availableVehicle(cargo, begin, end);
        doReturn(category).when(vehicle).getCategoryRequired();
        doReturn(employee)
                .when(transportCompany)
                .availableEmployee(category, begin, end);
        doReturn(transport)
                .when(transportCompany)
                .createNewTransport(employee, vehicle, client, 33, cargo, begin, end);
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
    public void createNewTransport_CreatesTransport() {
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
                .createNewTransport(employee, vehicle, client, 33, cargo, begin, end);

        assertEquals(expected, actual);
    }

    @Test
    public void addToEarningsIfEmployeePaysTransport_AddToEarnings_ClientHavesEnoughMoney() {
        doReturn(BigDecimal.ONE).when(transport).getPriceForTransport();
        doReturn(BigDecimal.TEN).when(client).getBudget();
        doReturn(BigDecimal.ONE).when(transportCompany).getEarnings();

        //act
        transportCompany.addToEarningsIfEmployeePaysTransport(transport, client, true);

        //assert
        verify(transportCompany, times(1))
                .increaseEarnings(transport.getPriceForTransport());
        verify(client, times(1)).setBudget(BigDecimal.TEN.subtract(transport.getPriceForTransport()));
        verify(client, times(2)).getBudget();
        verify(transport, times(1)).setPayed(true);
    }

    @Test
    public void addToEarningsIfEmployeePaysTransport_DoesNotAddToEarnings_ClientHavesEnoughMoney() {
        doReturn(BigDecimal.TEN).when(transport).getPriceForTransport();
        doReturn(BigDecimal.ONE).when(client).getBudget();
        //doReturn(BigDecimal.ONE).when(transportCompany).getEarnings();

        //act
        transportCompany.addToEarningsIfEmployeePaysTransport(transport, client, true);

        //assert
        verify(transportCompany, times(0))
                .increaseEarnings(transport.getPriceForTransport());
        verify(client, times(1)).getBudget();
        verify(transport, times(1)).setPayed(false);
    }

    @Test
    public void addToEarningsIfEmployeePaysTransport_DoesNotAddToEarnings_ClientDoesNotPay() {
//        doReturn(BigDecimal.ONE).when(client).getBudget();
        //doReturn(BigDecimal.ONE).when(transportCompany).getEarnings();

        //act
        transportCompany.addToEarningsIfEmployeePaysTransport(transport, client, false);

        //assert
        verify(transport, times(1)).setPayed(false);
    }

    @Test
    public void availableEmployee_null_IfNoEmployeeFind() {
        //arrange
        doReturn(employeeList)
                .when(transportCompany)
                .employeesThatCanDriveSpecificVehicle(category);
        doReturn(employeeList)
                .when(transportCompany)
                .employeesAvailableAtPeriod(employeeList, begin, end);

        //act

        Employee employee = transportCompany.availableEmployee(category, begin, end);

        assertTrue(Objects.isNull(employee));
    }

    @Test
    public void availableEmployee_Employee_EmployeeFound() {
        //arrange
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        doReturn(employees)
                .when(transportCompany)
                .employeesThatCanDriveSpecificVehicle(category);
//        doReturn(employees)
        //              .when(transportCompany)
        //            .employeesAvailableAtPeriod(employeeList, begin, end);

        //act

        Employee actual = transportCompany.availableEmployee(category, begin, end);

        assertEquals(employee, actual);
    }

    @Test
    public void availableVehicle_null_IfNoEmployeeFind() {
        //arrange
        doReturn(vehicles)
                .when(transportCompany)
                .getVehiclesThatMeetsRequest(cargo);
        doReturn(vehicles)
                .when(transportCompany)
                .vehiclesThatAreAvailableOnPeriod(vehicles, begin, end);

        //act

        Vehicle vehicle = transportCompany.availableVehicle(cargo, begin, end);

        assertTrue(Objects.isNull(vehicle));
    }

    @Test
    public void availableVehicle_Vehicle_VehicleFound() {
        //arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        doReturn(vehicles)
                .when(transportCompany)
                .getVehiclesThatMeetsRequest(cargo);
        doReturn(vehicles)
                .when(transportCompany)
                .vehiclesThatAreAvailableOnPeriod(vehicles, begin, end);

        //act

        Vehicle refactor = transportCompany.availableVehicle(cargo, begin, end);

        assertEquals(vehicle, refactor);
    }

    @Test
    public void employeesAvailableAtPeriod_ListOfEmployeesWhoAreAvailable() {
        //arrange

        ArrayList<Transport> transports = new ArrayList<>();
        transports.add(transport);

        doReturn(transports).when(transportCompany).getTransports();
        doReturn(employee1).when(transport).getDriver();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        //act
        List<Employee> actual = transportCompany.employeesAvailableAtPeriod(employees, new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime(),
                new GregorianCalendar(2014, Calendar.FEBRUARY, 14).getTime());

        //assert
        assertEquals(employees, actual);
    }

    @Test
    public void employeesThatCanDriveSpecificVehicle_ListOfEmployeeWhoHaveNeededCategory() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        doReturn(CATEGORY.D).when(employee).getCategory();
        doReturn(employees).when(transportCompany).getEmployees();

        List<Employee> actual = transportCompany.employeesThatCanDriveSpecificVehicle(CATEGORY.D);

        assertEquals(employees, actual);
    }

    @Test
    public void employeesThatCanDriveSpecificVehicle_EmptyList_NoEmployeeFound() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        doReturn(CATEGORY.D).when(employee).getCategory();
        doReturn(employees).when(transportCompany).getEmployees();

        List<Employee> actual = transportCompany.employeesThatCanDriveSpecificVehicle(CATEGORY.C);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void vehiclesThatAreAvailableOnPeriod_ListOfVehiclesWhoAreAvailable() {
        //arrange
        Date beforeNotDummy = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        ArrayList<Transport> transports = new ArrayList<>();
        transports.add(transport);
        doReturn(beforeNotDummy).when(transport).getDateOfBegin();
        doReturn(transports).when(transportCompany).getTransports();
        doReturn(vehicle1).when(transport).getVehicle();
        List<Vehicle> employees = new ArrayList<>();
        employees.add(vehicle);
        employees.add(vehicle1);

        //act
        List<Vehicle> actual = transportCompany.vehiclesThatAreAvailableOnPeriod(employees, new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime(),
                new GregorianCalendar(2014, Calendar.FEBRUARY, 14).getTime());

        //assert
        assertEquals(employees, actual);
    }

    @Test
    public void getVehiclesThatMeetsRequest_EmptyList_NoVehiclesFound_TransportTypeMismatch() {
        //arrange & act
        List<Employee> actual = transportCompany.employeesThatCanDriveSpecificVehicle(CATEGORY.C);

        //assert
        assertTrue(actual.isEmpty());
    }

    @Test
    public void getVehiclesThatMeetsRequest_EmptyList_NoVehiclesFound_MaximumCapacityMismatch() {
        ArrayList<Vehicle> employees = new ArrayList<>();
        employees.add(vehicle);
        doReturn(TRANSPORT_TYPE.PRODUCT).when(vehicle).getTransportType();
        doReturn(TRANSPORT_TYPE.PRODUCT).when(cargo).getCargoType();
        doReturn(5.0).when(vehicle).getMaximumCapacity();
        doReturn(6.0).when(cargo).getNecessaryInformation();

        doReturn(employees).when(transportCompany).getVehicles();

        List<Vehicle> actual = transportCompany.getVehiclesThatMeetsRequest(cargo);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void sortEmployee_ListOfSortedEmployees() {
        //arrange
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee);
        employees.add(employee2);
        doReturn(employees).when(transportCompany).getEmployees();

        doReturn(BigDecimal.TEN).when(employee).getSalary();
        doReturn(BigDecimal.ONE).when(employee1).getSalary();
        doReturn(BigDecimal.TEN).when(employee2).getSalary();

        doReturn(CATEGORY.D).when(employee).getCategory();
        //  doReturn(CATEGORY.D).when(employee1).getCategory();
        doReturn(CATEGORY.C).when(employee2).getCategory();

        List<Employee> expected = new ArrayList<>();
        expected.add(employee);
        expected.add(employee2);
        expected.add(employee1);

        //act
        List<Employee> actual = transportCompany.sortEmployee();

        //arrange
        assertEquals(expected, actual);
    }

    @Test
    public void sortEmployee_EmptyList_NoEmployeesToSort() {
        //arrange
        ArrayList<Employee> employees = new ArrayList<>();
        doReturn(employees).when(transportCompany).getEmployees();

        List<Employee> expected = new ArrayList<>();

        //act
        List<Employee> actual = transportCompany.sortEmployee();

        //arrange
        assertEquals(expected, actual);
    }

    @Test
    public void sortTransports_ListOfSortedTransports() {
        //arrange
        ArrayList<Transport> transports = new ArrayList<>();
        transports.add(transport);
        transports.add(transport1);
        transports.add(transport2);
        doReturn(transports).when(transportCompany).getTransports();

        doReturn(2.0).when(transport).getDestination();
        doReturn(3.0).when(transport1).getDestination();
        doReturn(4.0).when(transport2).getDestination();

        List<Transport> expected = new ArrayList<>();
        expected.add(transport2);
        expected.add(transport1);
        expected.add(transport);

        //act
        List<Transport> actual = transportCompany.sortTransports();

        //arrange
        assertEquals(expected, actual);
    }

    @Test
    public void writeTransportsToFile_True_TransportAreWritten() {
        //arrange
        File LocationToWrite = Paths.get("src/main/resources/dummySerialisation.ser").toFile();

        Map<Transport, Client> map = new HashMap<>();
        map.put(transport, client);
        map.put(transport1, client);
        map.put(transport2, client);

        doReturn(map).when(transportCompany).getTransportsLikeMap();

        //act
        boolean result = transportCompany.writeTransportsToFile(LocationToWrite);

        //assert
        assertTrue(result);
    }

    @Test
    public void writeTransportsToFile_False_TransportAreNotWritten() {
        //arrange
        File LocationToWrite = Paths.get("src/notMain/resources/dummySerialisation.ser").toFile();


        //act
        boolean result = transportCompany.writeTransportsToFile(LocationToWrite);

        //assert
        assertFalse(result);
    }

    @Test
    public void readTransportsFromFile_NotEmpty_TransportsAreReadFromFile() {
        File LocationToWrite = Paths.get("src/main/resources/dummySerialisation.ser").toFile();

        Map<Transport, Client> map = new HashMap<>();
        map.put(transport, client);
        map.put(transport1, client);
        map.put(transport2, client);

        doReturn(map).when(transportCompany).getTransportsLikeMap();

        transportCompany.writeTransportsToFile(LocationToWrite);

        //act
        Map<Transport, Client> actual = transportCompany.readTransportsFromFile(LocationToWrite);

        //assert
        assertEquals(3, actual.size());
    }

    @Test
    public void readTransportsFromFile_Empty_TransportsAreNotReadFromFile() {
        File LocationToWrite = Paths.get("src/main/resources/dummySerialisation.ser").toFile();

        Map<Transport, Client> map = new HashMap<>();
        map.put(transport, client);
        map.put(transport1, client);
        map.put(transport2, client);

        doReturn(map).when(transportCompany).getTransportsLikeMap();

        transportCompany.writeTransportsToFile(LocationToWrite);

        LocationToWrite = Paths.get("src/notMain/resources/dummySerialisation.ser").toFile();
        //act
        Map<Transport, Client> actual = transportCompany.readTransportsFromFile(LocationToWrite);

        //assert
        assertEquals(0, actual.size());
    }

    @Test
    public void readAndWriteTransportsToCompany_True_TransportsAreWritten() {
        File LocationToWrite = Paths.get("src/main/resources/dummySerialisation.ser").toFile();

        Map<Transport, Client> map = new HashMap<>();
        map.put(transport, client);
        map.put(transport1, client);
        map.put(transport2, client);

        doReturn(map).when(transportCompany).readTransportsFromFile(LocationToWrite);

        Map<Transport, Client> mapForCompany = new HashMap<>();

        doReturn(mapForCompany).when(transportCompany).getTransportsLikeMap();
        //act
        boolean result = transportCompany.readAndWriteTransportsToCompany(LocationToWrite);

        //assert
        assertTrue(result);
        assertEquals(3, mapForCompany.size());

    }

    @Test
    public void readAndWriteTransportsToCompany_False_TransportsAreEmpty() {
        File LocationToWrite = Paths.get("src/main/resources/dummySerialisation.ser").toFile();

        Map<Transport, Client> map = new HashMap<>();

        doReturn(map).when(transportCompany).readTransportsFromFile(LocationToWrite);

        //act
        boolean result = transportCompany.readAndWriteTransportsToCompany(LocationToWrite);

        //assert
        assertFalse(result);
        assertEquals(0, transportCompany.getTransports().size());
    }

    @Test
    public void reportHowManyTransportsHaveBeenMade_String() {
        //arrange
        Date dateOnTransport = new GregorianCalendar(2012, Calendar.FEBRUARY, 11).getTime();

        List<Transport> transports = new ArrayList<>();
        transports.add(transport);
        transports.add(transport1);
        transports.add(transport2);

        doReturn(dateOnTransport).when(transport).getDateOfEnd();
        doReturn(dateOnTransport).when(transport1).getDateOfEnd();
        doReturn(dateOnTransport).when(transport2).getDateOfEnd();

        doReturn(transports).when(transportCompany).getTransports();

        //act
        String result = transportCompany.reportHowManyTransportsHaveBeenMade();

        //assert
        assertTrue(result.contains("3"));
    }

    @Test
    public void reportSumOfMadeTransports_String() {
        //arrange
        Date dateOnTransport = new GregorianCalendar(2012, Calendar.FEBRUARY, 11).getTime();

        List<Transport> transports = new ArrayList<>();
        transports.add(transport);
        transports.add(transport1);
        transports.add(transport2);

        doReturn(dateOnTransport).when(transport).getDateOfEnd();
        doReturn(dateOnTransport).when(transport1).getDateOfEnd();
        doReturn(dateOnTransport).when(transport2).getDateOfEnd();

        doReturn(transports).when(transportCompany).getTransports();

        doReturn(BigDecimal.ONE).when(transport).getPriceForTransport();
        doReturn(BigDecimal.ONE).when(transport1).getPriceForTransport();
        doReturn(BigDecimal.ONE).when(transport2).getPriceForTransport();

        //act
        String result = transportCompany.reportSumOfMadeTransports();

        BigDecimal resolve = BigDecimal.ONE.add(BigDecimal.ONE.add(BigDecimal.ONE));
        //assert
        assertTrue(result.contains(resolve.toString()));
    }

    @Test
    public void timesEmployeesDrove_String() {
        //arrange
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);

        doReturn(1).when(transportCompany).timesDrove(employee);
        doReturn(2).when(transportCompany).timesDrove(employee1);
        doReturn(3).when(transportCompany).timesDrove(employee2);

        doReturn(employees).when(transportCompany).getEmployees();

        //act
        String result = transportCompany.timesEmployeesDrove();

        String val = "Employee null : 3 trips.";

        //assert
        assertTrue(result.contains(val));
    }

    @Test
    public void earningsOnPeriod_String() {
        //arrange
        Date beforeOnTransport = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date afterOnTransport = new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime();

        Date begin = new GregorianCalendar(2012, Calendar.FEBRUARY, 11).getTime();
        Date end = new GregorianCalendar(2016, Calendar.FEBRUARY, 15).getTime();

        List<Transport> transports = new ArrayList<>();
        transports.add(transport1);
        transports.add(transport2);

        doReturn(beforeOnTransport).when(transport1).getDateOfBegin();
        doReturn(afterOnTransport).when(transport1).getDateOfEnd();

        doReturn(beforeOnTransport).when(transport2).getDateOfBegin();
        doReturn(afterOnTransport).when(transport2).getDateOfEnd();

        doReturn(transports).when(transportCompany).getTransports();

        doReturn(BigDecimal.ONE).when(transport1).getPriceForTransport();
        doReturn(BigDecimal.ONE).when(transport2).getPriceForTransport();

        //act
        String result = transportCompany.earningsOnPeriod(begin, end);

        BigDecimal val = BigDecimal.ONE.add(BigDecimal.ONE);
        //arrange
        assertTrue(result.contains(val.toString()));
    }

    @Test
    public void earningsOnPeriodFromEmployee_String() {
        //arrange
        Date beforeOnTransport = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date afterOnTransport = new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime();

        Date begin = new GregorianCalendar(2012, Calendar.FEBRUARY, 11).getTime();
        Date end = new GregorianCalendar(2016, Calendar.FEBRUARY, 15).getTime();

        List<Transport> transports = new ArrayList<>();
        transports.add(transport1);
        transports.add(transport2);

        doReturn(beforeOnTransport).when(transport1).getDateOfBegin();
        doReturn(afterOnTransport).when(transport1).getDateOfEnd();

        doReturn(beforeOnTransport).when(transport2).getDateOfBegin();
        doReturn(afterOnTransport).when(transport2).getDateOfEnd();

        doReturn(transports).when(transportCompany).getTransports();

        doReturn(BigDecimal.ONE).when(transport1).getPriceForTransport();
//        doReturn(BigDecimal.TEN).when(transport2).getPriceForTransport();

        doReturn(employee2).when(transport2).getDriver();
        doReturn(employee).when(transport1).getDriver();

        //act
        String result = transportCompany.earningsOnPeriodFromEmployee(begin, end, employee);

        BigDecimal val = BigDecimal.ONE;
        //arrange
        assertTrue(result.contains(val.toString()));
    }

    @Test
    public void timesDrove_TimesEmployeeDroveAnTransport() {
        //arrange
        List<Transport> transports = new ArrayList<>();
        transports.add(transport1);
        transports.add(transport2);

        doReturn(employee2).when(transport2).getDriver();
        doReturn(employee).when(transport1).getDriver();

        doReturn(transports).when(transportCompany).getTransports();

        //act
        int actual = transportCompany.timesDrove(employee);

        //assert
        assertEquals(1, actual);
    }

    @Test
    public void setTransport_setsTransportList() {
        //arrange
        List<Transport> transports = new ArrayList<>();
        transports.add(transport1);
        transports.add(transport2);

        doReturn(client).when(transport1).getClient();
        doReturn(client).when(transport2).getClient();

        //act
        transportCompany.setTransports(transports);

        //assert
        assertEquals(transports.size(), transportCompany.getTransports().size());
    }

    @Test
    public void setTransportsAsMap_setsTransports() {
        //arrange
        Map<Transport, Client> transports = new HashMap<>();
        transports.put(transport, client);
        transports.put(transport1, client);


        //act
        transportCompany.setTransportsAsMap(transports);

        //assert
        assertEquals(transports.size(), transportCompany.getTransports().size());
    }

    @Test
    public void equals_true_objectsAreEqual() {
        //arrange
        TransportCompany company1 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clientsList);

        TransportCompany company2 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clientsList);

        //act
        boolean result = company1.equals(company2);

        //assert
        assertTrue(result);
    }

    @Test
    public void equals_false_objectsAreNotEqual() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clientsList);

        TransportCompany company2 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clients);

        //act
        boolean result = company1.equals(company2);

        //assert
        assertFalse(result);
    }

    @Test
    public void hashCode_sameHash_objectsAreSame() {
        //arrange
        TransportCompany company1 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clientsList);

        TransportCompany company2 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clientsList);

        //act
        int company1hash = company1.hashCode();
        int company2hash = company2.hashCode();

        //assert
        assertEquals(company1hash, company2hash);
    }

    @Test
    public void hashCode_differentHash_objectsAreNotSame() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clientsList);

        TransportCompany company2 = new TransportCompany("name", vehicles, employeeList,
                transports, earnings, clients);

        //act
        int company1hash = company1.hashCode();
        int company2hash = company2.hashCode();

        //assert
        assertNotSame(company1hash, company2hash);
    }

    @Test
    public void compareTo_One_ObjectIsBigger_FirstCompare() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("b", vehicles, employeeList,
                transports, earnings, clientsList);

        TransportCompany company2 = new TransportCompany("a", vehicles, employeeList,
                transports, earnings, clients);

        //act
        int result = company1.compareTo(company2);

        //assert
        assertEquals(1, result);
    }

    @Test
    public void compareTo_MinusOne_ObjectIsSmaller_FirstCompare() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("a", vehicles, employeeList,
                transports, earnings, clientsList);

        TransportCompany company2 = new TransportCompany("b", vehicles, employeeList,
                transports, earnings, clients);

        //act
        int result = company1.compareTo(company2);

        //assert
        assertEquals(-1, result);
    }

    @Test
    public void compareTo_MinusOne_ObjectIsSmaller_SecondCompare() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("a", vehicles, employeeList,
                transports, BigDecimal.ONE, clientsList);

        TransportCompany company2 = new TransportCompany("a", vehicles, employeeList,
                transports, BigDecimal.TEN, clients);

        //act
        int result = company1.compareTo(company2);

        //assert
        assertEquals(-1, result);
    }

    @Test
    public void compareTo_One_ObjectIsBigger_SecondCompare() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("a", vehicles, employeeList,
                transports, BigDecimal.TEN, clientsList);

        TransportCompany company2 = new TransportCompany("a", vehicles, employeeList,
                transports, BigDecimal.ONE, clients);

        //act
        int result = company1.compareTo(company2);

        //assert
        assertEquals(1, result);
    }

    @Test
    public void compareTo_One_ObjectAreEqual() {
        //arrange
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        TransportCompany company1 = new TransportCompany("a", vehicles, employeeList,
                transports, BigDecimal.ONE, clientsList);

        TransportCompany company2 = new TransportCompany("a", vehicles, employeeList,
                transports, BigDecimal.ONE, clients);

        //act
        int result = company1.compareTo(company2);

        //assert
        assertEquals(0, result);
    }

    @Test
    public void toString_OutputAtLeastCompanyName() {
        //arrange & act
        String toString = transportCompany.toString();

        assertTrue(toString.contains("companyName=" + transportCompany.getCompanyName()));
    }

    @Test
    public void testBuilder() {
        //arrange
        String companyName = "name";

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee2);

        Map<Transport, Client> map = new HashMap<>();
        map.put(transport, client);

        BigDecimal earnings = BigDecimal.ONE;

        List<Client> clients = new ArrayList<>();
        clients.add(client);

        //act
        TransportCompany transportCompany1 = new TransportCompany
                .TransportCompanyBuilder()
                .withCompanyName(companyName)
                .withVehicles(vehicles)
                .withClients(clients)
                .withEmployees(employees)
                .withTransports(map)
                .withEarnings(earnings)
                .build();

        //assert
        assertEquals(companyName, transportCompany1.getCompanyName());
        assertEquals(1, transportCompany1.getTransports().size());
        assertEquals(1, transportCompany1.getVehicles().size());
        assertEquals(1, transportCompany1.getEmployees().size());
        assertEquals(1, transportCompany1.getTransportsLikeMap().size());
        assertEquals(BigDecimal.ONE, transportCompany1.getEarnings());
        assertEquals(1, transportCompany1.getClients().size());

    }
}
